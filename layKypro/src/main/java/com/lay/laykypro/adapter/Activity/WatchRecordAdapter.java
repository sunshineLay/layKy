package com.lay.laykypro.adapter.Activity;

import android.content.Context;

import com.lay.laykypro.R;
import com.lay.laykypro.adapter.ClidFragment.BaseRecyclerViewAdapter;

import java.util.HashMap;
import java.util.List;

public class WatchRecordAdapter extends BaseRecyclerViewAdapter<HashMap<String,Object>> {


    public WatchRecordAdapter(List<HashMap<String, Object>> hashMaps, Context mContext, int layId) {
        super(hashMaps, mContext, layId);
    }

    @Override
    public void convert(ViewHolder holder, HashMap<String, Object> itemData,int position) {
        holder.setText(R.id.tv_videosmallcard_title,(String)itemData.get("title"))
        .setText(R.id.tv_videosmallcard_category,(String)itemData.get("category"))
        .setImageFromUrl(R.id.img_videosmallcard_homepage,(String)itemData.get("imgurl"));
    }
}
