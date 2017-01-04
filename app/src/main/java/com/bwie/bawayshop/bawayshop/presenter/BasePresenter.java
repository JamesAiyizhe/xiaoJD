package com.bwie.bawayshop.bawayshop.presenter;

import com.bwie.bawayshop.bawayshop.view.interfaces.BaseView;

/**
 * Created by Administrator on 2016/12/27 0027.
 */

public class BasePresenter<T extends BaseView> {

    protected   T baseView;

    public T getBaseView() {
        return baseView;
    }

    public void attchView(T baseView) {
        this.baseView = baseView;
    }
}
