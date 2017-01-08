package com.bwie.bawayshop.bawayshop.presenter;

import android.os.Message;

import com.bwie.bawayshop.bawayshop.model.api.HttpRequest;
import com.bwie.bawayshop.bawayshop.model.bean.CategoryBean;
import com.bwie.bawayshop.bawayshop.model.bean.CategoryChild;
import com.bwie.bawayshop.bawayshop.model.bean.CategoryChild2;
import com.bwie.bawayshop.bawayshop.system.Link;
import com.bwie.bawayshop.bawayshop.view.interfaces.CategoryView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/27 0027.
 */

public class CategoryPresenter extends BasePresenter<CategoryView> {

    private Message message  = new Message();
    private String url;

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
    public void getRightList_1(String gc_id){
        url = Link.LINK_MOBILE_CLASS_CHILD+gc_id;
        HttpRequest request = HttpRequest.getInstance();
        request.requestJson2Bean(url, CategoryChild.class, new HttpRequest.RequestJson2BeanCallBack<CategoryChild>() {
            @Override
            public void success(CategoryChild result) {
                List<CategoryChild.DatasBean.ClassListBean> class_list = result.getDatas().getClass_list();
                //调用方法传递参数
                getRightList_2(class_list);
//                message.what = 1;
//                message.obj = class_list;
//                baseView.onSuccess(message);

            }

            @Override
            public void error() {

            }
        });

    }
    //请求右边的总数据
    public void getRightList_2(final List<CategoryChild.DatasBean.ClassListBean> class_list){
        final HashMap<String,List<CategoryChild2.DatasBean.ClassListBean>> map = new HashMap<>();
        final HttpRequest request = HttpRequest.getInstance();

        for (int i = 0; i < class_list.size(); i++) {
            //获的集合种第i个对象
            final CategoryChild.DatasBean.ClassListBean cc = class_list.get(i);
            request.requestJson2Bean(url+"&gc_id="+cc.getGc_id(),CategoryChild2.class, new HttpRequest.RequestJson2BeanCallBack<CategoryChild2>() {
                @Override
                public void success(CategoryChild2 result) {
                    List<CategoryChild2.DatasBean.ClassListBean> class_list1 = result.getDatas().getClass_list();
                    map.put(cc.getGc_name(),class_list1);
                    if(class_list.size() == map.size()){
                        message.what = 1;
                        message.obj = map;
                        baseView.onSuccess(message);

                    }
                }

                @Override
                public void error() {

                }
            });



        }


    }

}
