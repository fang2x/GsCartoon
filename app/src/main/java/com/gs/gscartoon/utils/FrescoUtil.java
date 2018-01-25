package com.gs.gscartoon.utils;

import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.gs.gscartoon.GsApplication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by camdora on 18-1-24.
 */

public class FrescoUtil {
    private final static String TAG = "FrescoUtil";

    //zhijia采用https方式，要在Header中增加Referer才能访问
    private final static String ZHI_JIA_COVER_URL = "images.dmzj.com";//封面
    private final static String ZHI_JIA_BROWSE_URL = "imgsmall.dmzj.com";//浏览漫画

    public static ImagePipelineConfig getConfig(){
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        //LogUtil.e(TAG, "Fresco加载图片 "+chain.request().url().host());
                        //只有访问zhijia才添加Header，其他的没有要求
                        if (!chain.request().url().host().equals(ZHI_JIA_COVER_URL) &&
                                !chain.request().url().host().equals(ZHI_JIA_BROWSE_URL)) {
                            return chain.proceed(chain.request());
                        }
                        final Request.Builder requestBuilder = chain.request().newBuilder();
                        requestBuilder.addHeader("Referer", "http://images.dmzj.com/");
                        return chain.proceed(requestBuilder.build());
                    }
                });
        ImagePipelineConfig imagePipelineConfig = OkHttpImagePipelineConfigFactory.newBuilder(
                GsApplication.getAppContext(),
                okHttpClientBuilder.build())
                .build();
        return imagePipelineConfig;
    }
}
