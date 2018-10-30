package com.lay.laykypro.presenter;

import com.lay.laykypro.base.BasePresenter;
import com.lay.laykypro.base.IBackRequestCallBack;
import com.lay.laykypro.model.MainClidFragModel;
import com.lay.laykypro.view.MainFragmentClid.MainClidFragment;

public class MainClidPresenter extends BasePresenter<MainClidFragment>implements MainClidPreInter {
    @Override
    public void getClidListData(String root, String path) {
            new MainClidFragModel().getClidListData(root, path, new IBackRequestCallBack<String>() {
                @Override
                public void requestSuccess(String tData) {
                    MainClidFragment mainClidFragment=getView();
                    if(mainClidFragment!=null){
                        mainClidFragment.showClidListData(tData);
                    }
                }
            });
    }

    @Override
    public void getListData(String path) {
        new MainClidFragModel().getListData(path, new IBackRequestCallBack<String>() {
            @Override
            public void requestSuccess(String tData) {
                MainClidFragment mainClidFragment=getView();
                if(mainClidFragment!=null){
                    mainClidFragment.showClidListData(tData);
                }
            }
        });

    }

    @Override
    public void getMainClidAddDyListData(String path, int start) {
        new MainClidFragModel().getMainClidAddDyListData(path, start, new IBackRequestCallBack<String>() {
            @Override
            public void requestSuccess(String tData) {
                MainClidFragment view = getView();
                if(view!=null){
                    view.showMainClidAddListData(tData);
                }
            }
        });
    }

    @Override
    public void getMainClidAddListData(String root, String path, int start) {
        new MainClidFragModel().getMainClidAddListData(root, path, start, new IBackRequestCallBack<String>() {
            @Override
            public void requestSuccess(String tData) {
                MainClidFragment view = getView();
                if(view!=null){
                    view.showMainClidAddListData(tData);
                }
            }
        });

    }

}
