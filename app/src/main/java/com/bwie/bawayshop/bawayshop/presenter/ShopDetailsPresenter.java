package com.bwie.bawayshop.bawayshop.presenter;

import android.os.Message;
import android.util.Log;

import com.bwie.bawayshop.bawayshop.model.api.HttpRequest;
import com.bwie.bawayshop.bawayshop.model.bean.ShopDetailsBean;
import com.bwie.bawayshop.bawayshop.view.interfaces.ShopDetailsView;

/**
 * Created by 艾一哲 on 2017/1/6 0006.
 */

public class ShopDetailsPresenter extends BasePresenter<ShopDetailsView> {

    private Message msg = new Message();
    private String details_url = "http://169.254.188.41/mobile/index.php?act=goods&op=goods_detail&goods_id=";


    /**
     *
     * @param good_id
     */
    public void getShopDeatails(String good_id) {
        HttpRequest request = HttpRequest.getInstance();
        Log.e("TAG",details_url+good_id);
        request.requestJson2Bean(details_url + good_id, ShopDetailsBean.class, new HttpRequest.RequestJson2BeanCallBack<ShopDetailsBean>() {
            @Override
            public void success(ShopDetailsBean result) {
                msg.what = 0;
                msg.obj = result;
                //回传数据
                baseView.onSuccess(msg);

            }

            @Override
            public void error() {

            }
        });
    }



}
