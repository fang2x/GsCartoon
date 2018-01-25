package com.gs.gscartoon.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by camdora on 18-1-25.
 */

public class OkHttpUtil {
    private final static String TAG = "OkHttpUtil";

    //zhijia采用https方式，要在Header中增加Referer才能访问
    private final static String ZHI_JIA_COVER_URL = "images.dmzj.com";//封面
    private final static String ZHI_JIA_BROWSE_URL = "imgsmall.dmzj.com";//浏览漫画

    public static OkHttpClient.Builder getHeaderOkHttpClientBuilder(){
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        //LogUtil.e(TAG, "OkHttpClient访问的路径 "+chain.request().url().host());
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

        return okHttpClientBuilder;
    }
}
