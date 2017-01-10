package com.bwie.bawayshop.bawayshop.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.bwie.bawayshop.bawayshop.R;
import com.bwie.bawayshop.bawayshop.model.bean.CategoryChild2;
import com.bwie.bawayshop.bawayshop.view.activity.ShopListActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by 艾一哲 on 2017/1/4 0004.
 */
public class CategoryChild2Adapter extends RecyclerView.Adapter<CategoryChild2Adapter.MyViewHolder> {

    private HashMap<String, List<CategoryChild2.DatasBean.ClassListBean>> map;
    private Context mContext;
    private ArrayList<String> Keys = new ArrayList<>();

    public CategoryChild2Adapter(HashMap<String, List<CategoryChild2.DatasBean.ClassListBean>> map, Context mContext) {
        this.mContext = mContext;
        this.map = map;
        Set<String> gc_name = map.keySet();
        //遍历Set集合取出key只放入集合
        for (String s : gc_name) {
            Keys.add(s);
        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.category_right_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        String name = Keys.get(position);
        holder.textView.setText(name);
        final List<CategoryChild2.DatasBean.ClassListBean> desList = map.get(name);
        holder.gridView.setAdapter(new GridItemBaseAdapter(mContext,desList));
       //gridView点击监听
        holder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String gc_id = desList.get(position).getGc_id();
                Log.e("TAG", "++"+gc_id);
                Intent intent= new Intent(mContext,ShopListActivity.class);
                intent.putExtra("gcid",gc_id);
                //重新创建一个新的栈 把Activity放入新的栈
//               intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return map.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView textView;
        GridView gridView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_category_title);
            gridView = (GridView) itemView.findViewById(R.id.gv_category_deas);

        }
    }
}


