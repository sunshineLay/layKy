package com.lay.laykypro.utils;

import com.lay.laykypro.api.ApiService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitUtils {
    //
    public  String baseUrl = "http://baobab.kaiyanapp.com/api/v5/index/tab/";

    public static ApiService apiService;
    //单例
    public static ApiService getApiService() {
            synchronized (RetrofitUtils.class) {
                if (apiService == null) {
                    new RetrofitUtils();
                }
            }

        return apiService;
    }
    private RetrofitUtils() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())//请求的结果转为实体类
                //适配RxJava2.0,RxJava1.x则为RxJavaCallAdapterFactory.create()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }
    public void setBaseUrl(String baseUrl){
        this.baseUrl=baseUrl;
    }
}


