package com.gs.gscartoon.kuaikan.model;

import android.content.Context;

import com.gs.gscartoon.RetrofitService;
import com.gs.gscartoon.kuaikan.bean.KuaiKanAllChapterBean;
import com.gs.gscartoon.utils.RetrofitHelper;

import io.reactivex.Observable;

/**
 * Created by camdora on 17-11-22.
 */

public class KuaiKanAllChapterModel {

    private RetrofitService mRetrofitService;

    public KuaiKanAllChapterModel(Context context){
        this.mRetrofitService = RetrofitHelper.getKuaiKanInstance(context).getServer();
    }

    public Observable<KuaiKanAllChapterBean> refreshKuaiKanAllChapter(String id){
        return mRetrofitService.refreshKuaiKanAllChapter(id);
    }
}
