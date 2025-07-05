package com.flashlack.felleaguehome.dao;

import com.flashlack.felleaguehome.common.ErrorCodeEnum;
import com.flashlack.felleaguehome.expection.BusinessException;
import com.flashlack.felleaguehome.mapper.RoleMapper;
import com.flashlack.felleaguehome.model.entity.RoleDO;
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
    public @NotNull RoleDO getRoleByUuid(@NotNull String roleUuid) {
        if (roleUuid.isEmpty()) {
            throw new IllegalArgumentException("RoleUuid不能为null或空字符串");
        }
        RoleDO roleDO = roleMapper.getRoleByUuid(roleUuid);
        if (roleDO == null) {
            throw new BusinessException(ErrorCodeEnum.ROLE_NOT_FOUND, "角色不存在或已被删除");
        }
        return roleDO;
    }

}
