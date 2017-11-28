package com.gs.gscartoon.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by camdora on 17-11-23.
 */

public class AppInforUtil {
    /**
     * 获取应用的名称
     * @param c
     * @return
     */
    public static String getAppName(Context c) {
        PackageInfo pkgInfo = null;
        try {
            pkgInfo = c.getPackageManager().getPackageInfo(c.getPackageName(), 0);
            //获取应用名
            String appName = pkgInfo.applicationInfo.loadLabel(c.getPackageManager()).toString();
            return appName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 获取当前程序版本名
     * @param c
     * @return
     */
    public static String getAppVersionName(Context c) {
        PackageInfo pkgInfo = null;
        try {
            pkgInfo = c.getPackageManager().getPackageInfo(c.getPackageName(), 0);
            //程序版本名
            String versionName = pkgInfo.versionName;
            return versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 获取当前应用程序的版本号。
     */
    public static int getAppVersionCode(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
