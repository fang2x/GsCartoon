package com.gs.gscartoon.utils;

import android.widget.Toast;

import com.gs.gscartoon.GsApplication;

/**
 * Created by camdora on 17-11-28.
 */

public class ToastUtil {

    public static void showToastShort(int stringId){
        showToastShort(GsApplication.getAppContext().getString(stringId));
    }

    public static void showToastShort(String string){
        Toast.makeText(GsApplication.getAppContext(),string,Toast.LENGTH_SHORT).show();
    }

    public static void showToastLong(int stringId){
        showToastLong(GsApplication.getAppContext().getString(stringId));
    }

    public static void showToastLong(String string){
        Toast.makeText(GsApplication.getAppContext(),string,Toast.LENGTH_LONG).show();
    }
}
