package com.bwie.bawayshop.bawayshop.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bwie.bawayshop.bawayshop.R;
import com.bwie.bawayshop.bawayshop.model.bean.ShopListBean;
import com.bwie.bawayshop.bawayshop.presenter.ShopListPresenter;
import com.bwie.bawayshop.bawayshop.view.adapter.ShopListAdapter;
import com.bwie.bawayshop.bawayshop.view.interfaces.ShopListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商品列表页
 * Created by 艾一哲 on 2017/1/5 0005.
 */
@RequiresApi(api = Build.VERSION_CODES.M)
public class ShopListActivity extends BaseActivity implements ShopListView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.btn_zh_order)
    Button btnZhOrder;
    @BindView(R.id.btn_xl_order)
    Button btnXlOrder;
    @BindView(R.id.btn_sx_order)
    Button btnSxOrder;
    @BindView(R.id.btn_model)
    ImageButton btnModel;
    @BindView(R.id.shopRecyclerView)
    RecyclerView shopRecyclerView;
    @BindView(R.id.ptf)
    SwipeRefreshLayout ptf;
    @BindView(R.id.btn_shopList_back)
    ImageButton btnShopListBack;
    @BindView(R.id.et_shopList_search)
    EditText etShopListSearch;
    @BindView(R.id.btn_shopList_search)
    ImageButton btnShopListSearch;
    private ShopListPresenter pesenter;

    private LinearLayoutManager layoutManager;
    private ShopListAdapter adapter;


    /**
     * SwipeRefreshLayout里面需要注意的Api：
     * 1、setOnRefreshListener(OnRefreshListener listener)  设置下拉监听，当用户下拉的时候会去执行回调
     * 2、setColorSchemeColors(int... colors) 设置 进度条的颜色变化，最多可以设置4种颜色
     * 3、setProgressViewOffset(boolean scale, int start, int end) 调整进度条距离屏幕顶部的距离
     * 4、setRefreshing(boolean refreshing) 设置SwipeRefreshLayout当前是否处于刷新状态，一般是在请求数据的时候设置为true，在数据被加载到View中后，
     * 设置为false。
     */

    @Override
    public void addActivity() {

    }

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoplist);
        ButterKnife.bind(this);
        initView();
        initDatas();
    }


    private void initView() {
        //设置圆圈的颜色
        ptf.setColorSchemeColors(Color.BLUE);
        //监听
        ptf.setOnRefreshListener(this);

        //
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        shopRecyclerView.setLayoutManager(layoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        shopRecyclerView.setHasFixedSize(true);


    }

    private void initDatas() {
        Intent intent = getIntent();
        String gc_id = intent.getStringExtra("gcid");
        pesenter = new ShopListPresenter();
        pesenter.attchView(this);
        Toast.makeText(ShopListActivity.this, "++"+gc_id, Toast.LENGTH_SHORT).show();

        pesenter.getShopList(gc_id);


    }


    @Override
    public void onSuccess(Message message) {
        switch (message.what) {
            case 0:
                final List<ShopListBean.DatasBean.GoodsListBean> goods_list = (List<ShopListBean.DatasBean.GoodsListBean>) message.obj;

                //创建和设置adapter
                adapter = new ShopListAdapter(goods_list, this);
                shopRecyclerView.setAdapter(adapter);
                //RecyclerView自定义监听监听到的是Title
                adapter.setOnItemClickLister(new ShopListAdapter.onRecyclerViewItemClickListener() {
                    @Override
                    public void onItemClickLister(View v, String position) {
                        Intent intent = new Intent(ShopListActivity.this,ShopDetailsActivity.class);
                        intent.putExtra("goods_id",position);
                        startActivity(intent);
//                        //调用跳转详情的方法
//                        pesenter.getShopDeatails(position);



                    }
                });



                break;
            //请求跳转详情页
            case 1:


                break;

        }

    }

    @Override
    public void onFail() {

    }

    /**
     * 按钮监听
     *
     * @param view
     */
    @OnClick({R.id.btn_zh_order, R.id.btn_xl_order, R.id.btn_sx_order, R.id.btn_model,R.id.btn_shopList_back, R.id.btn_shopList_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_zh_order:
                break;
            case R.id.btn_xl_order:
                break;
            case R.id.btn_sx_order:
                break;
            case R.id.btn_model:
                Toast.makeText(this, "model改变", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_shopList_back:
                finish();
                break;
            case R.id.btn_shopList_search:
                break;
        }
    }

    /**
     *
     */
    @Override
    public void onRefresh() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (ptf.isRefreshing()) {
                            ptf.setRefreshing(false);
                        }
                    }
                });
            }
        }).start();
    }


}
