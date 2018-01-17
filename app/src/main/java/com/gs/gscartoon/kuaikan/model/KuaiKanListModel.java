package com.gs.gscartoon.kuaikan.model;

import android.content.Context;

import com.gs.gscartoon.RetrofitService;
import com.gs.gscartoon.kuaikan.bean.KuaiKanListBean;
import com.gs.gscartoon.utils.RetrofitHelper;

import io.reactivex.Observable;

/**
 * Created by camdora on 17-11-22.
 */

public class KuaiKanListModel {

    private RetrofitService mRetrofitService;

    public KuaiKanListModel(Context context){
        this.mRetrofitService = RetrofitHelper.getKuaiKanInstance(context).getServer();
    }

    public Observable<KuaiKanListBean> refreshKuaiKanList(String timestamp){
        return mRetrofitService.refreshKuaiKanList(timestamp, 0);
    }
}
