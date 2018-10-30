package com.lay.laykypro.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lay.laykypro.view.Fragment.LazyFragment;

public abstract class BaseFragment<B extends BaseView,P extends BasePresenter> extends LazyFragment {
    public P basePresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        basePresenter=getBasePresenter();
        basePresenter.attach((B)this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        basePresenter.detach();
    }
    public abstract P getBasePresenter();
}
