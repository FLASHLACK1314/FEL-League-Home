package com.flashlack.felleaguehome.dao;

import com.flashlack.felleaguehome.mapper.RoleMapper;
import com.flashlack.felleaguehome.model.RoleDO;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

/**
 * 角色数据访问对象（RoleDAO）类。
 * * 该类实现了RoleMapper接口，提供对角色数据的访问方法。
 * * @author FLASHLACK
 */
@Repository
public class RoleDAO {
    private final RoleMapper roleMapper;

    /**
     * 构造函数，注入RoleMapper依赖。
     * @param roleMapper 角色映射器
     */
    public RoleDAO(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }
    /**
     * 根据角色UUID获取角色信息。
     * @param roleUuid 角色的唯一标识符
     * @return RoleDO 角色数据对象
     * @throws IllegalArgumentException 如果roleUuid为null或空字符串
     */
    public RoleDO getRoleByUuid(@NotNull String roleUuid) {
        if (roleUuid.isEmpty()) {
            throw new IllegalArgumentException("RoleUuid不能为null或空字符串");
        }
        return roleMapper.getRoleByUuid(roleUuid);
    }

}
