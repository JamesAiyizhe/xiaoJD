package com.bwie.bawayshop.bawayshop.application;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.facebook.fresco.helper.Phoenix;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/28 0028.
 */

public class MyApplication extends Application {

    private ArrayList<AppCompatActivity> mActivityList;
    private Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        if (mActivityList == null) {
            mActivityList = new ArrayList<AppCompatActivity>();
        }
        //注册fresco的工具类
        Phoenix.init(mContext); // Context
    }


    // 添加Activity到集合
    public void addActivity(AppCompatActivity activity) {
        mActivityList.add(activity);
    }

    // 一键关闭功能
    public void killActivity() {
        for (AppCompatActivity activity : mActivityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
