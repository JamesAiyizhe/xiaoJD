package com.bwie.bawayshop.bawayshop.view.interfaces;

import android.os.Message;

/**
 * Created by Administrator on 2016/12/27 0027.
 */

public interface CategoryView extends BaseView {

       void onSuccess(Message message);
       void onFail();

}
