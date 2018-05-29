package com.example.administrator.jingdong.MyApp;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class Myapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
