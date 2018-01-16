package com.gs.gscartoon.utils;

import android.content.Context;

import com.gs.gscartoon.BuildConfig;
import com.gs.gscartoon.RetrofitService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by camdora on 17-11-21.
 */

public class RetrofitHelper {
    private static final String TAG = "RetrofitHelper";

    private static RetrofitHelper instance = null;
    private static RetrofitHelper mKuaiKanInstance = null;
    private static RetrofitHelper mZhiJiaInstance = null;
    private static RetrofitHelper mManManInstance = null;
    private Context mContext;

    private Retrofit mRetrofit = null;

    private RetrofitHelper(Context context){
        this.mContext = context;
        resetAppRetrofit(AppConstants.BASE_URL);
    }

    private RetrofitHelper(Context context, String url){
        this.mContext = context;
        resetAppRetrofit(url);
    }

    /**
     * DCL单例模式
     * @param context
     * @return
     */
    public static RetrofitHelper getInstance(Context context){
        if (instance == null){
            synchronized (RetrofitHelper.class){
                if(instance == null){
                    instance = new RetrofitHelper(context);
                }
            }
        }
        return instance;
    }

    public static RetrofitHelper getKuaiKanInstance(Context context){
        if (mKuaiKanInstance == null){
            synchronized (RetrofitHelper.class){
                if(mKuaiKanInstance == null){
                    mKuaiKanInstance = new RetrofitHelper(context, AppConstants.KUAI_KAN_URL);
                }
            }
        }
        return mKuaiKanInstance;
    }

    public static RetrofitHelper getZhiJiaInstance(Context context){
        if (mZhiJiaInstance == null){
            synchronized (RetrofitHelper.class){
                if(mZhiJiaInstance == null){
                    mZhiJiaInstance = new RetrofitHelper(context, AppConstants.ZHI_JIA_URL);
                }
            }
        }
        return mZhiJiaInstance;
    }

    public static RetrofitHelper getManManInstance(Context context){
        if (mManManInstance == null){
            synchronized (RetrofitHelper.class){
                if(mManManInstance == null){
                    mManManInstance = new RetrofitHelper(context, AppConstants.MAN_MAN_URL);
                }
            }
        }
        return mManManInstance;
    }

    private void resetAppRetrofit(String url) {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request.Builder builder = chain.request().newBuilder();
                builder.addHeader("X-Device-Type", "android");
                Request request = builder.build();
                return chain.proceed(request);
            }
        });

        if (BuildConfig.ENABLE_DEBUG) {
            builder.addNetworkInterceptor(new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY));
        }

        mRetrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public RetrofitService getServer(){
        return mRetrofit.create(RetrofitService.class);
    }
}
