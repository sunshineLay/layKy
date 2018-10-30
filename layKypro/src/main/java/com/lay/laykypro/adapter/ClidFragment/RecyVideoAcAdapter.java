package com.lay.laykypro.adapter.ClidFragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.lay.laykypro.R;
import com.lay.laykypro.bean.VideoListBean;
import com.lay.laykypro.bean.play.VideoListItemBean;
import com.lay.laykypro.bean.play.VideoPlayItemBean;

import java.util.List;

public class RecyVideoAcAdapter extends BaseRecyclerViewAdapter<VideoListItemBean> {

    public RecyVideoAcAdapter(List<VideoListItemBean> itemBeans, Context mContext, int layId) {
        super(itemBeans, mContext, layId);
    }

    @Override
    public void convert(ViewHolder holder, VideoListItemBean itemData,int position) {
        if(itemData.type.equals("videoSmallCard")){
            holder.setImageFromUrl(R.id.img_videosmallcard_homepage,itemData.data.cover.feed)
                    .setText(R.id.tv_videosmallcard_title,itemData.data.title)
                    .setText(R.id.tv_videosmallcard_category,itemData.data.description);
        }else{
            holder.setText(R.id.tv_header5,"相关推荐");
        }


    }
}
