package com.flashlack.felleaguehome.dao;


import com.flashlack.felleaguehome.mapper.UserMapper;
import com.flashlack.felleaguehome.model.entity.UserDO;
import jakarta.validation.constraints.NotBlank;
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
    public UserDO getUserByUsername(@NotBlank String username) {
        return userMapper.getUserByUsername(username);
    }

    /**
     * 根据电子邮件获取用户信息。
     *
     * @param email 电子邮件地址
     * @return 用户信息
     */
    public UserDO getUserByEmail(@NotBlank String email) {
        return userMapper.getUserByEmail(email);
    }

    /**
     * 根据QQ号获取用户信息。
     *
     * @param qq QQ号
     * @return 用户信息
     */
    public UserDO getUserByQq(String qq) {
        return userMapper.getUserByQqAccount(qq);
    }

    /**
     * 保存超级管理员用户信息。
     *
     * @param userDO 用户数据对象
     */
    public void save(UserDO userDO) {
        userMapper.save(userDO);
    }
}
