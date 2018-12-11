package com.example.lenovo.retrofit.transformer;

import android.util.Log;

import com.example.lenovo.retrofit.base.BaseHttpResult;
import com.example.lenovo.retrofit.exception.ErrorType;
import com.example.lenovo.retrofit.exception.ExceptionEngine;
import com.example.lenovo.retrofit.exception.ServerException;
import com.example.lenovo.retrofit.utils.LoggerUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


/**
 * Time:10:04
 * Author:lenovo
 * Description:Error Transformer
 */
public class ErrorTransformer<T> implements ObservableTransformer<BaseHttpResult<T>, T> {
    private static ErrorTransformer errorTransformer = null;
    private static final String TAG = "ErrorTransformer";

    @Override
    public ObservableSource<T> apply(Observable<BaseHttpResult<T>> upstream) {
        return upstream.map(new Function<BaseHttpResult<T>, T>() {
            @Override
            public T apply(@NonNull BaseHttpResult<T> tBaseHttpResult) throws Exception {
                if (tBaseHttpResult == null) {
                    throw new ServerException(ErrorType.EMPTY_BEAN, "解析对象为空");
                }
                LoggerUtils.e(TAG, tBaseHttpResult.toString());
                if (tBaseHttpResult.getCode() != ErrorType.SUCCESS) {
                    throw new ServerException(tBaseHttpResult.getCode(),
                            tBaseHttpResult.getReason());
                }
                Log.d(TAG, tBaseHttpResult.getResult().toString());
                return tBaseHttpResult.getResult();
            }
        }).onErrorResumeNext(new Function<Throwable, ObservableSource<? extends T>>() {
            @Override
            public ObservableSource<? extends T> apply(@NonNull Throwable throwable)
                    throws Exception {
                // ExceptionEngine 为处理异常的驱动器 throwable
                throwable.printStackTrace();
                return Observable.error(ExceptionEngine.handleException(throwable));
            }
        });
    }

    public static <T> ErrorTransformer<T> getInstance() {
        if (errorTransformer == null) {
            synchronized (ErrorTransformer.class) {
                if (errorTransformer == null) {
                    errorTransformer = new ErrorTransformer();
                }
            }
        }
        return errorTransformer;
    }
}
