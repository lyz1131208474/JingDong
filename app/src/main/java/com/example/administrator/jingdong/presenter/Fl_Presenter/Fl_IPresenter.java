package com.example.administrator.jingdong.presenter.Fl_Presenter;

import com.example.administrator.jingdong.model.FL_Model.IModel;
import com.example.administrator.jingdong.view.Fl_View.Fl_IMainView;

public interface Fl_IPresenter {
    //显示左侧列表
    void showLeftToView(IModel iModel, Fl_IMainView iMainView);
    //显示右侧列表
    void showRightToView(IModel iModel, Fl_IMainView iMainView);
}
