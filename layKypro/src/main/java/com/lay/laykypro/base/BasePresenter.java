package com.lay.laykypro.base;

import java.lang.ref.WeakReference;

//负责所以的P都需要完成的基础部分
//P是一个有趣的部分
public class BasePresenter<B extends BaseView>  {
    //使用软引用
    private WeakReference<B> weakReference;

    public void attach(B view){
        weakReference=new WeakReference<B>(view);
    }
    public void detach(){
        if(weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }

    }
    public B getView(){
        return weakReference.get();
    }


}
