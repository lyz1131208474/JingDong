package com.example.administrator.jingdong.Fragment.WoDe.DengLu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.model.DL_ModelMain.ZC_ModelImpl;
import com.example.administrator.jingdong.presenter.DL_Presenter.DL_presenterImpl;
import com.example.administrator.jingdong.view.DL_ZC.ZC_View;

public class ZhuCe extends AppCompatActivity implements View.OnClickListener ,ZC_View{

    private EditText login_mobile;
    private EditText login_password;
    private Button login;
    private Button reg;
    private Button reg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);

        initViews();
    }

    private void initViews() {
        //获取控件ID
        login_mobile = findViewById(R.id.login_mobile);
        login_password = findViewById(R.id.login_password);
        reg1 = findViewById(R.id.reg_but);
        reg1.setOnClickListener(this);
    }

    //点击事件
    @Override
    public void onClick(View v) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        DL_presenterImpl presenter = new DL_presenterImpl();
        presenter.getRegJson(new ZC_ModelImpl(),this);
    }

    @Override
    public void showLoginSuccess(String json) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ZhuCe.this,DengLu.class);
        startActivity(intent);
    }

    @Override
    public void showLoginError(String error) {
        Toast.makeText(this, "注册失败"+error, Toast.LENGTH_SHORT).show();
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
