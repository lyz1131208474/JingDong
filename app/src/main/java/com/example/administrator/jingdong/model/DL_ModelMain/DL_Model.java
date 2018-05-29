package com.example.administrator.jingdong.model.DL_ModelMain;

import java.util.Map;

public interface DL_Model {
    //获取数据的回调方法
    void showLoginJson(String url, Map<String,String> map, DL_ModelListener dl_modelListener);
}
