package com.example.administrator.jingdong.MyAdapter.SY_Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.jingdong.Bean.Shouye_bean;
import com.example.administrator.jingdong.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class Miaoshaadapter extends RecyclerView.Adapter<Miaoshaadapter.Mymiaoshahodler> {
    private Context context;
    private List<Shouye_bean.MiaoshaBean.ListBeanX> miaoshalist;

    public Miaoshaadapter(Context context, List<Shouye_bean.MiaoshaBean.ListBeanX> miaoshalist) {
        this.context = context;
        this.miaoshalist = miaoshalist;
    }

    @Override
    public Mymiaoshahodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.shouye_tuijian_zi, null);
        Mymiaoshahodler mymiaoshahodler=new Mymiaoshahodler(inflate);
        return mymiaoshahodler;
    }

    @Override
    public void onBindViewHolder(final Mymiaoshahodler holder, int position) {
        holder.jiugongge_tv.setText(miaoshalist.get(position).getTitle());
        String images = miaoshalist.get(position).getImages();
        String[] split = images.split(".jpg");
        holder.sd.setImageURI(Uri.parse(split[0]+".jpg"));
        //给recycleView的item设置点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //索引
                int layoutPosition = holder.getLayoutPosition();

                //进行回调
                listener.itemClick(holder.itemView,layoutPosition);
            }
        });
    }
    /**
     * recyclerView的监听事件
     */
    OnItemClickListener listener;
    public void setOnItemClickListener(OnItemClickListener listener){

        this.listener = listener;
    }
    @Override
    public int getItemCount() {
        return miaoshalist.size();
    }

    class Mymiaoshahodler extends RecyclerView.ViewHolder{
        public SimpleDraweeView sd;
        public TextView jiugongge_tv;
        public Mymiaoshahodler(View itemView) {
            super(itemView);
            this.sd=itemView.findViewById(R.id.sd);
            this.jiugongge_tv=itemView.findViewById(R.id.jiugongge_tv);
        }
    }
    //传进去点击事件和长按事件

    interface OnItemClickListener{
        void  itemClick(View v,int position);
        void  itemLongClick(View v,int position);
    }
}
