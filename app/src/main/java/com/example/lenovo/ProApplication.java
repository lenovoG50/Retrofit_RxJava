package com.example.lenovo;

import android.app.Application;
import android.content.Context;


/**
 * Time:09:36
 * Author:lenovo
 * Description:新生成的类
 */
public class ProApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    /**
     * @return 全局的上下文
     */
    public static Context getContext() {
        return mContext;
    }
}
