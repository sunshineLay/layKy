package com.lay.laykypro.model;

import com.lay.laykypro.base.IBackRequestCallBack;
import com.lay.laykypro.bean.VideoListBean;
import com.lay.laykypro.bean.play.VideoListItemBean;
import com.lay.laykypro.bean.play.VideoPlayItemBean;

public interface VideoListModel {
    void getVideoPlayListData(int id,IBackRequestCallBack<VideoListBean<VideoListItemBean>> videoListBeanIBackRequestCallBack);
}
