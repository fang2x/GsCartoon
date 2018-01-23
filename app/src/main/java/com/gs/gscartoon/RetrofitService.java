package com.gs.gscartoon;

import com.gs.gscartoon.kuaikan.bean.KuaiKanAllChapterBean;
import com.gs.gscartoon.kuaikan.bean.KuaiKanBrowseBean;
import com.gs.gscartoon.kuaikan.bean.KuaiKanListBean;
import com.gs.gscartoon.zhijia.bean.ZhiJiaListBean;
import com.gs.gscartoon.zhijia.bean.ZhiJiaResult;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
    //---------------------动漫之家---------------
}
