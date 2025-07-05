package com.flashlack.felleaguehome.service;

/**
 * 用户服务接口（UserService）定义了与用户相关的业务逻辑方法。
 * @author FLASHLACK
 */
public interface UserService {
    /**
     * 检查用户名是否有效。
     * @param username 用户名
     */
    void checkUserName(String username);

}
