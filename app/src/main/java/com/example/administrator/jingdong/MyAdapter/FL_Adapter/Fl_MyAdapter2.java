package com.example.administrator.jingdong.MyAdapter.FL_Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.jingdong.Bean.Fl_bean.RightBean;
import com.example.administrator.jingdong.R;

import java.util.List;

public class Fl_MyAdapter2 extends BaseAdapter {

    private Context context;
    private List<RightBean.DataBean> list;
    public Fl_MyAdapter2(Context context,List<RightBean.DataBean> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder2 myViewHolder2=null;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.right_item_layout,null);
            TextView right_title = convertView.findViewById(R.id.right_title);
            GridView right_gv = convertView.findViewById(R.id.right_gv);

            myViewHolder2= new MyViewHolder2(right_title,right_gv);

            convertView.setTag(myViewHolder2);

        }
        else {
            myViewHolder2= (MyViewHolder2) convertView.getTag();
        }
        //赋值
        myViewHolder2.getRight_tv().setText(list.get(position).getName());
        //
        List<RightBean.DataBean.ListBean> list = this.list.get(position).getList();
        Fl_MyAdapter3 myAdapter3 = new Fl_MyAdapter3(context, list);
        myViewHolder2.getRight_gv().setAdapter(myAdapter3);
        //设置点击事件
        myViewHolder2.getRight_gv().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"Postiion"+position,Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
    class MyViewHolder2{
        private TextView right_tv;
        private GridView right_gv;

        public MyViewHolder2(TextView right_tv, GridView right_gv) {
            this.right_tv = right_tv;
            this.right_gv = right_gv;
        }

        public TextView getRight_tv() {
            return right_tv;
        }

        public void setRight_tv(TextView right_tv) {
            this.right_tv = right_tv;
        }

        public GridView getRight_gv() {
            return right_gv;
        }

        public void setRight_gv(GridView right_gv) {
            this.right_gv = right_gv;
        }
    }
}
