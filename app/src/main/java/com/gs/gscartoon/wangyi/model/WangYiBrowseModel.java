package com.gs.gscartoon.wangyi.model;

import android.content.Context;

import com.gs.gscartoon.RetrofitService;
import com.gs.gscartoon.history.bean.HistoryBean;
import com.gs.gscartoon.realm.DataHelper;
import com.gs.gscartoon.utils.AppConstants;
import com.gs.gscartoon.utils.RetrofitHelper;
import com.gs.gscartoon.wangyi.bean.WangYiBrowseBean;

import java.util.Date;

import io.reactivex.Observable;
import io.realm.Realm;

/**
 * Created by camdora on 17-11-22.
 */

public class WangYiBrowseModel {

    private Realm realm;
    private RetrofitService mRetrofitService;

    public WangYiBrowseModel(Context context){
        this.mRetrofitService = RetrofitHelper.getWangYiInstance(context).getServer();
        realm = DataHelper.getRealmInstance();
    }

    public void closeRealm(){
        if(realm == null){
            return;
        }
        realm.close();
    }

    public Observable<WangYiBrowseBean> refreshWangYiBrowse(String url){
        return mRetrofitService.refreshWangYiBrowse(url);
    }

    public void createHistory(WangYiBrowseBean mDataBean, String comicTitle, String coverUrl){
        if(mDataBean == null){
            return;
        }

        WangYiBrowseBean.DataBean bean = mDataBean.getData();
        if(bean == null){
            return;
        }

        String id = AppConstants.WANG_YI_INT + "_" + bean.getComicId();
        HistoryBean mHistoryBean = DataHelper.getHistoryById(id, true);

        realm.beginTransaction();
        mHistoryBean.setOrigin(AppConstants.WANG_YI_INT);
        mHistoryBean.setComicId(bean.getComicId());
        mHistoryBean.setChapterId(bean.getChapterId());
        mHistoryBean.setCoverUrl(coverUrl);
        mHistoryBean.setComicName(comicTitle);
        mHistoryBean.setChapterTitle(bean.getTitle());
        mHistoryBean.setUpdateTime(new Date());
        realm.commitTransaction();
    }
}
