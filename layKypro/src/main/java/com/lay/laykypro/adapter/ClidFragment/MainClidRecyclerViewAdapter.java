package com.lay.laykypro.adapter.ClidFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dl7.player.media.IjkPlayerView;
import com.lay.laykypro.R;
import com.lay.laykypro.view.Activity.VideoActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainClidRecyclerViewAdapter extends BaseRecyclerViewAdapter<HashMap<String, Object>> {



    public MainClidRecyclerViewAdapter(List<HashMap<String, Object>> hashMaps, Context mContext, int layId) {
        super(hashMaps, mContext, layId);
    }

    @Override
    public void convert(ViewHolder holder, HashMap<String, Object> itemData,int position) {
        String type = (String) itemData.get("type");
        if(type.equals("horizontalScrollCard")){
            RecyclerView recyclerView=holder.getViewAtId(R.id.recy_banner_horizon);
            //显示
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            // 数据源
            Integer count = (Integer) itemData.get("count");
            ArrayList<String> imgList = new ArrayList<>();
            for (int i = 0; i <count ; i++) {
                String imageUrl = (String) itemData.get("image" + i);
                imgList.add(imageUrl);
            }
            // 多布局
            RecyHorizonBannerAdapter recyHorizonBannerAdapter = new RecyHorizonBannerAdapter(imgList, mContext, R.layout.item_horizontalscroll_itemrecy);
            recyHorizonBannerAdapter.setMultiTypeSupport(new MultiTypeSupport<String>() {
                @Override
                public int getLayoutId(String item) {
                    return R.layout.item_horizontalscroll_itemrecy;
                }
            });
            //点击事件
            recyHorizonBannerAdapter.setOnItemClickListener(new OnItemClickListener<String>() {
                @Override
                public void onItemClick(int position, List<String> mList) {
                    Toast.makeText(mContext,"点击事件H",Toast.LENGTH_SHORT).show();
                }
            });
            //设置Adapter
            recyclerView.setAdapter(recyHorizonBannerAdapter);
        }else if(type.equals("header5")){
            holder.setText(R.id.tv_header5,(String)itemData.get("text"));
        }else if(type.equals("footer2")){
            if(position<tList.size()-1){
                holder.setText(R.id.tv_footer2,(String) itemData.get("text"));
            }else{
                holder.itemView.setVisibility(View.GONE);
            }
        }else if(type.equals("briefCard")){
           holder.setText(R.id.tv_merge_title,(String)itemData.get("title"))
                   .setText(R.id.tv_merge_description,(String)itemData.get("description"))
                   .setImageFromUrl(R.id.img_merge_icon,(String)itemData.get("icon"));
        }else if(type.equals("banner3")){
            holder.setImageFromUrl(R.id.img_merge_icon,(String)itemData.get("icon"))
                    .setText(R.id.tv_merge_title,(String)itemData.get("title"))
                    .setText(R.id.tv_merge_description,(String)itemData.get("description"))
                    .setImageFromUrl(R.id.img_banner3_image,(String)itemData.get("image"))
                    .setText(R.id.tv_banner3_rightTop,(String)itemData.get("card"));
        }else if(type.equals("followCard")){
            holder.setText(R.id.tv_mergefb_title,(String)itemData.get("title"))
                    .setText(R.id.tv_mergefb_description,(String)itemData.get("category"))
                    .setImageFromUrl(R.id.img_mergefb_icon,(String)itemData.get("icon"))
                    .setImageFromUrl(R.id.img_followcard_image,(String)itemData.get("homepage"));
        }else if(type.equals("videoSmallCard")){
           holder.setImageFromUrl(R.id.img_videosmallcard_homepage,(String)itemData.get("homepage"))
                   .setText(R.id.tv_videosmallcard_title,(String)itemData.get("title"))
                   .setText(R.id.tv_videosmallcard_category,(String)itemData.get("category"));
        }else if(type.equals("squareCardCollectionbanner")){
            RecyclerView recyclerView=holder.getViewAtId(R.id.recy_banner_squarecardcollect);
            //显示
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            //数据源
            ArrayList<String> imgLists = new ArrayList<>();
            Integer count = (Integer) itemData.get("count");
            for (int i = 0; i <count ; i++) {
                String imgUrl = (String) itemData.get("image" + i);
                imgLists.add(imgUrl);
            }
            RecyHorizonBannerAdapter recyHorizonBannerAdapter = new RecyHorizonBannerAdapter(imgLists, mContext, R.layout.item_horizontalscroll_itemrecy);
            recyHorizonBannerAdapter.setMultiTypeSupport(new MultiTypeSupport<String>() {
                @Override
                public int getLayoutId(String item) {
                    return R.layout.item_horizontalscroll_itemrecy;
                }
            });
            //点击事件
            recyHorizonBannerAdapter.setOnItemClickListener(new OnItemClickListener<String>() {
                @Override
                public void onItemClick(int position, List<String> mList) {

                }
            });
            //设置Adapter
            recyclerView.setAdapter(recyHorizonBannerAdapter);
        }else if(type.equals("videoCollectionWithBrief")){
            holder.setText(R.id.tv_mergefb_title,(String)itemData.get("title"))
                    .setImageFromUrl(R.id.img_mergefb_icon,(String)itemData.get("icon"))
                    .setText(R.id.tv_mergefb_description,(String)itemData.get("description"));
            RecyclerView recyclerView=holder.getViewAtId(R.id.recy_banner_videocollectionwibf);
            //显示
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            //数据源
            ArrayList<HashMap<String, Object>> hashMapArrayList = new ArrayList<>();

            Integer count = (Integer) itemData.get("count");
            for (int i = 0; i <count ; i++) {
                HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put("description",(String) itemData.get("description"+i));
                hashMap.put("feed",(String)itemData.get("feed"+i));
                hashMap.put("title",(String)itemData.get("title"+i));
                hashMap.put("id",(Integer)itemData.get("id"+i));
                hashMap.put("type","videoCollectionWithBrief");
                hashMapArrayList.add(hashMap);

            }
            RecyVideoCollectionWibfAdapter recyVideoCollectionWibfAdapter = new RecyVideoCollectionWibfAdapter(hashMapArrayList, mContext, R.layout.item_videocollectionwibf_itemrecy);
            recyVideoCollectionWibfAdapter.setMultiTypeSupport(new MultiTypeSupport<HashMap<String, Object>>() {
                @Override
                public int getLayoutId(HashMap<String, Object> item) {
                    return R.layout.item_videocollectionwibf_itemrecy;
                }
            });
            recyVideoCollectionWibfAdapter.setOnItemClickListener(new OnItemClickListener<HashMap<String, Object>>() {
                @Override
                public void onItemClick(int position, List<HashMap<String,Object>> mList) {
                    HashMap<String, Object> hashMap = mList.get(position);
                    String type = (String) hashMap.get("type");
                    if(type.equals("videoCollectionWithBrief")){
                        Intent intent = new Intent(mContext, VideoActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("id",(Integer) hashMap.get("id"));
                        bundle.putString("type",(String)hashMap.get("type"));
                        bundle.putString("title",(String)hashMap.get("title"));
                        intent.putExtra("Bundle",bundle);
                        mContext.startActivity(intent);
                    }
                }
            });
            //设置Adapter
            recyclerView.setAdapter(recyVideoCollectionWibfAdapter);

        }else if(type.equals("banner")){
           holder.setImageFromUrl(R.id.banner_img,(String)itemData.get("image"));

        }else if(type.equals("squareCardCollectionfollowCard")){
            holder.setText(R.id.tv_header5_sqfollow,(String)itemData.get("title"));
           RecyclerView recyclerSqfollow = holder.getViewAtId(R.id.recy_banner_sqfollow);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
            recyclerSqfollow.setLayoutManager(linearLayoutManager);
            //数据源
            ArrayList<HashMap<String, Object>> hashMapArrayList = new ArrayList<>();
            Integer count = (Integer) itemData.get("count");
            for (int i = 0; i <count ; i++) {
                HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put("feed",(String)itemData.get("feed"+i));
                hashMap.put("icon",(String)itemData.get("icon"+i));
                hashMap.put("headertitle",(String)itemData.get("headertitle"+i));//description
                hashMap.put("description",(String)itemData.get("description"+i));
                hashMap.put("id",(Integer)itemData.get("id"+i));
                hashMap.put("title",(String)itemData.get("title"+i));
                hashMap.put("type","squareCardCollectionfollowCard" );
                hashMapArrayList.add(hashMap);
            }
            RecySqfollowAdapter recySqfollowAdapter = new RecySqfollowAdapter(hashMapArrayList, mContext, R.layout.item_clidfragment_followcard);
            recySqfollowAdapter.setMultiTypeSupport(new MultiTypeSupport<HashMap<String,  Object>>() {
                @Override
                public int getLayoutId(HashMap<String,  Object> item) {
                    return R.layout.item_clidfragment_followcard;
                }
            });
            recySqfollowAdapter.setOnItemClickListener(new OnItemClickListener<HashMap<String,  Object>>() {
                @Override
                public void onItemClick(int position, List<HashMap<String,  Object>> mList) {
                    HashMap<String, Object> hashMap = mList.get(position);
                    String type = (String) hashMap.get("type");
                    if(type.equals("squareCardCollectionfollowCard")){
                        Intent intent = new Intent(mContext, VideoActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("id",(Integer) hashMap.get("id"));
                        bundle.putString("type",(String)hashMap.get("type"));
                        bundle.putString("title",(String)hashMap.get("title"));
                        intent.putExtra("Bundle",bundle);
                        mContext.startActivity(intent);
                    }
                }
            });
            recyclerSqfollow.setAdapter(recySqfollowAdapter);

        }else if(type.equals("autoPlayVideoAd")){
            holder.setImageFromUrl(R.id.img_autoplayvideoad_image,(String)itemData.get("imageUrl"))
                    .setImageFromUrl(R.id.img_mergefb_icon,(String)itemData.get("icon"))
                    .setText(R.id.tv_mergefb_title,(String)itemData.get("title"))
                    .setText(R.id.tv_mergefb_description,(String)itemData.get("description"));
        }else if(type.equals("autoPlayFollowCard")){
            holder.setImageFromUrl(R.id.img_autoplayvideoad_homepage,(String)itemData.get("homepage"));
        }else if(type.equals("DynamicInfoCard")){
            holder.setImageFromUrl(R.id.cirimg_dynamereply_icon,(String)itemData.get("cover"))
                    .setText(R.id.tv_dynamereply_name,(String)itemData.get("nickname"))
                    .setText(R.id.tv_dynamereply_content,(String)itemData.get("description"))
                    .setImageFromUrl(R.id.img_dynamereply_homepage,(String)itemData.get("homepage"))
                    .setText(R.id.tv_dynamereply_title,(String)itemData.get("title"))
                    .setText(R.id.tv_dynamereply_category,"#"+(String)itemData.get("category"));

        } else if(type.equals("communityBanner")){
            holder.setImageFromUrl(R.id.banner_img,(String)itemData.get("image"));
        }

    }




}
