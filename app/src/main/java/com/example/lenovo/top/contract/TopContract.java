package com.example.lenovo.top.contract;

import com.example.lenovo.top.Bean;

import java.util.List;

/**
 * Time:11:44
 * Author:lenovo
 * Description:新生成的类
 */
public interface TopContract {
    interface Model {
    }

    interface View {
       void setData(List<Bean.ResultBean.DataBean> data);
    }

    interface Presenter {
        void getData();
    }
}
