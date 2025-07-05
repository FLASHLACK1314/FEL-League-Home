package com.flashlack.felleaguehome.logic;

import cn.hutool.core.util.IdUtil;
import com.flashlack.felleaguehome.dao.RoleDAO;
import com.flashlack.felleaguehome.dao.UserDAO;
import com.flashlack.felleaguehome.model.entity.RoleDO;
import com.flashlack.felleaguehome.model.entity.UserDO;
import com.flashlack.felleaguehome.model.vo.RegisterVO;
import com.flashlack.felleaguehome.service.AuthService;
import com.flashlack.felleaguehome.service.RoleService;
import com.flashlack.felleaguehome.service.UserService;
import com.flashlack.felleaguehome.service.mail.MailService;
import com.flashlack.felleaguehome.util.PasswordUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;


/**
 * 认证逻辑类（AuthLogic）实现了 AuthService 接口，
 *
 * @author FLASHLACK
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthLogic implements AuthService {
    private final RoleDAO roleDAO;
    private final RoleService roleService;
    private final UserService userService;
    private final MailService mailService;
    private final UserDAO userDAO;
    private final PasswordUtil passwordUtil;


    @Override
    public void register(@NotNull RegisterVO registerVO) {
        log.debug("注册请求已接收");
        UserDO userDO = new UserDO();
        RoleDO roleDO = roleService.getRoleByName(registerVO.getRegisterRole());
        log.debug("获取角色信息: {}", roleDO);
        userDO.setUserUuid(IdUtil.fastUUID())
                .setUserName(registerVO.getUserName())
                .setPassword(passwordUtil.encryptPassword(registerVO.getPassword()))
                .setEmail(registerVO.getEmail())
                .setQqAccount(registerVO.getQq())
                .setRoleUuid(roleDO.getRoleUuid());
        userDAO.save(userDO);
    }

    @Override
    public void checkRegister(@NotNull RegisterVO registerVO) {
        log.debug("检查注册信息是否有效");
        userService.checkUserName(registerVO.getUserName());
        userService.checkEmail(registerVO.getEmail());
        userService.checkQa(registerVO.getQq());
        mailService.checkEmailCode(registerVO.getEmail(),registerVO.getEmailCode());
        log.debug("注册信息检查通过");
    }
}
