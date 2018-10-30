package com.lay.laykypro.adapter.ClidFragment;

import android.content.Context;

import com.lay.laykypro.R;

import java.util.HashMap;
import java.util.List;

public class RecySqfollowAdapter extends BaseRecyclerViewAdapter<HashMap<String,Object>> {

    public RecySqfollowAdapter(List<HashMap<String, Object>> hashMaps, Context mContext, int layId) {
        super(hashMaps, mContext, layId);
    }

    @Override
    public void convert(ViewHolder holder, HashMap<String, Object> itemData,int position) {
        holder.setImageFromUrl(R.id.img_followcard_image,(String)itemData.get("feed"))
                .setImageFromUrl(R.id.img_mergefb_icon,(String)itemData.get("icon"))
                .setText(R.id.tv_mergefb_title,(String)itemData.get("headertitle"))
                .setText(R.id.tv_mergefb_description,(String)itemData.get("description"));

    }
}
