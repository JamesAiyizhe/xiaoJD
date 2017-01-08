package com.bwie.bawayshop.bawayshop.system;

/**
 *
 * Created by 艾一哲 on 2017/1/4 0004.
 */

public class Link {

    public final static String BASE_LINK = "http://169.254.188.41/";                //请求地址
    public final static String LINK_MOBILE = BASE_LINK+"mobile/index.php?act=";   //主干
    public final static String LINK_MOBILE_CLASS = LINK_MOBILE+"goods_class";       //分类
    public final static String LINK_MOBILE_CLASS_CHILD = LINK_MOBILE_CLASS+"&gc_id=";       //分类
    //分类详情的Url
//    http://169.254.23.18/mobile/index.php?act=goods&op=goods_list&page=100&key=1&gc_id=
}
