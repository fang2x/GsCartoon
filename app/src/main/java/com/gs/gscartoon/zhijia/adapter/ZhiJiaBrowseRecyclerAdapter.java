package com.gs.gscartoon.zhijia.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gs.gscartoon.BaseRecyclerAdapter;
import com.gs.gscartoon.BaseRecyclerVH;
import com.gs.gscartoon.R;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.utils.OkHttpUtil;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;

/**
 * Created by camdora on 16-12-13.
 */

public class ZhiJiaBrowseRecyclerAdapter extends BaseRecyclerAdapter<String,
        ZhiJiaBrowseRecyclerAdapter.ZhiJiaBrowseRecyclerHolder> {

    private Context mContext;
    private Picasso mPicasso;

    public ZhiJiaBrowseRecyclerAdapter(Context context) {
        super(context);
        mContext = context;

        OkHttpClient okHttpClient = OkHttpUtil.getHeaderOkHttpClientBuilder().build();
        mPicasso = new Picasso.Builder(mContext)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();
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

        mPicasso.load(mData.get(position)).placeholder(R.drawable.ic_kuaikan_default_image_vertical)
                .error(R.drawable.ic_kuaikan_default_image_vertical)
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
