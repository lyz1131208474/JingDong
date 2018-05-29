package com.example.administrator.jingdong.Fragment.Home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.administrator.jingdong.Bean.Jiugongge_bean;
import com.example.administrator.jingdong.Bean.Shouye_bean;
import com.example.administrator.jingdong.Fragment.WoDe.DengLu.SouSuo.SouSuoActivity;
import com.example.administrator.jingdong.MyAdapter.SY_Adapter.SY_Myadapter;
import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.model.JiuGongGeModel.Mymode;
import com.example.administrator.jingdong.presenter.SY_Presenter.Mypresenter;
import com.example.administrator.jingdong.view.ShouYeView.Iview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements Iview, View.OnClickListener {

    private XRecyclerView xrc;
    private View inflate;
    List<String> lunbolist = new ArrayList<>();
    List<Jiugongge_bean.DataBean> data;
    private SY_Myadapter myadapter;
    Handler handler = new Handler();
    private View view;
    private int mDistanceY;
    private LinearLayout mSsk;
    private ImageView image_sao;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fr_home, container, false);
        xrc = view.findViewById(R.id.xrc);
        Mypresenter mypresenter = new Mypresenter();
        mypresenter.getmv1(this, new Mymode());
        mypresenter.getmv(getContext(), this, new Mymode());
        inflate = View.inflate(getContext(), R.layout.shouye_xbanner, null);
        xrc.addHeaderView(inflate);
        initView(view);
        return view;

    }

    @Override
    public void setadapter(Context context, Shouye_bean shouye_bean) {


        List<Shouye_bean.DataBean> data1 = shouye_bean.getData();
        for (int i = 0; i < data1.size(); i++) {
            lunbolist.add(data1.get(i).getIcon());
        }
        XBanner myxbanner = inflate.findViewById(R.id.myxbanner);
        myxbanner.setData(lunbolist, null);
        myxbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getContext()).load(lunbolist.get(position)).into((ImageView) view);
            }
        });
        myadapter = new SY_Myadapter(context, data, shouye_bean);
        xrc.setAdapter(myadapter);
        xrc.setLayoutManager(new LinearLayoutManager(context));
        xrc.setLoadingMoreEnabled(false);
        xrc.setLoadingListener(new XRecyclerView.LoadingListener() {

            private FrameLayout fg;

            @Override
            public void onRefresh() {
                fg = view.findViewById(R.id.fg);
                fg.setVisibility(View.GONE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fg.setVisibility(View.VISIBLE);
                        xrc.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {

            }
        });

        xrc.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //滑动的距离
                mDistanceY += dy;
                //toolbar的高度
                FrameLayout f1_frag = view.findViewById(R.id.fg);
                int toolbarHeight = f1_frag.getBottom();

                //当滑动的距离 <= toolbar高度的时候，改变Toolbar背景色的透明度，达到渐变的效果
                if (mDistanceY <= 300) {
                    float scale = (float) mDistanceY / 300;
                    float alpha = scale * 255;
                    f1_frag.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));

                } else {
                    //将标题栏的颜色设置为完全不透明状态
                    f1_frag.setBackgroundResource(R.color.colorAccent);

                }
            }
        });


    }

    @Override
    public void setadapter1(List<Jiugongge_bean.DataBean> data) {
        this.data = data;

    }

    private void initView(View view) {
        mSsk = (LinearLayout) view.findViewById(R.id.ssk);
        mSsk.setOnClickListener(this);
        image_sao = view.findViewById(R.id.image_sao);
        image_sao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Sao_activit.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.ssk:
                Intent intent = new Intent(getActivity(), SouSuoActivity.class);
                startActivity(intent);
                break;

        }
    }
}
