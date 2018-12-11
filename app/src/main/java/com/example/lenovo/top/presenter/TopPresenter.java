package com.example.lenovo.top.presenter;

import com.example.lenovo.top.Bean;
import com.example.lenovo.ProApplication;
import com.example.lenovo.retrofit.Observer.CommonObserver;
import com.example.lenovo.retrofit.http.Http;
import com.example.lenovo.retrofit.transformer.CommonTransFormers;
import com.example.lenovo.top.contract.TopContract;

import java.util.List;

/**
 * Time:11:44
 * Author:lenovo
 * Description:新生成的类
 */
public class TopPresenter implements TopContract.Presenter {

    private TopContract.View view;

    public TopPresenter(TopContract.View view) {
        this.view = view;
    }

    @Override
    public void getData() {
        Http.getHttpService().getTop("top")
                .compose(new CommonTransFormers<>())
                .subscribe(new CommonObserver<Bean.ResultBean>(ProApplication.getContext()) {
                    @Override
                    public void onNext(Bean.ResultBean resultBean) {
                        List<Bean.ResultBean.DataBean> data = resultBean.getData();
                        view.setData(data);
                    }
                });
    }
}
