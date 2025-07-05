package com.flashlack.felleaguehome.dao;


import com.flashlack.felleaguehome.common.ErrorCodeEnum;
import com.flashlack.felleaguehome.expection.BusinessException;
import com.flashlack.felleaguehome.mapper.UserMapper;
import com.flashlack.felleaguehome.model.entity.UserDO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 用户数据访问对象（UserDAO）类。
 *
 * @author FLASHLACK
 */
@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;


    /**
     * 根据用户名获取用户信息。
     *
     * @param username 用户名
     * @return 用户信息
     */
    public @NotNull UserDO getUserByUsername(@NotBlank String username) {
        UserDO userDO = userMapper.getUserByUsername(username);
        if (userDO == null) {
            throw new BusinessException(ErrorCodeEnum.USER_NOT_FOUND, "用户不存在");
        }
        return userDO;
    }


}
