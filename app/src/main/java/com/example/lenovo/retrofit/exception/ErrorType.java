package com.example.lenovo.retrofit.exception;

/**
 * Time:09:52
 * Author:lenovo
 * Description:错误类型
 */
public interface ErrorType { /**
 * 请求成功
 */
int SUCCESS = 0;
    /**
     * 未知错误
     */
    int UNKONW = 1000;
    /**
     * 解析错误
     */
    int PARSE_ERROR = 1001;
    /**
     * 网络错误
     */
    int NETWORK_ERROR = 1002;
    /**
     * HTTP请求错误
     */
    int HTTP_ERROR = 1003;
    /**
     * 解析对象为空
     */
    int EMPTY_BEAN = 1004;
}
