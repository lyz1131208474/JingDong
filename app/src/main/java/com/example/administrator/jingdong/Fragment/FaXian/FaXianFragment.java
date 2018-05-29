package com.example.administrator.jingdong.Fragment.FaXian;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.administrator.jingdong.R;

public class FaXianFragment extends Fragment {
    private WebView web;
    String url = "https://h5.m.jd.com/active/faxian/list/article-list.html";
    private View view;
    private WebView Web;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fr_faxian, container, false);

        initView(view);
        return view;
    }

    private View initView(View view) {
        Web = (WebView) view.findViewById(R.id.web);

        web = view.findViewById(R.id.web);
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        web.loadUrl(url);
        return view;
    }
}
