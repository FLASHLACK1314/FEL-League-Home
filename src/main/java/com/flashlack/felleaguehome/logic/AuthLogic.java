package com.flashlack.felleaguehome.logic;

import com.flashlack.felleaguehome.dao.RoleDAO;
import com.flashlack.felleaguehome.dao.UserDAO;
import com.flashlack.felleaguehome.model.vo.RegisterVO;
import com.flashlack.felleaguehome.service.AuthService;
import com.flashlack.felleaguehome.service.UserService;
import com.flashlack.felleaguehome.service.mail.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final UserService userService;
    private final MailService mailService;
    private final UserDAO userDAO;

    @Override
    public void register(RegisterVO registerVO) {
        log.debug("注册请求已接收");
    }

    @Override
    public void checkRegister(RegisterVO registerVO) {
        log.debug("检查注册信息是否有效");
        userService.checkUserName(registerVO.getUserName());
        userService.checkEmail(registerVO.getEmail());
        userService.checkQa(registerVO.getQq());
        log.debug("注册信息检查通过");
    }
}
