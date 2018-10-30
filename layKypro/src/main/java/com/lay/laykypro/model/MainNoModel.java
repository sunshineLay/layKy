package com.lay.laykypro.model;


import com.lay.laykypro.base.IBackRequestCallBack;
import com.lay.laykypro.bean.MainNoBean;

public interface MainNoModel {
    void getData(IBackRequestCallBack<MainNoBean> iBackRequestCallBack);
}
