package com.example.administrator.jingdong.model.DL_ModelMain;

import com.example.administrator.jingdong.httputils.FromHttpListener;
import com.example.administrator.jingdong.Bean.ZC_Bean;
import com.example.administrator.jingdong.httputils.HttpUtils;
import com.google.gson.Gson;

import java.util.Map;

public class ZC_ModelImpl implements ZC_model {
    @Override
    public void showRegnJson(String url, Map<String, String> map, final ZC_ModelListener zc_modelListener) {
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
                ZC_Bean regBean = gson.fromJson(json, ZC_Bean.class);
                String code = regBean.getCode();
                if (code.equals("0")) {//判断当code等于0时为注册成功 否则为登录失败
                    zc_modelListener.showRegJsonSuccess(regBean.getMsg());
                }else {
                    //请求失败  code不为0
                    zc_modelListener.showRegJsonError(regBean.getMsg());
                }
            }

            @Override
            public void fromJsonError(String error) {
                //请求失败
                zc_modelListener.showRegJsonError(error);
            }
        });
    }
}
