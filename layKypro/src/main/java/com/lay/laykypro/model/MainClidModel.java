package com.lay.laykypro.model;

import com.lay.laykypro.base.IBackRequestCallBack;

public interface MainClidModel {
    void getListData(String path,IBackRequestCallBack<String> stringIBackRequestCallBack);

    void getClidListData(String root,String path,IBackRequestCallBack<String> stringIBackRequestCallBack);

    void getMainClidAddDyListData(String path, int start,IBackRequestCallBack<String> stringIBackRequestCallBack);

    void getMainClidAddListData(String root,String path, int start,IBackRequestCallBack<String> stringIBackRequestCallBack);
}
