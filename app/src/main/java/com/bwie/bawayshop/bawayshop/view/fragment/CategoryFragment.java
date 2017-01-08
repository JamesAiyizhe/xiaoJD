package com.bwie.bawayshop.bawayshop.view.fragment;

import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.bwie.bawayshop.bawayshop.R;
import com.bwie.bawayshop.bawayshop.model.bean.CategoryBean;
import com.bwie.bawayshop.bawayshop.model.bean.CategoryChild2;
import com.bwie.bawayshop.bawayshop.presenter.CategoryPresenter;
import com.bwie.bawayshop.bawayshop.view.adapter.CategoryAdapter;
import com.bwie.bawayshop.bawayshop.view.adapter.CategoryChild2Adapter;
import com.bwie.bawayshop.bawayshop.view.interfaces.CategoryView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/28 0028.
 */

public class CategoryFragment extends BaseFragment implements CategoryView {


    private List<CategoryBean.DatasBean.ClassListBean> mList;
    private ListView mCateList;
    private CategoryPresenter categoryPresenter;
    private CategoryAdapter mAdapter;
    private RecyclerView mCategoryDes;


    /**
     * 初始化数据
     */
    @Override
    public void initData() {
    }

    @Override
    public void initUI(View view) {
        mCateList = (ListView) view.findViewById(R.id.lv_categroylist);
        mCategoryDes = (RecyclerView) view.findViewById(R.id.re_categroylist_dea);
    }

    @Override
    public View initView() {
        categoryPresenter = new CategoryPresenter();
        categoryPresenter.attchView(this);
        //请求左边条目的数据
        categoryPresenter.getLeftList();

        return View.inflate(mActivity, R.layout.category_fragment, null);
    }
    /**
     *
     * @param message
     */
    @Override
    public void onSuccess(Message message) {
        switch (message.what) {
            case 0:
                this.mList = (List<CategoryBean.DatasBean.ClassListBean>) message.obj;
                mAdapter = new CategoryAdapter(mList, mContext, categoryPresenter);
                mCateList.setAdapter(mAdapter);
                Log.e("TAG", mList.get(0).getGc_name());
                break;
            case 1:
                HashMap<String,List<CategoryChild2.DatasBean.ClassListBean>> map = (HashMap<String, List<CategoryChild2.DatasBean.ClassListBean>>) message.obj;
                Toast.makeText(mContext, map.size()+"", Toast.LENGTH_SHORT).show();
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
                mCategoryDes.setLayoutManager(layoutManager);
                mCategoryDes.setAdapter(new CategoryChild2Adapter(map,mContext));
                break;
        }
    }
    @Override
    public void onFail() {
        Toast.makeText(mContext, "请求数据失败！", Toast.LENGTH_SHORT).show();
    }
}
