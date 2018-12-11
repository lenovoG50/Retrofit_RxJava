package com.example.lenovo.retrofit.Observer;

import android.content.Context;

import com.example.lenovo.retrofit.base.BaseObserver;
import com.example.lenovo.retrofit.exception.ApiException;
import com.example.lenovo.retrofit.utils.LoggerUtils;
import com.example.lenovo.retrofit.utils.NetworkUtil;

import io.reactivex.disposables.Disposable;

/**
 * Time:09:56
 * Author:lenovo
 * Description:新生成的类
 */
public abstract class CommonObserver<T> extends BaseObserver<T> {
    private static final String TAG = "CommonObserver";
    private Context context;
    // Disposable 相当于RxJava1.x中的 Subscription，用于解除订阅 disposable.dispose();
    protected Disposable disposable;

    public CommonObserver(Context context) {
        this.context = context;
    }

    @Override
    public void onSubscribe(Disposable d) {
        disposable = d;
        if (!NetworkUtil.isNetworkAvailable(context))
            LoggerUtils.e(TAG, "网络不可用");
        else
            LoggerUtils.e(TAG, "网络可用");
    }

    @Override
    protected void onError(ApiException e) {
        LoggerUtils.e(TAG, "HTTP错误-->" + "code:" + e.code + ",message:" + e.message);
    }

    @Override
    public void onComplete() {
        LoggerUtils.e(TAG, "成功了");
    }
}
