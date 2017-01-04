package com.bwie.bawayshop.bawayshop.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.bawayshop.bawayshop.R;
import com.bwie.bawayshop.bawayshop.model.bean.CategoryBean;
import com.bwie.bawayshop.bawayshop.presenter.CategoryPresenter;

import java.util.List;

/**
 *
 * 分类页面列表的适配器
 * Created by 艾一哲 on 2017/1/3 0003.
 */
public class CategoryAdapter extends BaseAdapter {

    private List<CategoryBean.DatasBean.ClassListBean> mList;
    private Context mContext;
    private LayoutInflater mInflater;
    private int selectPosition;
    private CategoryPresenter persenter;



    public CategoryAdapter(List<CategoryBean.DatasBean.ClassListBean> mList, Context mContext, CategoryPresenter persenter) {
        this.mList = mList;
        this.mContext = mContext;
        this.persenter = persenter;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CategoryBean.DatasBean.ClassListBean getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.cotegory_life_item,null);
            holder.mText = (TextView) convertView.findViewById(R.id.tv_cotegoey);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //条目点击事件
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPosition = position;
                persenter.getRightList_1(getItem(position).getGc_id());
                notifyDataSetChanged();
            }
        });
        holder.mText.setText(mList.get(position).getGc_name());
        //改变字体颜色和背景
        if(selectPosition == position) {
            holder.mText.setTextColor(Color.RED);
            holder.mText.setBackgroundColor(Color.parseColor("#22000000"));

        }else{
            holder.mText.setTextColor(Color.BLACK);
            holder.mText.setBackgroundColor(Color.WHITE);

        }

        return convertView;
    }

    static class ViewHolder{

        TextView mText;
    }
}
