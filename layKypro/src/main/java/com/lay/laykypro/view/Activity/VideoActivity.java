package com.lay.laykypro.view.Activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dl7.player.media.IjkPlayerView;
import com.lay.laykypro.R;
import com.lay.laykypro.adapter.ClidFragment.BaseRecyclerViewAdapter;
import com.lay.laykypro.adapter.ClidFragment.MainClidItemDecoration;
import com.lay.laykypro.adapter.ClidFragment.RecyVideoAcAdapter;
import com.lay.laykypro.adapter.ClidFragment.WrapRecyclerView;
import com.lay.laykypro.base.BaseActivity;
import com.lay.laykypro.base.BaseView;
import com.lay.laykypro.bean.VideoListBean;
import com.lay.laykypro.bean.play.VideoListItemBean;
import com.lay.laykypro.presenter.VideoPresenter;
import com.lay.laykypro.view.AppManager;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//  private String VideoList = "http://baobab.kaiyanapp.com/api/v4/video/related?id=121825&udid=bd4602def0ed4576b145297b0bc8dc6c6b414e3b&vc=381&vn=4.3&deviceModel=BLN-AL40&first_channel=eyepetizer_zhihuiyun_market&last_channel=eyepetizer_zhihuiyun_market&system_version_code=24";

public class VideoActivity extends BaseActivity<BaseView, VideoPresenter> implements VideoInter {

    @BindView(R.id.video_player_view)
    IjkPlayerView videoPlayerView;
    @BindView(R.id.video_recy_play)
    WrapRecyclerView videoRecyPlay;


    private String TAG = "layVideo";
    private HashMap<String, Object> hashMap;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

        AppManager.getInstance().addActivity(this);

        hashMap = initData();
        Integer id = (Integer) hashMap.get("id");
        String title = (String) hashMap.get("title");
        initPlayView(id, title);
        basePresenter.getVideoPlayListData(id);

    }

    //得到数据
    private HashMap<String, Object> initData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Bundle");
        if (bundle.get("type").equals("followCard") || bundle.get("type").equals("videoSmallCard")
                || bundle.get("type").equals("videoCollectionWithBrief")
                || bundle.get("type").equals("squareCardCollectionfollowCard")
                || bundle.get("type").equals("FocusClidWorksFragment")
                || bundle.get("type").equals("DynamicInfoCard")) {
            //follow
            hashMap.put("id", bundle.getInt("id"));
            hashMap.put("title", bundle.getString("title"));
        }
        return hashMap;
    }

    //设置PlayView;
    private void initPlayView(int id, String title) {
        String urlOld = "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=%d&resourceType=video&editionType=high&source=aliyun";
        String url = String.format(urlOld, id);
        videoPlayerView.init()
                .setTitle(title)
//                .setSkipTip(1000 * 60 * 1)//跳转提示，这个跳到上次看的时间；
                .enableOrientation()//重力
                .setVideoPath(url)
                .setMediaQuality(IjkPlayerView.DRAWING_CACHE_QUALITY_HIGH)
                .start();

    }

    @Override
    protected void onResume() {
        super.onResume();
        videoPlayerView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoPlayerView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoPlayerView.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        videoPlayerView.configurationChanged(newConfig);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (videoPlayerView.handleVolumeKey(keyCode)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if (videoPlayerView.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public VideoPresenter getBasePresenter() {
        return new VideoPresenter();
    }


    @Override
    public void showVideoListData(VideoListBean<VideoListItemBean> videoPlayItemBeanVideoListBean) {
        Log.e(TAG, "showVideoListData: " + videoPlayItemBeanVideoListBean.itemList.get(1).data.description);
        initRecyclerView(videoPlayItemBeanVideoListBean);
    }

    private void initRecyclerView(VideoListBean<VideoListItemBean> videoPlayItemBeanVideoListBean) {
        List<VideoListItemBean> itemList = videoPlayItemBeanVideoListBean.itemList;

        //布局呈现
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        videoRecyPlay.setLayoutManager(linearLayoutManager);
        //adapter
        RecyVideoAcAdapter recyVideoAcAdapter = new RecyVideoAcAdapter(itemList, VideoActivity.this, R.layout.item_clidfragment_videosmallcard);
        recyVideoAcAdapter.setMultiTypeSupport(new BaseRecyclerViewAdapter.MultiTypeSupport<VideoListItemBean>() {
            @Override
            public int getLayoutId(VideoListItemBean item) {
                String type = item.type;
                if (type.equals("videoSmallCard")) {
                    return R.layout.item_clidfragment_videosmallcard;
                }
                return R.layout.item_clidfragment_header5;

            }
        });
        recyVideoAcAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener<VideoListItemBean>() {
            @Override
            public void onItemClick(int position, List<VideoListItemBean> mList) {
                Intent intent = new Intent(VideoActivity.this, VideoActivity.class);
                VideoListItemBean videoListItemBean = mList.get(position);
                Bundle bundle = new Bundle();
                int id = mList.get(position).data.id;
                bundle.putInt("id", id);
                String title = mList.get(position).data.title;
                bundle.putString("title", title);
                String type = mList.get(position).type;
                bundle.putString("type", type);
                intent.putExtra("Bundle", bundle);
                startActivity(intent);
            }
        });

        //设置适配器
        videoRecyPlay.setAdapter(recyVideoAcAdapter);


        View footerView = LayoutInflater.from(this).inflate(R.layout.item_video_footer, videoRecyPlay, false);

        videoRecyPlay.addFooterView(footerView);

        videoRecyPlay.addItemDecoration(new MainClidItemDecoration(VideoActivity.this, R.drawable.itemdecoration));


    }

    private void initHeaderView(HashMap<String, Object> hashMap, View headerView) {
        //把数据设置上去
        TextView tvTitle=getViewAtId(headerView, R.id.header_content_title);
        tvTitle.setText((String)hashMap.get("title"));
        TextView tvTag=getViewAtId(headerView, R.id.header_content_tag);
        tvTag.setText((String)hashMap.get("category"));
        TextView tvCon=getViewAtId(headerView, R.id.header_content_con);
        tvCon.setText((String)hashMap.get("description"));
       // content_zan
        TextView tvZan=getViewAtId(headerView, R.id.content_zan);
        tvZan.setText(hashMap.get("collectionCount")+"");
        TextView tvShare=getViewAtId(headerView, R.id.content_share);
        tvShare.setText(hashMap.get("shareCount")+"");
        TextView tvMessage=getViewAtId(headerView, R.id.content_message);
        tvMessage.setText(hashMap.get("replyCount")+"");
        //tag_img_01
        ImageView img01=getViewAtId(headerView,R.id.tag_img_01);
        Glide.with(this).load((String)hashMap.get("headerImage"+0)).into(img01);
        ImageView img02=getViewAtId(headerView,R.id.tag_img_02);
        Glide.with(this).load((String)hashMap.get("headerImage"+1)).into(img02);
        ImageView img03=getViewAtId(headerView,R.id.tag_img_03);
        Glide.with(this).load((String)hashMap.get("headerImage"+2)).into(img03);
        //cirimg_video_icon
        ImageView imgIcon=getViewAtId(headerView,R.id.cirimg_video_icon);
        Glide.with(this).load((String)hashMap.get("icon")).into(imgIcon);
        TextView tvAuthor=getViewAtId(headerView, R.id.foot_author);
        tvAuthor.setText((String)hashMap.get("name"));
        //authordescription
        TextView tvAuthorDescription=getViewAtId(headerView, R.id.foot_subTitle);
        tvAuthorDescription.setText((String)hashMap.get("authordescription"));





    }

    /**
     * 通过id得到view
     * @param viewId
     * @param <V>
     * @return
     */
    public <V extends View>V getViewAtId(View headerView,int viewId){
        View view=null;
        if(view==null){
            view=headerView.findViewById(viewId);
        }
        return (V)view;
    }

    @Override
    public void finish() {
        super.finish();
//        AppManager.getInstance().finishActivity();
    }
}
