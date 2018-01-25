package com.gs.gscartoon.utils;

import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.gs.gscartoon.GsApplication;

import okhttp3.OkHttpClient;

/**
 * Created by camdora on 18-1-24.
 */

public class FrescoUtil {
    private final static String TAG = "FrescoUtil";

    public static ImagePipelineConfig getConfig(){
        OkHttpClient.Builder okHttpClientBuilder = OkHttpUtil.getHeaderOkHttpClientBuilder();
        ImagePipelineConfig imagePipelineConfig = OkHttpImagePipelineConfigFactory.newBuilder(
                GsApplication.getAppContext(),
                okHttpClientBuilder.build())
                .build();
        return imagePipelineConfig;
    }
}
