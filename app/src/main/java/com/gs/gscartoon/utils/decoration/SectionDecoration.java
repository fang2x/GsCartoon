package com.gs.gscartoon.utils.decoration;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;

import com.gs.gscartoon.R;
import com.gs.gscartoon.utils.LogUtil;

/**
 * Created by camdora on 18-2-2.
 */

public class SectionDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = "SectionDecoration";

    private DecorationCallback callback;
    private TextPaint textPaint;
    private Paint paint;
    private int topGap;
    private Paint.FontMetrics fontMetrics;

    public SectionDecoration(Context context, DecorationCallback decorationCallback) {
        Resources res = context.getResources();
        this.callback = decorationCallback;

        paint = new Paint();
        paint.setColor(res.getColor(R.color.colorAccent));

        textPaint = new TextPaint();
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(80);
        textPaint.setColor(Color.BLACK);
        textPaint.getFontMetrics(fontMetrics);
        textPaint.setTextAlign(Paint.Align.LEFT);
        fontMetrics = new Paint.FontMetrics();
        topGap = res.getDimensionPixelSize(R.dimen.sectioned_top);//32dp
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int pos = parent.getChildAdapterPosition(view);
        //LogUtil.i(TAG, "getItemOffsets：" + pos);
        String groupId = callback.getGroupId(pos);
        if (TextUtils.isEmpty(groupId)) {
            return;
        }
        if (pos == 0 || isFirstInGroup(pos)) {//同组的第一个才添加padding
            outRect.top = topGap;
        } else {
            outRect.top = 0;
        }
    }

    /*
    //没有粘性的　section标签头
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        //LogUtil.e(TAG, "onDraw childCount="+childCount);
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(view);
            String groupId = callback.getGroupId(position);
            if (TextUtils.isEmpty(groupId)) {
                return;
            }
            String textLine = callback.getGroupFirstLine(position);
            if (position == 0 || isFirstInGroup(position)) {
                float top = view.getTop() - topGap;
                float bottom = view.getTop();
                c.drawRect(left, top, right, bottom, paint);//绘制红色矩形
                c.drawText(textLine, left, bottom, textPaint);//绘制文本
            }
        }
    }*/

    //StickyHeader 粘性头部 英文也有叫 pinned section
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int itemCount = state.getItemCount();
        int childCount = parent.getChildCount();
        float lineHeight = textPaint.getTextSize() + fontMetrics.descent;

        String preGroupId = null, groupId = null;
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(view);

            preGroupId = groupId;
            groupId = callback.getGroupId(position);
            if (TextUtils.isEmpty(groupId) || groupId.equals(preGroupId)){
                //LogUtil.e(TAG,"两组的id一样");
                continue;
            }

            String textLine = callback.getGroupFirstLine(position);
            if (TextUtils.isEmpty(textLine)){
                continue;
            }

            int viewBottom = view.getBottom();
            float textY = Math.max(topGap, view.getTop());
            //LogUtil.e(TAG, " position="+position+" viewBottom="+viewBottom+" viewTop="+view.getTop());
            if (position + 1 < itemCount) { //下一个和当前不一样移动当前
                String nextGroupId = callback.getGroupId(position + 1);
                if (!nextGroupId .equals(groupId) && viewBottom < textY ) {//组内最后一个view进入了header
                    textY = viewBottom;
                }
            }
            c.drawRect(left, textY - topGap, right, textY, paint);
            c.drawText(textLine, left, textY, textPaint);
        }
    }

    private boolean isFirstInGroup(int pos) {
        if (pos == 0) {
            return true;
        } else {
            String prevGroupId = callback.getGroupId(pos - 1);
            String groupId = callback.getGroupId(pos);
            return !prevGroupId.equals(groupId);//不相等表示不是一个组的
        }
    }

    public interface DecorationCallback {

        String getGroupId(int position);

        String getGroupFirstLine(int position);
    }
}
