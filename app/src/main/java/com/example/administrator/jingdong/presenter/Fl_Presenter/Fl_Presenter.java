package com.example.administrator.jingdong.presenter.Fl_Presenter;

import android.util.Log;

import com.example.administrator.jingdong.Bean.Fl_bean.LeftBean;
import com.example.administrator.jingdong.Bean.Fl_bean.RightBean;
import com.example.administrator.jingdong.httputils.Fl_http.Fl_HttpConfig;
import com.example.administrator.jingdong.model.FL_Model.GetLeftListener;
import com.example.administrator.jingdong.model.FL_Model.GetRightListener;
import com.example.administrator.jingdong.model.FL_Model.IModel;
import com.example.administrator.jingdong.view.Fl_View.Fl_IMainView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Fl_Presenter implements Fl_IPresenter {
    private static final String TAG = "Presenter";

    //显示左侧列表
    @Override
    public void showLeftToView(IModel iModel, final Fl_IMainView iMainView) {
        Map<String, String> map = new HashMap<>();
        iModel.getLeftList(Fl_HttpConfig.left_url, map, new GetLeftListener() {
            @Override
            public void getLeftSuccess(String json) {
                //解析
                Gson gson = new Gson();
                LeftBean leftBean = gson.fromJson(json, LeftBean.class);
                if (leftBean.getCode().equals("0")) {
                    iMainView.showLeftView(leftBean.getData());
                } else {
                    Log.d(TAG, "失败" + json);
                }
            }

            @Override
            public void getLeftError(String error) {
                Log.d(TAG, "getLeftError: " + error);
            }
        });
    }
    //右侧
    @Override
    public void showRightToView(IModel iModel, final Fl_IMainView iMainView) {
        Map<String, String> map = new HashMap<>();
        map.put("cid",iMainView.getCid());
        iModel.getRightList(Fl_HttpConfig.right_url, map, new GetRightListener() {
            @Override
            public void getLeftSuccess(String json) {
                //解析
                Gson gson = new Gson();
                RightBean rightBean = gson.fromJson(json, RightBean.class);
                if (rightBean.getCode().equals("0")) {
                    iMainView.showRightView(rightBean.getData());
                } else {
                    Log.d(TAG, "失败" + json);
                }
            }

            @Override
            public void getLeftError(String error) {
                Log.d(TAG, "getLeftError: " + error);
            }
        });
    }
}

