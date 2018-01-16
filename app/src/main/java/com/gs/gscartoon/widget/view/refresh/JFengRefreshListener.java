package com.gs.gscartoon.widget.view.refresh;

import android.support.v4.widget.SwipeRefreshLayout;

/**
 * Created by yinjianfeng on 16/12/6.
 */

public interface JFengRefreshListener extends SwipeRefreshLayout.OnRefreshListener {
    void onLoad();
}
