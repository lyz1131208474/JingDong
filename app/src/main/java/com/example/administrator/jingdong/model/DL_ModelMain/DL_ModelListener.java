package com.example.administrator.jingdong.model.DL_ModelMain;

public interface DL_ModelListener {
    //获取数据成功
    void showLoginJsonSuccess(String json);
    //获取数据失败
    void showLoginJsonError(String error);
}
