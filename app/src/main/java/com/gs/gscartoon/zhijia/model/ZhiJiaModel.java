package com.gs.gscartoon.zhijia.model;

import android.content.Context;

import com.gs.gscartoon.RetrofitService;
import com.gs.gscartoon.utils.RetrofitHelper;
import com.gs.gscartoon.zhijia.bean.ZhiJiaListBean;
import com.gs.gscartoon.zhijia.bean.ZhiJiaResult;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by camdora on 17-11-22.
 */

public class ZhiJiaModel {

    private RetrofitService mRetrofitService;

    public ZhiJiaModel(Context context){
        this.mRetrofitService = RetrofitHelper.getZhiJiaInstance(context).getServer();
    }

    public Observable<ResponseBody> refreshZhiJiaList(){
        return mRetrofitService.refreshZhiJiaList();
    }

    public Observable<ResponseBody> loadZhiJiaList(int page){
        return mRetrofitService.loadZhiJiaList(page);
    }
}
