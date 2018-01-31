package com.gs.gscartoon;

import com.gs.gscartoon.kuaikan.bean.KuaiKanAllChapterBean;
import com.gs.gscartoon.kuaikan.bean.KuaiKanBrowseBean;
import com.gs.gscartoon.kuaikan.bean.KuaiKanListBean;
import com.gs.gscartoon.wangyi.bean.WangYiCategoryBean;
import com.gs.gscartoon.wangyi.bean.WangYiListBean;
import com.gs.gscartoon.zhijia.bean.ZhiJiaBrowseBean;
import com.gs.gscartoon.zhijia.bean.ZhiJiaDetailsBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by camdora on 17-11-21.
 */

public interface RetrofitService {
    //+++++++++++++++++++++快看+++++++++++++++
    @GET("v1/daily/comic_lists/{timestamp}")
    Observable<KuaiKanListBean> refreshKuaiKanList(
            @Path("timestamp") String timestamp, @Query("since") int since);

    @GET("v1/comics/{id}")
    Observable<KuaiKanBrowseBean> refreshKuaiKanBrowse(
            @Path("id") String id);

    @GET("v1/topics/{id}")
    Observable<KuaiKanAllChapterBean> refreshKuaiKanAllChapter(
            @Path("id") String id);
    //---------------------快看---------------

    //+++++++++++++++++++++动漫之家+++++++++++++++
    @GET("latest/100/0.json")
    Observable<ResponseBody> refreshZhiJiaList();

    @GET("latest/100/{page}.json")
    Observable<ResponseBody> loadZhiJiaList(
            @Path("page") int page);

    @GET("comic/{id}.json")
    Observable<ZhiJiaDetailsBean> getZhiJiaDetails(
            @Path("id") String id);

    @GET("chapter/{comic_id}/{chapter_id}.json")
    Observable<ZhiJiaBrowseBean> refreshZhiJiaBrowse(
            @Path("comic_id") int comic_id, @Path("chapter_id") int chapter_id);
    //---------------------动漫之家---------------

    //+++++++++++++++++++++网易+++++++++++++++
    @GET("navi.json?type=1&gender=1")
    Observable<WangYiCategoryBean> getWangYiCategory();

    @GET
    Observable<WangYiListBean> refreshWangYiList(@Url String url);

    @GET
    Observable<WangYiListBean> loadWangYiList(@Url String url);
    //---------------------网易---------------
}
