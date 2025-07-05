package com.flashlack.felleaguehome.constant;

import lombok.extern.slf4j.Slf4j;
import org.intellij.lang.annotations.Language;

/**
 * 字符串常量类，定义了应用程序中使用的字符串常量。
 *
 * @author FLASHLACK
 */
@Slf4j
public class StringConstant {


    private StringConstant() {
        log.error("StringConstant 不能被实例化");
    }

    /**
     * 正则表达式常量类，定义了应用程序中使用的正则表达式。
     */
    public static class Regular {
        @Language("RegExp")
        public static final String EMAIL_REGULAR_EXPRESSION = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        public static final String EMAIL_CODE_REGULAR_EXPRESSION = "^[0-9]{6}$";
        public static final String USER_NAME_REGULAR_EXPRESSION = "^[0-9A-Za-z_-]{4,32}$";
        public static final String PASSWORD_REGULAR_EXPRESSION = "^(?=.*\\\\d)(?=.*[a-zA-Z]).{7,}$";
        public static final String QQ_REGULAR_EXPRESSION = "^[1-9][0-9]{4,14}$";
        //用户注册角色为user(用户), admin(联赛管理员)
        public static final String REGISTER_ROLE_REGULAR_EXPRESSION = "^(user|admin)$";
    }
}
