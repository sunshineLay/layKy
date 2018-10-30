package com.lay.laykypro.utils;


import android.os.Environment;
import android.util.Log;

import com.lay.laykypro.base.IBackRequestCallBack;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttpUtils {

    private static OKHttpUtils utils;

    private OKHttpUtils(){

    }

    public OKHttpUtils getInstance() {
        if (utils == null) {
            synchronized (OKHttpUtils.class) {
                if (utils == null) {
                    utils = new OKHttpUtils();
                }
            }
        }
        return utils;
    }

    private static OkHttpClient okHttpClient;

    private static OkHttpClient getOkHttpClient() {

        if (okHttpClient == null) {
            File sdcache = new File(Environment.getExternalStorageDirectory(), "cache");
            int cacheSize = 10 * 1024 * 1024;
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request();
                            Request builder = request.newBuilder().addHeader("source", "android").build();
                            Response response = chain.proceed(builder);
                            return response;
                        }
                    })
                    .connectTimeout(15, TimeUnit.SECONDS)
                    //.cache(new Cache(sdcache, cacheSize))
                    .build();
        }
        return okHttpClient;
    }

    /**
     * 得到VideoList部分的Json数据,传给接口
     */
    public static Call getJsonFromVideoList(int id){
        //将id制作成String数据
        String urlOld="http://baobab.kaiyanapp.com/api/v4/video/related?id=%d&udid=bd4602def0ed4576b145297b0bc8dc6c6b414e3b&vc=381&vn=4.3&deviceModel=BLN-AL40&first_channel=eyepetizer_zhihuiyun_market&last_channel=eyepetizer_zhihuiyun_market&system_version_code=24";
        String url = String.format(urlOld, id);
        OkHttpClient okHttpClient = getOkHttpClient();
        final Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        return call;


    }




}
