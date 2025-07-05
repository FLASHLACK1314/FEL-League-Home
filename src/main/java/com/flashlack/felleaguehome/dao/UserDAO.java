package com.flashlack.felleaguehome.dao;


import com.flashlack.felleaguehome.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 用户数据访问对象（UserDAO）类。
 * @author FLASHLACK
 */
@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

}
