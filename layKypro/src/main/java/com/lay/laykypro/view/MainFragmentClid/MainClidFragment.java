package com.lay.laykypro.view.MainFragmentClid;


import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lay.laykypro.R;
import com.lay.laykypro.adapter.ClidFragment.BaseRecyclerViewAdapter;
import com.lay.laykypro.adapter.ClidFragment.MainClidItemDecoration;
import com.lay.laykypro.adapter.ClidFragment.MainClidRecyclerViewAdapter;
import com.lay.laykypro.adapter.ClidFragment.WrapRecyclerAdapter;
import com.lay.laykypro.adapter.ClidFragment.WrapRecyclerView;
import com.lay.laykypro.adapter.SuperEasyRefreshLayout;
import com.lay.laykypro.base.BaseFragment;
import com.lay.laykypro.base.BaseView;
import com.lay.laykypro.presenter.MainClidPresenter;
import com.lay.laykypro.sql.WatchRecordSqliteHelper;
import com.lay.laykypro.view.Activity.VideoActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainClidFragment extends BaseFragment<BaseView, MainClidPresenter> implements MainClidFrag {
    private static final String TAG = "MainClidFragment";
    @BindView(R.id.swipe_refresh_clidfragment)
    SuperEasyRefreshLayout swipeRefreshClidfragment;
    @BindView(R.id.recy_clidfragment)
    WrapRecyclerView recyClidfragment;

    private Unbinder unbinder;
    private MainClidRecyclerViewAdapter mainClidRecyclerViewAdapter;
    private int page = 1;//推荐页
    private int count = 0;//主页 其他页也可以如此判断。
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clid_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    /**
     * 第一次进入
     */
    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        Bundle clidBundle = getArguments();
        Integer num = (Integer) clidBundle.get("Num");
        //根据传递过来的数据来决定不同的数据请求；下面的switch之后会放到懒加载的数据请求的部分去。
        getListDataFromNum(num);
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        super.onFragmentVisibleChange(isVisible);
        if (isVisible) {
            //从不可见到可见
            //对话框显示
            progressDialog = ProgressDialog.show(getActivity(), "资源加载中", "正在加载，请稍后...", false, true);
        } else {
            //从可见到不可见
            //对话框隐藏
            progressDialog.dismiss();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public MainClidPresenter getBasePresenter() {
        return new MainClidPresenter();
    }

    @Override
    public void showClidListData(String jsonString) {
        //在这里解决拿到的数据
        //将数据解析到集合中去
        try {
            List<HashMap<String, Object>> mainClidArrayList = getListFromJsonString(jsonString);
            initView(mainClidArrayList);
//            initGridView(mainClidArrayList);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void showMainClidAddListData(String jsonString) {
        //在这里处理上拉加载的数据
        try {
            List<HashMap<String, Object>> listAddFromJsonString = getListFromJsonString(jsonString);
            mainClidRecyclerViewAdapter.loadMoreData(listAddFromJsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void disProgressDialog() {
        progressDialog.dismiss();
    }

    private List<HashMap<String, Object>> getListFromJsonString(String jsonString) throws JSONException {
        List<HashMap<String, Object>> mainClidList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray itemList = jsonObject.getJSONArray("itemList");
        for (int i = 0; i < itemList.length(); i++) {
            HashMap<String, Object> mainClidItemData = new HashMap<>();
            JSONObject itemObject = itemList.optJSONObject(i);
            String type =itemObject.optString("type");
            JSONObject dataObject = itemObject.optJSONObject("data");
            //情况一：horizontalScrollCard 图片必须是个数组，重新写。
            if (type.equals("horizontalScrollCard")) {
                //banner的图片数目、类型、图片
                mainClidItemData.put("count", dataObject.optInt("count"));
                mainClidItemData.put("type", type);
                JSONArray itemListInter = dataObject.optJSONArray("itemList");
                for (int j = 0; j < itemListInter.length(); j++) {
                    JSONObject bannerItem = itemListInter.optJSONObject(j);
                    JSONObject data = bannerItem.optJSONObject("data");
                    mainClidItemData.put("image" + j, data.optString("image"));
                }

            }
            //情况二：textCard
            if (type.equals("textCard")) {
                if (dataObject.optString("type").equals("header5")) {
                    //将内容设置一下
                    mainClidItemData.put("text", dataObject.optString("text"));
                    mainClidItemData.put("type", dataObject.optString("type"));
                }
                //情况四：textCard  footer2
                if (dataObject.optString("type").equals("footer2")) {
                    //将内容设置
                    mainClidItemData.put("text", dataObject.optString("text"));
                    mainClidItemData.put("type", dataObject.optString("type"));
                }
            }
            //情况三：briefCard
            if (type.equals("briefCard")) {
                //将icon、title、description装进去
                mainClidItemData.put("icon", dataObject.optString("icon"));
                mainClidItemData.put("title", dataObject.optString("title"));
                mainClidItemData.put("description", dataObject.optString("description"));
                mainClidItemData.put("type", type);

            }
            //情况五：暂时先解析到这一步，验证一下；followCard
            if (type.equals("followCard")) {
                //icon、title、description、homepage、
                mainClidItemData.put("type", type);

                JSONObject header = dataObject.optJSONObject("header");
                mainClidItemData.put("title", header.optString("title"));
                mainClidItemData.put("category", header.optString("description"));
                mainClidItemData.put("icon", header.optString("icon"));

                JSONObject content = dataObject.optJSONObject("content");
                JSONObject dataObjectCon = content.optJSONObject("data");
                mainClidItemData.put("id", dataObjectCon.optInt("id"));
                mainClidItemData.put("title", dataObjectCon.optString("title"));

                JSONObject cover = dataObjectCon.optJSONObject("cover");
                mainClidItemData.put("homepage", cover.optString("feed"));
                //header
                JSONObject author = dataObjectCon.optJSONObject("author");
                mainClidItemData.put("authordescription", author.optString("description"));
                mainClidItemData.put("icon", author.optString("icon"));
                mainClidItemData.put("name", author.optString("name"));
                mainClidItemData.put("concategory", dataObjectCon.optString("category"));
                mainClidItemData.put("condescription", dataObjectCon.optString("description"));
                mainClidItemData.put("contitle", dataObjectCon.optString("title"));
                JSONArray tags = dataObjectCon.optJSONArray("tags");
                mainClidItemData.put("tagsSize", tags.length());
                for (int j = 0; j < tags.length(); j++) {
                    JSONObject tagsJsonObject = tags.optJSONObject(j);
                    mainClidItemData.put("headerImage" + j, tagsJsonObject.optString("headerImage"));
                }
                JSONObject consumption = dataObjectCon.optJSONObject("consumption");
                mainClidItemData.put("collectionCount", consumption.optString("collectionCount"));
                mainClidItemData.put("replyCount", consumption.optString("replyCount"));
                mainClidItemData.put("shareCount", consumption.optString("shareCount"));
            }
            //情况六：videoSmallCard
            if (type.equals("videoSmallCard")) {
                //三个
                mainClidItemData.put("category", dataObject.optString("category"));
                mainClidItemData.put("title", dataObject.optString("title"));
                mainClidItemData.put("id", dataObject.optInt("id"));
                mainClidItemData.put("title", dataObject.optString("title"));
                JSONObject cover = dataObject.optJSONObject("cover");
                mainClidItemData.put("homepage", cover.optString("feed"));
                mainClidItemData.put("type", type);
                //header
                JSONObject author = dataObject.optJSONObject("author");
                mainClidItemData.put("authordescription", author.optString("description"));
                mainClidItemData.put("icon", author.optString("icon"));
                mainClidItemData.put("name", author.optString("name"));
                mainClidItemData.put("concategory", dataObject.optString("category"));
                mainClidItemData.put("condescription", dataObject.optString("description"));
                mainClidItemData.put("contitle", dataObject.optString("title"));
                JSONArray tags = dataObject.optJSONArray("tags");
                mainClidItemData.put("tagsSize", tags.length());
                for (int j = 0; j < tags.length(); j++) {
                    JSONObject tagsJsonObject = tags.optJSONObject(j);
                    mainClidItemData.put("headerImage" + j, tagsJsonObject.optString("headerImage"));
                }
                JSONObject consumption = dataObject.optJSONObject("consumption");
                mainClidItemData.put("collectionCount", consumption.optString("collectionCount"));
                mainClidItemData.put("replyCount", consumption.optString("replyCount"));
                mainClidItemData.put("shareCount", consumption.optString("shareCount"));

            }
            //情况七+十三
            if (type.equals("squareCardCollection")) {
                //title、count、itemList
                JSONObject header = dataObject.optJSONObject("header");
                mainClidItemData.put("title", header.optString("title"));
                mainClidItemData.put("count", dataObject.optInt("count"));
                JSONArray itemDataList = dataObject.optJSONArray("itemList");
                for (int j = 0; j < itemDataList.length(); j++) {
                    //image
                    JSONObject itembanner = itemDataList.optJSONObject(j);
                    JSONObject data = itembanner.optJSONObject("data");
                    //情况十三：squareCardCollection之下的ItemCollection之下的banner
                    if (itembanner.optString("type").equals("banner")) {
                        mainClidItemData.put("image" + j, data.optString("image"));
                        if (j == 0) {
                            mainClidItemData.put("type", "squareCardCollectionbanner");
                        }

                    }
                    //情况七： 带标题的轮播图  squareCardCollection之下的ItemCollection之下的follow
                    if (itembanner.optString("type").equals("followCard")) {
                        JSONObject headerObject = data.optJSONObject("header");
                        mainClidItemData.put("icon" + j, headerObject.optString("icon"));
                        mainClidItemData.put("headertitle" + j, headerObject.optString("title"));
                        mainClidItemData.put("description" + j, headerObject.optString("description"));

                        JSONObject content = data.optJSONObject("content");
                        JSONObject dataObjectInter = content.optJSONObject("data");
                        mainClidItemData.put("id" + j, dataObjectInter.optInt("id"));
                        mainClidItemData.put("slogan" + j, dataObjectInter.optString("slogan"));
                        mainClidItemData.put("title" + j, dataObjectInter.optString("title"));
                        JSONObject cover = dataObjectInter.optJSONObject("cover");

                        mainClidItemData.put("feed" + j, cover.optString("feed"));
                        if (j == 0) {
                            mainClidItemData.put("type", "squareCardCollectionfollowCard");
                        }

                    }


                }

            }
            //情况八：videoCollectionWithBrief
            if (type.equals("videoCollectionWithBrief")) {
                //count、icon、title、description、itemList
                mainClidItemData.put("count", dataObject.optInt("count"));
                JSONObject header = dataObject.optJSONObject("header");
                mainClidItemData.put("icon", header.optString("icon"));
                mainClidItemData.put("title", header.optString("title"));
                mainClidItemData.put("description", header.optString("description"));
                JSONArray itemDataList = dataObject.optJSONArray("itemList");
                for (int j = 0; j < itemDataList.length(); j++) {
                    //category、title、feed
                    JSONObject itembanner = itemDataList.optJSONObject(j);
                    JSONObject data = itembanner.optJSONObject("data");
                    mainClidItemData.put("id" + j, data.optInt("id"));
                    mainClidItemData.put("description" + j, data.optString("description"));
                    mainClidItemData.put("category" + j, data.optString("category"));
                    mainClidItemData.put("title" + j, data.optString("title"));
                    JSONObject cover = data.optJSONObject("cover");
                    mainClidItemData.put("feed" + j, cover.optString("feed"));
                }
                mainClidItemData.put("type", type);
            }
            //情况九：图片广告 banner3
            if (type.equals("banner3")) {
                //icon、title、description、image、card
                JSONObject header = dataObject.optJSONObject("header");
                JSONObject label = dataObject.optJSONObject("label");

                mainClidItemData.put("icon", header.optString("icon"));
                mainClidItemData.put("title", header.optString("title"));
                mainClidItemData.put("description", header.optString("description"));
                mainClidItemData.put("image", dataObject.optString("image"));
                mainClidItemData.put("card", label.optString("card"));

                mainClidItemData.put("type", type);
            }
            //情况十：DynamicInfoCard之下的reply
            if (type.equals("DynamicInfoCard")) {
                //icon、name、de、image、title、category、zan、Data、
                //playUrl
                if (dataObject.optString("dynamicType").equals("reply")) {
                    mainClidItemData.put("createDate", dataObject.optString("createDate"));
                    mainClidItemData.put("type", type);

                    JSONObject replyObject = dataObject.optJSONObject("reply");
                    mainClidItemData.put("likeCount", replyObject.optString("likeCount"));

                    JSONObject simpleVideo = dataObject.optJSONObject("simpleVideo");
                    mainClidItemData.put("category", simpleVideo.optString("category"));
                    mainClidItemData.put("title", simpleVideo.optString("title"));
                    mainClidItemData.put("id", simpleVideo.optInt("id"));
                    mainClidItemData.put("description", simpleVideo.optString("description"));

                    JSONObject cover = simpleVideo.optJSONObject("cover");
                    mainClidItemData.put("homepage", cover.optString("feed"));

                    JSONObject user = dataObject.optJSONObject("user");
                    mainClidItemData.put("nickname", user.optString("nickname"));
                    mainClidItemData.put("cover", user.optString("avatar"));
                    //P
                    mainClidItemData.put("playUrl", simpleVideo.optString("playUrl"));

                }

            }
            //情况十一:autoPlayFollowCard 之下的FollowCard
            if (type.equals("autoPlayFollowCard")) {
                if (dataObject.optString("dataType").equals("FollowCard")) {
                    //UI就是一个条目视频播放的UI
                    mainClidItemData.put("type", type);
                    //playUrl、id、title、type、homepage
                    JSONObject content = dataObject.optJSONObject("content");
                    JSONObject data = content.optJSONObject("data");
                    mainClidItemData.put("id", data.optString("id"));
                    mainClidItemData.put("playUrl", data.optString("playUrl"));
                    mainClidItemData.put("title", data.optString("description"));
                    JSONObject cover = data.optJSONObject("cover");
                    mainClidItemData.put("homepage", cover.optString("feed"));
                }

            }
            //情况十二:banner
            if (type.equals("banner")) {
                //图片
                mainClidItemData.put("image", dataObject.optString("image"));
                mainClidItemData.put("type", type);
            }
            //十三 autoPlayVideoAd
            if (type.equals("autoPlayVideoAd")) {
                JSONObject detail = dataObject.optJSONObject("detail");
                mainClidItemData.put("title", detail.optString("title"));
                mainClidItemData.put("icon", detail.optString("icon"));
                mainClidItemData.put("description", detail.optString("description"));
                mainClidItemData.put("imageUrl", detail.optString("imageUrl"));

                mainClidItemData.put("url", detail.optString("url"));
                mainClidItemData.put("type", type);
            }
            //十四 communityBanner
            if(type.equals("communityBanner")){
                //type、image
                mainClidItemData.put("image",dataObject.optString("image"));
                mainClidItemData.put("type",type);
            }
            //将每一条数据加载进去；
            mainClidList.add(mainClidItemData);
        }
        return mainClidList;
    }

    /**
     * 初始化RecyclerView之ListView
     */
    private void initView(List<HashMap<String, Object>> mainListData) {
        //设置显示方法
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyClidfragment.setLayoutManager(linearLayoutManager);

        //设置Adapter
        mainClidRecyclerViewAdapter = new MainClidRecyclerViewAdapter(mainListData, getActivity(), R.layout.item_recyclerview_clidfragment);
        mainClidRecyclerViewAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener<HashMap<String, Object>>() {
            @Override
            public void onItemClick(int position, List<HashMap<String, Object>> mList) {
                HashMap<String, Object> hashMap = mList.get(position);
                String type = (String) hashMap.get("type");
                if (type.equals("followCard") || type.equals("videoSmallCard") || type.equals("DynamicInfoCard")) {

                    Intent intent = new Intent(getActivity(), VideoActivity.class);
                    Bundle bundle = new Bundle();
                    Integer id = (Integer) hashMap.get("id");
                    String title = (String) hashMap.get("title");
                    bundle.putInt("id", id);
                    bundle.putString("type", type);
                    bundle.putString("title", title);
                    intent.putExtra("Bundle", bundle);
                    //视频的历史记录功能的实现
                    String category = (String) hashMap.get("category");
                    String imgurl = (String) hashMap.get("homepage");
                    initWatchRecord(id, title, type, category, imgurl);
                    startActivity(intent);
                }

            }
        });
        mainClidRecyclerViewAdapter.setMultiTypeSupport(new BaseRecyclerViewAdapter.MultiTypeSupport<HashMap<String, Object>>() {
            @Override
            public int getLayoutId(HashMap<String, Object> item) {
                String type = (String) item.get("type");
                Log.e(TAG, "getLayoutId: " + type);
                if (type.equals("horizontalScrollCard")) {
                    return R.layout.item_clidfragment_horizontalscroll;
                } else if (type.equals("header5")) {
                    return R.layout.item_clidfragment_header5;
                } else if (type.equals("footer2")) {
                    return R.layout.item_clidfragment_footer2;
                } else if (type.equals("briefCard")) {
                    return R.layout.item_clidfragment_briefcard;
                } else if (type.equals("banner3")) {
                    return R.layout.item_clidfragment_banner3;
                } else if (type.equals("followCard")) {
                    return R.layout.item_clidfragment_followcard;
                } else if (type.equals("videoSmallCard")) {
                    return R.layout.item_clidfragment_videosmallcard;
                } else if (type.equals("squareCardCollectionbanner")) {
                    return R.layout.item_clidfragment_squarecardcollect;
                } else if (type.equals("videoCollectionWithBrief")) {
                    return R.layout.item_clidfragment_videocollectionwibf;
                } else if (type.equals("banner")) {
                    return R.layout.item_clidfragment_banner;
                } else if (type.equals("autoPlayFollowCard")) {
                    return R.layout.item_clidfragment_autoplayfollowcard;
                } else if (type.equals("squareCardCollectionfollowCard")) {
                    return R.layout.item_clidfragment_sqfollow;
                } else if (type.equals("autoPlayVideoAd")) {
                    return R.layout.item_clidfragment_autoplayvideoad;
                } else if (type.equals("DynamicInfoCard")) {
                    return R.layout.item_clidfragment_dynamicinfocard;
                } else if(type.equals("communityBanner")){
                    return R.layout.item_clidfragment_banner;
                }
                return R.layout.item_recyclerview_clidfragment;
            }
        });
        WrapRecyclerAdapter wrapRecyclerAdapter = new WrapRecyclerAdapter(mainClidRecyclerViewAdapter);
        recyClidfragment.setAdapter(wrapRecyclerAdapter);

//        View footerView = LayoutInflater.from(getActivity()).inflate(R.layout.item_video_footer, recyClidfragment, false);
//        recyClidfragment.addFooterView(footerView);
        //设置分割线
        recyClidfragment.addItemDecoration(new MainClidItemDecoration(getActivity(), R.drawable.itemdecoration));

        initRefrshLoad();


    }

    //插入当前这一条记录
    //暂时的bug:对于重复插入的数据还没有解决；
    private void initWatchRecord(int id, String title, String type, String category, String imgurl) {
        //存入数据
        WatchRecordSqliteHelper watchRecordSqliteHelper = new WatchRecordSqliteHelper(getActivity());
        SQLiteDatabase watchDb = watchRecordSqliteHelper.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("oldid", id);
        contentValues.put("title", title);
        contentValues.put("type", type);
        contentValues.put("category", category);
        contentValues.put("imgurl", imgurl);

        watchDb.insert("watchrecord", null, contentValues);


    }

    private void initRefrshLoad() {
        //实现下拉刷新和上拉加载
        //下拉刷新
        swipeRefreshClidfragment.setOnRefreshListener(new SuperEasyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshClidfragment.setRefreshing(false);
                        Bundle clidBundle = getArguments();
                        Integer num = (Integer) clidBundle.get("Num");
                        getListDataFromNum(num);
                    }
                }, 2000);

            }
        });
        //上拉加载
        swipeRefreshClidfragment.setOnLoadMoreListener(new SuperEasyRefreshLayout.OnLoadMoreListener() {
            @Override
            public void onLoad() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshClidfragment.finishLoadMore();
                        //在这里请求数据
                        Bundle clidBundle = getArguments();
                        Integer num = (Integer) clidBundle.get("Num");
                        getListAddDataFromNum(num, page, count);
                        if (num == 0) {
                            count += 1;
                        }
                        if (num == 1) {
                            page += 1;
                        }


                    }
                }, 2000);
            }
        });
    }

    private void getListAddDataFromNum(int num, int page, int count) {
        switch (num) {
            case 0:
                //发现
//                basePresenter.getMainClidAddDyListData("discovery",start);//因为接口变了，所以改一下
                if (count > 0) {
                    Toast.makeText(getActivity(), "已经到底了！" + num, Toast.LENGTH_SHORT).show();
                } else {
                    View footerView = LayoutInflater.from(getActivity()).inflate(R.layout.item_video_footer, recyClidfragment, false);
                    recyClidfragment.addFooterView(footerView);
//                    Toast.makeText(getActivity(),"已经到底了！"+num,Toast.LENGTH_SHORT).show();
                }

                break;
            case 1:
                //推荐
                //http://baobab.kaiyanapp.com/api/v5/index/tab/allRec?page=2&isTag=true&adIndex=6
                basePresenter.getMainClidAddTJListData(page);
                break;
            case 2:
                //日报
                //按照日期来拿数据
                //http://baobab.kaiyanapp.com/api/v5/index/tab/feed?date=1539046800000&num=2
                Toast.makeText(getActivity(), "已经到底了！" + num, Toast.LENGTH_SHORT).show();
                break;
            case 3:
                //创意 category/2  出现了403错误
                //猜测一：服务器端可以判断是不是合法的访问方式
                Toast.makeText(getActivity(), "已经到底了！" + num, Toast.LENGTH_SHORT).show();
                break;
            case 4:
                //音乐
//                basePresenter.getClidListData("category", "20");
                Toast.makeText(getActivity(), "已经到底了！" + num, Toast.LENGTH_SHORT).show();
                break;
            case 5:
                //旅行
//                basePresenter.getClidListData("category", "6");
                Toast.makeText(getActivity(), "已经到底了！" + num, Toast.LENGTH_SHORT).show();
                break;
            case 6:
                //科普
//                basePresenter.getClidListData("category", "32");
                Toast.makeText(getActivity(), "已经到底了！" + num, Toast.LENGTH_SHORT).show();
                break;
            case 7:
                //搞笑
//                basePresenter.getClidListData("category", "28");
                Toast.makeText(getActivity(), "已经到底了！" + num, Toast.LENGTH_SHORT).show();
                break;
            case 8:
                //时尚
//                basePresenter.getClidListData("category", "24");
                Toast.makeText(getActivity(), "已经到底了！" + num, Toast.LENGTH_SHORT).show();
                break;
        }

    }

    public void getListDataFromNum(int num) {
        switch (num) {
            case 0:
                //发现
                basePresenter.getListData("discovery");
                break;
            case 1:
                //推荐
                basePresenter.getListData("allRec");
                break;
            case 2:
                //创意
                basePresenter.getClidListData("category", "2");
                break;
            case 3:
                //音乐
                basePresenter.getClidListData("category", "20");
                break;
            case 4:
                //旅行
                basePresenter.getClidListData("category", "6");
                break;
            case 5:
                //科普
                basePresenter.getClidListData("category", "32");
                break;
            case 6:
                //搞笑
                basePresenter.getClidListData("category", "28");
                break;
            case 7:
                //时尚
                basePresenter.getClidListData("category", "24");
                break;

        }

    }


}
