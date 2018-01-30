package com.gs.gscartoon.zhijia.model;

import android.content.Context;

import com.gs.gscartoon.RetrofitService;
import com.gs.gscartoon.history.bean.HistoryBean;
import com.gs.gscartoon.realm.DataHelper;
import com.gs.gscartoon.utils.AppConstants;
import com.gs.gscartoon.utils.RetrofitHelper;
import com.gs.gscartoon.zhijia.bean.ZhiJiaBrowseBean;

import java.util.Date;

import io.reactivex.Observable;
import io.realm.Realm;

/**
 * Created by camdora on 17-11-22.
 */

public class ZhiJiaBrowseModel {

    private Realm realm;
    private RetrofitService mRetrofitService;

    public ZhiJiaBrowseModel(Context context){
        this.mRetrofitService = RetrofitHelper.getZhiJiaInstance(context).getServer();
        realm = DataHelper.getRealmInstance();
    }

    public void closeRealm(){
        if(realm == null){
            return;
        }
        realm.close();
    }

    public Observable<ZhiJiaBrowseBean> refreshZhiJiaBrowse(int comicId, int chapterId){
        return mRetrofitService.refreshZhiJiaBrowse(comicId, chapterId);
    }

    public void createHistory(ZhiJiaBrowseBean mDataBean, String comicTitle, String coverUrl){

        String id = AppConstants.ZHI_JIA_INT + "_" + mDataBean.getComic_id();
        HistoryBean mHistoryBean = DataHelper.getHistoryById(id, true);

        realm.beginTransaction();
        mHistoryBean.setOrigin(AppConstants.ZHI_JIA_INT);
        mHistoryBean.setComicId(mDataBean.getComic_id());
        mHistoryBean.setChapterId(mDataBean.getChapter_id());
        mHistoryBean.setCoverUrl(coverUrl);
        mHistoryBean.setComicName(comicTitle);
        mHistoryBean.setChapterTitle(mDataBean.getTitle());
        mHistoryBean.setUpdateTime(new Date());
        realm.commitTransaction();
    }
}
