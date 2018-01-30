package com.gs.gscartoon.history.model;

import android.content.Context;

import com.gs.gscartoon.RetrofitService;
import com.gs.gscartoon.history.bean.HistoryBean;
import com.gs.gscartoon.realm.DataHelper;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.utils.RetrofitHelper;

import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.Sort;

/**
 * Created by camdora on 17-11-22.
 */

public class HistoryModel {
    private static final String TAG = "HistoryModel";

    private Realm realm;

    public HistoryModel(Context context){
        realm = DataHelper.getRealmInstance();
    }

    public void closeRealm(){
        if(realm == null){
            return;
        }
        realm.close();
    }

    public List<HistoryBean> refreshHistory(){
        return realm.where(HistoryBean.class)
                .findAll().sort("updateTime", Sort.DESCENDING);
    }

    public boolean deleteHistory(String id){
        boolean result = true;
        HistoryBean bean = DataHelper.getHistoryById(id, false);
        if(bean == null) {
            LogUtil.e(TAG, "bean == null");
            return false;
        }

        realm.beginTransaction();
        bean.deleteFromRealm();
        realm.commitTransaction();

        return result;
    }
}
