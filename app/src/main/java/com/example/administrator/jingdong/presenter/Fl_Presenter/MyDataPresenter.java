package com.example.administrator.jingdong.presenter.Fl_Presenter;

import com.example.administrator.jingdong.Bean.Fl_bean.List_DataBean;
import com.example.administrator.jingdong.model.FL_Model.List_MyDataMoudle;
import com.example.administrator.jingdong.view.Fl_View.List_DataView;

import java.util.List;

public class MyDataPresenter implements DataPresenter {
    private final List_MyDataMoudle myDataMoudle;
    List_DataView dataView;

    public MyDataPresenter(List_DataView dataView) {
        this.dataView = dataView;
        myDataMoudle = new List_MyDataMoudle();
    }


    @Override
    public void success(List<List_DataBean.DataBean> list) {
        dataView.toBackHome(list);
    }

    @Override
    public void eroor() {

    }
    public void netWork(String url) {

        myDataMoudle.getData(url,this);


    }
}
