package com.lay.laykypro.view.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.lay.laykypro.R;
import com.lay.laykypro.view.Activity.WatchRecordActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

//MainActivity 的首页碎片四个之一 我的部分；

public class MyFragment extends Fragment {

    @BindView(R.id.img_head_phset)
    ImageView imgHeadPhset;
    @BindView(R.id.img_head_head)
    com.lay.laykypro.view.CustomView.CircleImageView imgHeadHead;
    @BindView(R.id.tv_head_name)
    TextView tvHeadName;
    @BindView(R.id.tv_head_mymain)
    TextView tvHeadMymain;
    @BindView(R.id.tv_head_like)
    TextView tvHeadLike;
    @BindView(R.id.tv_head_cache)
    TextView tvHeadCache;
    @BindView(R.id.Re_head_fragmy)
    RelativeLayout ReHeadFragmy;
    @BindView(R.id.tv_item01_focus)
    TextView tvItem01Focus;
    @BindView(R.id.tv_item02_record)
    TextView tvItem02Record;
    @BindView(R.id.tv_item03_feedback)
    TextView tvItem03Feedback;
    @BindView(R.id.tv_item04_contribute)
    TextView tvItem04Contribute;
    @BindView(R.id.Re_body_sc)
    RelativeLayout ReBodySc;
    @BindView(R.id.Sc_body_fragmy)
    ScrollView ScBodyFragmy;
    @BindView(R.id.tv_num_Refoot)
    TextView tvNumRefoot;
    @BindView(R.id.Re_foot_fragmy)
    RelativeLayout ReFootFragmy;
    @BindView(R.id.lin_root_fragmy)
    LinearLayout linRootFragmy;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.tv_item02_record)
    public void onViewClicked() {
        //点击这个textView 跳转到WRActivity
        Intent intent = new Intent(getActivity(), WatchRecordActivity.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.anim_in_watch, R.anim.anim_out_watch);
        //进场动画


    }
}
