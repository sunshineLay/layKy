package com.lay.laykypro.presenter;

import com.lay.laykypro.base.BasePresenter;
import com.lay.laykypro.base.IBackRequestCallBack;
import com.lay.laykypro.bean.VideoListBean;
import com.lay.laykypro.bean.play.VideoListItemBean;
import com.lay.laykypro.model.VideoListAcModel;
import com.lay.laykypro.view.Activity.VideoActivity;

public class VideoPresenter extends BasePresenter<VideoActivity> implements VideoListPresenter {


    @Override
    public void getVideoPlayListData(int id) {
        new VideoListAcModel().getVideoPlayListData(id, new IBackRequestCallBack<VideoListBean<VideoListItemBean>>() {
            @Override
            public void requestSuccess(VideoListBean<VideoListItemBean> tData) {
                VideoActivity view = getView();
                if (view!=null){
                   view.showVideoListData(tData);
                }
            }

            @Override
            public void requestComplete() {

            }
        });
    }
}
