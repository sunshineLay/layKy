package com.lay.laykypro.adapter.ClidFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lay.laykypro.R;
import com.lay.laykypro.bean.FocusClidWorksBean;
import com.lay.laykypro.bean.play.FocusworksItemPlayDataBean;
import com.lay.laykypro.utils.MyTimeUtils;
import com.lay.laykypro.view.Activity.VideoActivity;
import com.lay.laykypro.view.CustomView.CircleImageView;

import java.util.List;


public class WorksRecyclerAdapter extends RecyclerView.Adapter<WorksRecyclerAdapter.PlayHolder>  {

    private List<FocusClidWorksBean.ItemBean<FocusworksItemPlayDataBean>> mWorksList;
    private Context mContext;
    private String TAG="WW";



    public WorksRecyclerAdapter(List<FocusClidWorksBean.ItemBean<FocusworksItemPlayDataBean>> itemBeanList, Context mContext) {
        this.mWorksList=itemBeanList;
        this.mContext = mContext;

    }

    @Override
    public PlayHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview_works, parent, false);
            PlayHolder playHolder = new PlayHolder(view, viewType);
            return playHolder;
    }

    @Override
    public void onBindViewHolder( final PlayHolder holder, int position) {
        if(mWorksList.get(position).type.equals("autoPlayFollowCard")){
//            将数据设置上去
            final FocusworksItemPlayDataBean.ContentBean.XDataBean dataBean = mWorksList.get(position).data.content.data;
            if(dataBean!=null){
                int size = dataBean.tags.size();
                for (int i = 0; i <size ; i++) {
                        if(i==0){
                            holder.tvLable01.setText(dataBean.tags.get(0).name);
                        }
                        if (i==1){
                            holder.tvLable02.setText(dataBean.tags.get(1).name);
                        }
                        if(i==2){
                            holder.tvLable03.setText(dataBean.tags.get(2).name);
                        }
                    }

//                    holder.tvLable02.setText(dataBean.tags.get(1).name);
//                    holder.tvLable03.setText(dataBean.tags.get(2).name);
//                for (int i = 0; i < dataBean.tags.size(); i++) {
//                    holder.tvLable01.setText(dataBean.tags.get(i).name);
//                }
                    holder.tvContent.setText(dataBean.description);
                    holder.tvTitle.setText(dataBean.author.name);
                    holder.tvZan.setText(""+dataBean.consumption.collectionCount);
                    holder.tvMess.setText(""+dataBean.consumption.replyCount);
                    //将数字转化为时间
                long releaseTime = dataBean.releaseTime;
                String dataString = MyTimeUtils.timeFormInt(releaseTime);
                holder.tvTime.setText(dataString);
                    //对于发布的特殊处理
                    String description = dataBean.author.description;
                    if(description.length()>10){
                        String substring = description.substring(0, 10);
                        holder.tvFbc.setText(substring);
                        holder.tvFbhz.setVisibility(View.VISIBLE);
                    } else {
                        holder.tvFbc.setText(description);
                        holder.tvFbhz.setVisibility(View.INVISIBLE);
                    }
                    //Image
                    Glide.with(mContext).load(dataBean.author.icon).into(holder.cirIcon);
                    if(dataBean.cover.detail!=null&&dataBean.cover.detail!=""){
                    Glide.with(mContext).load(dataBean.cover.detail).into(holder.imgPlay);
                    }
                //播放图片设置
                holder.imgPlay.setTag(R.id.imageid,position);//将当前的position设为标志
                //跳转
                final FocusClidWorksBean.ItemBean<FocusworksItemPlayDataBean> ItemBean = mWorksList.get(position);
                final FocusworksItemPlayDataBean.HeaderBean headerBean = mWorksList.get(position).data.header;

                if (ItemBean!=null&&headerBean!=null){
                    //跳转
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(mContext, VideoActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putInt("id",ItemBean.id);//VideoList和Video视频数据
                            //Video的Header数据
                            //Text
                            bundle.putString("title",dataBean.title);
                            bundle.putString("category",dataBean.category);
                            bundle.putString("description",dataBean.description);
                            //int
                            bundle.putInt("collectionCount",dataBean.consumption.collectionCount);
                            bundle.putInt("replyCount",dataBean.consumption.replyCount);
                            bundle.putInt("shareCount",dataBean.consumption.shareCount);
                            //tag
                            if(dataBean.tags.size()>0){
                                if(dataBean.tags.get(0)!=null){
                                    bundle.putString("headerImage01",dataBean.tags.get(0).headerImage);
                                }
                                if(dataBean.tags.get(1)!=null){
                                    bundle.putString("headerImage02",dataBean.tags.get(1).headerImage);
                                }
                                if(dataBean.tags.get(2)!=null){
                                    bundle.putString("headerImage03",dataBean.tags.get(2).headerImage);
                                }

                            }
                            //foot
                            bundle.putString("icon",headerBean.icon);
                            bundle.putString("issuerNam",headerBean.issuerName);
                            //注意，在之后的代码中需要做好处理，超过字数就要继续；
                            bundle.putString("subTitle",dataBean.author.description);
                            bundle.putString("type","FocusClidWorksFragment");
                            intent.putExtra("Bundle",bundle);
                            mContext.startActivity(intent);
                        }
                    });

                }

            }




            }


    }

    @Override
    public int getItemCount() {
        return mWorksList.size();//当要写Foot的时候需要加一;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }




    class PlayHolder extends RecyclerView.ViewHolder{

        ImageView imgPlay;
        TextView tvZan;
        TextView tvMess;
        TextView tvUp;
        TextView tvTime;
        TextView tvContent;
        TextView tvLable01;
        TextView tvLable02;
        TextView tvLable03;
        TextView tvTitle;
        TextView tvFb;
        TextView tvFbc;
        TextView tvFbhz;
        CircleImageView cirIcon;

        public PlayHolder(View itemView,int viewType) {
            super(itemView);
                cirIcon = (CircleImageView) itemView.findViewById(R.id.cirimg_works_icon);
                //Title
                tvTitle = (TextView) itemView.findViewById(R.id.tv_works_title);
                tvFb = (TextView) itemView.findViewById(R.id.tv_works_fb);
                tvFbc = (TextView) itemView.findViewById(R.id.tv_works_fbc);
                tvFbhz = (TextView) itemView.findViewById(R.id.tv_works_fbhz);
                tvContent = (TextView) itemView.findViewById(R.id.tv_works_content);
                //lable
                tvLable01 = (TextView) itemView.findViewById(R.id.tv_works_label01);
                tvLable02 = (TextView) itemView.findViewById(R.id.tv_works_label02);
                tvLable03 = (TextView) itemView.findViewById(R.id.tv_woks_label03);
                //icon
                tvZan = (TextView) itemView.findViewById(R.id.tv_works_zan);
                tvMess = (TextView) itemView.findViewById(R.id.tv_works_mess);
                tvUp = (TextView) itemView.findViewById(R.id.tv_works_up);
                tvTime = (TextView) itemView.findViewById(R.id.tv_works_time);
                //frameLayout

                imgPlay = (ImageView) itemView.findViewById(R.id.img_works_play);


            }
            //之后写一个else来写Foot


        }



    }






