package com.example.administrator.jingdong.presenter.DL_Presenter;

import com.example.administrator.jingdong.model.DL_ModelMain.DL_Model;
import com.example.administrator.jingdong.model.DL_ModelMain.ZC_model;
import com.example.administrator.jingdong.view.DL_ZC.DL_View;
import com.example.administrator.jingdong.view.DL_ZC.ZC_View;

public interface DL_IPresenter {
    //登录的回调方法
    void getLoginJson(DL_Model dl_model, DL_View dl_view);
    //注册的回调方法
    void getRegJson(ZC_model zc_model, ZC_View zc_view);
}
