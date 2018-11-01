package com.lay.laykypro.model;

import com.lay.laykypro.base.IBackRequestCallBack;

public interface MainClidModel {
    void getListData(String path,IBackRequestCallBack<String> stringIBackRequestCallBack);

    void getClidListData(String root,String path,IBackRequestCallBack<String> stringIBackRequestCallBack);

    void getMainClidAddTJListData(int page, IBackRequestCallBack<String> stringIBackRequestCallBack);

}
