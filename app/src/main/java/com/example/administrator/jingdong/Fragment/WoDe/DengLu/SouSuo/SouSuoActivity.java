package com.example.administrator.jingdong.Fragment.WoDe.DengLu.SouSuo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.administrator.jingdong.Fragment.WoDe.DengLu.SouSuo.MySqlDao.MySqlDao;
import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.view.MainFirst;
import com.fynn.fluidlayout.FluidLayout;

import java.util.List;

public class SouSuoActivity extends AppCompatActivity {

    MySqlDao mySQliteDao;
    EditText et;
    FluidLayout fluidLayout;
    Button bt_quxiao, bt_search;
    RadioButton rb_clear;
    ListView lv;
    List<String> list;
    MyAdapter myAdapter;

    String[] arrs = {"倩女幽魂", "单机斗地主", "天堂战记", "妖精的尾巴", "极限挑战"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sou_suo);
        et = findViewById(R.id.search_edit2);
        bt_quxiao = findViewById(R.id.bt_quxiao);
        bt_search = findViewById(R.id.bt_search);
        rb_clear = findViewById(R.id.rb_clear);
        fluidLayout = findViewById(R.id.fl);
        lv = findViewById(R.id.search_lv);

        //配置热搜流式布局
        for (int i = 0; i < arrs.length; i++) {
            String ss = arrs[i];
            TextView textView = new TextView(SouSuoActivity.this);
            textView.setText(ss);
            textView.setTextSize(13);
            textView.setBackgroundColor(Color.parseColor("#f5f5f5"));

            FluidLayout.LayoutParams params = new FluidLayout.LayoutParams(150, 50);
            params.setMargins(12, 12, 12, 12);

            fluidLayout.addView(textView, params);
        }

        //查询数据库,配置适配器，显示历史记录listview
        mySQliteDao = new MySqlDao(SouSuoActivity.this);
        list = mySQliteDao.select();
        myAdapter = new MyAdapter();
        lv.setAdapter(myAdapter);


        //点击事件，返回首页
        bt_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SouSuoActivity.this, MainFirst.class);
                startActivity(intent);
            }
        });
        //点击事件，添加搜索内容到数据库
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mySQliteDao.add(et.getText().toString());

                list = mySQliteDao.select();
                myAdapter.notifyDataSetChanged();
            }
        });
        //点击事件，清空数据库中的搜索内容
        rb_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mySQliteDao.deleteAll();

                list.removeAll(list);
                myAdapter.notifyDataSetChanged();
            }
        });

    }

    //显示搜索内容listview的适配器
    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            TextView textView = new TextView(SouSuoActivity.this);
            textView.setText(list.get(i));
            textView.setPadding(15, 15, 15, 15);
            return textView;
        }
    }
}
