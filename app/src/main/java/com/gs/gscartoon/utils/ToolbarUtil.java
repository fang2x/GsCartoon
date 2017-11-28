package com.gs.gscartoon.utils;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by camdora on 17-11-28.
 */

public class ToolbarUtil {
    private static final String TAG = "ToolbarUtil";

    public static void InitToolbar(AppCompatActivity context, Toolbar toolbar){
        context.setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = context.getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        int compatPaddingTop = 0;
        // android 4.4以上将Toolbar添加状态栏高度的上边距，沉浸到状态栏下方
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            compatPaddingTop = DisplayUtil.getStatusBarHeight();
        }
        toolbar.setPadding(toolbar.getPaddingLeft(),
                toolbar.getPaddingTop() + compatPaddingTop,
                toolbar.getPaddingRight(),
                toolbar.getPaddingBottom());
    }
}
