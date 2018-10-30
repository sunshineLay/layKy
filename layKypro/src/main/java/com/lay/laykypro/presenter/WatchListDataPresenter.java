package com.lay.laykypro.presenter;

import android.content.Context;

import com.lay.laykypro.base.BasePresenter;
import com.lay.laykypro.base.IBackRequestCallBack;
import com.lay.laykypro.model.WatchListDataModel;
import com.lay.laykypro.view.Activity.WatchRecordActivity;

import java.util.HashMap;
import java.util.List;

public class WatchListDataPresenter extends BasePresenter<WatchRecordActivity> implements WatchListDataPreInter {

    @Override
    public void getWatchListData(Context context) {
        new WatchListDataModel().getWatchDataFromSql(context, new IBackRequestCallBack<List<HashMap<String, Object>>>() {
            @Override
            public void requestSuccess(List<HashMap<String, Object>> tData) {
                WatchRecordActivity view = getView();
                if (view!=null){
                    view.showDataFromSQL(tData);
                }
            }
        });

    }
}
