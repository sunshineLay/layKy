package com.lay.laykypro.adapter.Fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lay.laykypro.R;
import com.lay.laykypro.bean.MainNoBean;
import com.lay.laykypro.utils.MyTimeUtils;


import java.util.List;

public class NoRecyclerViewAdapter extends RecyclerView.Adapter<NoRecyclerViewAdapter.MyViewHolder> {
    private List<MainNoBean.MessageListBean> messageListBeanList;
    private Context mContext;
    //设置普通的和尾巴的两种情况
    public final int NORMAL=1;

    public final int FOOT=0;

    //声明接口
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener=onItemClickListener;

    }

    public NoRecyclerViewAdapter(List<MainNoBean.MessageListBean> messageListBeanList, Context mContext) {
        this.messageListBeanList = messageListBeanList;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==NORMAL){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview_nofragment, parent, false);
            MyViewHolder myViewHolder = new MyViewHolder(view,viewType);
            return myViewHolder;
        }else{
            View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_no_foot, parent, false);
            return new MyViewHolder(view,viewType);
        }

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        //设置子项显示的内容
        if(getItemViewType(position)==NORMAL){
            Glide.with(mContext).load(messageListBeanList.get(position).icon).into(holder.imgIcon);

            holder.textContent.setText(messageListBeanList.get(position).content);

            //将int转化为时间
            long date = messageListBeanList.get(position).date;
            String dataString = MyTimeUtils.timeFormInt(date);
            holder.textDate.setText(dataString);

            holder.textTitle.setText(messageListBeanList.get(position).title);
        }


        //设置点击事件
        if(mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(position);
                }
            });

        }



    }

    @Override
    public int getItemCount() {
        return messageListBeanList.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==getItemCount()-1){
            return FOOT;
        }
        return NORMAL;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgIcon;
        TextView textDate;
        TextView textContent;
        TextView textTitle;
        RelativeLayout footView;

        //获取相关控件
        public MyViewHolder(View itemView,int viewType) {
            super(itemView);
            if(viewType==NORMAL){
                imgIcon = (ImageView) itemView.findViewById(R.id.item_no_img);
                textDate = (TextView) itemView.findViewById(R.id.item_no_date);
                textContent = (TextView) itemView.findViewById(R.id.item_no_content);
                textTitle = (TextView) itemView.findViewById(R.id.item_no_title);
            }else if(viewType==FOOT){
                footView = (RelativeLayout) itemView;
            }


        }
    }
}
