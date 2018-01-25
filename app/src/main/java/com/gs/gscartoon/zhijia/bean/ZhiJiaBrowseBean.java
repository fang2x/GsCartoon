package com.gs.gscartoon.zhijia.bean;

import java.util.List;

/**
 * Created by camdora on 18-1-24.
 */

public class ZhiJiaBrowseBean {

    /**
     * chapter_id : 72489
     * comic_id : 40525
     * title : 第05话
     * chapter_order : 50
     * direction : 1
     * page_url : ["http://imgsmall.dmzj.com/l/40525/72489/0.jpg","http://imgsmall.dmzj.com/l/40525/72489/1.jpg","http://imgsmall.dmzj.com/l/40525/72489/2.jpg","http://imgsmall.dmzj.com/l/40525/72489/3.jpg","http://imgsmall.dmzj.com/l/40525/72489/4.jpg","http://imgsmall.dmzj.com/l/40525/72489/5.jpg","http://imgsmall.dmzj.com/l/40525/72489/6.jpg","http://imgsmall.dmzj.com/l/40525/72489/7.jpg","http://imgsmall.dmzj.com/l/40525/72489/8.jpg","http://imgsmall.dmzj.com/l/40525/72489/9.jpg","http://imgsmall.dmzj.com/l/40525/72489/10.jpg","http://imgsmall.dmzj.com/l/40525/72489/11.jpg","http://imgsmall.dmzj.com/l/40525/72489/12.jpg","http://imgsmall.dmzj.com/l/40525/72489/13.jpg","http://imgsmall.dmzj.com/l/40525/72489/14.jpg","http://imgsmall.dmzj.com/l/40525/72489/15.jpg","http://imgsmall.dmzj.com/l/40525/72489/16.jpg","http://imgsmall.dmzj.com/l/40525/72489/17.jpg","http://imgsmall.dmzj.com/l/40525/72489/18.jpg","http://imgsmall.dmzj.com/l/40525/72489/19.jpg","http://imgsmall.dmzj.com/l/40525/72489/20.jpg","http://imgsmall.dmzj.com/l/40525/72489/21.jpg","http://imgsmall.dmzj.com/l/40525/72489/22.jpg","http://imgsmall.dmzj.com/l/40525/72489/23.jpg","http://imgsmall.dmzj.com/l/40525/72489/24.jpg"]
     * picnum : 25
     * comment_count : 19
     */

    private int chapter_id;
    private int comic_id;
    private String title;
    private int chapter_order;
    private int direction;
    private int picnum;
    private int comment_count;
    private List<String> page_url;

    public int getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(int chapter_id) {
        this.chapter_id = chapter_id;
    }

    public int getComic_id() {
        return comic_id;
    }

    public void setComic_id(int comic_id) {
        this.comic_id = comic_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getChapter_order() {
        return chapter_order;
    }

    public void setChapter_order(int chapter_order) {
        this.chapter_order = chapter_order;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getPicnum() {
        return picnum;
    }

    public void setPicnum(int picnum) {
        this.picnum = picnum;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public List<String> getPage_url() {
        return page_url;
    }

    public void setPage_url(List<String> page_url) {
        this.page_url = page_url;
    }
}
