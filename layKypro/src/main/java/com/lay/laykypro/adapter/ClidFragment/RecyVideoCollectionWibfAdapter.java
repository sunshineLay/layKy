package com.lay.laykypro.adapter.ClidFragment;

import android.content.Context;

import com.lay.laykypro.R;

import java.util.HashMap;
import java.util.List;

public class RecyVideoCollectionWibfAdapter extends BaseRecyclerViewAdapter<HashMap<String,Object>> {

    public RecyVideoCollectionWibfAdapter(List<HashMap<String, Object>> hashMaps, Context mContext, int layId) {
        super(hashMaps, mContext, layId);
    }

    @Override
    public void convert(ViewHolder holder, HashMap<String, Object> itemData,int position) {
        holder.setText(R.id.tv_videocollectionwibf_title,(String)itemData.get("title"))
        .setText(R.id.tv_videocollectionwibf_description,(String)itemData.get("description"))
        .setImageFromUrl(R.id.videocollectionwibf_img,(String)itemData.get("feed"));

    }
}
