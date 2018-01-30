package com.gs.gscartoon.realm;


import com.gs.gscartoon.utils.LogUtil;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by yinjianfeng on 16/12/6.
 */

public class DataHelper {
    public final static String TAG = "DataHelper";

    //realm数据库名字
    public final static String REALM_NAME = "GsCartoonRealm.realm";

    /**
     * 得到数据库实例
     * @return
     */
    public static Realm getRealmInstance(){
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(DataHelper.REALM_NAME)
                .schemaVersion(Migration.REALM_VERSION) // Must be bumped when the schema changes
                .migration(new Migration()) // Migration to run instead of throwing an exception
                .build();

        Realm realm = null;
        try {
            realm = Realm.getInstance(config);
        } catch (Exception e) {
            LogUtil.e(TAG,"Realm数据库出错："+e.getMessage());
            return realm;
        }
        return realm;
    }
}