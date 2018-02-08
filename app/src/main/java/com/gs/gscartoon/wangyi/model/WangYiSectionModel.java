package com.gs.gscartoon.wangyi.model;

import android.content.Context;

import com.gs.gscartoon.RetrofitService;
import com.gs.gscartoon.utils.RetrofitHelper;
import com.gs.gscartoon.wangyi.bean.WangYiSectionBean;

import io.reactivex.Observable;

/**
 * Created by camdora on 17-11-22.
 */

public class WangYiSectionModel {

    private RetrofitService mRetrofitService;

    public WangYiSectionModel(Context context){
        this.mRetrofitService = RetrofitHelper.getWangYiInstance(context).getServer();
    }

    public Observable<WangYiSectionBean> getWangYiSection(String id){
        return mRetrofitService.getWangYiSection(id);
    }
}
