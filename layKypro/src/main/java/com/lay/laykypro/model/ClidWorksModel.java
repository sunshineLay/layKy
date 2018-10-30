package com.lay.laykypro.model;


import com.lay.laykypro.api.ApiService;
import com.lay.laykypro.base.IBackRequestCallBack;
import com.lay.laykypro.bean.FocusClidWorksBean;
import com.lay.laykypro.bean.play.FocusworksItemPlayDataBean;
import com.lay.laykypro.bean.text.FocusworksItemDataBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

//  String url="http://baobab.kaiyanapp.com/api/v6/community/tab/follow?udid=bd4602def0ed4576b145297b0bc8dc6c6b414e3b&vc=376&vn=4.2.2&deviceModel=BLN-AL40&first_channel=eyepetizer_zhihuiyun_market&last_channel=eyepetizer_zhihuiyun_market&system_version_code=24";
public class ClidWorksModel implements FocusClidWorksModel {



    @Override
    public void getPlayData(final IBackRequestCallBack<FocusClidWorksBean<FocusworksItemPlayDataBean>> itemBeanPlayIBackRequestCallBack) {
        //先尝试是否成功，成功就封装
        String url="http://baobab.kaiyanapp.com/api/v6/community/tab/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getItemsPlayData("bd4602def0ed4576b145297b0bc8dc6c6b414e3b",376,"4.2.2","BLN-AL40","eyepetizer_zhihuiyun_market","eyepetizer_zhihuiyun_market",24)
                .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<FocusClidWorksBean<FocusworksItemPlayDataBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(FocusClidWorksBean<FocusworksItemPlayDataBean> focusworksItemPlayDataBeanFocusClidWorksBean) {
                itemBeanPlayIBackRequestCallBack.requestSuccess(focusworksItemPlayDataBeanFocusClidWorksBean);
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

