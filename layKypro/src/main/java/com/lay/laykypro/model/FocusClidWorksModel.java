package com.lay.laykypro.model;


import com.lay.laykypro.base.IBackRequestCallBack;
import com.lay.laykypro.bean.FocusClidWorksBean;
import com.lay.laykypro.bean.play.FocusworksItemPlayDataBean;
import com.lay.laykypro.bean.text.FocusworksItemDataBean;

public interface FocusClidWorksModel {

           void getPlayData(IBackRequestCallBack<FocusClidWorksBean<FocusworksItemPlayDataBean>> itemBeanPlayIBackRequestCallBack);


}
