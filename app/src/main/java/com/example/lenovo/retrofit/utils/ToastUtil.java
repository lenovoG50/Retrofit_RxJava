package com.example.lenovo.retrofit.utils;

import android.widget.Toast;

import com.example.lenovo.ProApplication;

/**
 * Time:10:08
 * Author:lenovo
 * Description:新生成的类
 */
public class ToastUtil {
    public static Toast toast;

    private ToastUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void showShort(CharSequence message) {
        if (toast == null) {
            toast = Toast.makeText(ProApplication.getContext(), message, Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        toast.show();
    }
}
