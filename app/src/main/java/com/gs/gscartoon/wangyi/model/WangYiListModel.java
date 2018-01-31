package com.gs.gscartoon.wangyi.model;

import android.content.Context;

import com.gs.gscartoon.RetrofitService;
import com.gs.gscartoon.utils.RetrofitHelper;
import com.gs.gscartoon.wangyi.bean.WangYiListBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by camdora on 17-11-22.
 */

public class WangYiListModel {

    private RetrofitService mRetrofitService;

    public WangYiListModel(Context context){
        this.mRetrofitService = RetrofitHelper.getWangYiInstance(context).getServer();
    }

    public Observable<WangYiListBean> refreshWangYiList(String url){
        return mRetrofitService.refreshWangYiList(url);
    }

    public Observable<WangYiListBean> loadWangYiList(String url){
        return mRetrofitService.loadWangYiList(url);
    }
}
