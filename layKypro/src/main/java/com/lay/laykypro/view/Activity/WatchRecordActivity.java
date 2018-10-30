package com.lay.laykypro.view.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lay.laykypro.R;
import com.lay.laykypro.adapter.Activity.WatchRecordAdapter;
import com.lay.laykypro.adapter.ClidFragment.BaseRecyclerViewAdapter;
import com.lay.laykypro.adapter.ClidFragment.MainClidItemDecoration;
import com.lay.laykypro.adapter.ClidFragment.WrapRecyclerView;
import com.lay.laykypro.base.BaseActivity;
import com.lay.laykypro.base.BaseView;
import com.lay.laykypro.presenter.WatchListDataPresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//实现“观看记录的功能”
public class WatchRecordActivity extends BaseActivity<BaseView, WatchListDataPresenter> implements WatchInter {

    private static final String TAG = WatchRecordActivity.class.getSimpleName();
    @BindView(R.id.recy_title_watchrecord)
    TextView recyTitleWatchrecord;
    @BindView(R.id.tv_watch_empty)
    TextView tvWatchEmpty;
    @BindView(R.id.recy_watchrecord)
    WrapRecyclerView recyWatchrecord;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watchrecord);
        ButterKnife.bind(this);
        basePresenter.getWatchListData(this);
    }

    @Override
    public WatchListDataPresenter getBasePresenter() {
        return new WatchListDataPresenter();
    }


    @Override
    public void showDataFromSQL(List<HashMap<String, Object>> tList) {
        if (tList.size() > 0) {
            Log.e(TAG, "showDataFromSQL: " + tList.get(3).get("title"));
            recyWatchrecord.setVisibility(View.VISIBLE);
            tvWatchEmpty.setVisibility(View.GONE);
            initRecyclerView(tList);
        } else {
            //显示一个没有数据的页面
            recyWatchrecord.setVisibility(View.GONE);
            tvWatchEmpty.setVisibility(View.VISIBLE);

        }

    }

    private void initRecyclerView(List<HashMap<String, Object>> tList) {
        recyWatchrecord.setLayoutManager(new LinearLayoutManager(this));
        WatchRecordAdapter watchRecordAdapter = new WatchRecordAdapter(tList, WatchRecordActivity.this, R.layout.item_clidfragment_videosmallcard);

        watchRecordAdapter.setMultiTypeSupport(new BaseRecyclerViewAdapter.MultiTypeSupport<HashMap<String, Object>>() {
            @Override
            public int getLayoutId(HashMap<String, Object> item) {
                return R.layout.item_clidfragment_videosmallcard;
            }
        });

        watchRecordAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener<HashMap<String, Object>>() {
            @Override
            public void onItemClick(int position, List<HashMap<String, Object>> mList) {
                //跳转到VideoActivity
                HashMap<String, Object> stringObjectHashMap = mList.get(position);
                String type = (String) stringObjectHashMap.get("type");
                if (type.equals("followCard") || type.equals("videoSmallCard") || type.equals("DynamicInfoCard")) {
                    Intent intent = new Intent(WatchRecordActivity.this, VideoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("id", (Integer) stringObjectHashMap.get("oldid"));
                    bundle.putString("type", (String) stringObjectHashMap.get("type"));
                    bundle.putString("title", (String) stringObjectHashMap.get("title"));

                    intent.putExtra("Bundle", bundle);
                    startActivity(intent);
                }


            }
        });
        recyWatchrecord.setAdapter(watchRecordAdapter);

        View footerView = LayoutInflater.from(this).inflate(R.layout.item_video_footer, recyWatchrecord, false);
        recyWatchrecord.addFooterView(footerView);

        recyWatchrecord.addItemDecoration(new MainClidItemDecoration(this, R.drawable.itemdecoration));

    }

    @OnClick(R.id.recy_title_watchrecord)
    public void onViewClicked() {
        //Activity 退场和进场动画

    }
}
