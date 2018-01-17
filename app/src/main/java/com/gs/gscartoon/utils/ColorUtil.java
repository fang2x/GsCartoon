package com.gs.gscartoon.utils;

import com.gs.gscartoon.GsApplication;

/**
 * Created by camdora on 17-12-14.
 */

public class ColorUtil {
    public static int getColor(int colorId){
        return GsApplication.getAppContext().getResources().getColor(colorId);
    }
}
