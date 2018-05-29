package com.example.administrator.jingdong.Fragment.WoDe.DengLu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.model.DL_ModelMain.DL_ModelImpl;
import com.example.administrator.jingdong.presenter.DL_Presenter.DL_presenterImpl;
import com.example.administrator.jingdong.view.DL_ZC.DL_View;
import com.example.administrator.jingdong.view.MainFirst;


public class DengLu extends AppCompatActivity implements View.OnClickListener,DL_View{
    private static final String TAG ="DengLu---" ;
    private EditText login_mobile;
    private EditText login_password;
    private Button login;
    private Button reg;
    private ImageView img;
    private TextView name;
    private Button dl_qq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deng_lu);

        initViews();
    }


    private void initViews() {
        //获取控件ID
        login_mobile = findViewById(R.id.login_mobile);
        login_password = findViewById(R.id.login_password);
        login = findViewById(R.id.login);
        img = findViewById(R.id.img);
        dl_qq = findViewById(R.id.Dl_qq);

        reg = findViewById(R.id.reg);

        dl_qq.setOnClickListener(this);
        login.setOnClickListener(this);
        reg.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                //点击登陆
                DL_presenterImpl presenter = new DL_presenterImpl();
                presenter.getLoginJson(new DL_ModelImpl(),DengLu.this);
                break;
            case R.id.reg:
                //点击注册
                Intent intent =new Intent(DengLu.this,ZhuCe.class);
                startActivity(intent);
                break;

            case R.id.Dl_qq:

                break;

        }
    }

    @Override
    public void showLoginSuccess(String json) {

        Log.d(TAG, "showLoginSuccess: "+json);
        Intent intent = new Intent(DengLu.this, MainFirst.class);
        startActivity(intent);
    }

    @Override
    public void showLoginError(String error) {
        Toast.makeText(this, "登录失败："+error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getMobile() {
        return login_mobile.getText().toString();
    }

    @Override
    public String getPassword() {
        return login_password.getText().toString();
    }



}
