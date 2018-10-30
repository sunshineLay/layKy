package com.lay.laykypro.view.Activity;

import com.lay.laykypro.base.BaseView;

import java.util.HashMap;
import java.util.List;

public interface WatchInter extends BaseView{
    void showDataFromSQL(List<HashMap<String,Object>> tList);
}
