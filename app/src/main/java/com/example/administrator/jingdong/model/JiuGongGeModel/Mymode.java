package com.example.administrator.jingdong.model.JiuGongGeModel;

import com.example.administrator.jingdong.Bean.Jiugongge_bean;
import com.example.administrator.jingdong.Bean.Shouye_bean;
import com.example.administrator.jingdong.httputils.Getnet;
import com.example.administrator.jingdong.httputils.Util;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Mymode implements Imode {
    @Override
    public void getnetjson(final Getjson getjson) {
        Observable<Shouye_bean> user = Util.getmInstance().getnetjson(Getnet.net).getUser();
        user.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Shouye_bean>() {
                    @Override
                    public void accept(Shouye_bean shouye_bean) throws Exception {
                        getjson.getnetjson(shouye_bean);
                    }
                });
    }

    @Override
    public void getjiugonggejson(final Getjiugongge getjiugongge) {
        Observable<Jiugongge_bean> getjiugongge1 = Util.getmInstance().getnetjson(Getnet.net).getjiugongge();
        getjiugongge1.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Jiugongge_bean>() {
                    @Override
                    public void accept(Jiugongge_bean jiugongge_bean) throws Exception {
                        List<Jiugongge_bean.DataBean> data = jiugongge_bean.getData();
                        getjiugongge.getJiugongge(data);
                    }
                });
    }
}
