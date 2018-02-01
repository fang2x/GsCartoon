package com.gs.gscartoon.zhijia.adapter;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.gs.gscartoon.BaseRecyclerAdapter;
import com.gs.gscartoon.BaseRecyclerVH;
import com.gs.gscartoon.R;
import com.squareup.picasso.Picasso;

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

        Picasso.with(mContext).load(mData.get(position)).placeholder(R.drawable.ic_wangyi_default_image_vertical)
                .error(R.drawable.ic_wangyi_default_image_vertical)
                .into(holder.ivBrowse);
    }

    public class ZhiJiaBrowseRecyclerHolder extends BaseRecyclerVH<String> {

        private FrameLayout mFrameLayout;
        private ImageView ivBrowse;

        public ZhiJiaBrowseRecyclerHolder(View itemView) {
            super(itemView);
            mFrameLayout = (FrameLayout) itemView.findViewById(R.id.fl_item_root_view);
            ivBrowse = (ImageView) itemView.findViewById(R.id.iv_browse);
        }
    }
}
