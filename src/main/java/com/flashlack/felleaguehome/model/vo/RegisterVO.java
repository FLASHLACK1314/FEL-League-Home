package com.flashlack.felleaguehome.model.vo;


import com.flashlack.felleaguehome.constant.StringConstant;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;


/**
 * 注册视图对象（RegisterVO）类。
 *
 * @author FLASHLACK
 */
@Getter
public class RegisterVO {
    // 用户名
    @NotNull(message = "用户名不能为空")
    @Pattern(regexp = StringConstant.Regular.USER_NAME_REGULAR_EXPRESSION,
            message = "用户名格式不正确")
    private String userName;
    // 密码
    @NotNull(message = "密码不能为空")
    @Pattern(regexp = StringConstant.Regular.PASSWORD_REGULAR_EXPRESSION,
            message = "密码格式不正确")
    private String password;
    // 电子邮件地址
    @NotNull(message = "电子邮件不能为空")
    @Pattern(regexp = StringConstant.Regular.EMAIL_REGULAR_EXPRESSION,
            message = "电子邮件格式不正确")
    private String email;
    //邮箱验证码
    @NotNull(message = "邮箱验证码不能为空")
    @Pattern(regexp = StringConstant.Regular.EMAIL_CODE_REGULAR_EXPRESSION,
            message = "邮箱验证码格式不正确")
    private String emailCode;
    // QQ号
    @NotNull(message = "QQ号不能为空")
    @Pattern(regexp = StringConstant.Regular.QQ_REGULAR_EXPRESSION,
            message = "QQ号格式不正确")
    private String qq;
    // 角色
    @NotNull(message = "角色不能为空")
    @Pattern(regexp = StringConstant.Regular.REGISTER_ROLE_REGULAR_EXPRESSION, message = "角色格式不正确")
    private String registerRole;
}
