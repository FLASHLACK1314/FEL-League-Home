package com.flashlack.felleaguehome.logic;

import com.flashlack.felleaguehome.common.ErrorCodeEnum;
import com.flashlack.felleaguehome.dao.RoleDAO;
import com.flashlack.felleaguehome.expection.BusinessException;
import com.flashlack.felleaguehome.model.entity.RoleDO;
import com.flashlack.felleaguehome.service.RoleService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 角色逻辑类（RoleLogic）用于处理与角色相关的业务逻辑。
 *
 * @author FLASHLACK
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RoleLogic implements RoleService {

    private final RoleDAO roleDAO;

    @Override
    public @NotNull RoleDO getRoleByName(String roleName) {
        RoleDO roleDO = roleDAO.getRoleByName(roleName);
        if (roleDO == null) {
            log.debug("角色名称 {} 不存在", roleName);
            throw new BusinessException(ErrorCodeEnum.ROLE_NOT_FOUND);
        }
        return roleDO;
    }
}
