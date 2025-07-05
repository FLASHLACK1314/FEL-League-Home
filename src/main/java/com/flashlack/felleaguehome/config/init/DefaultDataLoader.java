package com.flashlack.felleaguehome.config.init;

import cn.hutool.core.util.IdUtil;
import com.flashlack.felleaguehome.dao.RoleDAO;
import com.flashlack.felleaguehome.dao.UserDAO;
import com.flashlack.felleaguehome.model.entity.RoleDO;
import com.flashlack.felleaguehome.util.PasswordUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
/**
 * 默认数据加载器类（DefaultDataLoader）用于初始化应用程序的默认数据。
 *
 * @author FLASHLACK
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultDataLoader {
    private final RoleDAO roleDAO;
    private final UserDAO userDAO;
    private final PasswordUtil passwordUtil;

    /**
     * 初始化默认数据
     */
    public void initializeData() {
        log.debug("开始加载默认数据");
        loadDefaultRoleData();
        // 可以在这里添加更多的默认数据加载方法
        log.debug("默认数据加载完成");
    }

    /**
     * 加载默认角色数据数据。
     */
    private void loadDefaultRoleData() {
        log.debug("开始加载默认角色数据");
        RoleDO superAdmin = new RoleDO();
        superAdmin.setRoleUuid(IdUtil.fastUUID());
        superAdmin.setRoleName("superAdmin");
        superAdmin.setDescription("系统管理员，拥有所有权限");
        roleDAO.save(superAdmin);
        RoleDO admin = new RoleDO();
        admin.setRoleUuid(IdUtil.fastUUID());
        admin.setRoleName("admin");
        admin.setDescription("管理员，拥有管理用户和角色的权限");
        roleDAO.save(admin);
        RoleDO user = new RoleDO();
        user.setRoleUuid(IdUtil.fastUUID());
        user.setRoleName("user");
        user.setDescription("普通用户，拥有基本的访问权限");
        roleDAO.save(user);
    }

}
