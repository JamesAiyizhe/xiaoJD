package com.bwie.bawayshop.bawayshop.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.bawayshop.bawayshop.R;
import com.bwie.bawayshop.bawayshop.model.bean.ShopListBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.Phoenix;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 商品列表的适配器
 * Created by Administrator on 2017/1/8 0008.
 */

public class ShopListAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<ShopListBean.DatasBean.GoodsListBean> mlist;
    private Context context;
    private LayoutInflater mLayoutInflater;
    private onRecyclerViewItemClickListener onRecyclerViewItemClickListener;

    public ShopListAdapter(List<ShopListBean.DatasBean.GoodsListBean> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    //绑定一个ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mLayoutInflater.inflate(R.layout.shop_recyclerview_item,null);
        MyViewHolder holder = new MyViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        ShopListBean.DatasBean.GoodsListBean goods = mlist.get(position);
        holder.tvShopListTitle.setText(goods.getGoods_name());
        holder.tvShopListPrice.setText("￥"+goods.getGoods_price());
        holder.tvShopListNum.setText("已售："+goods.getGoods_salenum());
        //加载图片
        Phoenix.with(holder.ivShopListPic).load(goods.getGoods_image_url());
        //判断点击 用户点击条目
        if(onRecyclerViewItemClickListener != null){
            holder.tvShopListTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String goods_id = mlist.get(position).getGoods_id();
                    onRecyclerViewItemClickListener.onItemClickLister(v,goods_id);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }


    /**
     * 暴露一个接口的共有方法
     */
    public void setOnItemClickLister(onRecyclerViewItemClickListener onRecyclerViewItemClickListener){
            this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;

    }
    /**
     自定义监听接口
     */
    public interface onRecyclerViewItemClickListener{
        void onItemClickLister(View v,String position);
    }

}

class MyViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.iv_shopList_pic)
    SimpleDraweeView ivShopListPic;
    @BindView(R.id.tv_shopList_title)
    TextView tvShopListTitle;

    @BindView(R.id.tv_shopList_price)
    TextView tvShopListPrice;
    @BindView(R.id.tv_shopList_num)
    TextView tvShopListNum;

    public MyViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}


