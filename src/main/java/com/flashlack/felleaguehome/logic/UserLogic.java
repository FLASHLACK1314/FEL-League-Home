package com.flashlack.felleaguehome.logic;


import com.flashlack.felleaguehome.common.ErrorCodeEnum;
import com.flashlack.felleaguehome.dao.UserDAO;
import com.flashlack.felleaguehome.expection.BusinessException;
import com.flashlack.felleaguehome.model.entity.UserDO;
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

    /**
     * 检查用户名是否有效。
     * 如果用户名已存在，则抛出 BusinessException 异常。
     * @param username 用户名
     */
    @Override
    public void checkUserName(String username) {
        log.debug("检查用户名是否有效: {}", username);
        UserDO userDO = userDAO.getUserByUsername(username);
        if (userDO != null) {
            log.debug("用户名已存在: {}", username);
            throw new BusinessException(ErrorCodeEnum.USER_ALREADY_EXISTS);
        }
    }

    /**
     * 检查电子邮件是否有效。
     * 如果电子邮件已存在，则抛出 BusinessException 异常。
     * @param email 电子邮件地址
     */
    @Override
    public void checkEmail(String email) {
        log.debug("检查电子邮件是否有效: {}", email);
        UserDO userDO = userDAO.getUserByEmail(email);
        if (userDO != null) {
            log.debug("电子邮件已存在: {}", email);
            throw new BusinessException(ErrorCodeEnum.EMAIL_ALREADY_REGISTERED);
        }
    }

    @Override
    public void checkQa(String qq) {
        log.debug("检查QQ号是否有效: {}", qq);
        UserDO userDO = userDAO.getUserByQq(qq);
        if (userDO != null) {
            log.debug("QQ号已存在: {}", qq);
            throw new BusinessException(ErrorCodeEnum.QQ_ALREADY_REGISTERED);
        }
    }
}
