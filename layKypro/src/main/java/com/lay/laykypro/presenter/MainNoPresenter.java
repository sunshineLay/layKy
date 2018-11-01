package com.lay.laykypro.presenter;

import android.util.Log;

import com.lay.laykypro.base.BasePresenter;
import com.lay.laykypro.base.IBackRequestCallBack;
import com.lay.laykypro.bean.MainNoBean;
import com.lay.laykypro.model.NoModel;
import com.lay.laykypro.view.Fragment.NoFragment;


public class MainNoPresenter extends BasePresenter<NoFragment> implements NoPresenterInter {
    private String TAG="No";


    @Override
    public void getData() {
        new NoModel().getData(new IBackRequestCallBack<MainNoBean>() {
            @Override
            public void requestSuccess(MainNoBean tData) {
                getView().showData(tData);
                Log.d(TAG, "requestSuccess: "+tData.messageList.size());
            }

            @Override
            public void requestComplete() {

            }
        });

    }


}
