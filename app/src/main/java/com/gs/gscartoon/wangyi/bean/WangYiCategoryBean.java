package com.gs.gscartoon.wangyi.bean;

import java.util.List;

/**
 * Created by camdora on 18-1-31.
 */

public class WangYiCategoryBean {

    /**
     * resCode : 0
     * data : {"baseUrl":"https://api.mh.163.com","category":[{"text":"人气","url":"/rank.json?type=1","cover":"https://easyread.nosdn.127.net/pic20170728b19cf3fb08a94db3a4b8b8fa49ff77b1.png","ctype":9999,"type":1},{"text":"恋爱","url":"/tag/books.json?s=2&e=2008001","cover":"https://easyread.nosdn.127.net/pic2017080493a69babbbcf4f86b655f29f623b2633.png","ctype":1,"type":0,"brief":"触动少女心","labels":[2]},{"text":"漫威","url":"/comics.json?authorizer=85518982","cover":"https://easyread.nosdn.127.net/pic20170711a900256df83c4ccca3581054d0b12958.png","ctype":1,"type":0,"brief":"超级英雄拯救世界","labels":[2]},{"text":"日漫","url":"/filter/books.json?s=7&e=4","cover":"https://easyread.nosdn.127.net/pic20170804bfaad08723f24428bbf6a10baa34bf61.png","ctype":1,"type":3,"brief":"这里都是大神"},{"text":"古风","url":"/tag/books.json?s=2&e=4007","cover":"https://easyread.nosdn.127.net/pic2017080429a554170e45424a917e0d84b2388dc2.png","ctype":1,"type":0,"brief":"纵横五千年"},{"text":"校园","url":"/tag/books.json?s=2&e=5002","cover":"https://easyread.nosdn.127.net/pic20170804baf8dc7e99544da59f11e8deb938ba56.jpg","ctype":1,"type":0,"brief":"浪漫的校园际遇"},{"text":"耽美","url":"/tag/books.json?s=2&e=6","cover":"https://easyread.nosdn.127.net/pic201708045d7f5e95ac764e509fbd02945739613a.png","ctype":1,"type":0,"brief":"另一种浪漫？他和他？or 她和她？","labels":[2]},{"text":"搞笑","url":"/tag/books.json?s=2&e=14","cover":"https://easyread.nosdn.127.net/pic2017080463741285f3584420975a74caeb355fca.png","ctype":1,"type":0,"brief":"吐你一脸槽","labels":[2]},{"text":"穿越","url":"/tag/books.json?s=2&e=5010","cover":"https://easyread.nosdn.127.net/pic20170804c1459455a02d4f3a93cd271d2a9a7917.png","ctype":1,"type":0,"brief":"走上人生巅峰"},{"text":"恐怖","url":"/tag/books.json?s=2&e=6001","cover":"https://easyread.nosdn.127.net/pic201708040f4d9fd9cf7d441482829d249852a0aa.png","ctype":1,"type":0,"brief":"面膜都吓掉了","labels":[2]},{"text":"完结","url":"/filter/books.json?s=5&e=3001","cover":"https://easyread.nosdn.127.net/pic20170804fd6406cac34e46e5aa7bb0724a4798af.png","ctype":1,"type":2,"brief":"完结撒花中"},{"text":"新秀场","url":"/filter/books.json?s=3&e=2013001","cover":"https://easyread.nosdn.127.net/pic201708042bd97984dab94aa8b4e42b4a55d19c5d.png","ctype":1,"type":5,"brief":"新人漫画看这里"},{"text":"VIP","url":"/filter/books.json?s=8&e=5011","cover":"https://easyread.nosdn.127.net/pic20170728504aa7eccefa4853bcbb9c8917ed7025.png","ctype":1,"type":4,"brief":"付费专享"},{"text":"都市","url":"/tag/books.json?s=2&e=4003","cover":"https://easyread.nosdn.127.net/pic2017080421eefb421825478bb0fbdc3499a565da.jpg","ctype":1,"type":0,"brief":"绚烂的都市，是故事的起点"},{"text":"治愈","url":"/tag/books.json?s=2&e=4001","cover":"https://easyread.nosdn.127.net/pic20170804686f5b1def5a4e1588d2c946f04f93da.png","ctype":1,"type":0,"brief":"死宅也有温情"},{"text":"热血","url":"/tag/books.json?s=2&e=1","cover":"https://easyread.nosdn.127.net/pic201708042746cf9147784d19a5e2f68a7abed5d4.png","ctype":1,"type":0,"brief":"中二拯救世界"},{"text":"玄幻","url":"/tag/books.json?s=2&e=7001","cover":"https://easyread.nosdn.127.net/pic201708047afce356bf3b46ef8e71347c516bffad.png","ctype":1,"type":0,"brief":"你所不知道的世界"},{"text":"悬疑","url":"/tag/books.json?s=2&e=4013","cover":"https://easyread.nosdn.127.net/pic201708041f3d60be1c7542a09d5427433cdfbc49.png","ctype":1,"type":0,"brief":"凶手未必一个"},{"text":"冒险","url":"/tag/books.json?s=2&e=4006","cover":"https://easyread.nosdn.127.net/pic201708048151b534164a4316b7c9d3f1117d53fd.png","ctype":1,"type":0,"brief":"当奶还是当T，去旅行吧！"},{"text":"打赏","url":"/rank.json?type=5","cover":"https://easyread.nosdn.127.net/pic201707280d3a3975b5604d299788140bc76aff67.png","ctype":9999,"type":5},{"text":"新书","url":"/rank.json?type=3","cover":"https://easyread.nosdn.127.net/pic20170728ac4bd387707347cdb1f1c0b61356d857.png","ctype":9999,"type":3}]}
     * resReason : ok
     */

    private int resCode;
    private DataBean data;
    private String resReason;

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getResReason() {
        return resReason;
    }

    public void setResReason(String resReason) {
        this.resReason = resReason;
    }

    public static class DataBean {
        /**
         * baseUrl : https://api.mh.163.com
         * category : [{"text":"人气","url":"/rank.json?type=1","cover":"https://easyread.nosdn.127.net/pic20170728b19cf3fb08a94db3a4b8b8fa49ff77b1.png","ctype":9999,"type":1},{"text":"恋爱","url":"/tag/books.json?s=2&e=2008001","cover":"https://easyread.nosdn.127.net/pic2017080493a69babbbcf4f86b655f29f623b2633.png","ctype":1,"type":0,"brief":"触动少女心","labels":[2]},{"text":"漫威","url":"/comics.json?authorizer=85518982","cover":"https://easyread.nosdn.127.net/pic20170711a900256df83c4ccca3581054d0b12958.png","ctype":1,"type":0,"brief":"超级英雄拯救世界","labels":[2]},{"text":"日漫","url":"/filter/books.json?s=7&e=4","cover":"https://easyread.nosdn.127.net/pic20170804bfaad08723f24428bbf6a10baa34bf61.png","ctype":1,"type":3,"brief":"这里都是大神"},{"text":"古风","url":"/tag/books.json?s=2&e=4007","cover":"https://easyread.nosdn.127.net/pic2017080429a554170e45424a917e0d84b2388dc2.png","ctype":1,"type":0,"brief":"纵横五千年"},{"text":"校园","url":"/tag/books.json?s=2&e=5002","cover":"https://easyread.nosdn.127.net/pic20170804baf8dc7e99544da59f11e8deb938ba56.jpg","ctype":1,"type":0,"brief":"浪漫的校园际遇"},{"text":"耽美","url":"/tag/books.json?s=2&e=6","cover":"https://easyread.nosdn.127.net/pic201708045d7f5e95ac764e509fbd02945739613a.png","ctype":1,"type":0,"brief":"另一种浪漫？他和他？or 她和她？","labels":[2]},{"text":"搞笑","url":"/tag/books.json?s=2&e=14","cover":"https://easyread.nosdn.127.net/pic2017080463741285f3584420975a74caeb355fca.png","ctype":1,"type":0,"brief":"吐你一脸槽","labels":[2]},{"text":"穿越","url":"/tag/books.json?s=2&e=5010","cover":"https://easyread.nosdn.127.net/pic20170804c1459455a02d4f3a93cd271d2a9a7917.png","ctype":1,"type":0,"brief":"走上人生巅峰"},{"text":"恐怖","url":"/tag/books.json?s=2&e=6001","cover":"https://easyread.nosdn.127.net/pic201708040f4d9fd9cf7d441482829d249852a0aa.png","ctype":1,"type":0,"brief":"面膜都吓掉了","labels":[2]},{"text":"完结","url":"/filter/books.json?s=5&e=3001","cover":"https://easyread.nosdn.127.net/pic20170804fd6406cac34e46e5aa7bb0724a4798af.png","ctype":1,"type":2,"brief":"完结撒花中"},{"text":"新秀场","url":"/filter/books.json?s=3&e=2013001","cover":"https://easyread.nosdn.127.net/pic201708042bd97984dab94aa8b4e42b4a55d19c5d.png","ctype":1,"type":5,"brief":"新人漫画看这里"},{"text":"VIP","url":"/filter/books.json?s=8&e=5011","cover":"https://easyread.nosdn.127.net/pic20170728504aa7eccefa4853bcbb9c8917ed7025.png","ctype":1,"type":4,"brief":"付费专享"},{"text":"都市","url":"/tag/books.json?s=2&e=4003","cover":"https://easyread.nosdn.127.net/pic2017080421eefb421825478bb0fbdc3499a565da.jpg","ctype":1,"type":0,"brief":"绚烂的都市，是故事的起点"},{"text":"治愈","url":"/tag/books.json?s=2&e=4001","cover":"https://easyread.nosdn.127.net/pic20170804686f5b1def5a4e1588d2c946f04f93da.png","ctype":1,"type":0,"brief":"死宅也有温情"},{"text":"热血","url":"/tag/books.json?s=2&e=1","cover":"https://easyread.nosdn.127.net/pic201708042746cf9147784d19a5e2f68a7abed5d4.png","ctype":1,"type":0,"brief":"中二拯救世界"},{"text":"玄幻","url":"/tag/books.json?s=2&e=7001","cover":"https://easyread.nosdn.127.net/pic201708047afce356bf3b46ef8e71347c516bffad.png","ctype":1,"type":0,"brief":"你所不知道的世界"},{"text":"悬疑","url":"/tag/books.json?s=2&e=4013","cover":"https://easyread.nosdn.127.net/pic201708041f3d60be1c7542a09d5427433cdfbc49.png","ctype":1,"type":0,"brief":"凶手未必一个"},{"text":"冒险","url":"/tag/books.json?s=2&e=4006","cover":"https://easyread.nosdn.127.net/pic201708048151b534164a4316b7c9d3f1117d53fd.png","ctype":1,"type":0,"brief":"当奶还是当T，去旅行吧！"},{"text":"打赏","url":"/rank.json?type=5","cover":"https://easyread.nosdn.127.net/pic201707280d3a3975b5604d299788140bc76aff67.png","ctype":9999,"type":5},{"text":"新书","url":"/rank.json?type=3","cover":"https://easyread.nosdn.127.net/pic20170728ac4bd387707347cdb1f1c0b61356d857.png","ctype":9999,"type":3}]
         */

        private String baseUrl;
        private List<CategoryBean> category;

        public String getBaseUrl() {
            return baseUrl;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }

        public List<CategoryBean> getCategory() {
            return category;
        }

        public void setCategory(List<CategoryBean> category) {
            this.category = category;
        }

        public static class CategoryBean {
            /**
             * text : 人气
             * url : /rank.json?type=1
             * cover : https://easyread.nosdn.127.net/pic20170728b19cf3fb08a94db3a4b8b8fa49ff77b1.png
             * ctype : 9999
             * type : 1
             * brief : 触动少女心
             * labels : [2]
             */

            private String text;
            private String url;
            private String cover;
            private int ctype;
            private int type;
            private String brief;
            private List<Integer> labels;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public int getCtype() {
                return ctype;
            }

            public void setCtype(int ctype) {
                this.ctype = ctype;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getBrief() {
                return brief;
            }

            public void setBrief(String brief) {
                this.brief = brief;
            }

            public List<Integer> getLabels() {
                return labels;
            }

            public void setLabels(List<Integer> labels) {
                this.labels = labels;
            }
        }
    }
}
