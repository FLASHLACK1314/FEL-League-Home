package com.flashlack.felleaguehome.dao;

import com.flashlack.felleaguehome.common.ErrorCodeEnum;
import com.flashlack.felleaguehome.expection.BusinessException;
import com.flashlack.felleaguehome.mapper.RoleMapper;
import com.flashlack.felleaguehome.model.entity.RoleDO;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

/**
 * 角色数据访问对象（RoleDAO）类。
 * * 该类实现了RoleMapper接口，提供对角色数据的访问方法。
 * * @author FLASHLACK
 */
@Repository
@RequiredArgsConstructor
public class RoleDAO {
    private final RoleMapper roleMapper;

    /**
     * 根据角色UUID获取角色信息。
     * @param roleUuid 角色的唯一标识符
     * @return RoleDO 角色数据对象
     * @throws IllegalArgumentException 如果roleUuid为null或空字符串
     */
    public @NotNull RoleDO getRoleByUuid(@NotBlank String roleUuid) {
        if (roleUuid.isEmpty()) {
            throw new BusinessException(ErrorCodeEnum.UUID_BLANK, "角色UUID不能为空");
        }
        return roleMapper.getRoleByUuid(roleUuid);
    }

    /**
     * 保存角色信息。
     * @param roleDO 角色数据对象
     */
    public void save(RoleDO roleDO) {
        roleMapper.save(roleDO);
    }
}
