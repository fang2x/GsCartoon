package com.gs.gscartoon.zhijia.model;

import android.content.Context;

import com.gs.gscartoon.RetrofitService;
import com.gs.gscartoon.utils.RetrofitHelper;
import com.gs.gscartoon.zhijia.bean.ZhiJiaBrowseBean;

import io.reactivex.Observable;

/**
 * Created by camdora on 17-11-22.
 */

public class ZhiJiaBrowseModel {

    private RetrofitService mRetrofitService;

    public ZhiJiaBrowseModel(Context context){
        this.mRetrofitService = RetrofitHelper.getZhiJiaInstance(context).getServer();
    }

    public Observable<ZhiJiaBrowseBean> refreshZhiJiaBrowse(int comicId, int chapterId){
        return mRetrofitService.refreshZhiJiaBrowse(comicId, chapterId);
    }
}
