package com.example.administrator.jingdong.model.GouWuChe_model;

import com.example.administrator.jingdong.Bean.Gw_bean.ShopBean;
import com.example.administrator.jingdong.httputils.Gw_http.BaseObserver;
import com.example.administrator.jingdong.httputils.Gw_http.RetrofitManager;
import com.example.administrator.jingdong.presenter.Gw_presenter.IMShopPresenter;

import java.util.HashMap;
import java.util.Map;

public class ShopModel {
    private IMShopPresenter imShopPresenter;

    public ShopModel(IMShopPresenter imShopPresenter) {
        this.imShopPresenter=imShopPresenter;

    }


    public void getshop(final String s, int uid) {

        Map<String,String> map = new HashMap<>();

        map.put("uid", String.valueOf(uid));
        map.put("source","android");
        RetrofitManager.post(s, map, new BaseObserver<ShopBean>() {
            @Override
            public void success(ShopBean shopBean) {
                imShopPresenter.shop(shopBean);


            }

            @Override
            public void failure(int code) {

            }
        });
    }
}
