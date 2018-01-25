package com.gs.gscartoon.zhijia.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gs.gscartoon.BaseRecyclerAdapter;
import com.gs.gscartoon.BaseRecyclerVH;
import com.gs.gscartoon.R;
import com.gs.gscartoon.utils.LogUtil;

/**
 * Created by camdora on 16-12-13.
 */

public class ZhiJiaBrowseRecyclerAdapter extends BaseRecyclerAdapter<String,
        ZhiJiaBrowseRecyclerAdapter.ZhiJiaBrowseRecyclerHolder> {

    private Context mContext;

    public ZhiJiaBrowseRecyclerAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_zhi_jia_browse;
    }

    @Override
    protected ZhiJiaBrowseRecyclerHolder createViewHolder(View itemView) {
        ZhiJiaBrowseRecyclerHolder mRecyclerHolder = new ZhiJiaBrowseRecyclerHolder(itemView);
        return mRecyclerHolder;
    }

    @Override
    public void onBindViewHolder(final ZhiJiaBrowseRecyclerHolder holder, int position) {
        LogUtil.e(TAG,"1111 "+mData.get(position));
        holder.sdvBrowse.setImageURI(Uri.parse(mData.get(position)));
    }

    public class ZhiJiaBrowseRecyclerHolder extends BaseRecyclerVH<String> {

        private FrameLayout mFrameLayout;
        private SimpleDraweeView sdvBrowse;

        public ZhiJiaBrowseRecyclerHolder(View itemView) {
            super(itemView);
            mFrameLayout = (FrameLayout) itemView.findViewById(R.id.fl_item_root_view);
            sdvBrowse = (SimpleDraweeView) itemView.findViewById(R.id.sdv_browse);
        }
    }
}
