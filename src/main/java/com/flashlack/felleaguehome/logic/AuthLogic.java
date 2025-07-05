package com.flashlack.felleaguehome.logic;

import com.flashlack.felleaguehome.dao.RoleDAO;
import com.flashlack.felleaguehome.dao.UserDAO;
import com.flashlack.felleaguehome.model.vo.RegisterVO;
import com.flashlack.felleaguehome.service.AuthService;
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
    private final UserDAO userDAO;

    @Override
    public void register(RegisterVO registerVO) {
        log.debug("注册请求已接收");
    }

    @Override
    public void checkRegister(RegisterVO registerVO) {
    }
}
