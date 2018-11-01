package com.lay.laykypro.presenter;


import com.lay.laykypro.base.BasePresenter;
import com.lay.laykypro.base.IBackRequestCallBack;
import com.lay.laykypro.bean.FocusClidWorksBean;
import com.lay.laykypro.bean.play.FocusworksItemPlayDataBean;
import com.lay.laykypro.model.ClidWorksModel;
import com.lay.laykypro.view.MainFragmentClid.FocusClidWorksFragment;

public class FocusClidWorksPresenter extends BasePresenter<FocusClidWorksFragment> implements WorksPresenterInter {



    @Override
    public void getPlayData() {
        new ClidWorksModel().getPlayData(new IBackRequestCallBack<FocusClidWorksBean<FocusworksItemPlayDataBean>>() {
            @Override
            public void requestSuccess(FocusClidWorksBean<FocusworksItemPlayDataBean> tData) {
                FocusClidWorksFragment view = getView();
                if (view!=null){
                    view.showPlayData(tData);
                }

            }

            @Override
            public void requestComplete() {

            }
        });

    }


}

