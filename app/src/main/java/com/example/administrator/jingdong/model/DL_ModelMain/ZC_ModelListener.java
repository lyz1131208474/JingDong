package com.example.administrator.jingdong.model.DL_ModelMain;

public interface ZC_ModelListener {
    //获取数据成功
    void showRegJsonSuccess(String json);
    //获取数据失败
    void showRegJsonError(String error);
}
