package com.example.lenovo.top.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lenovo.top.Bean;
import com.example.lenovo.baserecyclerview.base.ViewHolder;
import com.example.lenovo.baserecyclerview.wrapper.CommonAdapter;
import com.example.lenovo.retrofit.R;
import com.example.lenovo.retrofit.databinding.ActivityTopBinding;
import com.example.lenovo.top.contract.TopContract;
import com.example.lenovo.top.presenter.TopPresenter;

import java.util.List;

public class TopActivity extends AppCompatActivity implements TopContract.View {

    private ActivityTopBinding binding;
    private TopPresenter topPresenter;
    private RecyclerView rcvTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_top);
        binding.rcvTop.setLayoutManager(new LinearLayoutManager(this));
        rcvTop = findViewById(R.id.rcv_top);
        topPresenter = new TopPresenter(this);
        topPresenter.getData();
    }

    @Override
    public void setData(List<Bean.ResultBean.DataBean> data) {
        binding.rcvTop.setAdapter(new CommonAdapter<Bean.ResultBean.DataBean>(this, R.layout.adapter_top, data) {
            @Override
            protected void convert(ViewHolder holder, Bean.ResultBean.DataBean dataBean, int position) {
                holder.setText(R.id.item_top,dataBean.getAuthor_name());
                holder.setImageDrawable(TopActivity.this,R.id.img,dataBean.getThumbnail_pic_s());
            }

        });
    }
}
