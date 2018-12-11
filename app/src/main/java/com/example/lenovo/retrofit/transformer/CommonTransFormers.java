package com.example.lenovo.retrofit.transformer;

import com.example.lenovo.retrofit.base.BaseHttpResult;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Time:15:41
 * Author:lenovo
 * Description:新生成的类
 */
public class CommonTransFormers<T> implements ObservableTransformer<BaseHttpResult<T>,T> {

    @Override
    public ObservableSource<T> apply(Observable<BaseHttpResult<T>> upstream) {
        return upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(ErrorTransformer.getInstance());
    }
}
