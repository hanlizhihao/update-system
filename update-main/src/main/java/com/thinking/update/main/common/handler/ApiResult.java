package com.thinking.update.main.common.handler;

/**
 * @author Administrator
 * @create 2018/5/27
 */

import java.io.Serializable;

/**
 * 统一返回对象.
 * @author Administrator
 */

public class ApiResult implements Serializable {

    /**
     * 成功
     */
    public static final int OK = 200;

    /**
     * 数据库异常
     */
    public static final int DB_ERROR = 300;

    /**
     * 调用远程服务异常
     */
    public static final int RPC_ERROR = 400;

    /**
     * 参数异常
     */
    public static final int INVALID_ARG_ERROR = 500;

    /**
     * 表单验证异常
     */
    public static final int FORM_VALID_ERROR = 501;

    /**
     * 业务异常
     */
    public static final int BUSINESS_ERROR = 600;

    /**
     * 服务端内部异常
     */
    public static final int INTERNAL_SERVER_ERROR = 900;

    /**
     * 登录异常
     */
    public static final int LOGIN_ERROR = 1000;

    private int code = OK;

    private String message;

    private Object result;


    public ApiResult(Object result) {
        this.result = result;
    }

    public ApiResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
