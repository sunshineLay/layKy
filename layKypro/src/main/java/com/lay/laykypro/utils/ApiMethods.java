package com.lay.laykypro.utils;

import android.graphics.Movie;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ApiMethods {
    /**
     * 封装线程管理和订阅的过程
     */
    public static void ApiSubscribe(Observable observable, Observer observer) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public static void getMainClidAddDyListData(String path, int start, Observer<String> observer) {
        ApiMethods.ApiSubscribe(RetrofitUtils.getApiService().getMainClidAddDyListData(path, start, 5), observer);
    }
    public static void getMainClidAddListData(String root, String path,int start, Observer<String> observer) {
        ApiMethods.ApiSubscribe(RetrofitUtils.getApiService().getMainClidAddListData(root,path, start, 5), observer);
    }

}
