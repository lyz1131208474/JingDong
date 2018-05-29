package com.example.administrator.jingdong.presenter.Gw_presenter;

import com.example.administrator.jingdong.Bean.Gw_bean.ShopBean;
import com.example.administrator.jingdong.model.GouWuChe_model.ShopModel;
import com.example.administrator.jingdong.view.GouWuChe_View.IMshopview;

public class ShopPresenter implements IMShopPresenter {

    private ShopModel shopModel;
    private IMshopview iMshopview;

    public ShopPresenter(IMshopview iMshopview) {
        this.iMshopview=iMshopview;
        shopModel = new ShopModel(this);


    }

    public void getshop(String s, int uid) {
        shopModel.getshop(s,uid);

    }

    @Override
    public void shop(ShopBean shopBean) {
        iMshopview.shop(shopBean);

    }
}
