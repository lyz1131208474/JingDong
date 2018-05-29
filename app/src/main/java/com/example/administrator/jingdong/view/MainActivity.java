package com.example.administrator.jingdong.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.jingdong.R;

public class MainActivity extends AppCompatActivity {

    /**
     * 3秒后跳转
     */
    private TextView timerView;
    private int time=3;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    Intent intent = new Intent(MainActivity.this,MainFirst.class);
                    startActivity(intent);
                    finish();
                    break;

                default:break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //实例化一个sp对象
        SharedPreferences sp = getSharedPreferences("USER",MODE_PRIVATE);
        //得到一个编辑器
        SharedPreferences.Editor edit = sp.edit();
        //得到一个bool值
        boolean first = sp.getBoolean("first", true);
        if (first){
            //如果是第一次就给他put一个值 改变状态为false
            edit.putBoolean("first",false);
            edit.commit();
            initView();//初始化数据
            handler.sendEmptyMessageDelayed(0,3000);
        }else {
            //直接跳转
            Intent intent = new Intent(MainActivity.this,MainFirst.class);
            startActivity(intent);
            finish();
        }
    }

    private void initView() {
        timerView = (TextView) findViewById(R.id.timerView);

        //实例化一个MyCount：
        MyCount myCount = new MyCount(3000,1000);
        // 开始倒计时：
        myCount.start();
    }

    public class MyCount extends CountDownTimer {


        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            timerView.setText("");

        }
        @Override
        public void onTick(long millisUntilFinished) {
            timerView.setText("请等待" + millisUntilFinished / 1000 + "秒");
        }

    }
}
