package com.example.administrator.jingdong.model.FL_Model;

import com.example.administrator.jingdong.Bean.Fl_bean.List_DataBean;
import com.example.administrator.jingdong.httputils.Fl_http.List_OkhtttpUtils;
import com.example.administrator.jingdong.presenter.Fl_Presenter.DataPresenter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class List_MyDataMoudle implements List_DataMoudle {
    @Override
    public void getData(String url, final DataPresenter dataPresenter) {
        List_OkhtttpUtils.doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String json = response.body().string();

                Gson gson = new Gson();

                List_DataBean beandata = gson.fromJson(json, List_DataBean.class);

                List<List_DataBean.DataBean> list=beandata.getData();

                dataPresenter.success(list);

            }
        });
    }
}
