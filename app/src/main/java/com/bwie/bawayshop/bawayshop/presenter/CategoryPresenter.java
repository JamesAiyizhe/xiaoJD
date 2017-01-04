package com.bwie.bawayshop.bawayshop.presenter;

import android.os.Message;

import com.bwie.bawayshop.bawayshop.model.api.HttpRequest;
import com.bwie.bawayshop.bawayshop.model.bean.CategoryBean;
import com.bwie.bawayshop.bawayshop.model.bean.CategoryChild;
import com.bwie.bawayshop.bawayshop.view.interfaces.CategoryView;

import java.util.List;

import system.Link;

/**
 * Created by Administrator on 2016/12/27 0027.
 */

public class CategoryPresenter extends BasePresenter<CategoryView> {

    private Message message  = new Message();
    //请求分类数据的方法
    public void getLeftList(){
        //初始化HttpResquest对象
        HttpRequest request = HttpRequest.getInstance();
        request.requestJson2Bean(Link.LINK_MOBILE_CLASS, CategoryBean.class, new HttpRequest.RequestJson2BeanCallBack<CategoryBean>() {



            @Override
            public void success(CategoryBean result) {
                //获取返回的集合
                List<CategoryBean.DatasBean.ClassListBean> mList = result.getDatas().getClass_list();

                message.what=0;
                message.obj=mList;
                baseView.onSuccess(message);
            }

            @Override
            public void error() {

                baseView.onFail();

            }
        });

    }
    //请求右边的数据
    public void getRightList(String gc_id){
        HttpRequest request = HttpRequest.getInstance();
        request.requestJson2Bean(Link.LINK_MOBILE_CLASS_CHILD+gc_id, CategoryChild.class, new HttpRequest.RequestJson2BeanCallBack<CategoryChild>() {
            @Override
            public void success(CategoryChild result) {
                List<CategoryChild.DatasBean.ClassListBean> class_list = result.getDatas().getClass_list();
                message.what = 1;
                message.obj = class_list;
                baseView.onSuccess(message);

            }

            @Override
            public void error() {

            }
        });

    }

}
