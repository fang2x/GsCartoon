package com.gs.gscartoon;

import com.gs.gscartoon.kuaikan.bean.KuaiKanBrowseBean;
import com.gs.gscartoon.kuaikan.bean.KuaiKanListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by camdora on 17-11-21.
 */

public interface RetrofitService {
    @GET("v1/daily/comic_lists/{timestamp}")
    Observable<KuaiKanListBean> refreshKuaiKanList(
            @Path("timestamp") String timestamp, @Query("since") int since);

    @GET("v1/comics/{id}")
    Observable<KuaiKanBrowseBean> refreshKuaiKanBrowse(
            @Path("id") String id);
}
