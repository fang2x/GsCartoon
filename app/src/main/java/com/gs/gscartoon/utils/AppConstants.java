package com.gs.gscartoon.utils;

/**
 * Created by camdora on 17-11-22.
 */

public class AppConstants {
    //++++++++++++字符串常量++++++++++++
    public static final String BASE_URL = "";//访问服务器地址
    public static final String KUAI_KAN_URL = "http://api.kuaikanmanhua.com/";//快看访问服务器地址
    public static final String ZHI_JIA_URL = "http://v2.api.dmzj.com/";//动漫之家访问服务器地址
    public static final String MAN_MAN_URL = "";//漫漫访问服务器地址
    public static final String WANG_YI_URL = "https://api.mh.163.com/";//网易访问服务器地址
    //------------字符串常量------------

    //++++++++++++Activity传递数据　key ++++++++++++
    public static final String URL = "url";//链接地址
    public static final String TIMESTAMP = "timestamp";//时间戳
    public static final String CHAPTER_ID = "ChapterId";//某一话漫画id
    public static final String COMIC_ID = "ComicId";//漫画id
    public static final String COMIC_TITLE = "ComicTitle";//漫画Title
    public static final String COVER_URL = "CoverUrl";//封面url
    public static final String ZHI_JIA_COVER_BITMAP = "ZhiJiaCoverBitmap";
    //------------Activity传递数据　key ------------

    //++++++++++++int常量++++++++++++
    public static final int ASC = 100001;//正序
    public static final int DESC = 100002;//倒序

    public static final int KUAI_KAN_INT = 900001;//快看
    public static final int ZHI_JIA_INT = 900002;//之家
    public static final int WANG_YI_INT = 900003;//网易
    public static final int MAN_MAN_INT = 900004;//漫漫
    public static final int TENG_XUN_INT = 900005;//腾讯

    public static final int HISTORY_LIMIT = 1000;//历史记录上限
    //------------int串常量------------
}
