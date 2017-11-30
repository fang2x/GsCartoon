package com.gs.gscartoon.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.gs.gscartoon.R;

/**
 * Created by camdora on 17-11-28.
 */

public class ToolbarUtil {
    private static final String TAG = "ToolbarUtil";

    public static void initToolbar(AppCompatActivity context, Toolbar toolbar){
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

    public static void actionBarDrawerToggle(Activity activity, DrawerLayout dlLeftMain, Toolbar tbToolbar){
        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(activity, dlLeftMain, tbToolbar, R.string.open, R.string.close){
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        super.onDrawerOpened(drawerView);
                    }
                    @Override
                    public void onDrawerClosed(View drawerView) {
                        super.onDrawerClosed(drawerView);
                    }
                };
        actionBarDrawerToggle.syncState();
        dlLeftMain.addDrawerListener(actionBarDrawerToggle);
    }
}
