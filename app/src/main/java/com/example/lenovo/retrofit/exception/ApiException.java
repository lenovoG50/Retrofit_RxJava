package com.example.lenovo.retrofit.exception;

/**
 * Time:09:43
 * Author:lenovo
 * Description:Http错误
 */
public class ApiException extends RuntimeException{
    public int code;
    public String message;

    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }
}
