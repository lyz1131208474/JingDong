package com.example.administrator.jingdong.presenter.SY_Presenter;

import android.content.Context;

import com.example.administrator.jingdong.model.JiuGongGeModel.Imode;
import com.example.administrator.jingdong.view.ShouYeView.Iview;

public interface  Ipressenter {
    void getmv(Context context, Iview iview, Imode imode);

    void getmv1( Iview iview, Imode imode);
}
