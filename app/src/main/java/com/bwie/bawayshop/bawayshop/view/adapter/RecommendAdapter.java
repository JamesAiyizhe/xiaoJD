package com.bwie.bawayshop.bawayshop.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.bawayshop.bawayshop.R;
import com.bwie.bawayshop.bawayshop.model.bean.ShopDetailsBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.Phoenix;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
* 店铺推荐的RecyclerView的适配器
*
*@author 艾一哲
*
*created at 2017/1/11 0011 20:34
*/

public class RecommendAdapter extends RecyclerView.Adapter<RecommendViewHolder> {

    private List<ShopDetailsBean.DatasBean.GoodsCommendListBean> commendList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private OnRecyclerViewItemListener mRecyclerViewItemListener;

    public RecommendAdapter(List<ShopDetailsBean.DatasBean.GoodsCommendListBean> commendList, Context mContext) {
        this.commendList = commendList;
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecommendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.shop_recyclerview_item,null);
        RecommendViewHolder holder = new RecommendViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(final RecommendViewHolder holder, int position) {

        final ShopDetailsBean.DatasBean.GoodsCommendListBean goods = commendList.get(position);
        holder.tvShopListTitle.setText(goods.getGoods_name());
        holder.tvShopListPrice.setText("￥"+goods.getGoods_promotion_price());
        //加载图片
        Phoenix.with(holder.ivShopListPic).load(goods.getGoods_image_url());
        //监听
        holder.tvShopListTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecyclerViewItemListener.RecyclerViewItemListener(v,goods.getGoods_id());
            }
        });


    }



    /**
     * 获取总数
     * @return
     */
    @Override
    public int getItemCount() {
        return commendList.size();
    }

    public void setOnRecyclerViewItemListener(OnRecyclerViewItemListener mRecyclerViewItemListener){
       this.mRecyclerViewItemListener = mRecyclerViewItemListener;
    }

    /**
     * 定义一个接口
     */
    public interface OnRecyclerViewItemListener{

        void RecyclerViewItemListener(View view,String position);

    }
}

class RecommendViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.iv_shopList_pic)
    SimpleDraweeView ivShopListPic;
    @BindView(R.id.tv_shopList_title)
    TextView tvShopListTitle;
     @BindView(R.id.tv_shopList_price)
    TextView tvShopListPrice;

    public RecommendViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
