package com.example.administrator.jingdong.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.jingdong.Fragment.FaXian.FaXianFragment;
import com.example.administrator.jingdong.Fragment.FenLei.FenLeiFragment;
import com.example.administrator.jingdong.Fragment.GouWuChe.GouWuFragment;
import com.example.administrator.jingdong.Fragment.Home.HomeFragment;
import com.example.administrator.jingdong.Fragment.WoDe.WoDeFragment;
import com.example.administrator.jingdong.R;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainFirst extends AppCompatActivity {

    private BottomTabBar mBottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_first);
        initView();
        BottomTabar();
    }

    private void BottomTabar() {
        mBottomTabBar.init(getSupportFragmentManager())
                .setImgSize(100,100)
                .setFontSize(0)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("首页", R.drawable.ac0,HomeFragment.class)
                .addTabItem("分类",R.drawable.abw, FenLeiFragment.class)
                .addTabItem("发现",R.drawable.aby, FaXianFragment.class)
                .addTabItem("购物车",R.drawable.abu, GouWuFragment.class)
                .addTabItem("我的",R.drawable.ac2, WoDeFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }

    private void initView() {
        mBottomTabBar = (BottomTabBar) findViewById(R.id.bottomTabBar);

    }
}
