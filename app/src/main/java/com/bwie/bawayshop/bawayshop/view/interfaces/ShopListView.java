package com.bwie.bawayshop.bawayshop.view.interfaces;

import android.os.Message;

/**
 * Created by 艾一哲 on 2017/1/6 0006.
 */

public interface ShopListView extends BaseView {

    void onSuccess(Message message);
    void onFail();

}
