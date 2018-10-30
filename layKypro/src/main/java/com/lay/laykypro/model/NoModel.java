package com.lay.laykypro.model;

import android.util.Log;


import com.lay.laykypro.api.ApiService;
import com.lay.laykypro.base.IBackRequestCallBack;
import com.lay.laykypro.bean.MainNoBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class NoModel implements MainNoModel{

    private String TAG="TAG";

    @Override
    public void getData(final IBackRequestCallBack<MainNoBean> iBackRequestCallBack) {
        String baseNoUrl="http://baobab.kaiyanapp.com/api/v3/";

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseNoUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getNoData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainNoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MainNoBean mainNoBean) {
                        Log.d(TAG, "onNext: "+mainNoBean.messageList.size());
                       iBackRequestCallBack.requestSuccess(mainNoBean);

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
