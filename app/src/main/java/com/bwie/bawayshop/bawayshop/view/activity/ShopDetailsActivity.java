package com.bwie.bawayshop.bawayshop.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.bawayshop.bawayshop.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/10 0010.
 */

public class ShopDetailsActivity extends BaseActivity {
    @BindView(R.id.particulars_back_image)
    ImageView particularsBackImage;
    @BindView(R.id.particulars_shoucang_image)
    ImageView particularsShoucangImage;
    @BindView(R.id.particulars_share_image)
    ImageView particularsShareImage;
    @BindView(R.id.particulars_title)
    LinearLayout particularsTitle;
    @BindView(R.id.particulars_pic_image)
    ImageView particularsPicImage;
    @BindView(R.id.particulars_name_tv)
    TextView particularsNameTv;
    @BindView(R.id.particulars_price_tv)
    TextView particularsPriceTv;
    @BindView(R.id.particulars_salenum_tv)
    TextView particularsSalenumTv;
    @BindView(R.id.particulars_arrea_tv)
    TextView particularsArreaTv;
    @BindView(R.id.particulars_goods_tv)
    TextView particularsGoodsTv;
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

    @Override
    public void addActivity() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productdetail_activity);
        ButterKnife.bind(this);
    }
}
