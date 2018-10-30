package com.lay.laykypro.adapter.ClidFragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * 打造一个可以添加头和尾的RecyclerView
 */
public class WrapRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RecyclerView.Adapter mRealAdapter;
    private ArrayList<View> mHeaderList;
    private ArrayList<View> mFooterList;

    public WrapRecyclerAdapter(RecyclerView.Adapter mAdapter) {
        this.mRealAdapter = mAdapter;
        this.mHeaderList = new ArrayList<>();
        this.mFooterList =  new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        // Header (negative positions will throw an IndexOutOfBoundsException)
        int numHeaders = getHeadersCount();

        if (position< numHeaders) {
            return createFooterHeaderViewHolder(mHeaderList.get(position));
        }

        // Adapter
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mRealAdapter != null) {
            adapterCount = mRealAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                return mRealAdapter.onCreateViewHolder(parent, mRealAdapter.getItemViewType(adjPosition));
            }
        }

        // Footer (off-limits positions will throw an IndexOutOfBoundsException)
        return createFooterHeaderViewHolder(mFooterList.get(adjPosition - adapterCount));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return;
        }
        // Adapter
        final int adjPosition = position - numHeaders;
        if (mRealAdapter != null) {
            int adapterCount = mRealAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                mRealAdapter.onBindViewHolder(holder, adjPosition);
            }
        }
    }

    private RecyclerView.ViewHolder createFooterHeaderViewHolder(View view) {
        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mRealAdapter.getItemCount()+mHeaderList.size()+mFooterList.size();
    }
    public int getHeadersCount() {
        return mHeaderList.size();
    }
    /**
     * 添加底部View
     * @param view
     */
    public void addFooterView(View view) {
        if (!mFooterList.contains(view)) {
           mFooterList.add(view);
            notifyDataSetChanged();
        }
    }

    /**
     * 添加头部View
     * @param view
     */
    public void addHeaderView(View view) {
        if (!mHeaderList.contains(view)) {
            mHeaderList.add(view);
            notifyDataSetChanged();
        }
    }

    /**
     * 移除底部View
     * @param view
     */
    public void removeFooterView(View view) {
        if (mFooterList.contains(view)) {
           mFooterList.remove(view);
            notifyDataSetChanged();
        }
    }

    /**
     * 移除头部View
     * @param view
     */
    public void removeHeaderView(View view) {
        if (mHeaderList.contains(view)) {
            mHeaderList.remove(view);
            notifyDataSetChanged();
        }
    }
    
}
