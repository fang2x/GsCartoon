package com.gs.gscartoon.wangyi.adapter;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.gs.gscartoon.BaseRecyclerAdapter;
import com.gs.gscartoon.BaseRecyclerVH;
import com.gs.gscartoon.R;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.wangyi.bean.WangYiBrowseBean.DataBean.ImageListBean;
import com.squareup.picasso.Picasso;

/**
 * Created by camdora on 16-12-13.
 */

public class WangYiBrowseRecyclerAdapter extends BaseRecyclerAdapter<ImageListBean,
        WangYiBrowseRecyclerAdapter.WangYiBrowseRecyclerHolder> {

    private Context mContext;

    public WangYiBrowseRecyclerAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_wang_yi_browse;
    }

    @Override
    protected WangYiBrowseRecyclerHolder createViewHolder(View itemView) {
        WangYiBrowseRecyclerHolder mRecyclerHolder = new WangYiBrowseRecyclerHolder(itemView);
        return mRecyclerHolder;
    }

    @Override
    public void onBindViewHolder(final WangYiBrowseRecyclerHolder holder, int position) {
        ImageListBean bean = mData.get(position);
        if(bean == null){
            LogUtil.e(TAG,"bean==null");
            return;
        }

        Picasso.with(mContext).load(bean.getImageUrl()).placeholder(R.drawable.ic_wangyi_default_image_vertical)
                .error(R.drawable.ic_wangyi_default_image_vertical)
                .into(holder.ivBrowse);
    }

    public class WangYiBrowseRecyclerHolder extends BaseRecyclerVH<ImageListBean> {

        private FrameLayout mFrameLayout;
        private ImageView ivBrowse;

        public WangYiBrowseRecyclerHolder(View itemView) {
            super(itemView);
            mFrameLayout = (FrameLayout) itemView.findViewById(R.id.fl_item_root_view);
            ivBrowse = (ImageView) itemView.findViewById(R.id.iv_browse);
        }
    }
}
