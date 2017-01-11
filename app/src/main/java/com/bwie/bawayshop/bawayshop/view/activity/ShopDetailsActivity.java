package com.bwie.bawayshop.bawayshop.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.bawayshop.bawayshop.R;
import com.bwie.bawayshop.bawayshop.model.bean.ShopDetailsBean;
import com.bwie.bawayshop.bawayshop.presenter.ShopDetailsPresenter;
import com.bwie.bawayshop.bawayshop.view.adapter.RecommendAdapter;
import com.bwie.bawayshop.bawayshop.view.interfaces.ShopDetailsView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.Phoenix;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author 艾一哲
 *         <p>
 *         created at 2017/1/11 0011 11:21
 */

public class ShopDetailsActivity extends BaseActivity implements ShopDetailsView {
    @BindView(R.id.particulars_back_image)
    ImageView particularsBackImage;
    @BindView(R.id.particulars_shoucang_image)
    ImageView particularsShoucangImage;
    @BindView(R.id.particulars_share_image)
    ImageView particularsShareImage;
    @BindView(R.id.particulars_title)
    LinearLayout particularsTitle;

    @BindView(R.id.particulars_name_tv)
    TextView particulars_name_tv;
    @BindView(R.id.particulars_price_tv)
    TextView particularsPriceTv;
    @BindView(R.id.particulars_salenum_tv)
    TextView particularsSalenumTv;
    @BindView(R.id.particulars_arrea_tv)
    TextView particularsArreaTv;
    @BindView(R.id.particulars_goods_tv)
    TextView particulars_goods_tv;
    @BindView(R.id.particulars_money_tv)
    TextView particularsMoneyTv;
    @BindView(R.id.particulars_comment_tv)
    TextView particularsCommentTv;
    @BindView(R.id.particulars_goodcomment_tv)
    TextView particularsGoodcommentTv;
    @BindView(R.id.particulars_pernum_tv)
    TextView particularsPernumTv;
    @BindView(R.id.particulars_desc_tv)
    TextView particularsDescTv;
    @BindView(R.id.particulars_service_tv)
    TextView particularsServiceTv;
    @BindView(R.id.particulars_wuliu_tv)
    TextView particularsWuliuTv;
    @BindView(R.id.head_llayout)
    LinearLayout headLlayout;
    @BindView(R.id.particulars_tuijian_tv)
    TextView particularsTuijianTv;
    @BindView(R.id.particulars_goods_list_recyclerview)
    RecyclerView particularsGoodsListRecyclerview;
    @BindView(R.id.particulars_kefu_tv)
    TextView particularsKefuTv;
    @BindView(R.id.particulars_gouwuche_tv)
    TextView particularsGouwucheTv;
    @BindView(R.id.particulars_jointocar_tv)
    TextView particularsJointocarTv;
    @BindView(R.id.particulars_buynow_tv)
    TextView particularsBuynowTv;
    @BindView(R.id.particulars_pic_image)
    SimpleDraweeView particularsPicImage;
    @BindView(R.id.goods_jingle)
    TextView goodsJingle;
    @BindView(R.id.store_name)
    TextView storeName;
    @BindView(R.id.particulars_descf_tv)
    TextView particularsDescfTv;
    @BindView(R.id.particulars_servicef_tv)
    TextView particularsServicefTv;
    @BindView(R.id.particulars_wuliuf_tv)
    TextView particularsWuliufTv;
    private ShopDetailsPresenter presenter;
    private ShopDetailsBean shopDetailsBean;

    @Override
    public void addActivity() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productdetail_activity);
        ButterKnife.bind(this);

        initDatas();

    }

    private void showDatas() {
        //展示主图片
        showImage();
        //展示具体数据
        showDestails();
        //展示店铺推荐的数据
        showRecyclerview();

    }
    //展示店铺推荐的数据
    private void showRecyclerview() {
        List<ShopDetailsBean.DatasBean.GoodsCommendListBean> commendList = shopDetailsBean.getDatas().getGoods_commend_list();
        //设置模式
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        particularsGoodsListRecyclerview.setLayoutManager(layoutManager);
        //设置Adapter
        RecommendAdapter adapter = new RecommendAdapter(commendList,this);
        particularsGoodsListRecyclerview.setAdapter(adapter);
        //
        adapter.setOnRecyclerViewItemListener(new RecommendAdapter.OnRecyclerViewItemListener() {
            @Override
            public void RecyclerViewItemListener(View view, String position) {
                Intent intent = new Intent(ShopDetailsActivity.this,ShopDetailsActivity.class);
                intent.putExtra("goods_id",position);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    //展示具体数据
    private void showDestails() {
        //商品详细信息
        shopDetailsBean.getDatas().getGoods_info();
        //地址信息
        shopDetailsBean.getDatas().getGoods_hair_info();
        //设置商品名
        particulars_name_tv.setText(shopDetailsBean.getDatas().getGoods_info().getGoods_name());
        //设置价格名
        particularsPriceTv.setText("￥" + shopDetailsBean.getDatas().getGoods_info().getGoods_price());
        //设置销量
        particularsSalenumTv.setText("销量：" + shopDetailsBean.getDatas().getGoods_info().getGoods_salenum());
        //介绍
        String jingle = shopDetailsBean.getDatas().getGoods_info().getGoods_jingle();
        goodsJingle.setText(TextUtils.isEmpty(jingle)?"该商品暂无也介绍":jingle);
        //商城名字
        storeName.setText(shopDetailsBean.getDatas().getStore_info().getStore_name());
        //地址
        particularsArreaTv.setText(shopDetailsBean.getDatas().getGoods_hair_info().getArea_name());
        //有货
        particulars_goods_tv.setText(shopDetailsBean.getDatas().getGoods_hair_info().getIf_store_cn());
        //运费
        particularsMoneyTv.setText(shopDetailsBean.getDatas().getGoods_hair_info().getContent());
        //物流
        particularsWuliuTv.setText(shopDetailsBean.getDatas().getStore_info().getStore_credit().getStore_deliverycredit().getText());
        particularsWuliufTv.setText(":"+shopDetailsBean.getDatas().getStore_info().getStore_credit().getStore_deliverycredit().getCredit()+"分");

        //服务
        particularsServiceTv.setText(shopDetailsBean.getDatas().getStore_info().getStore_credit().getStore_servicecredit().getText());
        particularsServicefTv.setText(":"+shopDetailsBean.getDatas().getStore_info().getStore_credit().getStore_servicecredit().getCredit()+"分");

        //描述
        particularsDescTv.setText(shopDetailsBean.getDatas().getStore_info().getStore_credit().getStore_desccredit().getText());
        particularsDescfTv.setText(":"+shopDetailsBean.getDatas().getStore_info().getStore_credit().getStore_desccredit().getCredit()+"分");
    }

    private void showImage() {
        String image = shopDetailsBean.getDatas().getGoods_image();
        String[] img = image.split(",");
        //展示主图片利用Frico
        Phoenix.with(particularsPicImage).load(img[0]);
    }

    /**
     * 初始化数据
     */
    private void initDatas() {
        Intent intent = getIntent();
        String goods_id = intent.getStringExtra("goods_id");
        presenter = new ShopDetailsPresenter();
        presenter.attchView(this);
        //调用方法
        presenter.getShopDeatails(goods_id);
    }

    /**
     *
     *
     */

    @Override
    public void onSuccess(Message message) {
        switch (message.what) {
            case 0:
                shopDetailsBean = (ShopDetailsBean) message.obj;

                //展示数据
                showDatas();
                break;
        }


    }

    @Override
    public void onFail() {

    }

    /**
     * 监听
     * @param view
     */
    @OnClick({R.id.particulars_back_image, R.id.particulars_shoucang_image, R.id.particulars_share_image, R.id.particulars_kefu_tv, R.id.particulars_gouwuche_tv, R.id.particulars_jointocar_tv, R.id.particulars_buynow_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.particulars_back_image:
                finish();
                break;
            case R.id.particulars_shoucang_image:
                break;
            case R.id.particulars_share_image:
                break;
            case R.id.particulars_kefu_tv:
                break;
            case R.id.particulars_gouwuche_tv:
                break;
            case R.id.particulars_jointocar_tv:
                break;
            case R.id.particulars_buynow_tv:
                break;
        }
    }
}
