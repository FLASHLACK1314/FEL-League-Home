package com.flashlack.felleaguehome.logic;


import com.flashlack.felleaguehome.dao.UserDAO;
import com.flashlack.felleaguehome.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户逻辑类（UserLogic）实现了与用户相关的业务逻辑。
 *
 * @author FLASHLACK
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserLogic implements UserService {
    private final UserDAO userDAO;

    @Override
    public void checkUserName(String username) {
        log.debug("检查用户名是否有效: {}", username);

    }
}
