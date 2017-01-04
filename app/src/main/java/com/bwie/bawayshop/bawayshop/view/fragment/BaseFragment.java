package com.bwie.bawayshop.bawayshop.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.bawayshop.bawayshop.view.activity.MainActivity;

/**
 * 基类Fragment
 * Created by Administrator on 2016/12/27 0027.
 */

public abstract class BaseFragment extends Fragment {

    protected MainActivity mActivity;
    protected Context mContext;
    protected View mView;
//    protected HttpUtil mHttpUtil;
//    protected XUtil mXUtil;
//    protected SpUtil mSputil;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //创建时拿到上下文,Activity
        mActivity = (MainActivity)getActivity();
        mContext = getActivity();
//        mHttpUtil = ((MyApplication) mActivity.getApplication()).getHttpUtil();
//        mXUtil = ((MyApplication) mActivity.getApplication()).getXUtil();
//        mSputil = ((MyApplication) mActivity.getApplication()).getSpUtil();

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        mView = initView();

        return mView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //初始化组件
        initUI(view);
        //初始化数据
        initData();
    }




    public abstract void initData();

    public abstract void initUI(View view);

    public abstract View initView();

}
