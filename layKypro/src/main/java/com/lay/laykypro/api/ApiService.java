package com.lay.laykypro.api;

import com.lay.laykypro.bean.FocusClidWorksBean;
import com.lay.laykypro.bean.MainNoBean;
import com.lay.laykypro.bean.VideoListBean;
import com.lay.laykypro.bean.play.FocusworksItemPlayDataBean;
import com.lay.laykypro.bean.play.VideoListItemBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    //Main页面的通知Fragment数据
    @GET("messages")
    Observable<MainNoBean> getNoData();

    //Main页面的Focus页面的WorksFragment的数据
    @GET("follow")
    Observable<FocusClidWorksBean> getWorksData(@Query("udid") String udid,
                                                @Query("vc") int vc, @Query("vn") String vn,
                                                @Query("deviceModel") String deviceModel,
                                                @Query("first_channel") String first_channel,
                                                @Query("last_channel") String last_channel,
                                                @Query("system_version_code") int system_version_code);


    @GET("follow")
    Observable<FocusClidWorksBean<FocusworksItemPlayDataBean>> getItemsPlayData(@Query("udid") String udid,
                                                                                @Query("vc") int vc, @Query("vn") String vn,
                                                                                @Query("deviceModel") String deviceModel,
                                                                                @Query("first_channel") String first_channel,
                                                                                @Query("last_channel") String last_channel,
                                                                                @Query("system_version_code") int system_version_code);

    //Main的Clid页面
    //Clid的Json数据字符串 discovery
    //例：发现discovery页面：http://baobab.kaiyanapp.com/api/v5/index/tab/discovery?udid=bd4602def0ed4576b145297b0bc8dc6c6b414e3b&vc=256&vn=3.14&deviceModel=BLN-AL40&first_channel=eyepetizer_zhihuiyun_market&last_channel=eyepetizer_zhihuiyun_market&system_version_code=24
   //第一种情况
    @GET("{path}")
    Observable<String> getListData(@Path("path") String path,@Query("udid") String udid,
                                   @Query("vc") int vc, @Query("vn") String vn,
                                   @Query("deviceModel") String deviceModel,
                                   @Query("first_channel") String first_channel,
                                   @Query("last_channel") String last_channel,
                                   @Query("system_version_code") int system_version_code);

    //第二种情况
    @GET("{root}/{path}")
    Observable<String> getClidListData(@Path("root") String root,@Path("path") String path,@Query("udid") String udid,
                                       @Query("vc") int vc, @Query("vn") String vn,
                                       @Query("deviceModel") String deviceModel,
                                       @Query("first_channel") String first_channel,
                                       @Query("last_channel") String last_channel,
                                       @Query("system_version_code") int system_version_code);

    //http://baobab.kaiyanapp.com/api/v4/video/related?id=121825&udid=bd4602def0ed4576b145297b0bc8dc6c6b414e3b&vc=381&vn=4.3&deviceModel=BLN-AL40&first_channel=eyepetizer_zhihuiyun_market&last_channel=eyepetizer_zhihuiyun_market&system_version_code=24";
   //VideoActivity的RecyclerView列表数据
    @GET("related")
    Observable<VideoListBean<VideoListItemBean>> getVideoPlayListData(@Query("id") int id, @Query("udid") String udid,
                                                                      @Query("vc") int vc, @Query("vn") String vn,
                                                                      @Query("deviceModel") String deviceModel,
                                                                      @Query("first_channel") String first_channel,
                                                                      @Query("last_channel") String last_channel,
                                                                      @Query("system_version_code") int system_version_code);

    //http://baobab.kaiyanapp.com/api/v5/index/tab/discovery?start=0&num=5 发现 不能用了这个撤销。
    @GET("{path}")
    Observable<String> getMainClidAddDyListData(@Path("path")String path, @Query("start") int start, @Query("num") int num);

    //创意 http://baobab.kaiyanapp.com/api/v5/index/tab/category/2?start=5&num=5
    @GET("{root}/{path}")
    Observable<String> getMainClidAddCyListData(@Path("root") String root, @Path("path") String path, @Query("start") int start, @Query("num") int num);


    //推荐：http://baobab.kaiyanapp.com/api/v5/index/tab/allRec?page=2&isTag=true&adIndex=6
    @GET("allRec")
    Observable<String> getMainClidAddTJListData(@Query("page") int page, @Query("isTag") boolean isTag, @Query("adIndex") int adIndex);


}
