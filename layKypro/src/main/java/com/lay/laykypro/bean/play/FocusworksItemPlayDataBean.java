package com.lay.laykypro.bean.play;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FocusworksItemPlayDataBean {
    /**
     * adIndex : -1
     * data : {"author":{"approvedNotReadyVideoCount":0,"description":"人生不将就，从你的住宅开始。","follow":{"followed":false,"itemId":1978,"itemType":"author"},"icon":"http://img.kaiyanapp.com/27b7e5abb644a143a229bc8d5ae6d8bf.jpeg?imageMogr2/quality/60/format/jpg","id":1978,"ifPgc":true,"latestReleaseTime":1532401005000,"link":"","name":"新视觉工作室","shield":{"itemId":1978,"itemType":"author","shielded":false},"videoNum":38},"category":"生活","collected":false,"consumption":{"collectionCount":0,"replyCount":0,"shareCount":0},"cover":{"blurred":"http://img.kaiyanapp.com/392ec5a26f39a2f0d85bbe47eef3c172.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/9402405ac6e59d2aeebbb424bb3a5598.jpeg?imageMogr2/quality/60/format/jpg","feed":"http://img.kaiyanapp.com/9402405ac6e59d2aeebbb424bb3a5598.jpeg?imageMogr2/quality/60/format/jpg"},"dataType":"VideoBeanForClient","date":1532400462000,"description":"房间的室外露台配备有石砌壁炉、烧烤站和水疗中心。超大的主卧套间设置有一个完整的酒吧吧台。每间卧室都有私人浴室和宽敞的衣帽间。","descriptionEditor":"","descriptionPgc":"房间的室外露台配备有石砌壁炉、烧烤站和水疗中心。超大的主卧套间设置有一个完整的酒吧吧台。每间卧室都有私人浴室和宽敞的衣帽间。","duration":121,"id":116861,"idx":0,"ifLimitVideo":false,"labelList":[],"library":"DEFAULT","playInfo":[{"height":720,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=116861&resourceType=video&editionType=high&source=aliyun&uid=301289426","urlList":[{"name":"aliyun","size":18456534,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=116861&resourceType=video&editionType=high&source=aliyun&uid=301289426"},{"name":"qcloud","size":18456534,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=116861&resourceType=video&editionType=high&source=qcloud&uid=301289426"},{"name":"ucloud","size":18456534,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=116861&resourceType=video&editionType=high&source=ucloud&uid=301289426"}],"width":1280}],"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=116861&resourceType=video&editionType=default&source=aliyun&uid=301289426","played":false,"provider":{"alias":"CustomSrc","icon":"","name":"定制来源"},"releaseTime":1532400462000,"resourceType":"video","searchWeight":0,"subtitles":[],"tags":[{"actionUrl":"eyepetizer://tag/729/?title=%E5%88%9B%E6%84%8F%E7%94%9F%E6%B4%BB","bgPicture":"http://img.kaiyanapp.com/5260e075e03b6e828d12b26b0c2c4372.jpeg?imageMogr2/quality/60/format/jpg","desc":"","headerImage":"http://img.kaiyanapp.com/5260e075e03b6e828d12b26b0c2c4372.jpeg?imageMogr2/quality/60/format/jpg","id":729,"name":"创意生活","tagRecType":"IMPORTANT"},{"actionUrl":"eyepetizer://tag/666/?title=%E7%94%9F%E6%B4%BB","bgPicture":"http://img.kaiyanapp.com/be945b24182e6a268bdd66f054148f47.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/be945b24182e6a268bdd66f054148f47.jpeg?imageMogr2/quality/60/format/jpg","id":666,"name":"生活","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/684/?title=%E8%AE%BE%E8%AE%A1","bgPicture":"http://img.kaiyanapp.com/35ad4c34a1504cd8d398b315453a0f69.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/35ad4c34a1504cd8d398b315453a0f69.jpeg?imageMogr2/quality/60/format/jpg","id":684,"name":"设计","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/596/?title=%E5%AE%B6%E5%B1%85","bgPicture":"http://img.kaiyanapp.com/5194cbc31012757368f1ade41c08cf95.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/11fd436110d9a2c06965510ca93caf87.jpeg?imageMogr2/quality/100","id":596,"name":"家居","tagRecType":"NORMAL"}],"title":"建筑商自留豪宅：烧烤站、水疗室一应俱全","titlePgc":"建筑商自留豪宅：烧烤站、水疗室一应俱全","type":"NORMAL","webUrl":{"forWeibo":"http://www.eyepetizer.net/detail.html?vid=116861","raw":"http://www.eyepetizer.net/detail.html?vid=116861"}}
     * id : 0
     * type : video
     */

    public ContentBean content;
    public String dataType;
    /**
     * actionUrl : eyepetizer://pgc/detail/1978/?title=%E6%96%B0%E8%A7%86%E8%A7%89%E5%B7%A5%E4%BD%9C%E5%AE%A4&userType=PGC&tabIndex=1
     * followType : author
     * icon : http://img.kaiyanapp.com/27b7e5abb644a143a229bc8d5ae6d8bf.jpeg?imageMogr2/quality/60/format/jpg
     * iconType : round
     * id : 116861
     * issuerName : 新视觉工作室
     * showHateVideo : false
     * tagId : 0
     * time : 1532400462000
     */

    public HeaderBean header;

    public static class ContentBean {
        public int adIndex;
        /**
         * author : {"approvedNotReadyVideoCount":0,"description":"人生不将就，从你的住宅开始。","follow":{"followed":false,"itemId":1978,"itemType":"author"},"icon":"http://img.kaiyanapp.com/27b7e5abb644a143a229bc8d5ae6d8bf.jpeg?imageMogr2/quality/60/format/jpg","id":1978,"ifPgc":true,"latestReleaseTime":1532401005000,"link":"","name":"新视觉工作室","shield":{"itemId":1978,"itemType":"author","shielded":false},"videoNum":38}
         * category : 生活
         * collected : false
         * consumption : {"collectionCount":0,"replyCount":0,"shareCount":0}
         * cover : {"blurred":"http://img.kaiyanapp.com/392ec5a26f39a2f0d85bbe47eef3c172.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/9402405ac6e59d2aeebbb424bb3a5598.jpeg?imageMogr2/quality/60/format/jpg","feed":"http://img.kaiyanapp.com/9402405ac6e59d2aeebbb424bb3a5598.jpeg?imageMogr2/quality/60/format/jpg"}
         * dataType : VideoBeanForClient
         * date : 1532400462000
         * description : 房间的室外露台配备有石砌壁炉、烧烤站和水疗中心。超大的主卧套间设置有一个完整的酒吧吧台。每间卧室都有私人浴室和宽敞的衣帽间。
         * descriptionEditor :
         * descriptionPgc : 房间的室外露台配备有石砌壁炉、烧烤站和水疗中心。超大的主卧套间设置有一个完整的酒吧吧台。每间卧室都有私人浴室和宽敞的衣帽间。
         * duration : 121
         * id : 116861
         * idx : 0
         * ifLimitVideo : false
         * labelList : []
         * library : DEFAULT
         * playInfo : [{"height":720,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=116861&resourceType=video&editionType=high&source=aliyun&uid=301289426","urlList":[{"name":"aliyun","size":18456534,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=116861&resourceType=video&editionType=high&source=aliyun&uid=301289426"},{"name":"qcloud","size":18456534,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=116861&resourceType=video&editionType=high&source=qcloud&uid=301289426"},{"name":"ucloud","size":18456534,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=116861&resourceType=video&editionType=high&source=ucloud&uid=301289426"}],"width":1280}]
         * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=116861&resourceType=video&editionType=default&source=aliyun&uid=301289426
         * played : false
         * provider : {"alias":"CustomSrc","icon":"","name":"定制来源"}
         * releaseTime : 1532400462000
         * resourceType : video
         * searchWeight : 0
         * subtitles : []
         * tags : [{"actionUrl":"eyepetizer://tag/729/?title=%E5%88%9B%E6%84%8F%E7%94%9F%E6%B4%BB","bgPicture":"http://img.kaiyanapp.com/5260e075e03b6e828d12b26b0c2c4372.jpeg?imageMogr2/quality/60/format/jpg","desc":"","headerImage":"http://img.kaiyanapp.com/5260e075e03b6e828d12b26b0c2c4372.jpeg?imageMogr2/quality/60/format/jpg","id":729,"name":"创意生活","tagRecType":"IMPORTANT"},{"actionUrl":"eyepetizer://tag/666/?title=%E7%94%9F%E6%B4%BB","bgPicture":"http://img.kaiyanapp.com/be945b24182e6a268bdd66f054148f47.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/be945b24182e6a268bdd66f054148f47.jpeg?imageMogr2/quality/60/format/jpg","id":666,"name":"生活","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/684/?title=%E8%AE%BE%E8%AE%A1","bgPicture":"http://img.kaiyanapp.com/35ad4c34a1504cd8d398b315453a0f69.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/35ad4c34a1504cd8d398b315453a0f69.jpeg?imageMogr2/quality/60/format/jpg","id":684,"name":"设计","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/596/?title=%E5%AE%B6%E5%B1%85","bgPicture":"http://img.kaiyanapp.com/5194cbc31012757368f1ade41c08cf95.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/11fd436110d9a2c06965510ca93caf87.jpeg?imageMogr2/quality/100","id":596,"name":"家居","tagRecType":"NORMAL"}]
         * title : 建筑商自留豪宅：烧烤站、水疗室一应俱全
         * titlePgc : 建筑商自留豪宅：烧烤站、水疗室一应俱全
         * type : NORMAL
         * webUrl : {"forWeibo":"http://www.eyepetizer.net/detail.html?vid=116861","raw":"http://www.eyepetizer.net/detail.html?vid=116861"}
         */

        @SerializedName("data")
        public XDataBean data;
        public int id;
        public String type;

        public static class XDataBean {
            /**
             * approvedNotReadyVideoCount : 0
             * description : 人生不将就，从你的住宅开始。
             * follow : {"followed":false,"itemId":1978,"itemType":"author"}
             * icon : http://img.kaiyanapp.com/27b7e5abb644a143a229bc8d5ae6d8bf.jpeg?imageMogr2/quality/60/format/jpg
             * id : 1978
             * ifPgc : true
             * latestReleaseTime : 1532401005000
             * link :
             * name : 新视觉工作室
             * shield : {"itemId":1978,"itemType":"author","shielded":false}
             * videoNum : 38
             */

            public AuthorBean author;
            public String category;
            public boolean collected;
            /**
             * collectionCount : 0
             * replyCount : 0
             * shareCount : 0
             */

            public ConsumptionBean consumption;
            /**
             * blurred : http://img.kaiyanapp.com/392ec5a26f39a2f0d85bbe47eef3c172.jpeg?imageMogr2/quality/60/format/jpg
             * detail : http://img.kaiyanapp.com/9402405ac6e59d2aeebbb424bb3a5598.jpeg?imageMogr2/quality/60/format/jpg
             * feed : http://img.kaiyanapp.com/9402405ac6e59d2aeebbb424bb3a5598.jpeg?imageMogr2/quality/60/format/jpg
             */

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
            /**
             * alias : CustomSrc
             * icon :
             * name : 定制来源
             */

            public ProviderBean provider;
            public long releaseTime;
            public String resourceType;
            public int searchWeight;
            public String title;
            public String titlePgc;
            public String type;
            /**
             * forWeibo : http://www.eyepetizer.net/detail.html?vid=116861
             * raw : http://www.eyepetizer.net/detail.html?vid=116861
             */

            public WebUrlBean webUrl;
            public List<?> labelList;
            /**
             * height : 720
             * name : 高清
             * type : high
             * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=116861&resourceType=video&editionType=high&source=aliyun&uid=301289426
             * urlList : [{"name":"aliyun","size":18456534,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=116861&resourceType=video&editionType=high&source=aliyun&uid=301289426"},{"name":"qcloud","size":18456534,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=116861&resourceType=video&editionType=high&source=qcloud&uid=301289426"},{"name":"ucloud","size":18456534,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=116861&resourceType=video&editionType=high&source=ucloud&uid=301289426"}]
             * width : 1280
             */

            public List<PlayInfoBean> playInfo;
            public List<?> subtitles;
            /**
             * actionUrl : eyepetizer://tag/729/?title=%E5%88%9B%E6%84%8F%E7%94%9F%E6%B4%BB
             * bgPicture : http://img.kaiyanapp.com/5260e075e03b6e828d12b26b0c2c4372.jpeg?imageMogr2/quality/60/format/jpg
             * desc :
             * headerImage : http://img.kaiyanapp.com/5260e075e03b6e828d12b26b0c2c4372.jpeg?imageMogr2/quality/60/format/jpg
             * id : 729
             * name : 创意生活
             * tagRecType : IMPORTANT
             */

            public List<TagsBean> tags;

            public static class AuthorBean {
                public int approvedNotReadyVideoCount;
                public String description;
                /**
                 * followed : false
                 * itemId : 1978
                 * itemType : author
                 */

                public FollowBean follow;
                public String icon;
                public int id;
                public boolean ifPgc;
                public long latestReleaseTime;
                public String link;
                public String name;
                /**
                 * itemId : 1978
                 * itemType : author
                 * shielded : false
                 */

                public ShieldBean shield;
                public int videoNum;

                public static class FollowBean {
                    public boolean followed;
                    public int itemId;
                    public String itemType;
                }

                public static class ShieldBean {
                    public int itemId;
                    public String itemType;
                    public boolean shielded;
                }
            }

            public static class ConsumptionBean {
                public int collectionCount;
                public int replyCount;
                public int shareCount;
            }

            public static class CoverBean {
                public String blurred;
                public String detail;
                public String feed;
            }

            public static class ProviderBean {
                public String alias;
                public String icon;
                public String name;
            }

            public static class WebUrlBean {
                public String forWeibo;
                public String raw;
            }

            public static class PlayInfoBean {
                public int height;
                public String name;
                public String type;
                public String url;
                public int width;
                /**
                 * name : aliyun
                 * size : 18456534
                 * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=116861&resourceType=video&editionType=high&source=aliyun&uid=301289426
                 */

                public List<UrlListBean> urlList;

                public static class UrlListBean {
                    public String name;
                    public int size;
                    public String url;
                }
            }

            public static class TagsBean {
                public String actionUrl;
                public String bgPicture;
                public String desc;
                public String headerImage;
                public int id;
                public String name;
                public String tagRecType;
            }
        }
    }

    public static class HeaderBean {
        public String actionUrl;
        public String followType;
        public String icon;
        public String iconType;
        public int id;
        public String issuerName;
        public boolean showHateVideo;
        public int tagId;
        public long time;
    }
}
