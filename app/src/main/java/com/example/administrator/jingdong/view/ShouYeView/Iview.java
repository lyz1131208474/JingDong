package com.example.administrator.jingdong.view.ShouYeView;

import android.content.Context;

import com.example.administrator.jingdong.Bean.Jiugongge_bean;
import com.example.administrator.jingdong.Bean.Shouye_bean;

import java.util.List;

public interface Iview {
    void setadapter(Context context, Shouye_bean shouye_bean);

    void setadapter1( List<Jiugongge_bean.DataBean> data);
}
