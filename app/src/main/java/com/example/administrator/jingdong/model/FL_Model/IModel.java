package com.example.administrator.jingdong.model.FL_Model;

import java.util.Map;

public interface IModel {
    //获取左侧列表数据
    void getLeftList(String url, Map<String,String> map, GetLeftListener getLeftListener);
    //获取右侧列表数据
    void getRightList(String url, Map<String,String> map,GetRightListener getRightListener);
}
