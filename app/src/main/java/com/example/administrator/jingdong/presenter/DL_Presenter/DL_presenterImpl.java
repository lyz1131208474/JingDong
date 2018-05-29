package com.example.administrator.jingdong.presenter.DL_Presenter;

import com.example.administrator.jingdong.httputils.DL_HttpConfig;
import com.example.administrator.jingdong.model.DL_ModelMain.DL_Model;
import com.example.administrator.jingdong.model.DL_ModelMain.DL_ModelListener;
import com.example.administrator.jingdong.model.DL_ModelMain.ZC_ModelListener;
import com.example.administrator.jingdong.model.DL_ModelMain.ZC_model;
import com.example.administrator.jingdong.view.DL_ZC.DL_View;
import com.example.administrator.jingdong.view.DL_ZC.ZC_View;

import java.util.HashMap;
import java.util.Map;

public class DL_presenterImpl implements DL_IPresenter{



    @Override
    public void getLoginJson(DL_Model dl_model, final DL_View dl_view) {
        //创建Map集合
        Map<String, String> map = new HashMap<>();
        map.put("mobile", dl_view.getMobile());
        map.put("password", dl_view.getPassword());
        dl_model.showLoginJson(DL_HttpConfig.login_url, map, new DL_ModelListener(){
            @Override
            public void showLoginJsonSuccess(String json) {
                //登录成功
                dl_view.showLoginSuccess(json);
            }

            @Override
            public void showLoginJsonError(String error) {
                dl_view.showLoginError(error);//登录失败
            }
        });
    }

    @Override
    public void getRegJson(ZC_model zc_model, final ZC_View zc_view) {
        //创建Map集合
        Map<String, String> map = new HashMap<>();
        map.put("mobile", zc_view.getMobile());
        map.put("password", zc_view.getPassword());
        zc_model.showRegnJson(DL_HttpConfig.reg_url, map, new ZC_ModelListener() {
            @Override
            public void showRegJsonSuccess(String json) {
                zc_view.showLoginSuccess(json);
            }

            @Override
            public void showRegJsonError(String error) {
                zc_view.showLoginError(error);
            }
        });
    }
}
