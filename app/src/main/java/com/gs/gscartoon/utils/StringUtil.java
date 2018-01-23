package com.gs.gscartoon.utils;

import android.content.ClipboardManager;
import android.content.Context;

import com.gs.gscartoon.GsApplication;

import java.text.DecimalFormat;
import java.util.UUID;

/**
 * Created by camdora on 16-12-28. 17:00
 */

public class StringUtil {
    private final static String TAG = "StringUtil";

    public static String formatIpAddress(int ipAdress) {
        return (ipAdress & 0xFF ) + "." +
                ((ipAdress >> 8 ) & 0xFF) + "." +
                ((ipAdress >> 16 ) & 0xFF) + "." +
                ( ipAdress >> 24 & 0xFF) ;
    }

    public static String getPrintSize(long size) {
        //如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义
        if (size < 1024) {
            return String.valueOf(size) + "B";
        } else {
            size = size / 1024;
        }
        //如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位
        //因为还没有到达要使用另一个单位的时候
        //接下去以此类推
        if (size < 1024) {
            return String.valueOf(size) + "KB";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            //因为如果以MB为单位的话，要保留最后1位小数，
            //因此，把此数乘以100之后再取余
            size = size * 100;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "MB";
        } else {
            //否则如果要以GB为单位的，先除于1024再作同样的处理
            size = size * 100 / 1024;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "GB";
        }
    }

    /**
     * 生成唯一标识UUID
     * @return
     */
    public static String getUuid(){
        return UUID.randomUUID().toString();
    }

    /**
     * 实现文本复制功能
     * @param content
     */
    public static void copyText(String content, Context context) {
        // 得到剪贴板管理器
        ClipboardManager cmb = (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
        cmb.setText(content.trim());
    }

    /**
     * 格式化巨大数字显示
     * @param number
     * @return
     */
    public static String getPrintHugeNumber(long number) {
        Context context = GsApplication.getAppContext();
        if (context == null){
            LogUtil.e(TAG,"getPrintPeopleNumber context == null");
            return "";
        }

        String s;
        DecimalFormat format = new DecimalFormat("##.##");
        if(context.getResources().getConfiguration().locale.getCountry().equals("CN")){
            if(number < 10000){
                s = String.valueOf(number);
            }else if(number < 100000000){
                s = format.format(number/10000.0f) + "万";
            }else {
                s = format.format(number/100000000.0f) + "亿";
            }
        }else {
            if (number < 1000){
                s = String.valueOf(number);
            }else if(number < 1000000){
                s = format.format(number/1000.0f) + "K";
            }else {
                s = format.format(number/1000000.0f) + "M";
            }
        }
        return s;
    }

    public static String getPrintHugeNumber(String number) {
        try {
            long i = Long.parseLong(number);
            return getPrintHugeNumber(i);
        }catch (Exception e){
            LogUtil.e(TAG,"getPrintPeopleNumber error "+e.getMessage());
            return "";
        }
    }
}
