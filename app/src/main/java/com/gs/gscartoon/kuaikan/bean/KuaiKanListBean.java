package com.gs.gscartoon.kuaikan.bean;

import java.util.List;

/**
 * Created by camdora on 18-1-16.
 */

public class KuaiKanListBean {

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {

        private int timestamp;
        private int since;
        private List<ComicsBean> comics;

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public int getSince() {
            return since;
        }

        public void setSince(int since) {
            this.since = since;
        }

        public List<ComicsBean> getComics() {
            return comics;
        }

        public void setComics(List<ComicsBean> comics) {
            this.comics = comics;
        }

        public static class ComicsBean {
            /**
             * info_type : 0
             * can_view : true
             * updated_count : 0
             * cover_image_url : http://f2.kkmh.com/image/180115/JAVYU2Wir.webp-w640
             * created_at : 1516053048
             * title : 第18话（下） 爱你的事情
             * updated_at : 1516013614
             * selling_kk_currency : 0
             * zoomable : 1
             * push_flag : 0
             * id : 71110
             * comic_type : 0
             * is_liked : false
             * label_color : #10beaa
             * storyboard_cnt : 45
             * url : http://m.kuaikanmanhua.com/comics/71110
             * likes_count : 208654
             * comments_count : 7093
             * label_text : 青春
             * is_free : true
             * topic : {"discover_image_url":"http://f2.kkmh.com/image/160401/qtglp1ihq.webp-w750","vertical_image_url":"http://f2.kkmh.com/image/161214/ic0pkr0jo.webp-w320","cover_image_url":"http://f2.kkmh.com/image/160511/chrrrrs4v.webp-w640","description":"少男少女同住一个屋檐下，一同历经青春懵懂和成长烦恼，彼此鼓励、渐生爱意。画风温馨的超人气少女漫，体会青春悸动的纯爱萌芽，这一部就够！【独家/每周二更新，责编：牛奶】","created_at":1459132969,"title":"怦然心动","male_vertical_image_url":"http://f2.kkmh.com/image/161214/ic0pkr0jo.webp-w320","updated_at":1459132969,"id":766,"user":{"pub_feed":1,"avatar_url":"http://f2.kkmh.com/image/150421/uelm8ugiz.jpg-w180","grade":1,"nickname":"\u203bkid岁","reg_type":"weibo","id":47124},"label_id":41,"male_cover_image_url":"http://f2.kkmh.com/image/160511/chrrrrs4v.webp-w640","order":500,"comics_count":88,"status":"published"}
             * shared_count : 0
             * label_text_color : #ffffff
             * serial_no : 0
             * status : published
             */

            private int info_type;
            private boolean can_view;
            private int updated_count;
            private String cover_image_url;
            private int created_at;
            private String title;
            private int updated_at;
            private int selling_kk_currency;
            private int zoomable;
            private int push_flag;
            private int id;
            private int comic_type;
            private boolean is_liked;
            private String label_color;
            private int storyboard_cnt;
            private String url;
            private int likes_count;
            private int comments_count;
            private String label_text;
            private boolean is_free;
            private TopicBean topic;
            private int shared_count;
            private String label_text_color;
            private int serial_no;
            private String status;

            public int getInfo_type() {
                return info_type;
            }

            public void setInfo_type(int info_type) {
                this.info_type = info_type;
            }

            public boolean isCan_view() {
                return can_view;
            }

            public void setCan_view(boolean can_view) {
                this.can_view = can_view;
            }

            public int getUpdated_count() {
                return updated_count;
            }

            public void setUpdated_count(int updated_count) {
                this.updated_count = updated_count;
            }

            public String getCover_image_url() {
                return cover_image_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public int getSelling_kk_currency() {
                return selling_kk_currency;
            }

            public void setSelling_kk_currency(int selling_kk_currency) {
                this.selling_kk_currency = selling_kk_currency;
            }

            public int getZoomable() {
                return zoomable;
            }

            public void setZoomable(int zoomable) {
                this.zoomable = zoomable;
            }

            public int getPush_flag() {
                return push_flag;
            }

            public void setPush_flag(int push_flag) {
                this.push_flag = push_flag;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getComic_type() {
                return comic_type;
            }

            public void setComic_type(int comic_type) {
                this.comic_type = comic_type;
            }

            public boolean isIs_liked() {
                return is_liked;
            }

            public void setIs_liked(boolean is_liked) {
                this.is_liked = is_liked;
            }

            public String getLabel_color() {
                return label_color;
            }

            public void setLabel_color(String label_color) {
                this.label_color = label_color;
            }

            public int getStoryboard_cnt() {
                return storyboard_cnt;
            }

            public void setStoryboard_cnt(int storyboard_cnt) {
                this.storyboard_cnt = storyboard_cnt;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getLikes_count() {
                return likes_count;
            }

            public void setLikes_count(int likes_count) {
                this.likes_count = likes_count;
            }

            public int getComments_count() {
                return comments_count;
            }

            public void setComments_count(int comments_count) {
                this.comments_count = comments_count;
            }

            public String getLabel_text() {
                return label_text;
            }

            public void setLabel_text(String label_text) {
                this.label_text = label_text;
            }

            public boolean isIs_free() {
                return is_free;
            }

            public void setIs_free(boolean is_free) {
                this.is_free = is_free;
            }

            public TopicBean getTopic() {
                return topic;
            }

            public void setTopic(TopicBean topic) {
                this.topic = topic;
            }

            public int getShared_count() {
                return shared_count;
            }

            public void setShared_count(int shared_count) {
                this.shared_count = shared_count;
            }

            public String getLabel_text_color() {
                return label_text_color;
            }

            public void setLabel_text_color(String label_text_color) {
                this.label_text_color = label_text_color;
            }

            public int getSerial_no() {
                return serial_no;
            }

            public void setSerial_no(int serial_no) {
                this.serial_no = serial_no;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public static class TopicBean {
                /**
                 * discover_image_url : http://f2.kkmh.com/image/160401/qtglp1ihq.webp-w750
                 * vertical_image_url : http://f2.kkmh.com/image/161214/ic0pkr0jo.webp-w320
                 * cover_image_url : http://f2.kkmh.com/image/160511/chrrrrs4v.webp-w640
                 * description : 少男少女同住一个屋檐下，一同历经青春懵懂和成长烦恼，彼此鼓励、渐生爱意。画风温馨的超人气少女漫，体会青春悸动的纯爱萌芽，这一部就够！【独家/每周二更新，责编：牛奶】
                 * created_at : 1459132969
                 * title : 怦然心动
                 * male_vertical_image_url : http://f2.kkmh.com/image/161214/ic0pkr0jo.webp-w320
                 * updated_at : 1459132969
                 * id : 766
                 * user : {"pub_feed":1,"avatar_url":"http://f2.kkmh.com/image/150421/uelm8ugiz.jpg-w180","grade":1,"nickname":"\u203bkid岁","reg_type":"weibo","id":47124}
                 * label_id : 41
                 * male_cover_image_url : http://f2.kkmh.com/image/160511/chrrrrs4v.webp-w640
                 * order : 500
                 * comics_count : 88
                 * status : published
                 */

                private String discover_image_url;
                private String vertical_image_url;
                private String cover_image_url;
                private String description;
                private int created_at;
                private String title;
                private String male_vertical_image_url;
                private int updated_at;
                private int id;
                private UserBean user;
                private int label_id;
                private String male_cover_image_url;
                private int order;
                private int comics_count;
                private String status;

                public String getDiscover_image_url() {
                    return discover_image_url;
                }

                public void setDiscover_image_url(String discover_image_url) {
                    this.discover_image_url = discover_image_url;
                }

                public String getVertical_image_url() {
                    return vertical_image_url;
                }

                public void setVertical_image_url(String vertical_image_url) {
                    this.vertical_image_url = vertical_image_url;
                }

                public String getCover_image_url() {
                    return cover_image_url;
                }

                public void setCover_image_url(String cover_image_url) {
                    this.cover_image_url = cover_image_url;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getCreated_at() {
                    return created_at;
                }

                public void setCreated_at(int created_at) {
                    this.created_at = created_at;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getMale_vertical_image_url() {
                    return male_vertical_image_url;
                }

                public void setMale_vertical_image_url(String male_vertical_image_url) {
                    this.male_vertical_image_url = male_vertical_image_url;
                }

                public int getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(int updated_at) {
                    this.updated_at = updated_at;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public UserBean getUser() {
                    return user;
                }

                public void setUser(UserBean user) {
                    this.user = user;
                }

                public int getLabel_id() {
                    return label_id;
                }

                public void setLabel_id(int label_id) {
                    this.label_id = label_id;
                }

                public String getMale_cover_image_url() {
                    return male_cover_image_url;
                }

                public void setMale_cover_image_url(String male_cover_image_url) {
                    this.male_cover_image_url = male_cover_image_url;
                }

                public int getOrder() {
                    return order;
                }

                public void setOrder(int order) {
                    this.order = order;
                }

                public int getComics_count() {
                    return comics_count;
                }

                public void setComics_count(int comics_count) {
                    this.comics_count = comics_count;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public static class UserBean {
                    /**
                     * pub_feed : 1
                     * avatar_url : http://f2.kkmh.com/image/150421/uelm8ugiz.jpg-w180
                     * grade : 1
                     * nickname : ※kid岁
                     * reg_type : weibo
                     * id : 47124
                     */

                    private int pub_feed;
                    private String avatar_url;
                    private int grade;
                    private String nickname;
                    private String reg_type;
                    private int id;

                    public int getPub_feed() {
                        return pub_feed;
                    }

                    public void setPub_feed(int pub_feed) {
                        this.pub_feed = pub_feed;
                    }

                    public String getAvatar_url() {
                        return avatar_url;
                    }

                    public void setAvatar_url(String avatar_url) {
                        this.avatar_url = avatar_url;
                    }

                    public int getGrade() {
                        return grade;
                    }

                    public void setGrade(int grade) {
                        this.grade = grade;
                    }

                    public String getNickname() {
                        return nickname;
                    }

                    public void setNickname(String nickname) {
                        this.nickname = nickname;
                    }

                    public String getReg_type() {
                        return reg_type;
                    }

                    public void setReg_type(String reg_type) {
                        this.reg_type = reg_type;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }
                }
            }
        }
    }
}
