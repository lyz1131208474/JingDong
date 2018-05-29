package com.example.administrator.jingdong.view.DL_ZC;

public interface ZC_View {
    //登录成功的回调
    void showLoginSuccess(String json);
    //登录失败的回调
    void showLoginError(String error);
    //获取输入的手机号
    String getMobile();
    //获取输入的密码
    String getPassword();
}
