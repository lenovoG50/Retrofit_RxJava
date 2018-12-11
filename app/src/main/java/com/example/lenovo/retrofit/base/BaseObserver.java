package com.example.lenovo.retrofit.base;

import com.example.lenovo.retrofit.exception.ApiException;

import io.reactivex.Observer;

/**
 * Time:09:40
 * Author:lenovo
 * Description:新生成的类
 */
public abstract class BaseObserver<T> implements Observer<T> {
    @Override
    public void onError(Throwable e) {
        ApiException apiException= (ApiException) e;
        onError(apiException);
    }

    /**
     * @param e 错误的一个回调
     */
    protected abstract void onError(ApiException e);
}
