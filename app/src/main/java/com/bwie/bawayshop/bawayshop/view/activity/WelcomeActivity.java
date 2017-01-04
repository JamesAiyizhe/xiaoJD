package com.bwie.bawayshop.bawayshop.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.bwie.bawayshop.bawayshop.R;
import com.bwie.bawayshop.bawayshop.utils.SpUtils;
import com.bwie.bawayshop.bawayshop.view.adapter.GuideAdapter;

/**
 * Created by Administrator on 2016/12/27 0027.
 */

public class WelcomeActivity extends BaseActivity {


    private ViewPager mPager;
    private String FALG = "flag";
    private boolean flag;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initViews();
    }

    private void sp() {

        flag = (boolean) SpUtils.get(WelcomeActivity.this,FALG,false);
        if (flag){

            goHome();

        }else{

            //修改存值
            SpUtils.put(this,FALG,true);


        }
    }

    public void goHome() {
        startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
        finish();
    }

    private void initViews() {
        mPager = (ViewPager) findViewById(R.id.vp_pager);
        mPager.setAdapter(new GuideAdapter(this));
        sp();
    }

    @Override
    public void addActivity() {

    }
}
