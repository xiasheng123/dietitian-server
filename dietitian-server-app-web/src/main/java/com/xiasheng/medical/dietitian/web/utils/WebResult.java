package com.xiasheng.medical.dietitian.web.utils;

import lombok.Data;

/**
 * Created by fu on 2017/9/12.
 */

@Data
public class WebResult<T> {

    public static final Integer INTERNAL_ERROR = 500;
    public static final Integer SERVICE_EXCEPTION = 501;
    public static final Integer PARAM_ERROR = 999;
    public static final int AUTHORITY_ERROR = 401;
    public static final Integer SUCCESS = 200;
    public static final Integer INPUT_ERROR = 402;

    private Integer code = SUCCESS;
    private String msg;
    private T result;

    public static WebResult fail(String msg) {
        WebResult webResult = new WebResult();
        webResult.setCode(INTERNAL_ERROR);
        webResult.setMsg(msg);
        return webResult;
    }

    public static WebResult success(Object result) {
        WebResult webResult = new WebResult();
        webResult.setCode(SUCCESS);
        webResult.setResult(result);
        return webResult;
    }

    public static boolean isSuccess(WebResult result) {
        return SUCCESS.equals(result.getCode());
    }

    public WebResult() {
    }

    public WebResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
