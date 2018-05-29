package com.example.administrator.jingdong.model.FL_Model;

import android.util.Log;

import com.example.administrator.jingdong.httputils.Fl_http.Fl_HttpUtils;
import com.example.administrator.jingdong.httputils.Fl_http.Fl_OkLoadListener;

import java.util.Map;

public class ModelImpl implements IModel {
    private static final String TAG = "ModelImpl----";
    //获取左侧数据的实现类
    @Override
    public void getLeftList(String url, Map<String, String> map, final GetLeftListener getLeftListener) {
        Fl_HttpUtils fl_httpUtils = Fl_HttpUtils.getHttpUtils();
        fl_httpUtils.okPost(url,map);
        fl_httpUtils.setOkLoadListener(new Fl_OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {
                Log.d(TAG, "okLoadSuccess: "+json);
                //回调
                getLeftListener.getLeftSuccess(json);
            }

            @Override
            public void okLoadError(String error) {
                Log.d(TAG, "失败: "+error);
                //回调
                getLeftListener.getLeftError(error);
            }
        });
    }
    //右侧
    @Override
    public void getRightList(String url, Map<String, String> map, final GetRightListener getRightListener) {
        Fl_HttpUtils fl_httpUtils = Fl_HttpUtils.getHttpUtils();
        fl_httpUtils.okPost(url,map);
        fl_httpUtils.setOkLoadListener(new Fl_OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {
                Log.d(TAG, "okLoadSuccess: "+json);
                //回调
                getRightListener.getLeftSuccess(json);
            }

            @Override
            public void okLoadError(String error) {
                Log.d(TAG, "失败: "+error);
                //回调
                getRightListener.getLeftError(error);
            }
        });
    }
}
