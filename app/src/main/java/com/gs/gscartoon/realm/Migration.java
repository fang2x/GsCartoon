package com.gs.gscartoon.realm;

import com.gs.gscartoon.utils.LogUtil;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

/**
 * Created by camdora on 17-1-21. 12:22
 */

public class Migration implements RealmMigration {
    private final static String TAG = "Migration";

    public final static int REALM_VERSION = 0;

    @Override
    public void migrate(final DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();
        LogUtil.i(TAG,"数据库版本 oldVersion="+oldVersion+" newVersion="+newVersion);

        /************************************************
         HousingInforRealmBean 增加pagelink coverUrl字段
         ************************************************/

        // Migrate from version 0 to version 1
        /*if (oldVersion == 0) {
            RealmObjectSchema realmObjectSchema = schema.get("HousingInforRealmBean");
            realmObjectSchema
                    .addField("pagelink", String.class)
                    .addField("coverUrl", String.class);

            oldVersion++;
        }*/
    }

    @Override
    public int hashCode() {
        return Migration.class.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if(object == null) {
            return false;
        }
        return object instanceof Migration;
    }
}
