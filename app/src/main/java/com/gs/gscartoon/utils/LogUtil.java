package com.gs.gscartoon.utils;

import android.util.Log;

import com.gs.gscartoon.BuildConfig;


/**
 * Created by camdora on 17-3-31. 15:47
 */

public class LogUtil {

    public static void v(String tag, String message){
        if(BuildConfig.ENABLE_DEBUG){
            Log.v(tag, message);
        }
    }

    public static void d(String tag, String message){
        if(BuildConfig.ENABLE_DEBUG){
            Log.d(tag, message);
        }
    }

    public static void i(String tag, String message){
        if(BuildConfig.ENABLE_DEBUG){
            Log.i(tag, message);
        }
    }

    public static void w(String tag, String message){
        if(BuildConfig.ENABLE_DEBUG){
            Log.w(tag, message);
        }
    }

    public static void w(String tag, String message, Throwable throwable){
        if(BuildConfig.ENABLE_DEBUG){
            Log.w(tag, message, throwable);
        }
    }

    public static void e(String tag, String message){
        if(BuildConfig.ENABLE_DEBUG){
            Log.e(tag, message);
        }
    }

    public static void e(String tag, String message, Throwable throwable){
        if(BuildConfig.ENABLE_DEBUG){
            Log.e(tag, message, throwable);
        }
    }

    /**
     * 分段打印出较长log文本
     * @param log        原log文本
     * @param showCount  规定每段显示的长度（最好不要超过eclipse限制长度）
     */
    public static void showLogCompletion(String log, int showCount){
        if(log.length() >showCount){
            String show = log.substring(0, showCount);
            //          System.out.println(show);
            Log.i("TAG", show+"");
            if((log.length() - showCount)>showCount){//剩下的文本还是大于规定长度
                String partLog = log.substring(showCount,log.length());
                showLogCompletion(partLog, showCount);
            }else{
                String surplusLog = log.substring(showCount, log.length());
                //              System.out.println(surplusLog);
                Log.i("TAG", surplusLog+"");
            }

        }else{
            //          System.out.println(log);
            Log.i("TAG", log+"");
        }
    }
}
