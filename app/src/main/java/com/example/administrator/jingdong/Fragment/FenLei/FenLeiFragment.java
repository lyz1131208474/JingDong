package com.example.administrator.jingdong.Fragment.FenLei;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.jingdong.Bean.Fl_bean.LeftBean;
import com.example.administrator.jingdong.Bean.Fl_bean.RightBean;
import com.example.administrator.jingdong.MyAdapter.FL_Adapter.Fl_MyAdapter1;
import com.example.administrator.jingdong.MyAdapter.FL_Adapter.Fl_MyAdapter2;
import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.model.FL_Model.ModelImpl;
import com.example.administrator.jingdong.presenter.Fl_Presenter.Fl_Presenter;
import com.example.administrator.jingdong.view.Fl_View.Fl_IMainView;
import com.example.administrator.jingdong.view.MainActivity;

import java.util.List;

public class FenLeiFragment extends Fragment implements Fl_IMainView {

    private static final String TAG = "MainActivity";
    private ListView left_listview;
    private ListView right_listview;
    private List<LeftBean.DataBean> list;
    private String cid;
    private Fl_Presenter Fl_presenter;
    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View contentView = inflater.inflate(R.layout.fr_fenlei, container, false);

        initView(contentView);
        initDatas();
        return contentView;
    }
    private void initDatas() {
        Fl_presenter = new Fl_Presenter();
        Fl_presenter.showLeftToView(new ModelImpl(),this);
    }

    private void initView(View contentView) {
        left_listview = (ListView) contentView.findViewById(R.id.left_listview);
        right_listview = (ListView) contentView.findViewById(R.id.right_listview);
        //设置条目点击事件
        left_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cid = list.get(position).getCid() + "";
                //调用p层的方法
                Fl_presenter.showRightToView(new ModelImpl(),FenLeiFragment.this);
            }
        });
    }

    //显示左侧列表
    @Override
    public void showLeftView(List<LeftBean.DataBean> list) {
        this.list=list;
        Log.d(TAG, "showLeftView: "+list);
        Fl_MyAdapter1 myAdapter1 = new Fl_MyAdapter1(getActivity(), list);
        left_listview.setAdapter(myAdapter1);
        //显示右侧的默认值，就是cid=1
        int cid = list.get(0).getCid();
        FenLeiFragment.this.cid=cid+"";

        Fl_presenter.showRightToView(new ModelImpl(),FenLeiFragment.this);
    }
    //右侧
    @Override
    public void showRightView(List<RightBean.DataBean> list) {
        Log.d(TAG, "右侧------: "+list);
        Fl_MyAdapter2 myAdapter2 = new Fl_MyAdapter2(getActivity(), list);
        right_listview.setAdapter(myAdapter2);
    }

    @Override
    public String getCid() {
        return this.cid;
    }
}
