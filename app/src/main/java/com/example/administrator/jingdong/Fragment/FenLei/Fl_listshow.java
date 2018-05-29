package com.example.administrator.jingdong.Fragment.FenLei;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.jingdong.Bean.Fl_bean.List_DataBean;
import com.example.administrator.jingdong.MyAdapter.FL_Adapter.List_Adapter;
import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.presenter.Fl_Presenter.MyDataPresenter;
import com.example.administrator.jingdong.view.Fl_View.List_DataView;

import java.util.List;

public class Fl_listshow extends AppCompatActivity implements List_DataView{

    private String url="https://www.zhaoapi.cn/product/getProducts?pscid=2";
    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            List<List_DataBean.DataBean> list = (List<List_DataBean.DataBean>) msg.obj;


            List_Adapter myAdapter = new List_Adapter(Fl_listshow.this, list);
            rec.setAdapter(myAdapter);

        }
    };
    private RecyclerView rec;
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fl_listshow);
        rec = findViewById(R.id.rec);
        final ImageView image=findViewById(R.id.image);

        MyDataPresenter presenter = new MyDataPresenter(this);
        presenter.netWork(url);
        rec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if (i%2==0){
                    rec.setLayoutManager(new LinearLayoutManager(Fl_listshow.this,LinearLayoutManager.VERTICAL,false));
                }else {
                    rec.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                }


                ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(image,"rotation",0f,180f);
                objectAnimator.setDuration(500);
                objectAnimator.start();
            }
        });
    }


    @Override
    public void toBackHome(List<List_DataBean.DataBean> list) {
        Message msg = new Message();
        msg.obj= list;

        handler.sendMessage(msg);
    }
}
