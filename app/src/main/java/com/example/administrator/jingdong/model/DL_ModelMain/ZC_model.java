package com.example.administrator.jingdong.model.DL_ModelMain;

import java.util.Map;

public interface ZC_model {
    //获取数据的回调方法
    void showRegnJson(String url, Map<String, String> map, ZC_ModelListener zc_modelListener);
}
