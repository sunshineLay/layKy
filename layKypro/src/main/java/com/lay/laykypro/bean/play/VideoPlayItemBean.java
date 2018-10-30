package com.lay.laykypro.bean.play;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class VideoPlayItemBean {


    /**
     * author : {"approvedNotReadyVideoCount":0,"description":"Prepix 是一家位于韩国的著名舞蹈工作室。","follow":{"followed":false,"itemId":1432,"itemType":"author"},"icon":"http://img.kaiyanapp.com/2eb649341890c784d925903e0a390b37.jpeg?imageMogr2/quality/60/format/jpg","id":1432,"ifPgc":true,"latestReleaseTime":1534331772000,"link":"","name":"Prepix 舞蹈工作室","shield":{"itemId":1432,"itemType":"author","shielded":false},"videoNum":399}
     * category : 音乐
     * collected : false
     * consumption : {"collectionCount":18,"replyCount":0,"shareCount":12}
     * cover : {"blurred":"http://img.kaiyanapp.com/12805536d7ed3a64f519cdc7e32cdc5c.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/25745653687f912d275272943cd321f0.jpeg?imageMogr2/quality/60/format/jpg","feed":"http://img.kaiyanapp.com/25745653687f912d275272943cd321f0.jpeg?imageMogr2/quality/60/format/jpg"}
     * dataType : VideoBeanForClient
     * date : 1521481650000
     * description : RUBY 编舞「Wine」 原曲：Suran - Wine
     * descriptionEditor :
     * descriptionPgc : RUBY 编舞「Wine」 原曲：Suran - Wine
     * duration : 33
     * id : 92133
     * idx : 0
     * ifLimitVideo : false
     * labelList : []
     * library : DEFAULT
     * playInfo : [{"height":270,"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=low&source=aliyun","urlList":[{"name":"aliyun","size":1961757,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=low&source=aliyun"},{"name":"qcloud","size":1961757,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=low&source=qcloud"},{"name":"ucloud","size":1961757,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=low&source=ucloud"}],"width":480},{"height":480,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=normal&source=aliyun","urlList":[{"name":"aliyun","size":4341751,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=normal&source=aliyun"},{"name":"qcloud","size":4341751,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=normal&source=qcloud"},{"name":"ucloud","size":4341751,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=normal&source=ucloud"}],"width":854},{"height":720,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=high&source=aliyun","urlList":[{"name":"aliyun","size":7331231,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=high&source=aliyun"},{"name":"qcloud","size":7331231,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=high&source=qcloud"},{"name":"ucloud","size":7331231,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=high&source=ucloud"}],"width":1280}]
     * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=default&source=aliyun
     * played : false
     * provider : {"alias":"CustomSrc","icon":"","name":"定制来源"}
     * releaseTime : 1521481650000
     * resourceType : video
     * searchWeight : 0
     * src : 11
     * subtitles : []
     * tags : [{"actionUrl":"eyepetizer://tag/18/?title=%E9%9F%B3%E4%B9%90","bgPicture":"http://img.kaiyanapp.com/cfc2ffd94f4c2234ff9f77eb99205791.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/cfc2ffd94f4c2234ff9f77eb99205791.jpeg?imageMogr2/quality/100","id":18,"name":"音乐","tagRecType":"IMPORTANT"},{"actionUrl":"eyepetizer://tag/753/?title=%E8%88%9E%E8%B9%88","bgPicture":"http://img.kaiyanapp.com/a84a0c92c2c19fc527cf376f76c944f8.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/a84a0c92c2c19fc527cf376f76c944f8.jpeg?imageMogr2/quality/60/format/jpg","id":753,"name":"舞蹈","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/46/?title=%E6%95%99%E7%A8%8B","bgPicture":"http://img.kaiyanapp.com/ca40278cd698aec9997985139ae05007.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/ca40278cd698aec9997985139ae05007.jpeg?imageMogr2/quality/60/format/jpg","id":46,"name":"教程","tagRecType":"NORMAL"}]
     * title : RUBY 编舞「Wine」
     * titlePgc : RUBY 编舞「Wine」
     * type : NORMAL
     * webUrl : {"forWeibo":"http://www.eyepetizer.net/detail.html?vid=92133","raw":"http://www.eyepetizer.net/detail.html?vid=92133"}
     */

    public AuthorBean author;
    public String category;
    public boolean collected;
    public ConsumptionBean consumption;
    public CoverBean cover;
    public String dataType;
    public long date;
    public String description;
    public String descriptionEditor;
    public String descriptionPgc;
    public int duration;
    public int id;
    public int idx;
    public boolean ifLimitVideo;
    public String library;
    public String playUrl;
    public boolean played;
    public ProviderBean provider;
    public long releaseTime;
    public String resourceType;
    public int searchWeight;
    public int src;
    public String title;
    public String titlePgc;
    public String type;
    public WebUrlBean webUrl;
    public List<?> labelList;
    public List<PlayInfoBean> playInfo;
    public List<?> subtitles;
    public List<TagsBean> tags;

    public static VideoPlayItemBean objectFromData(String str) {

        return new Gson().fromJson(str, VideoPlayItemBean.class);
    }

    public static VideoPlayItemBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), VideoPlayItemBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<VideoPlayItemBean> arrayVideoPlayItemBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<VideoPlayItemBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<VideoPlayItemBean> arrayVideoPlayItemBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<VideoPlayItemBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public static class AuthorBean {
        /**
         * approvedNotReadyVideoCount : 0
         * description : Prepix 是一家位于韩国的著名舞蹈工作室。
         * follow : {"followed":false,"itemId":1432,"itemType":"author"}
         * icon : http://img.kaiyanapp.com/2eb649341890c784d925903e0a390b37.jpeg?imageMogr2/quality/60/format/jpg
         * id : 1432
         * ifPgc : true
         * latestReleaseTime : 1534331772000
         * link :
         * name : Prepix 舞蹈工作室
         * shield : {"itemId":1432,"itemType":"author","shielded":false}
         * videoNum : 399
         */

        public int approvedNotReadyVideoCount;
        public String description;
        public FollowBean follow;
        public String icon;
        public int id;
        public boolean ifPgc;
        public long latestReleaseTime;
        public String link;
        public String name;
        public ShieldBean shield;
        public int videoNum;

        public static AuthorBean objectFromData(String str) {

            return new Gson().fromJson(str, AuthorBean.class);
        }

        public static AuthorBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), AuthorBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<AuthorBean> arrayAuthorBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<AuthorBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<AuthorBean> arrayAuthorBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<AuthorBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public static class FollowBean {
            /**
             * followed : false
             * itemId : 1432
             * itemType : author
             */

            public boolean followed;
            public int itemId;
            public String itemType;

            public static FollowBean objectFromData(String str) {

                return new Gson().fromJson(str, FollowBean.class);
            }

            public static FollowBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), FollowBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<FollowBean> arrayFollowBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<FollowBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<FollowBean> arrayFollowBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<FollowBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }
        }

        public static class ShieldBean {
            /**
             * itemId : 1432
             * itemType : author
             * shielded : false
             */

            public int itemId;
            public String itemType;
            public boolean shielded;

            public static ShieldBean objectFromData(String str) {

                return new Gson().fromJson(str, ShieldBean.class);
            }

            public static ShieldBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ShieldBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<ShieldBean> arrayShieldBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<ShieldBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<ShieldBean> arrayShieldBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<ShieldBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }
        }
    }

    public static class ConsumptionBean {
        /**
         * collectionCount : 18
         * replyCount : 0
         * shareCount : 12
         */

        public int collectionCount;
        public int replyCount;
        public int shareCount;

        public static ConsumptionBean objectFromData(String str) {

            return new Gson().fromJson(str, ConsumptionBean.class);
        }

        public static ConsumptionBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ConsumptionBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<ConsumptionBean> arrayConsumptionBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ConsumptionBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ConsumptionBean> arrayConsumptionBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ConsumptionBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }
    }

    public static class CoverBean {
        /**
         * blurred : http://img.kaiyanapp.com/12805536d7ed3a64f519cdc7e32cdc5c.jpeg?imageMogr2/quality/60/format/jpg
         * detail : http://img.kaiyanapp.com/25745653687f912d275272943cd321f0.jpeg?imageMogr2/quality/60/format/jpg
         * feed : http://img.kaiyanapp.com/25745653687f912d275272943cd321f0.jpeg?imageMogr2/quality/60/format/jpg
         */

        public String blurred;
        public String detail;
        public String feed;

        public static CoverBean objectFromData(String str) {

            return new Gson().fromJson(str, CoverBean.class);
        }

        public static CoverBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), CoverBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<CoverBean> arrayCoverBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<CoverBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<CoverBean> arrayCoverBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<CoverBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }
    }

    public static class ProviderBean {
        /**
         * alias : CustomSrc
         * icon :
         * name : 定制来源
         */

        public String alias;
        public String icon;
        public String name;

        public static ProviderBean objectFromData(String str) {

            return new Gson().fromJson(str, ProviderBean.class);
        }

        public static ProviderBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ProviderBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<ProviderBean> arrayProviderBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ProviderBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ProviderBean> arrayProviderBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ProviderBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }
    }

    public static class WebUrlBean {
        /**
         * forWeibo : http://www.eyepetizer.net/detail.html?vid=92133
         * raw : http://www.eyepetizer.net/detail.html?vid=92133
         */

        public String forWeibo;
        public String raw;

        public static WebUrlBean objectFromData(String str) {

            return new Gson().fromJson(str, WebUrlBean.class);
        }

        public static WebUrlBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), WebUrlBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<WebUrlBean> arrayWebUrlBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<WebUrlBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<WebUrlBean> arrayWebUrlBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<WebUrlBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }
    }

    public static class PlayInfoBean {
        /**
         * height : 270
         * name : 流畅
         * type : low
         * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=low&source=aliyun
         * urlList : [{"name":"aliyun","size":1961757,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=low&source=aliyun"},{"name":"qcloud","size":1961757,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=low&source=qcloud"},{"name":"ucloud","size":1961757,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=low&source=ucloud"}]
         * width : 480
         */

        public int height;
        public String name;
        public String type;
        public String url;
        public int width;
        public List<UrlListBean> urlList;

        public static PlayInfoBean objectFromData(String str) {

            return new Gson().fromJson(str, PlayInfoBean.class);
        }

        public static PlayInfoBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), PlayInfoBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<PlayInfoBean> arrayPlayInfoBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<PlayInfoBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<PlayInfoBean> arrayPlayInfoBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<PlayInfoBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public static class UrlListBean {
            /**
             * name : aliyun
             * size : 1961757
             * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=92133&resourceType=video&editionType=low&source=aliyun
             */

            public String name;
            public int size;
            public String url;

            public static UrlListBean objectFromData(String str) {

                return new Gson().fromJson(str, UrlListBean.class);
            }

            public static UrlListBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), UrlListBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<UrlListBean> arrayUrlListBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<UrlListBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<UrlListBean> arrayUrlListBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<UrlListBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }
        }
    }

    public static class TagsBean {
        /**
         * actionUrl : eyepetizer://tag/18/?title=%E9%9F%B3%E4%B9%90
         * bgPicture : http://img.kaiyanapp.com/cfc2ffd94f4c2234ff9f77eb99205791.jpeg?imageMogr2/quality/100
         * headerImage : http://img.kaiyanapp.com/cfc2ffd94f4c2234ff9f77eb99205791.jpeg?imageMogr2/quality/100
         * id : 18
         * name : 音乐
         * tagRecType : IMPORTANT
         */

        public String actionUrl;
        public String bgPicture;
        public String headerImage;
        public int id;
        public String name;
        public String tagRecType;

        public static TagsBean objectFromData(String str) {

            return new Gson().fromJson(str, TagsBean.class);
        }

        public static TagsBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), TagsBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<TagsBean> arrayTagsBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<TagsBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<TagsBean> arrayTagsBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<TagsBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }
    }
}
