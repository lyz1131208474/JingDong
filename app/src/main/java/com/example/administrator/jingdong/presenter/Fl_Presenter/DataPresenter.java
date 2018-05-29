package com.example.administrator.jingdong.presenter.Fl_Presenter;

import com.example.administrator.jingdong.Bean.Fl_bean.List_DataBean;

import java.util.List;

public interface DataPresenter {
    void success(List<List_DataBean.DataBean> list);
    void eroor();
}
