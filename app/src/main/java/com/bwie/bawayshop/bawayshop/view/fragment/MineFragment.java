package com.bwie.bawayshop.bawayshop.view.fragment;

import android.view.View;

import com.bwie.bawayshop.bawayshop.R;

/**
 * Created by Administrator on 2016/12/28 0028.
 */

public class MineFragment extends BaseFragment  {


    /**
     * 初始化数据
     */
    @Override
    public void initData() {

    }

    @Override
    public void initUI(View view) {
        String url1 = "http://ww3.sinaimg.cn/large/610dc034jw1f6m4aj83g9j20zk1hcww3.jpg";
        String url = "http://image.tianjimedia.com/uploadImages/2015/197/46/VWWGN47DG06Z.jpg";
//        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.sdv);
//        SimpleDraweeView simpleDraweeView1 = (SimpleDraweeView) view.findViewById(R.id.iv);
//        ImageView imageView  = (ImageView) view.findViewById(R.id.iv2);
//    //  Phoenix.with(simpleDraweeView).load(filePath);
//        Phoenix.with(simpleDraweeView).load(url);
//        Phoenix.with(simpleDraweeView1).setNeedBlur(true).load(url1);

    }

    @Override
    public View initView() {

        return View.inflate(mActivity, R.layout.mine_fragment, null);

    }

    
}
