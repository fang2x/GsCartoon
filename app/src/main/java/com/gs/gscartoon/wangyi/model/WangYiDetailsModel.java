package com.gs.gscartoon.wangyi.model;

import android.content.Context;

import com.gs.gscartoon.RetrofitService;
import com.gs.gscartoon.utils.RetrofitHelper;
import com.gs.gscartoon.wangyi.bean.WangYiDetailsBean;
import com.gs.gscartoon.zhijia.bean.ZhiJiaDetailsBean;

import io.reactivex.Observable;

/**
 * Created by camdora on 17-11-22.
 */

public class WangYiDetailsModel {

    private RetrofitService mRetrofitService;

    public WangYiDetailsModel(Context context){
        this.mRetrofitService = RetrofitHelper.getWangYiInstance(context).getServer();
    }

    public Observable<WangYiDetailsBean> getWangYiDetails(String id){
        return mRetrofitService.getWangYiDetails(id);
    }
}
