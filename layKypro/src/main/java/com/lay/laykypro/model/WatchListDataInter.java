package com.lay.laykypro.model;

import android.content.Context;

import com.lay.laykypro.base.IBackRequestCallBack;

import java.util.HashMap;
import java.util.List;

public interface WatchListDataInter {
    void getWatchDataFromSql(Context context, IBackRequestCallBack<List<HashMap<String,Object>>> iBackRequestCallBack);
}
