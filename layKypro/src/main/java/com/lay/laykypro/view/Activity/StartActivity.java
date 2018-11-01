package com.lay.laykypro.view.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lay.laykypro.R;
import com.lay.laykypro.utils.ApiPics;
import com.lay.laykypro.utils.TimeAsyncTask;
import com.lay.laykypro.view.AppManager;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

//这个里面需要使用网络资源和图片的三级缓存，所以可以使用MVP
//启动页
//简单的下载任务，不使用R+R，使用异步任务即可
//Step1.异步下载广告图片  OKHttp自带异步
//Step2.属性动画：3/2/1 倒计时；动画加Handler;
//Step3.三级缓存；【优化点】【之后再做】

//我使用AsyncTask实现了异步321；[1]
//另外一种；使用了Handler实现添加动画的3/2/1；

//如果将OKHttpClient 对象作为全局实例对象，有两个地方可以一试；BaseActivity和Application
public class StartActivity extends Activity{

    private ImageView imgStart;
    private TextView tvTime;
    private Button btnStartup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        AppManager.getInstance().addActivity(this);

        btnStartup = (Button) findViewById(R.id.btn_startup);
        tvTime = (TextView) findViewById(R.id.tv_bian_startup);
        imgStart = (ImageView) findViewById(R.id.img_startup);
        imgStart.setScaleType(ImageView.ScaleType.FIT_XY);
//        initData01();
        Call call = initOkHttp(ApiPics.StartUpPath);
        initData(call);
        initNumAnimal();
        btnStartup.setVisibility(View.INVISIBLE);
//        注意：invisible--不显示,但保留所占的空间；visible--正常显示；gone：不显示,且不保留所占的空间
        btnStartup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StartActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });





    }

    private void initNumAnimal() {
        //使用Handler/AsyncTask  来实现动画效果
        TimeAsyncTask timeAsyncTask = new TimeAsyncTask(tvTime,btnStartup);
        timeAsyncTask.execute(1000);
//        btnStartup.setVisibility(View.VISIBLE);


    }

    private Call initOkHttp(String Url){
        OkHttpClient okHttpClient=new OkHttpClient();
        final Request request = new Request.Builder()
                .url(Url)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        return  call;
    }

    private void initData(Call call) {
        //网络图片设置

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    ResponseBody responseBody = response.body();
                    //图片解析三件套
                    //1.得到byte
                    //2.将byte变成bitmap BF.将byte转换为bitmap
                    //3.关掉Body
                    byte[] data = responseBody.bytes();

                    final Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);

                    responseBody.close();

                   imgStart.post(new Runnable() {
                       @Override
                       public void run() {
                           imgStart.setImageBitmap(bitmap);
                       }
                   });

                }
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        AppManager.getInstance().finishActivity();
    }
}
