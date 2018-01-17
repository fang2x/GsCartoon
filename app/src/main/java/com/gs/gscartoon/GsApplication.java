package com.gs.gscartoon;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by camdora on 16-12-26. 12:00
 */

public class GsApplication extends Application {
    private final static String TAG = "GsApplication";

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        Fresco.initialize(mContext);
    }

    public static Context getAppContext(){
        return mContext;
    }

}
