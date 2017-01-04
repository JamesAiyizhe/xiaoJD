package com.bwie.bawayshop.bawayshop.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bwie.bawayshop.bawayshop.R;
import com.bwie.bawayshop.bawayshop.view.activity.MainActivity;

/**
 * 引导页
 * Author :艾一哲 date：2016.12.30
 */
public class GuideAdapter extends PagerAdapter {


    private Context context;
    private int id[] = new int[]{R.mipmap.vp1,R.mipmap.vp2,R.mipmap.vp3};

    public GuideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.guide_viewpager, null);
        Button in = (Button) view.findViewById(R.id.inputSystem);
        view.setBackgroundResource(id[position]);
        if(position == 2){
            in.setVisibility(View.VISIBLE);
            in.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  context.startActivity(new Intent(context, MainActivity.class));
                    ((Activity)context).finish();
                }
            });

        }
        container.addView(view);
        return view;
    }
}
