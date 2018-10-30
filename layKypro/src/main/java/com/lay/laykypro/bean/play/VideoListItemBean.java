package com.lay.laykypro.bean.play;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class VideoListItemBean {

    /**
     * adIndex : -1
     * data : {"author":{"approvedNotReadyVideoCount":0,"description":"Prepix 是一家位于韩国的著名舞蹈工作室。","follow":{"followed":false,"itemId":1432,"itemType":"author"},"icon":"http://img.kaiyanapp.com/2eb649341890c784d925903e0a390b37.jpeg?imageMogr2/quality/60/format/jpg","id":1432,"ifPgc":true,"latestReleaseTime":1538756293000,"link":"","name":"Prepix 舞蹈工作室","shield":{"itemId":1432,"itemType":"author","shielded":false},"videoNum":461},"category":"音乐","collected":false,"consumption":{"collectionCount":6,"replyCount":3,"shareCount":0},"cover":{"blurred":"http://img.kaiyanapp.com/6a741925a81d749614342a00caadc2ee.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/d4607ba0ec7ab093508de9b0bd96c1f2.jpeg?imageMogr2/quality/60/format/jpg","feed":"http://img.kaiyanapp.com/d4607ba0ec7ab093508de9b0bd96c1f2.jpeg?imageMogr2/quality/60/format/jpg"},"dataType":"VideoBeanForClient","date":1537781343000,"description":"WACOON 编舞「 Big Bank」 原曲 YG - Big Bank ft. 2 Chainz, Big Sean, Nicki Minaj","descriptionEditor":"","descriptionPgc":"WACOON 编舞「 Big Bank」 原曲 YG - Big Bank ft. 2 Chainz, Big Sean, Nicki Minaj","duration":108,"id":128611,"idx":0,"ifLimitVideo":false,"labelList":[],"library":"DEFAULT","playInfo":[{"height":270,"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=low&source=aliyun","urlList":[{"name":"aliyun","size":6260913,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=low&source=aliyun"},{"name":"qcloud","size":6260913,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=low&source=qcloud"},{"name":"ucloud","size":6260913,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=low&source=ucloud"}],"width":480},{"height":480,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=normal&source=aliyun","urlList":[{"name":"aliyun","size":13702699,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=normal&source=aliyun"},{"name":"qcloud","size":13702699,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=normal&source=qcloud"},{"name":"ucloud","size":13702699,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=normal&source=ucloud"}],"width":854},{"height":720,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=high&source=aliyun","urlList":[{"name":"aliyun","size":21733593,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=high&source=aliyun"},{"name":"qcloud","size":21733593,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=high&source=qcloud"},{"name":"ucloud","size":21733593,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=high&source=ucloud"}],"width":1280}],"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=default&source=aliyun","played":false,"provider":{"alias":"CustomSrc","icon":"","name":"定制来源"},"releaseTime":1537781343000,"resourceType":"video","searchWeight":0,"src":11,"subtitles":[],"tags":[{"actionUrl":"eyepetizer://tag/18/?title=%E9%9F%B3%E4%B9%90","bgPicture":"http://img.kaiyanapp.com/cfc2ffd94f4c2234ff9f77eb99205791.jpeg?imageMogr2/quality/100","communityIndex":8,"headerImage":"http://img.kaiyanapp.com/cfc2ffd94f4c2234ff9f77eb99205791.jpeg?imageMogr2/quality/100","id":18,"name":"音乐","tagRecType":"IMPORTANT"},{"actionUrl":"eyepetizer://tag/753/?title=%E8%88%9E%E8%B9%88","bgPicture":"http://img.kaiyanapp.com/a84a0c92c2c19fc527cf376f76c944f8.jpeg?imageMogr2/quality/60/format/jpg","communityIndex":3,"headerImage":"http://img.kaiyanapp.com/a84a0c92c2c19fc527cf376f76c944f8.jpeg?imageMogr2/quality/60/format/jpg","id":753,"name":"舞蹈","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/46/?title=%E6%95%99%E7%A8%8B","bgPicture":"http://img.kaiyanapp.com/ca40278cd698aec9997985139ae05007.jpeg?imageMogr2/quality/60/format/jpg","communityIndex":0,"headerImage":"http://img.kaiyanapp.com/ca40278cd698aec9997985139ae05007.jpeg?imageMogr2/quality/60/format/jpg","id":46,"name":"教程","tagRecType":"NORMAL"}],"title":"WACOON 编舞「 Big Bank」","titlePgc":"WACOON 编舞「 Big Bank」","type":"NORMAL","webUrl":{"forWeibo":"http://www.eyepetizer.net/detail.html?vid=128611&resourceType=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0","raw":"http://www.eyepetizer.net/detail.html?vid=128611"}}
     * id : 0
     * type : videoSmallCard
     */

    public int adIndex;
    public DataBean data;
    public int id;
    public String type;

    public static VideoListItemBean objectFromData(String str) {

        return new Gson().fromJson(str, VideoListItemBean.class);
    }

    public static VideoListItemBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), VideoListItemBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<VideoListItemBean> arrayVideoListItemBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<VideoListItemBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<VideoListItemBean> arrayVideoListItemBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<VideoListItemBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public static class DataBean {
        /**
         * author : {"approvedNotReadyVideoCount":0,"description":"Prepix 是一家位于韩国的著名舞蹈工作室。","follow":{"followed":false,"itemId":1432,"itemType":"author"},"icon":"http://img.kaiyanapp.com/2eb649341890c784d925903e0a390b37.jpeg?imageMogr2/quality/60/format/jpg","id":1432,"ifPgc":true,"latestReleaseTime":1538756293000,"link":"","name":"Prepix 舞蹈工作室","shield":{"itemId":1432,"itemType":"author","shielded":false},"videoNum":461}
         * category : 音乐
         * collected : false
         * consumption : {"collectionCount":6,"replyCount":3,"shareCount":0}
         * cover : {"blurred":"http://img.kaiyanapp.com/6a741925a81d749614342a00caadc2ee.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/d4607ba0ec7ab093508de9b0bd96c1f2.jpeg?imageMogr2/quality/60/format/jpg","feed":"http://img.kaiyanapp.com/d4607ba0ec7ab093508de9b0bd96c1f2.jpeg?imageMogr2/quality/60/format/jpg"}
         * dataType : VideoBeanForClient
         * date : 1537781343000
         * description : WACOON 编舞「 Big Bank」 原曲 YG - Big Bank ft. 2 Chainz, Big Sean, Nicki Minaj
         * descriptionEditor :
         * descriptionPgc : WACOON 编舞「 Big Bank」 原曲 YG - Big Bank ft. 2 Chainz, Big Sean, Nicki Minaj
         * duration : 108
         * id : 128611
         * idx : 0
         * ifLimitVideo : false
         * labelList : []
         * library : DEFAULT
         * playInfo : [{"height":270,"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=low&source=aliyun","urlList":[{"name":"aliyun","size":6260913,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=low&source=aliyun"},{"name":"qcloud","size":6260913,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=low&source=qcloud"},{"name":"ucloud","size":6260913,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=low&source=ucloud"}],"width":480},{"height":480,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=normal&source=aliyun","urlList":[{"name":"aliyun","size":13702699,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=normal&source=aliyun"},{"name":"qcloud","size":13702699,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=normal&source=qcloud"},{"name":"ucloud","size":13702699,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=normal&source=ucloud"}],"width":854},{"height":720,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=high&source=aliyun","urlList":[{"name":"aliyun","size":21733593,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=high&source=aliyun"},{"name":"qcloud","size":21733593,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=high&source=qcloud"},{"name":"ucloud","size":21733593,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=high&source=ucloud"}],"width":1280}]
         * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=default&source=aliyun
         * played : false
         * provider : {"alias":"CustomSrc","icon":"","name":"定制来源"}
         * releaseTime : 1537781343000
         * resourceType : video
         * searchWeight : 0
         * src : 11
         * subtitles : []
         * tags : [{"actionUrl":"eyepetizer://tag/18/?title=%E9%9F%B3%E4%B9%90","bgPicture":"http://img.kaiyanapp.com/cfc2ffd94f4c2234ff9f77eb99205791.jpeg?imageMogr2/quality/100","communityIndex":8,"headerImage":"http://img.kaiyanapp.com/cfc2ffd94f4c2234ff9f77eb99205791.jpeg?imageMogr2/quality/100","id":18,"name":"音乐","tagRecType":"IMPORTANT"},{"actionUrl":"eyepetizer://tag/753/?title=%E8%88%9E%E8%B9%88","bgPicture":"http://img.kaiyanapp.com/a84a0c92c2c19fc527cf376f76c944f8.jpeg?imageMogr2/quality/60/format/jpg","communityIndex":3,"headerImage":"http://img.kaiyanapp.com/a84a0c92c2c19fc527cf376f76c944f8.jpeg?imageMogr2/quality/60/format/jpg","id":753,"name":"舞蹈","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/46/?title=%E6%95%99%E7%A8%8B","bgPicture":"http://img.kaiyanapp.com/ca40278cd698aec9997985139ae05007.jpeg?imageMogr2/quality/60/format/jpg","communityIndex":0,"headerImage":"http://img.kaiyanapp.com/ca40278cd698aec9997985139ae05007.jpeg?imageMogr2/quality/60/format/jpg","id":46,"name":"教程","tagRecType":"NORMAL"}]
         * title : WACOON 编舞「 Big Bank」
         * titlePgc : WACOON 编舞「 Big Bank」
         * type : NORMAL
         * webUrl : {"forWeibo":"http://www.eyepetizer.net/detail.html?vid=128611&resourceType=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0","raw":"http://www.eyepetizer.net/detail.html?vid=128611"}
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

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public static DataBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), DataBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<DataBean> arrayDataBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<DataBean>>() {
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
             * latestReleaseTime : 1538756293000
             * link :
             * name : Prepix 舞蹈工作室
             * shield : {"itemId":1432,"itemType":"author","shielded":false}
             * videoNum : 461
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
             * collectionCount : 6
             * replyCount : 3
             * shareCount : 0
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
             * blurred : http://img.kaiyanapp.com/6a741925a81d749614342a00caadc2ee.jpeg?imageMogr2/quality/60/format/jpg
             * detail : http://img.kaiyanapp.com/d4607ba0ec7ab093508de9b0bd96c1f2.jpeg?imageMogr2/quality/60/format/jpg
             * feed : http://img.kaiyanapp.com/d4607ba0ec7ab093508de9b0bd96c1f2.jpeg?imageMogr2/quality/60/format/jpg
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
             * forWeibo : http://www.eyepetizer.net/detail.html?vid=128611&resourceType=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0
             * raw : http://www.eyepetizer.net/detail.html?vid=128611
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
             * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=low&source=aliyun
             * urlList : [{"name":"aliyun","size":6260913,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=low&source=aliyun"},{"name":"qcloud","size":6260913,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=low&source=qcloud"},{"name":"ucloud","size":6260913,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=low&source=ucloud"}]
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
                 * size : 6260913
                 * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=128611&resourceType=video&editionType=low&source=aliyun
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
             * communityIndex : 8
             * headerImage : http://img.kaiyanapp.com/cfc2ffd94f4c2234ff9f77eb99205791.jpeg?imageMogr2/quality/100
             * id : 18
             * name : 音乐
             * tagRecType : IMPORTANT
             */

            public String actionUrl;
            public String bgPicture;
            public int communityIndex;
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
}
