package com.flashlack.felleaguehome.service;

import com.flashlack.felleaguehome.model.vo.RegisterVO;

/**
 * 认证服务接口（AuthService）用于处理用户认证相关的操作。
 *
 * @author FLASHLACK
 */
public interface AuthService {
    /**
     * 用户注册方法。
     * @param registerVO 注册信息对象，包含用户名、密码等信息。
     */
    void register(
            RegisterVO registerVO);

    /**
     * 检查注册信息的有效性。
     * @param registerVO 注册信息对象，包含用户名、密码等信息。
     */
    void checkRegister(
            RegisterVO registerVO);
}
