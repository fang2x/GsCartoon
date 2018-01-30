
package com.gs.gscartoon.utils;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.gs.gscartoon.history.adapter.HistoryRecyclerAdapter;
import com.loopeer.itemtouchhelperextension.ItemTouchHelperExtension;

/**
 * itemtouchhelperextension开源库，实现item左滑显示菜单
 */
public class ItemTouchHelperCallback extends ItemTouchHelperExtension.Callback {

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(0, ItemTouchHelper.START);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

        if (viewHolder instanceof HistoryRecyclerAdapter.HistoryRecyclerHolder) {
            HistoryRecyclerAdapter.HistoryRecyclerHolder holder =
                    (HistoryRecyclerAdapter.HistoryRecyclerHolder) viewHolder;
            holder.mRootView.setTranslationX(dX);
        }
    }
}
