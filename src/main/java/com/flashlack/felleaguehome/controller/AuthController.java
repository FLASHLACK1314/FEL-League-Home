package com.flashlack.felleaguehome.controller;

import com.flashlack.felleaguehome.common.Result;
import com.flashlack.felleaguehome.model.vo.RegisterVO;
import com.flashlack.felleaguehome.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证控制器（AuthController）类。
 *
 * @author FLASHLACK
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {
    private final AuthService authService;

    /**
     * 用户注册接口。
     * @param registerVO 注册信息对象，包含用户名、密码等信息。
     * @return 注册成功的响应结果。
     */
    @PostMapping(value = "/register", name = "用户注册")
    public Result<String> register(
            @RequestBody @Valid RegisterVO registerVO
    ) {
        log.debug("注册请求已接收");
        authService.checkRegister(registerVO);
        authService.register(registerVO);
        return Result.success("注册成功");
    }


}
