package com.gs.gscartoon;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.gs.gscartoon.utils.FrescoUtil;

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

        ImagePipelineConfig imagePipelineConfig = FrescoUtil.getConfig();
        if(imagePipelineConfig == null){
            Fresco.initialize(mContext);
        }else {
            Fresco.initialize(mContext, imagePipelineConfig);
        }
    }

    public static Context getAppContext(){
        return mContext;
    }

}
