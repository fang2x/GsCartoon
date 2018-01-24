package com.gs.gscartoon.zhijia.bean;

import java.util.List;

/**
 * Created by camdora on 18-1-24.
 */

public class ZhiJiaDetailsBean {

    /**
     * id : 42365
     * islong : 1
     * direction : 2
     * title : 人鱼公主
     * is_dmzj : 0
     * cover : https://images.dmzj.com/img/webpic/19/1049681591513738510.jpg
     * description : 秦晴被富家女闺蜜张嘉瑶说动，参加了游艇派对，殊不知这是张嘉瑶嫉妒和怨恨下的一场阴谋……
     * last_updatetime : 1516757836
     * copyright : 1
     * first_letter : r
     * hot_num : 104648
     * hit_num : 199818
     * uid : 104968159
     * types : [{"tag_id":16,"tag_name":"其他"},{"tag_id":3328,"tag_name":"职场"},{"tag_id":5848,"tag_name":"奇幻"}]
     * status : [{"tag_id":2309,"tag_name":"连载中"}]
     * authors : [{"tag_id":11113,"tag_name":"微漫画"}]
     * subscribe_num : 478
     * chapters : [{"title":"连载","data":[{"chapter_id":73359,"chapter_title":"6话","updatetime":1516757836,"filesize":900327,"chapter_order":6},{"chapter_id":73110,"chapter_title":"5话","updatetime":1516153743,"filesize":1892858,"chapter_order":5},{"chapter_id":72868,"chapter_title":"4话","updatetime":1515548908,"filesize":1911636,"chapter_order":4},{"chapter_id":72662,"chapter_title":"3话","updatetime":1514956960,"filesize":1708406,"chapter_order":3},{"chapter_id":72439,"chapter_title":"2话","updatetime":1514340139,"filesize":1549288,"chapter_order":2},{"chapter_id":72247,"chapter_title":"1话","updatetime":1513738584,"filesize":489148,"chapter_order":1}]}]
     * author_notice : 微漫画出品~ 唯漫画，不将就
     * comic_notice :
     * comment : {"comment_count":13,"latest_comment":[{"comment_id":3668353,"uid":100439211,"content":"说这个漫画垃圾可以不看，不要在这里骂娘！","createtime":1515815112,"nickname":"^(ω)^明","avatar":"https://images.dmzj.com/user/25/14/2514bb458dcea9cc219cff2d051d1a4a.png"},{"comment_id":3618166,"uid":7143035,"content":"这女主能把男二整个扔到海里莫不是摔跤手么？难道是跟人鱼立契约获得的能力？这部作品难道是奇幻类？","createtime":1514971324,"nickname":"wren84AMD","avatar":"https://images.dmzj.com/user/3d/22/3d22e2c0257e05ffecd0baacdfdbde19.png"}]}
     */

    private int id;
    private int islong;
    private int direction;
    private String title;
    private int is_dmzj;
    private String cover;
    private String description;
    private int last_updatetime;
    private int copyright;
    private String first_letter;
    private int hot_num;
    private int hit_num;
    private int uid;
    private int subscribe_num;
    private String author_notice;
    private String comic_notice;
    private CommentBean comment;
    private List<TypesBean> types;
    private List<StatusBean> status;
    private List<AuthorsBean> authors;
    private List<ChaptersBean> chapters;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIslong() {
        return islong;
    }

    public void setIslong(int islong) {
        this.islong = islong;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIs_dmzj() {
        return is_dmzj;
    }

    public void setIs_dmzj(int is_dmzj) {
        this.is_dmzj = is_dmzj;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLast_updatetime() {
        return last_updatetime;
    }

    public void setLast_updatetime(int last_updatetime) {
        this.last_updatetime = last_updatetime;
    }

    public int getCopyright() {
        return copyright;
    }

    public void setCopyright(int copyright) {
        this.copyright = copyright;
    }

    public String getFirst_letter() {
        return first_letter;
    }

    public void setFirst_letter(String first_letter) {
        this.first_letter = first_letter;
    }

    public int getHot_num() {
        return hot_num;
    }

    public void setHot_num(int hot_num) {
        this.hot_num = hot_num;
    }

    public int getHit_num() {
        return hit_num;
    }

    public void setHit_num(int hit_num) {
        this.hit_num = hit_num;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getSubscribe_num() {
        return subscribe_num;
    }

    public void setSubscribe_num(int subscribe_num) {
        this.subscribe_num = subscribe_num;
    }

    public String getAuthor_notice() {
        return author_notice;
    }

    public void setAuthor_notice(String author_notice) {
        this.author_notice = author_notice;
    }

    public String getComic_notice() {
        return comic_notice;
    }

    public void setComic_notice(String comic_notice) {
        this.comic_notice = comic_notice;
    }

    public CommentBean getComment() {
        return comment;
    }

    public void setComment(CommentBean comment) {
        this.comment = comment;
    }

    public List<TypesBean> getTypes() {
        return types;
    }

    public void setTypes(List<TypesBean> types) {
        this.types = types;
    }

    public List<StatusBean> getStatus() {
        return status;
    }

    public void setStatus(List<StatusBean> status) {
        this.status = status;
    }

    public List<AuthorsBean> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorsBean> authors) {
        this.authors = authors;
    }

    public List<ChaptersBean> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChaptersBean> chapters) {
        this.chapters = chapters;
    }

    public static class CommentBean {
        /**
         * comment_count : 13
         * latest_comment : [{"comment_id":3668353,"uid":100439211,"content":"说这个漫画垃圾可以不看，不要在这里骂娘！","createtime":1515815112,"nickname":"^(ω)^明","avatar":"https://images.dmzj.com/user/25/14/2514bb458dcea9cc219cff2d051d1a4a.png"},{"comment_id":3618166,"uid":7143035,"content":"这女主能把男二整个扔到海里莫不是摔跤手么？难道是跟人鱼立契约获得的能力？这部作品难道是奇幻类？","createtime":1514971324,"nickname":"wren84AMD","avatar":"https://images.dmzj.com/user/3d/22/3d22e2c0257e05ffecd0baacdfdbde19.png"}]
         */

        private int comment_count;
        private List<LatestCommentBean> latest_comment;

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public List<LatestCommentBean> getLatest_comment() {
            return latest_comment;
        }

        public void setLatest_comment(List<LatestCommentBean> latest_comment) {
            this.latest_comment = latest_comment;
        }

        public static class LatestCommentBean {
            /**
             * comment_id : 3668353
             * uid : 100439211
             * content : 说这个漫画垃圾可以不看，不要在这里骂娘！
             * createtime : 1515815112
             * nickname : ^(ω)^明
             * avatar : https://images.dmzj.com/user/25/14/2514bb458dcea9cc219cff2d051d1a4a.png
             */

            private int comment_id;
            private int uid;
            private String content;
            private int createtime;
            private String nickname;
            private String avatar;

            public int getComment_id() {
                return comment_id;
            }

            public void setComment_id(int comment_id) {
                this.comment_id = comment_id;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getCreatetime() {
                return createtime;
            }

            public void setCreatetime(int createtime) {
                this.createtime = createtime;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }
    }

    public static class TypesBean {
        /**
         * tag_id : 16
         * tag_name : 其他
         */

        private int tag_id;
        private String tag_name;

        public int getTag_id() {
            return tag_id;
        }

        public void setTag_id(int tag_id) {
            this.tag_id = tag_id;
        }

        public String getTag_name() {
            return tag_name;
        }

        public void setTag_name(String tag_name) {
            this.tag_name = tag_name;
        }
    }

    public static class StatusBean {
        /**
         * tag_id : 2309
         * tag_name : 连载中
         */

        private int tag_id;
        private String tag_name;

        public int getTag_id() {
            return tag_id;
        }

        public void setTag_id(int tag_id) {
            this.tag_id = tag_id;
        }

        public String getTag_name() {
            return tag_name;
        }

        public void setTag_name(String tag_name) {
            this.tag_name = tag_name;
        }
    }

    public static class AuthorsBean {
        /**
         * tag_id : 11113
         * tag_name : 微漫画
         */

        private int tag_id;
        private String tag_name;

        public int getTag_id() {
            return tag_id;
        }

        public void setTag_id(int tag_id) {
            this.tag_id = tag_id;
        }

        public String getTag_name() {
            return tag_name;
        }

        public void setTag_name(String tag_name) {
            this.tag_name = tag_name;
        }
    }

    public static class ChaptersBean {
        /**
         * title : 连载
         * data : [{"chapter_id":73359,"chapter_title":"6话","updatetime":1516757836,"filesize":900327,"chapter_order":6},{"chapter_id":73110,"chapter_title":"5话","updatetime":1516153743,"filesize":1892858,"chapter_order":5},{"chapter_id":72868,"chapter_title":"4话","updatetime":1515548908,"filesize":1911636,"chapter_order":4},{"chapter_id":72662,"chapter_title":"3话","updatetime":1514956960,"filesize":1708406,"chapter_order":3},{"chapter_id":72439,"chapter_title":"2话","updatetime":1514340139,"filesize":1549288,"chapter_order":2},{"chapter_id":72247,"chapter_title":"1话","updatetime":1513738584,"filesize":489148,"chapter_order":1}]
         */

        private String title;
        private List<DataBean> data;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * chapter_id : 73359
             * chapter_title : 6话
             * updatetime : 1516757836
             * filesize : 900327
             * chapter_order : 6
             */

            private int chapter_id;
            private String chapter_title;
            private int updatetime;
            private int filesize;
            private int chapter_order;

            public int getChapter_id() {
                return chapter_id;
            }

            public void setChapter_id(int chapter_id) {
                this.chapter_id = chapter_id;
            }

            public String getChapter_title() {
                return chapter_title;
            }

            public void setChapter_title(String chapter_title) {
                this.chapter_title = chapter_title;
            }

            public int getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(int updatetime) {
                this.updatetime = updatetime;
            }

            public int getFilesize() {
                return filesize;
            }

            public void setFilesize(int filesize) {
                this.filesize = filesize;
            }

            public int getChapter_order() {
                return chapter_order;
            }

            public void setChapter_order(int chapter_order) {
                this.chapter_order = chapter_order;
            }
        }
    }
}
