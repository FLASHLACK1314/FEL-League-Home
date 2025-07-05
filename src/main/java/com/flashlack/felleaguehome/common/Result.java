package com.flashlack.felleaguehome.common;


import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * 通用结果类，用于封装API响应结果。
 *
 * @author FLASHLACK
 */
@Data
public class Result<T> {
    // 业务状态码
    private int code;
    // 响应信息
    private String message;
    // 响应数据
    private T data;

    /**
     * 成功响应（无数据）
     *
     * @return 通用结果对象
     */
    public static <T> @NotNull Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("操作成功");
        return result;
    }


    /**
     * 成功响应（有数据）
     *
     * @param data 响应数据
     * @return 通用结果对象
     */
    public static <T> @NotNull Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }

    /**
     * 失败响应（带消息）
     */
    public static <T> @NotNull Result<T> fail(String message) {
        Result<T> result = new Result<>();
        result.setCode(1000);
        result.setMessage(message);
        return result;
    }

    /**
     * 失败响应（带状态码和消息）
     */
    public static <T> @NotNull Result<T> fail(Integer code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 失败响应（带状态码、消息和数据）
     */
    public static <T> @NotNull Result<T> fail(Integer code, String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
