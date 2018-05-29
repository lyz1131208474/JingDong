package com.example.administrator.jingdong.httputils.SP_http;

import android.os.Environment;

import com.example.administrator.jingdong.Fragment.GouWuChe.GouApi;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Sp_HttpUtil {
    private static  Sp_HttpUtil insance;
    private final Retrofit retrofit;

    private Sp_HttpUtil(String uri){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        HttpLoggingInterceptor httpLoggingInterceptor1 = httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        File file = new File(Environment.getExternalStorageDirectory(),"cache999");

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor1)
                .readTimeout(3000, TimeUnit.SECONDS)
                .connectTimeout(3000,TimeUnit.SECONDS)
                .cache(new Cache(file,10*1024))
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(uri)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Sp_HttpUtil getInsance(String uri){
        if(insance==null){
            synchronized (Sp_HttpUtil.class){
                if(null==insance){
                    insance = new Sp_HttpUtil(uri);
                }
            }
        }
        return insance;
    }


    public GouApi getApi(){
        return  retrofit.create(GouApi.class);
    }
}
