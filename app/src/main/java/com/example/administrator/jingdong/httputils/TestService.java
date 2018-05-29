package com.example.administrator.jingdong.httputils;

import com.example.administrator.jingdong.Bean.Jiugongge_bean;
import com.example.administrator.jingdong.Bean.Shouye_bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface TestService {
    @GET("ad/getAd")
    Observable<Shouye_bean> getUser();

    @GET("product/getCatagory")
    Observable<Jiugongge_bean> getjiugongge();
}
