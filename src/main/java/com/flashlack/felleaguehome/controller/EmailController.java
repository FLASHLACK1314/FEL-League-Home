package com.flashlack.felleaguehome.controller;

import com.flashlack.felleaguehome.common.Result;
import com.flashlack.felleaguehome.constant.StringConstant;
import com.flashlack.felleaguehome.service.mail.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 邮件控制器（EmailController）类，用于处理与邮件相关的请求。
 *
 * @author FLASHLACK
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/email")
public class EmailController {
    private final MailService mailService;

    /**
     * 发送邮件验证码接口。
     *
     * @param email 接收验证码的邮箱地址
     * @return 发送结果的响应结果
     */
    @PostMapping(value = "/sendCode", name = "发送邮件验证码")
    public Result<String> sendCode(
            @RequestParam("email") String email) {
        log.debug("发送邮件验证码请求已接收，邮箱: {}", email);
        if (!email.matches(StringConstant.Regular.EMAIL_REGULAR_EXPRESSION)) {
            log.debug("无效的邮箱格式: {}", email);
            return Result.fail("无效的邮箱格式");
        }
        mailService.checkCodeExpireTime(email);
        mailService.sendEmailCode(email);
        return Result.success("验证码已发送到您的邮箱，请注意查收");
    }
}
