package com.bwie.bawayshop.bawayshop.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.RadioGroup;

import com.bwie.bawayshop.bawayshop.R;
import com.bwie.bawayshop.bawayshop.view.adapter.FragmentTabAdapter;
import com.bwie.bawayshop.bawayshop.view.fragment.CarFragment;
import com.bwie.bawayshop.bawayshop.view.fragment.CategoryFragment;
import com.bwie.bawayshop.bawayshop.view.fragment.HomeFragment;
import com.bwie.bawayshop.bawayshop.view.fragment.MineFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {



    private RadioGroup mMainRg;
    private FragmentManager mFm;
    private ArrayList<Fragment> mFragmentLsit = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentLsit.add(new HomeFragment());
        mFragmentLsit.add(new CategoryFragment());
        mFragmentLsit.add(new CarFragment());
        mFragmentLsit.add(new MineFragment());

        mMainRg = (RadioGroup) findViewById(R.id.rg_main);
        FragmentTabAdapter tabAdapter = new FragmentTabAdapter(this,mFragmentLsit,R.id.content_fragment,mMainRg);



    }


    @Override
    public void addActivity() {

    }
}
