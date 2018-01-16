package com.gs.gscartoon;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by bulong on 16/12/6.
 */

public abstract class BaseRecyclerVH<T> extends RecyclerView.ViewHolder {
    public BaseRecyclerVH(View itemView) {
        super(itemView);
    }
}
