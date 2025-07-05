package com.flashlack.felleaguehome.expection;

import com.flashlack.felleaguehome.common.ErrorCodeEnum;
import com.flashlack.felleaguehome.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器（GlobalExceptionHandler）用于捕获和处理应用程序中的所有异常。
 *
 * @author FLASHLACK
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获自定义的业务异常 (BusinessException)。
     * 当业务逻辑中抛出 BusinessException 时，会被此方法捕获并统一处理。
     * 通常业务异常返回 HTTP 状态码 200 OK，具体的错误信息在 Result 的 code 和 message 中体现。
     *
     * @param e 业务异常实例
     * @return 统一封装的 Result 对象
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK) // HTTP 状态码 200，表示请求本身是成功的，但业务逻辑有错误
    public Result<?> handleBusinessException(@NotNull BusinessException e) {
        // 从 BusinessException 中获取 code 和 message，直接用于 Result 返回
        log.debug("捕获到业务异常: {}", e.getMessage());
        return Result.fail(e.getCode(), e.getMessage());
    }

    /**
     * 捕获方法参数校验异常 (MethodArgumentNotValidException)。
     * 当控制器方法参数使用了 @Valid 或 @Validated 注解，且校验失败时，会抛出此异常。
     * 例如：@NotBlank, @Pattern 等校验不通过。
     * 通常返回 HTTP 状态码 400 Bad Request，表示客户端请求参数有问题。
     *
     * @param ex 参数校验异常实例
     * @return 统一封装的 Result 对象，包含详细的参数错误信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // HTTP 状态码 400，表示请求参数错误
    public Result<?> handleValidationExceptions(@NotNull MethodArgumentNotValidException ex) {
        // 获取第一个校验错误的消息作为 Result 的 message
        String firstErrorMessage = ex.getBindingResult().getAllErrors().stream()
                .findFirst() // 找到第一个错误
                // 获取其默认消息
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse(ErrorCodeEnum.INVALID_PARAMETER.getMessage());
        // 返回一个包含错误码和第一个错误消息的 Result 对象
        // data 字段将为 null，因为没有设置
        log.debug("参数校验失败: {}", firstErrorMessage);
        return Result.fail(ErrorCodeEnum.INVALID_PARAMETER.getCode(), firstErrorMessage);
    }

    /**
     * 捕获所有其他未被特定处理的异常 (Exception)。
     * 这是一个“兜底”的异常处理器，用于捕获应用程序中所有未预料到的运行时错误。
     * 通常返回 HTTP 状态码 500 Internal Server Error，表示服务器内部发生错误。
     *
     * @param e 异常实例
     * @return 统一封装的 Result 对象
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // HTTP 状态码 500，表示服务器内部错误
    public Result<?> handleGlobalException(Exception e) {
        // 打印堆栈信息，这对于调试非常重要，但在生产环境中可能需要更高级的日志记录
        log.debug("捕获到全局异常: ", e);
        // 返回一个通用的服务器内部错误信息
        return Result.fail(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getCode(), ErrorCodeEnum.INTERNAL_SERVER_ERROR.getMessage());
    }
}
