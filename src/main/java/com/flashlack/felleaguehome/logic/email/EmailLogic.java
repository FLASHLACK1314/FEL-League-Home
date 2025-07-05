package com.flashlack.felleaguehome.logic.email;


import com.flashlack.felleaguehome.service.mail.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * 电子邮件逻辑处理类（EmailLogic）。
 *
 * @author FLASHLACK
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class EmailLogic implements MailService {
    private final JavaMailSender javaMailSender;


}
