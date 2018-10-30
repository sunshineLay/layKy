package com.lay.laykypro.adapter.ClidFragment;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

public class WrapRecyclerView extends RecyclerView {
    private WrapRecyclerAdapter mWrapAdapter;
    public WrapRecyclerView(Context context) {
        super(context);
    }

    public WrapRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WrapRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    public void setAdapter(Adapter adapter) {
        // 这里做一个替换
        mWrapAdapter = new WrapRecyclerAdapter(adapter);
        super.setAdapter(mWrapAdapter);
    }

    /**
     * 添加头部View
     * @param view
     */
    public void addHeaderView(View view){
        if(mWrapAdapter != null){
            mWrapAdapter.addHeaderView(view);
        }
    }

    /**
     * 添加底部View
     * @param view
     */
    public void addFooterView(View view){
        if(mWrapAdapter != null){
            mWrapAdapter.addFooterView(view);
        }
    }

    /**
     * 移除头部View
     * @param view
     */
    public void removeHeaderView(View view){
        if(mWrapAdapter != null){
            mWrapAdapter.removeHeaderView(view);
        }
    }

    /**
     * 移除底部View
     * @param view
     */
    public void removeFooterView(View view){
        if(mWrapAdapter != null){
            mWrapAdapter.removeFooterView(view);
        }
    }
}



