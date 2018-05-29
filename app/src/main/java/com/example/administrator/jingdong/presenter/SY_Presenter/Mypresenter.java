package com.example.administrator.jingdong.presenter.SY_Presenter;

import android.content.Context;

import com.example.administrator.jingdong.Bean.Jiugongge_bean;
import com.example.administrator.jingdong.Bean.Shouye_bean;
import com.example.administrator.jingdong.model.JiuGongGeModel.Getjiugongge;
import com.example.administrator.jingdong.model.JiuGongGeModel.Getjson;
import com.example.administrator.jingdong.model.JiuGongGeModel.Imode;
import com.example.administrator.jingdong.view.ShouYeView.Iview;

import java.util.List;

public class Mypresenter implements Ipressenter {
    @Override
    public void getmv(final Context context, final Iview iview, Imode imode) {
        imode.getnetjson(new Getjson() {
            @Override
            public void getnetjson(Shouye_bean shouye_bean) {
                iview.setadapter(context,shouye_bean);
            }
        });
    }

    @Override
    public void getmv1(final Iview iview, Imode imode) {
        imode.getjiugonggejson(new Getjiugongge() {
            @Override
            public void getJiugongge(List<Jiugongge_bean.DataBean> data) {
                iview.setadapter1(data);
            }
        });
    }
}
