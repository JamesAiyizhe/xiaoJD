package com.bwie.bawayshop.bawayshop.presenter;

import android.os.Message;

import com.bwie.bawayshop.bawayshop.model.api.HttpRequest;
import com.bwie.bawayshop.bawayshop.model.bean.ShopListBean;
import com.bwie.bawayshop.bawayshop.view.interfaces.ShopListView;

import java.util.List;

/**
 * Created by 艾一哲 on 2017/1/6 0006.
 */

public class ShopListPresenter extends BasePresenter<ShopListView> {

    private Message msg = new Message();
    private String url = "http://169.254.188.41/mobile/index.php?act=goods&op=goods_list&page=100&key=1&gc_id=";

    /**
     *
     * @param gc_id
     */
    public void getShopList(String gc_id){
        HttpRequest request = HttpRequest.getInstance();
        request.requestJson2Bean(url+gc_id, ShopListBean.class, new HttpRequest.RequestJson2BeanCallBack<ShopListBean>() {
            @Override
            public void success(ShopListBean result) {
                //得到集合
                List<ShopListBean.DatasBean.GoodsListBean> goods_list = result.getDatas().getGoods_list();
                msg.what = 0;
                msg.obj = goods_list;
                //成功是数据回传
        baseView.onSuccess(msg);
            }

            @Override
            public void error() {

            }
        });
    }


}
