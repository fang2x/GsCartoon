package com.gs.gscartoon.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by camdora on 16-12-16. 14:31
 */

public class TimeUtil {
    private final static String TAG = "TimeUtil";

    /**
     * 计算两个日期型的时间相差多少时间
     * @param startDate  开始日期
     * @param endDate    结束日期
     * @return
     */
    public static String TwoDateDistance(Date startDate, Date endDate){

        if(startDate == null ||endDate == null){
            return null;
        }
        long timeLong = endDate.getTime() - startDate.getTime();
        timeLong = timeLong / 1000;
        if (timeLong < (60)) {
            return timeLong + "秒前";
        }
        else if (timeLong < (60*60)){
            timeLong = timeLong /60;
            return timeLong + "分钟前";
        }
        else if (timeLong < (60*60*24)){
            timeLong = timeLong/60/60;
            return timeLong+"小时前";
        }
        else if (timeLong < (60*60*24*7.0)){
            timeLong = timeLong/ 60 / 60 / 24;
            return timeLong + "天前";
        }
        else if (timeLong< (60*60*24*30.0)){
            timeLong = timeLong/ 60 / 60 / 24 / 7;
            return timeLong + "周前";
        }else if (timeLong < (60*60*24*30*12.0)){
            timeLong = timeLong/ 60 / 60 / 24 / 30;
            return timeLong + "个月前";
        }
        else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
            return sdf.format(startDate);
        }
    }

    /**
     * 字符串转Data对象
     * 服务器返回的时间是:2016-12-14T11:17:46.996Z
     * 所以采用yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
     * @param stringDate
     * @return
     */
    public static Date StringToDate(String stringDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = null;
        try {
            date = sdf.parse(stringDate);
            date = changeTimeZone(date,
                    TimeZone.getTimeZone("GMT"),
                    TimeZone.getDefault());
            //Log.i(TAG,"TimeZone="+TimeZone.getDefault().getDisplayName()+"  date="+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取更改时区后的日期
     * @param date 日期
     * @param oldZone 旧时区对象
     * @param newZone 新时区对象
     * @return 日期
     */
    public static Date changeTimeZone(Date date, TimeZone oldZone, TimeZone newZone) {
        Date dateTmp = null;
        if (date != null) {
            int timeOffset = oldZone.getRawOffset() - newZone.getRawOffset();
            dateTmp = new Date(date.getTime() - timeOffset);
        }
        return dateTmp;
    }

    public static String timestampToDate(Date timestamp){
        return timestampToDate(timestamp.getTime()/1000);
    }

    public static String timestampToDate(Date timestamp, String format){
        return timestampToDate(timestamp.getTime()/1000, format);
    }

    public static String timestampToDate(long timestamp){
        return timestampToDate(timestamp, "yyyy-MM-dd");
    }

    /**
     * 把时间戳转换成特定格式，eg：yyyy-MM-dd
     * @param timestamp 秒
     * @return
     */
    public static String timestampToDate(long timestamp, String format){
        //时间格式,HH是24小时制，hh是AM PM12小时制
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        //比如timestamp=1449210225945；
        long date_temp = Long.valueOf(timestamp);
        String date_string = sdf.format(new Date(date_temp * 1000L));
        //至于取10位或取13位，date_temp*1000L就是这种截取作用。如果是和服务器传值的，就和后台商量好就可以了
        return date_string;
    }

    public static String timestampToHour(Date timestamp){
        return timestampToHour(timestamp.getTime()/1000);
    }

    /**
     * 把时间戳转换成HH:mm
     * @param timestamp 秒
     * @return
     */
    public static String timestampToHour(long timestamp){
        //时间格式,HH是24小时制，hh是AM PM12小时制
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        //比如timestamp=1449210225945；
        long date_temp = Long.valueOf(timestamp);
        String date_string = sdf.format(new Date(date_temp * 1000L));
        //至于取10位或取13位，date_temp*1000L就是这种截取作用。如果是和服务器传值的，就和后台商量好就可以了
        return date_string;
    }

    /**
     * 时长格式化显示
     * @param time 毫秒
     * @return
     */
    public static String generateTime(long time) {
        int totalSeconds = (int) (time / 1000);
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;
        return hours > 0 ? String.format("%02d:%02d:%02d", hours, minutes, seconds)
                : String.format("%02d:%02d", minutes, seconds);
    }

    /**
     * 时长格式化显示
     * @param time 秒
     * @return
     */
    public static String generateTimeForSeconds(long time) {
        long seconds = time % 60;
        long minutes = (time / 60) % 60;
        long hours = time / 3600;
        return hours > 0 ? String.format("%02d:%02d:%02d", hours, minutes, seconds)
                : String.format("%02d:%02d", minutes, seconds);
    }

    public static ArrayList<String> getWeekTimeStamp(){
        ArrayList<String> weekTimeStamp = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        try {
            for (int i = 0; i < 7; i++) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                String hehe = dateFormat.format(calendar.getTime());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                weekTimeStamp.add(sdf.parse(hehe).getTime()/1000+"");
                calendar.add(Calendar.DATE, -1);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return weekTimeStamp;
    }
}
