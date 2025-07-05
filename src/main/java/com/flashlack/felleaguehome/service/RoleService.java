package com.flashlack.felleaguehome.service;

import com.flashlack.felleaguehome.model.entity.RoleDO;

/**
 * 角色服务接口（RoleService）用于处理与角色相关的操作。
 *
 * @author FLASHLACK
 */

public interface RoleService {

    /**
     * 根据角色名称获取角色信息。
     * @param roleName 角色名称
     * @return RoleDO 角色数据对象
     */
    RoleDO getRoleByName(String roleName);
}
