package com.suyan.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value = "Rest result", description = "请求结果")
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -4696898674758053321L;

    @ApiModelProperty(value = "结果代码")
    private int code;
    @ApiModelProperty(value = "错误说明")
    private String message = "";
    @ApiModelProperty(value = "结果对象")
    private T data;
    @ApiModelProperty(value = "操作标识")
    private boolean success;
    @ApiModelProperty(value = "当前时间戳")
    private Long timestamp;

    public Result(int code, String message, boolean success, T data) {
        this.setCode(code);
        this.setMessage(message);
        this.setSuccess(success);
        this.setData(data);
    }

    public Result(int code, String message, T data) {
        this.setCode(code);
        this.setMessage(message);
        this.setSuccess(code == 200);
        this.setData(data);
    }

    public Result() {
    }

    public static <T> Result<T> custom(int code, String message) {
        return new Result<T>(code, message, null);
    }

    public static <T> Result<T> custom(int code, String message, T data) {
        return new Result<T>(code, message, data);
    }

    /**
     * 构建返回对象实例
     *
     * @param resultCode
     * @param success
     * @param value
     * @return
     */
    public static <T> Result<T> newInstance(ResultCode resultCode, boolean success, T value) {
        return new Result<T>(resultCode.code, resultCode.desc, success, value);
    }

    /**
     * 构建成功对象实例
     *
     * @return
     */
    public static <T> Result<T> newSuccess() {
        return new Result<T>(ResultCode.SUCCESS.code,
                ResultCode.SUCCESS.desc, true, null);
    }

    /**
     * 构建成功对象实例
     *
     * @return
     */
    public static <T> Result<T> newSuccess(T value) {
        return new Result<T>(ResultCode.SUCCESS.code,
                ResultCode.SUCCESS.desc, true, value);
    }

    public static <T> Result<T> newSuccess(T data, String message) {
        return new Result<T>(ResultCode.SUCCESS.code, message, true, data);
    }

    public static <T> Result<T> newError(String message) {
        Result<T> result = new Result<T>(ResultCode.COMMON_MESSAGE.code, message, false, null);
        return result;
    }

    /**
     * 构建错误对象
     *
     * @param errorCode
     * @return
     */

    public static <T> Result<T> newError(ResultCode errorCode) {
        return new Result<T>(errorCode.code, errorCode.desc, false, null);
    }

    public static <T> Result<T> newError(int code, String message, Object... args) {
        Result<T> r = new Result<T>(code, "", false, null);
        r.setFormatMessage(message, args);
        return r;
    }

    public static <T> Result<T> newError(ResultCode resultCode, Object... args) {
        Result<T> r = new Result<T>(resultCode.getCode(), "", false, null);
        r.setFormatMessage(resultCode.getDesc(), args);

        return r;
    }

    /**
     * 设置错误编码
     *
     * @param errorCode
     */
    public Result<T> setErrorCode(ResultCode errorCode) {
        if (errorCode == null) return null;

        this.code = errorCode.code;
        this.message = errorCode.desc;
        this.success = false;
        return this;
    }

    /**
     * 设置错误编码
     *
     * @param errorCode
     * @param args
     * @return
     */
    public Result<T> setErrorCode(ResultCode errorCode, Object... args) {
        if (errorCode == null) return null;

        this.code = errorCode.code;
        setFormatMessage(errorCode.getDesc(), args);
        this.success = false;
        return this;
    }

    public void setMessageStatus(ResultCode resultCode, Object... args) {
        setCode(resultCode.getCode());
        setFormatMessage(resultCode.getDesc(), args);
    }

    public void setFormatMessage(String message, Object... args) {
        if (args == null || args.length == 0) {
            this.setMessage(message);
        } else {
            this.setMessage(String.format(message, args));
        }
    }

}
