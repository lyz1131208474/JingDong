package com.example.administrator.jingdong.Fragment.GouWuChe;

import com.example.administrator.jingdong.Bean.Gw_bean.AddShopBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface GouApi {
    //添加
    @GET("addCart")
    Call<AddShopBean> doGet(@Query("source") String source, @Query("uid") int uid, @Query("pid") int pid);


}
