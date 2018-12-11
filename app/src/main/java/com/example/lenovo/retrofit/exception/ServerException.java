package com.example.lenovo.retrofit.exception;

/**
 * Time:09:53
 * Author:lenovo
 * Description:新生成的类
 */
public class ServerException extends RuntimeException {
    public int code;
    public String message;

    public ServerException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
