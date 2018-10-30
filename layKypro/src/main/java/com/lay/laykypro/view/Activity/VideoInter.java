package com.lay.laykypro.view.Activity;

import com.lay.laykypro.base.BaseView;
import com.lay.laykypro.bean.VideoListBean;
import com.lay.laykypro.bean.play.VideoListItemBean;
import com.lay.laykypro.bean.play.VideoPlayItemBean;

import java.util.HashMap;
import java.util.List;

public interface VideoInter extends BaseView {
    void showVideoListData(VideoListBean<VideoListItemBean> videoPlayItemBeanVideoListBean);//参数为VideoListData 的数据类型；得到数据


}
