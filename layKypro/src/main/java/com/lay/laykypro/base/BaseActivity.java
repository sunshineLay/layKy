package com.lay.laykypro.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lay.laykypro.R;

import butterknife.ButterKnife;

/**
 * 对于MVP来说，在B中主要是使P的方法和A的生命周期关联
 */
public abstract class BaseActivity<B extends BaseView,P extends BasePresenter> extends AppCompatActivity {
    public P basePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        basePresenter=getBasePresenter();
        basePresenter.attach((B)this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        basePresenter.detach();
    }
    public abstract P getBasePresenter();
}
