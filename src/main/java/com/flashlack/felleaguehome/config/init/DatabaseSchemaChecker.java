package com.flashlack.felleaguehome.config.init;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.util.List;

/**
 * 数据库表结构检查器。
 *
 * @author FLSHLACK
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DatabaseSchemaChecker implements CommandLineRunner {
    private final JdbcTemplate jdbcTemplate;
    private final DefaultDataLoader defaultDataLoader;

    @Override
    public void run(String... args) throws IOException {
        log.debug("检查数据库表结构是否完整");
        List<String> requiredTables = List.of(
                "home_role",
                "home_user"
        );
        //获取所有数据库表名
        List<String> existingTables = this.getExistingTables();
        List<String> missingTables = requiredTables.stream()
                .filter(table -> !existingTables.contains(table))
                .toList();
        if (!missingTables.isEmpty()) {
            log.error("数据库表结构不完整，缺少以下表: {}", missingTables);
            //执行补救方法
            this.deleteAllTables(existingTables);
            this.createRequiredTables();
            defaultDataLoader.initializeData();
        } else {
            log.debug("数据库表结构检查通过，所有必需的表都已存在。");
        }
    }

    /**
     * 创建所有必需的数据库表。
     */
    private void createRequiredTables() throws IOException {
        log.debug("正在创建必需的数据库表...");
        // 按照自定义顺序读取sql文件进行表创建
        this.createTableFromSql("home_role");
        this.createTableFromSql("home_user");
        log.debug("所有必需的数据库表已创建或已存在。");
    }

    /**
     * 根据指定的表名从SQL文件中创建表。
     *
     * @param tableName 要创建的表名
     */
    private void createTableFromSql(String tableName) throws IOException {
        ClassPathResource resource = new ClassPathResource("sql/" + tableName + ".sql");
        String sql = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
        try {
            // 执行SQL语句创建表
            jdbcTemplate.execute(sql);
            log.debug("已成功创建表: {}", tableName);
        } catch (Exception e) {
            log.error("创建表 {} 时发生错误: {}", tableName, e.getMessage());
        }
    }

    /**
     * 删除所有已存在的用户表。
     * * 注意：此操作非常危险，将删除所有指定的用户表及其数据。
     *
     * @param existingTables 已存在的表名列表
     */
    private void deleteAllTables(@NotNull List<String> existingTables) {
        log.debug("正在执行删除所有数据库表的危险操作...");

        if (existingTables.isEmpty()) {
            log.debug("数据库中没有表需要删除。");
            return;
        }
        // 遍历并删除每个表
        for (String tableName : existingTables) {
            try {
                // 使用 "IF EXISTS" 避免删除不存在的表时报错
                // 使用 "CASCADE" 强制删除依赖对象（如外键约束）
                String dropSql = "DROP TABLE IF EXISTS " + tableName + " CASCADE";
                jdbcTemplate.execute(dropSql);
                log.debug("已删除表: {}", tableName);
            } catch (Exception e) {
                log.error("删除表 {} 时发生错误: {}", tableName, e.getMessage());
            }
        }
        log.debug("所有指定的用户表已尝试删除。");
    }

    /**
     * 获取当前数据库中已存在的表名列表。
     *
     * @return 已存在的表名列表
     */
    private @NotNull List<String> getExistingTables() {
        List<String> existingTables = jdbcTemplate.queryForList(
                "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'",
                String.class
        );
        log.debug("已存在的表名: {}", existingTables);
        return existingTables;
    }

}
