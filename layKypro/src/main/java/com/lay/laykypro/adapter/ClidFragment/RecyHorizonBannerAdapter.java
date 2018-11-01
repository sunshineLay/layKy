package com.lay.laykypro.adapter.ClidFragment;

import android.content.Context;

import com.lay.laykypro.R;

import java.util.List;

public class RecyHorizonBannerAdapter extends BaseRecyclerViewAdapter<String> {

    public RecyHorizonBannerAdapter(List<String> list, Context mContext, int layId) {
        super(list, mContext, layId);
    }

    @Override
    public void convert(ViewHolder holder, String itemData) {
        holder.setImageFromUrl(R.id.horizontal_img,itemData);

    }
}
