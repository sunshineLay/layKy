package com.lay.laykypro.model;

import com.lay.laykypro.api.ApiService;
import com.lay.laykypro.base.IBackRequestCallBack;
import com.lay.laykypro.utils.ApiMethods;
import com.lay.laykypro.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainClidFragModel implements MainClidModel {

    @Override
    public void getListData(String path, final IBackRequestCallBack<String> stringIBackRequestCallBack) {
        String url="http://baobab.kaiyanapp.com/api/v5/index/tab/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getListData(path,"bd4602def0ed4576b145297b0bc8dc6c6b414e3b",256,"3.14","BLN-AL40","eyepetizer_zhihuiyun_market","eyepetizer_zhihuiyun_market",24)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        //在这里接收String类型的字符串
                        stringIBackRequestCallBack.requestSuccess(s);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getClidListData(String root, String path, final IBackRequestCallBack<String> stringIBackRequestCallBack) {
        String url="http://baobab.kaiyanapp.com/api/v5/index/tab/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getClidListData(root,path,"bd4602def0ed4576b145297b0bc8dc6c6b414e3b",256,"3.14","BLN-AL40","eyepetizer_zhihuiyun_market","eyepetizer_zhihuiyun_market",24)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        //在这里接收String类型的字符串
                        stringIBackRequestCallBack.requestSuccess(s);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getMainClidAddDyListData(String path, int start, final IBackRequestCallBack<String> stringIBackRequestCallBack) {
        //之前的写法太繁琐，此处优化RxJava+Retrofit
        ApiMethods.getMainClidAddDyListData(path, start, new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                stringIBackRequestCallBack.requestSuccess(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void getMainClidAddListData(String root, String path, int start, final IBackRequestCallBack<String> stringIBackRequestCallBack) {
        ApiMethods.getMainClidAddListData(root, path, start, new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                stringIBackRequestCallBack.requestSuccess(s);
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
