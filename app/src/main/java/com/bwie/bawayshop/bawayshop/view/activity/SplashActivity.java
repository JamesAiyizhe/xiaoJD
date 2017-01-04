package com.bwie.bawayshop.bawayshop.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import com.bwie.bawayshop.bawayshop.R;

/**
 *
 * 启动页面
 * Created by Administrator on 2016/12/30 0030.
 */

public class SplashActivity extends BaseActivity {

    private static final long SPLASH_DELAY_MILLIS = 3000;
    private Handler mHandler = new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (msg.what == 0){
            //跳转页面
            goHome();

        }

    }


    };
    @Override
    public void addActivity() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();


    }
    //延时发送
    private void initView() {
        mHandler.sendEmptyMessageDelayed(0,SPLASH_DELAY_MILLIS);
    }
    //跳转
    private void goHome() {
        startActivity(new Intent(SplashActivity.this,WelcomeActivity.class));
        finish();

    }
}
