package com.lay.laykypro;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class MyApplication extends Application {
    //单例
    //1.static 自己；和G加S；S不是static；
    private static MyApplication myApplication;


    public static MyApplication getMyApplication() {
        return myApplication;
    }

    public  void setMyApplication(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setMyApplication(this);
        initLeakCanary();
    }


    private void initLeakCanary() {
        if(LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);
    }


}
