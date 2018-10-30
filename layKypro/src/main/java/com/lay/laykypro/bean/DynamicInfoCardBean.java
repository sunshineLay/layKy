package com.lay.laykypro.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DynamicInfoCardBean {

    /**
     * adIndex : -1
     * data : {"actionUrl":"eyepetizer://replies/video?videoId=51707&top=1052410605559873536&videoTitle=%E5%8F%8D%E6%80%9D%E4%BA%B2%E6%83%85%E5%8A%A8%E7%94%BB%EF%BC%9A%E3%80%8C%E5%A4%B1%E5%BF%86%E3%80%8D%E7%9A%84%E7%88%B6%E4%BA%B2","createDate":1539749216000,"dataType":"DynamicReplyCard","dynamicType":"reply","merge":false,"reply":{"id":1052410605559873536,"ifHotReply":true,"likeCount":11,"liked":false,"message":"茫茫人海 一片空白，无助徘徊 我 唤你回来。_心耐如初。若有时","parentReplyId":0,"rootReplyId":1052410605559873536,"showConversationButton":false,"user":{"actionUrl":"eyepetizer://pgc/detail/46391029/?title=%E2%84%A1%E3%80%90%E6%9C%89%E6%84%8F%E6%80%9D%E3%80%91&userType=NORMAL&tabIndex=0","avatar":"http://img.kaiyanapp.com/612afa4a3d144f187297680a9d375170.jpeg?imageMogr2/quality/60/format/jpg","cover":"http://img.kaiyanapp.com/3571c3c20e89bdba03b0bbeb01166510.jpeg?imageMogr2/quality/60/format/jpg","description":"闭眼APP的单方面甲方；对，是朕没错  为了守护世界的和平，为了防止世界被破坏，贯彻爱与被爱的隐藏角色，迷人又洒脱的，就！是！我！没错了  我皮我开心，你皮我也开心，若有freestyle,请开始你的表演。朕skr~over.","followed":false,"gender":"male","ifPgc":false,"library":"BLOCK","limitVideoOpen":false,"nickname":"℡【有意思】","registDate":1392880258000,"releaseDate":1539623672000,"uid":46391029,"uploadStatus":"NORMAL","userType":"NORMAL"},"videoId":51707,"videoTitle":"反思亲情动画：「失忆」的父亲"},"simpleVideo":{"actionUrl":"eyepetizer://ugcResourceDetail?id=51707&resourceType=video","category":"动画","collected":false,"count":0,"cover":{"blurred":"http://img.kaiyanapp.com/c43cc07622d9d9bfc43a857bfc004a63.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/36b718024ee67dd814232471349aed13.jpeg?imageMogr2/quality/60/format/jpg","feed":"http://img.kaiyanapp.com/36b718024ee67dd814232471349aed13.jpeg?imageMogr2/quality/60/format/jpg","homepage":"http://img.kaiyanapp.com/36b718024ee67dd814232471349aed13.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"description":"短片讲述了一位患有阿兹海默症的父亲和他女儿的故事。用细腻的画风描绘了一个普通的早晨，记忆力衰退的父亲需要靠备忘录来提醒自己，并拒绝女儿的好心照顾，直到他独自出门后\u2026\u2026今天是重阳节，记得问候渐渐老去的他们。From GOBELINS","duration":280,"id":51707,"onlineStatus":"ONLINE","playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=51707&resourceType=video&editionType=default&source=aliyun","releaseTime":1539738000000,"resourceType":"video","title":"反思亲情动画：「失忆」的父亲","uid":0},"text":"评论:","user":{"actionUrl":"eyepetizer://pgc/detail/46391029/?title=%E2%84%A1%E3%80%90%E6%9C%89%E6%84%8F%E6%80%9D%E3%80%91&userType=NORMAL&tabIndex=0","avatar":"http://img.kaiyanapp.com/612afa4a3d144f187297680a9d375170.jpeg?imageMogr2/quality/60/format/jpg","cover":"http://img.kaiyanapp.com/3571c3c20e89bdba03b0bbeb01166510.jpeg?imageMogr2/quality/60/format/jpg","description":"闭眼APP的单方面甲方；对，是朕没错  为了守护世界的和平，为了防止世界被破坏，贯彻爱与被爱的隐藏角色，迷人又洒脱的，就！是！我！没错了  我皮我开心，你皮我也开心，若有freestyle,请开始你的表演。朕skr~over.","followed":false,"gender":"male","ifPgc":false,"library":"BLOCK","limitVideoOpen":false,"nickname":"℡【有意思】","registDate":1392880258000,"releaseDate":1539623672000,"uid":46391029,"uploadStatus":"NORMAL","userType":"NORMAL"}}
     * id : 0
     * type : DynamicInfoCard
     */

    public int adIndex;
    public DataBean data;
    public int id;
    public String type;

    public static DynamicInfoCardBean objectFromData(String str) {

        return new Gson().fromJson(str, DynamicInfoCardBean.class);
    }

    public static DynamicInfoCardBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), DynamicInfoCardBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<DynamicInfoCardBean> arrayDynamicInfoCardBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<DynamicInfoCardBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<DynamicInfoCardBean> arrayDynamicInfoCardBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<DynamicInfoCardBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public static class DataBean {
        /**
         * actionUrl : eyepetizer://replies/video?videoId=51707&top=1052410605559873536&videoTitle=%E5%8F%8D%E6%80%9D%E4%BA%B2%E6%83%85%E5%8A%A8%E7%94%BB%EF%BC%9A%E3%80%8C%E5%A4%B1%E5%BF%86%E3%80%8D%E7%9A%84%E7%88%B6%E4%BA%B2
         * createDate : 1539749216000
         * dataType : DynamicReplyCard
         * dynamicType : reply
         * merge : false
         * reply : {"id":1052410605559873536,"ifHotReply":true,"likeCount":11,"liked":false,"message":"茫茫人海 一片空白，无助徘徊 我 唤你回来。_心耐如初。若有时","parentReplyId":0,"rootReplyId":1052410605559873536,"showConversationButton":false,"user":{"actionUrl":"eyepetizer://pgc/detail/46391029/?title=%E2%84%A1%E3%80%90%E6%9C%89%E6%84%8F%E6%80%9D%E3%80%91&userType=NORMAL&tabIndex=0","avatar":"http://img.kaiyanapp.com/612afa4a3d144f187297680a9d375170.jpeg?imageMogr2/quality/60/format/jpg","cover":"http://img.kaiyanapp.com/3571c3c20e89bdba03b0bbeb01166510.jpeg?imageMogr2/quality/60/format/jpg","description":"闭眼APP的单方面甲方；对，是朕没错  为了守护世界的和平，为了防止世界被破坏，贯彻爱与被爱的隐藏角色，迷人又洒脱的，就！是！我！没错了  我皮我开心，你皮我也开心，若有freestyle,请开始你的表演。朕skr~over.","followed":false,"gender":"male","ifPgc":false,"library":"BLOCK","limitVideoOpen":false,"nickname":"℡【有意思】","registDate":1392880258000,"releaseDate":1539623672000,"uid":46391029,"uploadStatus":"NORMAL","userType":"NORMAL"},"videoId":51707,"videoTitle":"反思亲情动画：「失忆」的父亲"}
         * simpleVideo : {"actionUrl":"eyepetizer://ugcResourceDetail?id=51707&resourceType=video","category":"动画","collected":false,"count":0,"cover":{"blurred":"http://img.kaiyanapp.com/c43cc07622d9d9bfc43a857bfc004a63.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/36b718024ee67dd814232471349aed13.jpeg?imageMogr2/quality/60/format/jpg","feed":"http://img.kaiyanapp.com/36b718024ee67dd814232471349aed13.jpeg?imageMogr2/quality/60/format/jpg","homepage":"http://img.kaiyanapp.com/36b718024ee67dd814232471349aed13.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"description":"短片讲述了一位患有阿兹海默症的父亲和他女儿的故事。用细腻的画风描绘了一个普通的早晨，记忆力衰退的父亲需要靠备忘录来提醒自己，并拒绝女儿的好心照顾，直到他独自出门后\u2026\u2026今天是重阳节，记得问候渐渐老去的他们。From GOBELINS","duration":280,"id":51707,"onlineStatus":"ONLINE","playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=51707&resourceType=video&editionType=default&source=aliyun","releaseTime":1539738000000,"resourceType":"video","title":"反思亲情动画：「失忆」的父亲","uid":0}
         * text : 评论:
         * user : {"actionUrl":"eyepetizer://pgc/detail/46391029/?title=%E2%84%A1%E3%80%90%E6%9C%89%E6%84%8F%E6%80%9D%E3%80%91&userType=NORMAL&tabIndex=0","avatar":"http://img.kaiyanapp.com/612afa4a3d144f187297680a9d375170.jpeg?imageMogr2/quality/60/format/jpg","cover":"http://img.kaiyanapp.com/3571c3c20e89bdba03b0bbeb01166510.jpeg?imageMogr2/quality/60/format/jpg","description":"闭眼APP的单方面甲方；对，是朕没错  为了守护世界的和平，为了防止世界被破坏，贯彻爱与被爱的隐藏角色，迷人又洒脱的，就！是！我！没错了  我皮我开心，你皮我也开心，若有freestyle,请开始你的表演。朕skr~over.","followed":false,"gender":"male","ifPgc":false,"library":"BLOCK","limitVideoOpen":false,"nickname":"℡【有意思】","registDate":1392880258000,"releaseDate":1539623672000,"uid":46391029,"uploadStatus":"NORMAL","userType":"NORMAL"}
         */

        public String actionUrl;
        public long createDate;
        public String dataType;
        public String dynamicType;
        public boolean merge;
        public ReplyBean reply;
        public SimpleVideoBean simpleVideo;
        public String text;
        public UserBeanX user;

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

        public static class ReplyBean {
            /**
             * id : 1052410605559873536
             * ifHotReply : true
             * likeCount : 11
             * liked : false
             * message : 茫茫人海 一片空白，无助徘徊 我 唤你回来。_心耐如初。若有时
             * parentReplyId : 0
             * rootReplyId : 1052410605559873536
             * showConversationButton : false
             * user : {"actionUrl":"eyepetizer://pgc/detail/46391029/?title=%E2%84%A1%E3%80%90%E6%9C%89%E6%84%8F%E6%80%9D%E3%80%91&userType=NORMAL&tabIndex=0","avatar":"http://img.kaiyanapp.com/612afa4a3d144f187297680a9d375170.jpeg?imageMogr2/quality/60/format/jpg","cover":"http://img.kaiyanapp.com/3571c3c20e89bdba03b0bbeb01166510.jpeg?imageMogr2/quality/60/format/jpg","description":"闭眼APP的单方面甲方；对，是朕没错  为了守护世界的和平，为了防止世界被破坏，贯彻爱与被爱的隐藏角色，迷人又洒脱的，就！是！我！没错了  我皮我开心，你皮我也开心，若有freestyle,请开始你的表演。朕skr~over.","followed":false,"gender":"male","ifPgc":false,"library":"BLOCK","limitVideoOpen":false,"nickname":"℡【有意思】","registDate":1392880258000,"releaseDate":1539623672000,"uid":46391029,"uploadStatus":"NORMAL","userType":"NORMAL"}
             * videoId : 51707
             * videoTitle : 反思亲情动画：「失忆」的父亲
             */

            public long id;
            public boolean ifHotReply;
            public int likeCount;
            public boolean liked;
            public String message;
            public int parentReplyId;
            public long rootReplyId;
            public boolean showConversationButton;
            public UserBean user;
            public int videoId;
            public String videoTitle;

            public static ReplyBean objectFromData(String str) {

                return new Gson().fromJson(str, ReplyBean.class);
            }

            public static ReplyBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ReplyBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<ReplyBean> arrayReplyBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<ReplyBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<ReplyBean> arrayReplyBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<ReplyBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public static class UserBean {
                /**
                 * actionUrl : eyepetizer://pgc/detail/46391029/?title=%E2%84%A1%E3%80%90%E6%9C%89%E6%84%8F%E6%80%9D%E3%80%91&userType=NORMAL&tabIndex=0
                 * avatar : http://img.kaiyanapp.com/612afa4a3d144f187297680a9d375170.jpeg?imageMogr2/quality/60/format/jpg
                 * cover : http://img.kaiyanapp.com/3571c3c20e89bdba03b0bbeb01166510.jpeg?imageMogr2/quality/60/format/jpg
                 * description : 闭眼APP的单方面甲方；对，是朕没错  为了守护世界的和平，为了防止世界被破坏，贯彻爱与被爱的隐藏角色，迷人又洒脱的，就！是！我！没错了  我皮我开心，你皮我也开心，若有freestyle,请开始你的表演。朕skr~over.
                 * followed : false
                 * gender : male
                 * ifPgc : false
                 * library : BLOCK
                 * limitVideoOpen : false
                 * nickname : ℡【有意思】
                 * registDate : 1392880258000
                 * releaseDate : 1539623672000
                 * uid : 46391029
                 * uploadStatus : NORMAL
                 * userType : NORMAL
                 */

                public String actionUrl;
                public String avatar;
                public String cover;
                public String description;
                public boolean followed;
                public String gender;
                public boolean ifPgc;
                public String library;
                public boolean limitVideoOpen;
                public String nickname;
                public long registDate;
                public long releaseDate;
                public int uid;
                public String uploadStatus;
                public String userType;

                public static UserBean objectFromData(String str) {

                    return new Gson().fromJson(str, UserBean.class);
                }

                public static UserBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), UserBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<UserBean> arrayUserBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<UserBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<UserBean> arrayUserBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<UserBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }
            }
        }

        public static class SimpleVideoBean {
            /**
             * actionUrl : eyepetizer://ugcResourceDetail?id=51707&resourceType=video
             * category : 动画
             * collected : false
             * count : 0
             * cover : {"blurred":"http://img.kaiyanapp.com/c43cc07622d9d9bfc43a857bfc004a63.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/36b718024ee67dd814232471349aed13.jpeg?imageMogr2/quality/60/format/jpg","feed":"http://img.kaiyanapp.com/36b718024ee67dd814232471349aed13.jpeg?imageMogr2/quality/60/format/jpg","homepage":"http://img.kaiyanapp.com/36b718024ee67dd814232471349aed13.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"}
             * description : 短片讲述了一位患有阿兹海默症的父亲和他女儿的故事。用细腻的画风描绘了一个普通的早晨，记忆力衰退的父亲需要靠备忘录来提醒自己，并拒绝女儿的好心照顾，直到他独自出门后……今天是重阳节，记得问候渐渐老去的他们。From GOBELINS
             * duration : 280
             * id : 51707
             * onlineStatus : ONLINE
             * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=51707&resourceType=video&editionType=default&source=aliyun
             * releaseTime : 1539738000000
             * resourceType : video
             * title : 反思亲情动画：「失忆」的父亲
             * uid : 0
             */

            public String actionUrl;
            public String category;
            public boolean collected;
            public int count;
            public CoverBean cover;
            public String description;
            public int duration;
            public int id;
            public String onlineStatus;
            public String playUrl;
            public long releaseTime;
            public String resourceType;
            public String title;
            public int uid;

            public static SimpleVideoBean objectFromData(String str) {

                return new Gson().fromJson(str, SimpleVideoBean.class);
            }

            public static SimpleVideoBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), SimpleVideoBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<SimpleVideoBean> arraySimpleVideoBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<SimpleVideoBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<SimpleVideoBean> arraySimpleVideoBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<SimpleVideoBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public static class CoverBean {
                /**
                 * blurred : http://img.kaiyanapp.com/c43cc07622d9d9bfc43a857bfc004a63.jpeg?imageMogr2/quality/60/format/jpg
                 * detail : http://img.kaiyanapp.com/36b718024ee67dd814232471349aed13.jpeg?imageMogr2/quality/60/format/jpg
                 * feed : http://img.kaiyanapp.com/36b718024ee67dd814232471349aed13.jpeg?imageMogr2/quality/60/format/jpg
                 * homepage : http://img.kaiyanapp.com/36b718024ee67dd814232471349aed13.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
                 */

                public String blurred;
                public String detail;
                public String feed;
                public String homepage;

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
        }

        public static class UserBeanX {
            /**
             * actionUrl : eyepetizer://pgc/detail/46391029/?title=%E2%84%A1%E3%80%90%E6%9C%89%E6%84%8F%E6%80%9D%E3%80%91&userType=NORMAL&tabIndex=0
             * avatar : http://img.kaiyanapp.com/612afa4a3d144f187297680a9d375170.jpeg?imageMogr2/quality/60/format/jpg
             * cover : http://img.kaiyanapp.com/3571c3c20e89bdba03b0bbeb01166510.jpeg?imageMogr2/quality/60/format/jpg
             * description : 闭眼APP的单方面甲方；对，是朕没错  为了守护世界的和平，为了防止世界被破坏，贯彻爱与被爱的隐藏角色，迷人又洒脱的，就！是！我！没错了  我皮我开心，你皮我也开心，若有freestyle,请开始你的表演。朕skr~over.
             * followed : false
             * gender : male
             * ifPgc : false
             * library : BLOCK
             * limitVideoOpen : false
             * nickname : ℡【有意思】
             * registDate : 1392880258000
             * releaseDate : 1539623672000
             * uid : 46391029
             * uploadStatus : NORMAL
             * userType : NORMAL
             */

            public String actionUrl;
            public String avatar;
            public String cover;
            public String description;
            public boolean followed;
            public String gender;
            public boolean ifPgc;
            public String library;
            public boolean limitVideoOpen;
            public String nickname;
            public long registDate;
            public long releaseDate;
            public int uid;
            public String uploadStatus;
            public String userType;

            public static UserBeanX objectFromData(String str) {

                return new Gson().fromJson(str, UserBeanX.class);
            }

            public static UserBeanX objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), UserBeanX.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<UserBeanX> arrayUserBeanXFromData(String str) {

                Type listType = new TypeToken<ArrayList<UserBeanX>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<UserBeanX> arrayUserBeanXFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<UserBeanX>>() {
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
