package com.gs.gscartoon.wangyi.model;

import android.content.Context;

import com.gs.gscartoon.RetrofitService;
import com.gs.gscartoon.utils.RetrofitHelper;
import com.gs.gscartoon.wangyi.bean.WangYiCategoryBean;

import io.reactivex.Observable;

/**
 * Created by camdora on 17-11-22.
 */

public class WangYiModel {

    private RetrofitService mRetrofitService;

    public WangYiModel(Context context){
        this.mRetrofitService = RetrofitHelper.getWangYiInstance(context).getServer();
    }

    public Observable<WangYiCategoryBean> getWangYiCategory(){
        return mRetrofitService.getWangYiCategory();
    }
}
