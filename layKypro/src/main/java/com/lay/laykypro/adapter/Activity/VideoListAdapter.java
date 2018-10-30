package com.lay.laykypro.adapter.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lay.laykypro.R;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoListAdapter extends BaseAdapter {
    private List<HashMap<String,Object>> videoLists;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    //final 标记过后才能用
    private static final int ITEM_PLAY=1;
    private static final int ITEM_TEXT=2;

    public VideoListAdapter(List<HashMap<String, Object>> videoLists, Context mContext) {
        this.videoLists=videoLists;
        this.mContext = mContext;
        mLayoutInflater=LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {
        return videoLists.size();
    }

    @Override
    public Object getItem(int position) {
        return videoLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        PlayViewHolder playViewHolder=null;
        TextViewHolder textViewHolder=null;
        int itemViewType = getItemViewType(position);
        if(convertview==null){
            switch (itemViewType){
                case ITEM_TEXT:
                    convertview=mLayoutInflater.inflate(R.layout.item_lv_text,parent,false);
                    textViewHolder=new TextViewHolder(convertview);
                    textViewHolder.tvTitle.setText((String)videoLists.get(position).get("text"));
                    convertview.setTag(R.layout.item_lv_text,textViewHolder);
                    break;
                case ITEM_PLAY:
                    convertview=mLayoutInflater.inflate(R.layout.item_lv_video,parent,false);
                    playViewHolder=new PlayViewHolder(convertview);
                    playViewHolder.tvTitle.setText((String)videoLists.get(position).get("name"));
                    playViewHolder.tvTag.setText((String)videoLists.get(position).get("description"));
                    Glide.with(mContext).load((String)videoLists.get(position).get("icon")).into(playViewHolder.videoImg);
                    convertview.setTag(R.layout.item_lv_video,playViewHolder);
                    break;

            }
        }else{
            switch (itemViewType){
                case ITEM_PLAY:
                    playViewHolder= (PlayViewHolder) convertview.getTag(R.layout.item_lv_video);
                    playViewHolder.tvTitle.setText((String)videoLists.get(position).get("name"));
                    playViewHolder.tvTag.setText((String)videoLists.get(position).get("description"));
                    Glide.with(mContext).load((String)videoLists.get(position).get("icon")).into(playViewHolder.videoImg);
                    break;
                case ITEM_TEXT:
                    textViewHolder=(TextViewHolder)convertview.getTag(R.layout.item_lv_text);
                    textViewHolder.tvTitle.setText((String)videoLists.get(position).get("text"));
                    break;
            }

        }

        return convertview;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }


    @Override
    public int getItemViewType(int position) {
        if(videoLists.get(position).get("type")=="textCard"){
            return ITEM_TEXT;
        }else if(videoLists.get(position).get("type")=="videoSmallCard"){
            return ITEM_PLAY;
        }

        return super.getItemViewType(position);
    }

    class TextViewHolder{
        @BindView(R.id.video_list_title)
        TextView tvTitle;
        public TextViewHolder(View view) {
            ButterKnife.bind(this,view);
        }
    }

    class PlayViewHolder{
        @BindView(R.id.video_img)
        ImageView videoImg;
        @BindView(R.id.video_lv_title)
        TextView tvTitle;
        @BindView(R.id.video_lv_tag)
        TextView tvTag;

        public PlayViewHolder(View view) {
            ButterKnife.bind(this,view);
        }
    }

}
