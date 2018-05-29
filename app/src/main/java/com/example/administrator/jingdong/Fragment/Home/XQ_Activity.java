package com.example.administrator.jingdong.Fragment.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.jingdong.Bean.Gw_bean.AddShopBean;
import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.httputils.SP_http.Sp_HttpUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class XQ_Activity extends AppCompatActivity implements View.OnClickListener {


    private SimpleDraweeView img;
    private TextView name;
    /**
     * ￥
     */
    private TextView mPp;
    /**
     * 钱
     */
    private TextView price;
    /**
     * pid
     */
    private TextView pid;
    /**
     * 添加到购物车
     */
    private Button shop;
    private int pid1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xq_);
        initView();

        //接受值
        Intent intent = getIntent();
        String img1 = intent.getStringExtra("photo");
        String name1 = intent.getStringExtra("name");
        String price1 = intent.getStringExtra("price");
        pid1 = intent.getExtras().getInt("pid");
        Toast.makeText(this,img1+"",Toast.LENGTH_SHORT).show();

        //赋值
        Glide.with(this).load(img1).into(img);
        name.setText(name1);
        price.setText(price1);
        pid.setText(""+ pid1);

        shopping();
    }


    private void initView() {
        img = findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        mPp = (TextView) findViewById(R.id.pp);
        price = (TextView) findViewById(R.id.price);
        pid = (TextView) findViewById(R.id.pid);
        shop = (Button) findViewById(R.id.shop);
        shop.setOnClickListener(this);
    }
    //添加
    private void shopping() {

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<AddShopBean> beanCall = Sp_HttpUtil.getInsance("http://120.27.23.105/product/").getApi().doGet("android",14538, pid1);

                beanCall.enqueue(new Callback<AddShopBean>() {
                    @Override
                    public void onResponse(Call<AddShopBean> call, Response<AddShopBean> response) {
                        AddShopBean body = response.body();

                        if(body.getMsg().equals("加购成功")){
                            Toast.makeText(XQ_Activity.this,body.getMsg(),Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(XQ_Activity.this,body.getMsg(),Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<AddShopBean> call, Throwable t) {

                    }
                });
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.shop:
                break;
        }
    }
}
