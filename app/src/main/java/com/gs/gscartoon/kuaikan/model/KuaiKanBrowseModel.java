package com.gs.gscartoon.kuaikan.model;

import android.content.Context;

import com.gs.gscartoon.RetrofitService;
import com.gs.gscartoon.kuaikan.bean.KuaiKanBrowseBean;
import com.gs.gscartoon.utils.RetrofitHelper;

import io.reactivex.Observable;

/**
 * Created by camdora on 17-11-22.
 */

public class KuaiKanBrowseModel {

    private RetrofitService mRetrofitService;

    public KuaiKanBrowseModel(Context context){
        this.mRetrofitService = RetrofitHelper.getKuaiKanInstance(context).getServer();
    }

    public Observable<KuaiKanBrowseBean> refreshKuaiKanBrowse(String id){
        return mRetrofitService.refreshKuaiKanBrowse(id);
    }
}
