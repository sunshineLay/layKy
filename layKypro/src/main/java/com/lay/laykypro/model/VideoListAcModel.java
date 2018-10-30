package com.lay.laykypro.model;

import android.util.Log;

import com.lay.laykypro.api.ApiService;
import com.lay.laykypro.base.IBackRequestCallBack;
import com.lay.laykypro.bean.VideoListBean;
import com.lay.laykypro.bean.play.VideoListItemBean;
import com.lay.laykypro.bean.play.VideoPlayItemBean;
import com.lay.laykypro.utils.OKHttpUtils;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideoListAcModel implements VideoListModel {
    private static final String TAG="layky";


    @Override
    public void getVideoPlayListData(int id, final IBackRequestCallBack<VideoListBean<VideoListItemBean>> videoListBeanIBackRequestCallBack) {
        String url="http://baobab.kaiyanapp.com/api/v4/video/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getVideoPlayListData(id,"bd4602def0ed4576b145297b0bc8dc6c6b414e3b",256,"3.14","BLN-AL40","eyepetizer_zhihuiyun_market","eyepetizer_zhihuiyun_market",24)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoListBean<VideoListItemBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VideoListBean<VideoListItemBean> videoListItemBeanVideoListBean) {
                        videoListBeanIBackRequestCallBack.requestSuccess(videoListItemBeanVideoListBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
