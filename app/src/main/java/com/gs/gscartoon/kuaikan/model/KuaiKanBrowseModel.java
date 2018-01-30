package com.gs.gscartoon.kuaikan.model;

import android.content.Context;

import com.gs.gscartoon.RetrofitService;
import com.gs.gscartoon.history.bean.HistoryBean;
import com.gs.gscartoon.kuaikan.bean.KuaiKanBrowseBean;
import com.gs.gscartoon.realm.DataHelper;
import com.gs.gscartoon.utils.AppConstants;
import com.gs.gscartoon.utils.RetrofitHelper;

import java.util.Date;

import io.reactivex.Observable;
import io.realm.Realm;

/**
 * Created by camdora on 17-11-22.
 */

public class KuaiKanBrowseModel {

    private Realm realm;
    private RetrofitService mRetrofitService;

    public KuaiKanBrowseModel(Context context){
        this.mRetrofitService = RetrofitHelper.getKuaiKanInstance(context).getServer();
        realm = DataHelper.getRealmInstance();
    }

    public void closeRealm(){
        if(realm == null){
            return;
        }
        realm.close();
    }

    public Observable<KuaiKanBrowseBean> refreshKuaiKanBrowse(String id){
        return mRetrofitService.refreshKuaiKanBrowse(id);
    }

    public void createHistory(KuaiKanBrowseBean.DataBean mDataBean){

        KuaiKanBrowseBean.DataBean.TopicBean mTopicBean = mDataBean.getTopic();
        if(mTopicBean != null){
            String id = AppConstants.KUAI_KAN_INT+"_"+mTopicBean.getId();
            HistoryBean mHistoryBean = DataHelper.getHistoryById(id, true);

            realm.beginTransaction();
            mHistoryBean.setOrigin(AppConstants.KUAI_KAN_INT);
            mHistoryBean.setComicId(mTopicBean.getId());
            mHistoryBean.setChapterId(mDataBean.getId());
            mHistoryBean.setCoverUrl(mDataBean.getCover_image_url());
            mHistoryBean.setComicName(mTopicBean.getTitle());
            mHistoryBean.setChapterTitle(mDataBean.getTitle());
            mHistoryBean.setUpdateTime(new Date());
            realm.commitTransaction();
        }
    }
}
