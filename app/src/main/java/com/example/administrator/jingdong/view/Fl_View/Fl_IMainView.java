package com.example.administrator.jingdong.view.Fl_View;

import com.example.administrator.jingdong.Bean.Fl_bean.LeftBean;
import com.example.administrator.jingdong.Bean.Fl_bean.RightBean;

import java.util.List;

public interface Fl_IMainView {
    //显示左侧列表
    void showLeftView(List<LeftBean.DataBean> list);
    //显示右侧
    void showRightView(List<RightBean.DataBean> list);
    //获取分类的cid
    String getCid();
}
