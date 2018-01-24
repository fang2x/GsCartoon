package com.gs.gscartoon.zhijia.model;

import android.content.Context;

import com.gs.gscartoon.RetrofitService;
import com.gs.gscartoon.utils.RetrofitHelper;
import com.gs.gscartoon.zhijia.bean.ZhiJiaDetailsBean;

import io.reactivex.Observable;

/**
 * Created by camdora on 17-11-22.
 */

public class ZhiJiaDetailsModel {

    private RetrofitService mRetrofitService;

    public ZhiJiaDetailsModel(Context context){
        this.mRetrofitService = RetrofitHelper.getZhiJiaInstance(context).getServer();
    }

    public Observable<ZhiJiaDetailsBean> getZhiJiaDetails(String id){
        return mRetrofitService.getZhiJiaDetails(id);
    }
}
