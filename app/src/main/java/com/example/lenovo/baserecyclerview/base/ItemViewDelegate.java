package com.example.lenovo.baserecyclerview.base;

/**
 * Time:17:00
 * Author:lenovo
 * Description:新生成的类
 */
public interface ItemViewDelegate<T> {
    int getItemViewLayoutId();
    boolean isForViewType(T item, int position);
    void convert(ViewHolder holder, T t, int position);

}
