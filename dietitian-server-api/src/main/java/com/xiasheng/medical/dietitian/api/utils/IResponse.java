package com.xiasheng.medical.dietitian.api.utils;

import java.io.Serializable;

public class IResponse<T> implements Serializable {

    public static final int CODE_SUCCESS = 200;
    public static final int CODE_FAILURE = 500;

    private int code = CODE_SUCCESS;

    private T data;

    private String errorMsg;

    public static <T> IResponse<T> success(T data) {
        IResponse<T> result = new IResponse<>();
        result.code = CODE_SUCCESS;
        result.data = data;
        return result;
    }

    public static <T> IResponse<T> fail(String errorMsg) {
        IResponse<T> result = new IResponse<>();
        result.code = CODE_FAILURE;
        result.errorMsg = errorMsg;
        return result;
    }

    public static <T> IResponse<T> fail(T data, String errorMsg) {
        IResponse<T> result = new IResponse<>();
        result.code = CODE_FAILURE;
        result.data = data;
        result.errorMsg = errorMsg;
        return result;
    }

    public boolean isSuccess() {
        return code == CODE_SUCCESS;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
