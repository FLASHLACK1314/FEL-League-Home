package com.flashlack.felleaguehome.expection;

import com.flashlack.felleaguehome.common.ErrorCodeEnum;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * 业务异常类（BusinessException）用于处理应用程序中的业务逻辑异常。
 * @author FLASHLACK
 */
@Getter
public class BusinessException extends RuntimeException {
    private final Integer code;

    public BusinessException(@NotNull ErrorCodeEnum errorCodeEnum) {
       super(errorCodeEnum.getMessage());
        this.code = errorCodeEnum.getCode();
    }

    public BusinessException(@NotNull ErrorCodeEnum errorCode, String customMessage) {
        // 允许自定义消息，但使用枚举的 code
        super(customMessage);
        this.code = errorCode.getCode();
    }

    // 如果需要，也可以保留只传入消息的构造函数，但默认码使用枚举
    public BusinessException(String message) {
        super(message);
        // 默认通用业务失败码
        this.code = ErrorCodeEnum.COMMON_BUSINESS_ERROR.getCode();
    }

}