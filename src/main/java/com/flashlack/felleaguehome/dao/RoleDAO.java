package com.flashlack.felleaguehome.dao;

import com.flashlack.felleaguehome.common.ErrorCodeEnum;
import com.flashlack.felleaguehome.expection.BusinessException;
import com.flashlack.felleaguehome.mapper.RoleMapper;
import com.flashlack.felleaguehome.model.entity.RoleDO;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * 角色数据访问对象（RoleDAO）类。
 * * 该类实现了RoleMapper接口，提供对角色数据的访问方法。
 * * @author FLASHLACK
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class RoleDAO {
    private final RoleMapper roleMapper;

    /**
     * 根据角色UUID获取角色信息。
     *
     * @param roleUuid 角色的唯一标识符
     * @return RoleDO 角色数据对象
     * @throws IllegalArgumentException 如果roleUuid为null或空字符串
     */
    public RoleDO getRoleByUuid(@NotBlank String roleUuid) {
        log.debug("根据角色UUID获取角色信息: {}", roleUuid);
        if (roleUuid.isEmpty()) {
            throw new BusinessException(ErrorCodeEnum.UUID_BLANK, "角色UUID不能为空");
        }
        return roleMapper.getRoleByUuid(roleUuid);
    }

    /**
     * 根据角色名称获取角色信息。
     * @param roleName 角色名称
     * @return RoleDO 角色数据对象
     */
    public RoleDO getRoleByName(@NotBlank String roleName) {
        log.debug("根据角色名称获取角色信息: {}", roleName);
        if (roleName.isEmpty()) {
            throw new BusinessException(ErrorCodeEnum.UUID_BLANK, "角色名称不能为空");
        }
        return roleMapper.getRoleByName(roleName);
    }

    /**
     * 保存角色信息。
     * @param roleDO 角色数据对象
     */
    public void save(RoleDO roleDO) {
        log.debug("保存角色信息: {}", roleDO);
        roleMapper.save(roleDO);
    }
}
