package com.flashlack.felleaguehome.model;

import lombok.Data;

/**
 * 角色数据对象（RoleDO）类。
 *
 * @author FLSHLACK
 */
@Data
public class RoleDO {
    // 角色唯一标识符
    private String roleUuid;
    // 角色名称
    private String roleName;
    // 角色描述
    private String description;
}
