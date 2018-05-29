package com.example.administrator.jingdong.MyAdapter.FL_Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.jingdong.Bean.Fl_bean.List_DataBean;
import com.example.administrator.jingdong.Fragment.Home.XQ_Activity;
import com.example.administrator.jingdong.R;

import java.util.List;

public class List_Adapter extends RecyclerView.Adapter {
    private String url = "https://m.360buyimg.com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg";

    Context context;
    List<List_DataBean.DataBean> list;
    public List_Adapter(Context context, List<List_DataBean.DataBean> list) {
        this.context=context;
        this.list=list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(parent.getContext(), R.layout.list_fl_item,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.tv1.setText(list.get(position).getTitle());
        viewHolder.tv2.setText(list.get(position).getPrice()+"");
        Glide.with(context).load(url).into(viewHolder.img);



        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, XQ_Activity.class);

                //截取第一张
                String[] split = list.get(position).getImages().split("\\|");

                //传值
                intent.putExtra("photo",split[0]);
                intent.putExtra("name",list.get(position).getTitle());
                intent.putExtra("price",list.get(position).getPrice()+"");

                int pid = (int) list.get(position).getPid();

                intent.putExtra("pid",pid);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv1,tv2;

        public ViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            tv2=itemView.findViewById(R.id.tv2);
            tv1=itemView.findViewById(R.id.tv1);
        }
    }
}
