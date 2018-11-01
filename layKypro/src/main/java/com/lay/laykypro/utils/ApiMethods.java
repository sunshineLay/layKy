package com.lay.laykypro.utils;

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

    //创意  这个会报403错误，应该是权限不够的原因
    public static void getMainClidAddCyListData(String root, String path, int start, Observer<String> observer) {
        ApiMethods.ApiSubscribe(RetrofitUtils.getApiService().getMainClidAddCyListData(root, path, start, 5), observer);
    }

    //推荐 写一个展示功能即可
    public static void getMainClidAddTJListData(int page, Observer<String> observer) {
        ApiMethods.ApiSubscribe(RetrofitUtils.getApiService().getMainClidAddTJListData(page, true, 6), observer);
    }

}
