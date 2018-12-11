package com.example.lenovo.retrofit.base;

/**
 * Time:17:00
 * Author:lenovo
 * Description:一个基类的bean, 直接在泛型中传data就行
 */
public class BaseHttpResult<T> {
    private String reason;
    private int code;
    private T result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


    @Override
    public String toString() {
        return "BaseHttpResult{" +
                "reason='" + reason + '\'' +
                ", error_code=" + code +
                ", result=" + result +
                '}';
    }
}
