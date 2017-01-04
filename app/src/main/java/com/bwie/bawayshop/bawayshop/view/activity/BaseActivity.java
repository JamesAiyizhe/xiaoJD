package com.bwie.bawayshop.bawayshop.view.activity;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bwie.bawayshop.bawayshop.application.MyApplication;

/**
 * 基类Activity
 * Created by Administrator on 2016/12/27 0027.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Application appLication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(appLication == null){
            appLication = (MyApplication) getApplication();
        }
    }
    protected <T extends View> T $(int id) {
        return (T) super.findViewById(id);
    }
    public abstract void addActivity();


}
