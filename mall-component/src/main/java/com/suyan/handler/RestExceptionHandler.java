/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.handler;


import com.suyan.exception.CommonException;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Status;
import org.zalando.problem.StatusType;
import org.zalando.problem.ThrowableProblem;
import org.zalando.problem.spring.web.advice.AdviceTrait;


/**
 * 全局异常处理
 */
@ControllerAdvice
public class RestExceptionHandler implements AdviceTrait {

    private static Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);


    @ExceptionHandler(value = {Throwable.class})
    @ResponseBody
    public Result<String> jsonErrorHandler(final NativeWebRequest req, final Throwable e) throws Exception {
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException validException = (MethodArgumentNotValidException) e;
            String defaultMessage = validException.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
            return Result.newError(defaultMessage);
        }
        if (e instanceof HttpMessageNotReadableException) {
            return Result.newError(ResultCode.C400);
        }
        if (e instanceof CommonException) {
            LOGGER.warn(e.getMessage(), e);
            Result<String> result = Result.newSuccess();
            result.setSuccess(false);
            result.setCode(((CommonException) e).getCode());
            result.setMessage(((CommonException) e).getMessage());
            return result;
        }
        LOGGER.error("全局异常", e);
        ThrowableProblem problem = this.toProblem(e);
        Result<String> result = toResult(problem);
        return result;
    }

    @ExceptionHandler
    @ResponseBody
    public Result<String> handleMediaTypeNotAcceptable(final HttpMediaTypeNotAcceptableException exception, final NativeWebRequest request) {
        return toProblemIspsResult(exception, Status.NOT_ACCEPTABLE);
    }

    @ExceptionHandler
    @ResponseBody
    public Result<String> handleRequestMethodNotSupportedException(final HttpRequestMethodNotSupportedException exception, final NativeWebRequest request) {
        Result<String> result = Result.newError(ResultCode.C405);
        result.setMessage(exception.getMessage());
        return result;
    }

    @ExceptionHandler
    @ResponseBody
    public Result<String> handleMediaTypeNotSupportedException(final HttpMediaTypeNotSupportedException exception, final NativeWebRequest request) {
        Result<String> result = Result.newError(ResultCode.C415);
        result.setMessage(exception.getMessage());
        return result;
    }


    private Result<String> toProblemIspsResult(final Throwable throwable, final StatusType status) {
        ThrowableProblem throwableProblem = this.toProblem(throwable, status);
        return toResult(throwableProblem);
    }

    private Result<String> toResult(ThrowableProblem problem) {
        try {
            return Result.newError(ResultCode.SYS_ERROR);
        } catch (Exception e) {
            LOGGER.error("内部异常", e);
            return Result.newError(ResultCode.SYS_ERROR);
        }
    }

}
