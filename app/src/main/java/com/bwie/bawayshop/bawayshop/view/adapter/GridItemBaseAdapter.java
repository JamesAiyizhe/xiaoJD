package com.bwie.bawayshop.bawayshop.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.bawayshop.bawayshop.R;
import com.bwie.bawayshop.bawayshop.model.bean.CategoryChild2;

import java.util.List;

/**
 * Created by 艾一哲 on 2017/1/4 0004.
 */
public class GridItemBaseAdapter extends BaseAdapter {

    private Context mContext;
    private List<CategoryChild2.DatasBean.ClassListBean> mList;

    public GridItemBaseAdapter(Context mContext, List<CategoryChild2.DatasBean.ClassListBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CategoryChild2.DatasBean.ClassListBean getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.grid_item,null);
            holder.textView = (TextView) convertView.findViewById(R.id.tv_category_des);
            convertView.setTag(holder);

        }else {
            holder = (ViewHolder) convertView.getTag();

        }

        holder.textView.setText(mList.get(position).getGc_name());
        return convertView;
    }


    class ViewHolder{

        TextView textView;

    }
}
