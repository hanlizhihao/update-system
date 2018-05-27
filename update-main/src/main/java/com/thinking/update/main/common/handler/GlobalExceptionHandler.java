package com.thinking.update.main.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 统一异常处理
 * @author Administrator
 * @create 2018/5/27
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResult handleException(Exception e) {
        log.error("异常", e);
        int code = ApiResult.INVALID_ARG_ERROR;
        String message = e.getMessage();
        return new ApiResult(code, message);
    }
}
