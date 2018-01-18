package com.gs.gscartoon.kuaikan.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gs.gscartoon.BaseRecyclerAdapter;
import com.gs.gscartoon.BaseRecyclerVH;
import com.gs.gscartoon.R;

/**
 * Created by camdora on 16-12-13.
 */

public class KuaiKanBrowseRecyclerAdapter extends BaseRecyclerAdapter<String,
        KuaiKanBrowseRecyclerAdapter.KuaiKanBrowseRecyclerHolder> {

    private Context mContext;

    public KuaiKanBrowseRecyclerAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_kuai_kan_browse;
    }

    @Override
    protected KuaiKanBrowseRecyclerHolder createViewHolder(View itemView) {
        KuaiKanBrowseRecyclerHolder mRecyclerHolder = new KuaiKanBrowseRecyclerHolder(itemView);
        return mRecyclerHolder;
    }

    @Override
    public void onBindViewHolder(final KuaiKanBrowseRecyclerHolder holder, int position) {
        holder.sdvBrowse.setImageURI(Uri.parse(mData.get(position)));
    }

    public class KuaiKanBrowseRecyclerHolder extends BaseRecyclerVH<String> {

        private FrameLayout mFrameLayout;
        private SimpleDraweeView sdvBrowse;

        public KuaiKanBrowseRecyclerHolder(View itemView) {
            super(itemView);
            mFrameLayout = (FrameLayout) itemView.findViewById(R.id.fl_item_root_view);
            sdvBrowse = (SimpleDraweeView) itemView.findViewById(R.id.sdv_browse);
        }
    }
}
