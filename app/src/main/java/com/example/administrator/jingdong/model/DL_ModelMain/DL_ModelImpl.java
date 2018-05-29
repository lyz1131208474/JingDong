package com.example.administrator.jingdong.model.DL_ModelMain;

import com.example.administrator.jingdong.httputils.FromHttpListener;
import com.example.administrator.jingdong.Bean.DL_Bean;
import com.example.administrator.jingdong.httputils.HttpUtils;
import com.google.gson.Gson;

import java.util.Map;

public class DL_ModelImpl implements DL_Model {
    @Override
    public void showLoginJson(String url, Map<String, String> map, final DL_ModelListener dl_modelListener) {
        //在Model层进行网络请求
        HttpUtils httputils = HttpUtils.getHttputils();
        //使用POST方式进行请求
        httputils.postOkHttp(url, map);
        httputils.setFromHttpListener(new FromHttpListener() {
            @Override
            public void fromJosnSuccess(String json) {
                //请求成功
                //进行解析
                Gson gson = new Gson();
                DL_Bean dl_bean = gson.fromJson(json, DL_Bean.class);
                String code = dl_bean.getCode();
                if (code.equals("0")) {//判断当code等于0时为登录成功 否则为登录失败
                    dl_modelListener.showLoginJsonSuccess(dl_bean.getMsg());
                }else {
                    //请求失败  code不为0
                    dl_modelListener.showLoginJsonError(dl_bean.getMsg());
                }
            }

            @Override
            public void fromJsonError(String error) {
                //请求失败
                dl_modelListener.showLoginJsonError(error);
            }
        });
    }
}
