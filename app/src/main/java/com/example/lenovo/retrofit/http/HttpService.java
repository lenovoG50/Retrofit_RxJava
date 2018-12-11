package com.example.lenovo.retrofit.http;

import com.example.lenovo.top.Bean;
import com.example.lenovo.retrofit.base.BaseHttpResult;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Time:09:30
 * Author:lenovo
 * Description:网络请求接口
 **/
public interface HttpService {
    //获取类别
    @POST("index?key=b0c1a57febbe49da8940dc820c2d8e43")
    Observable<BaseHttpResult<Bean.ResultBean>> getTop(@Query("type") String type);

}
