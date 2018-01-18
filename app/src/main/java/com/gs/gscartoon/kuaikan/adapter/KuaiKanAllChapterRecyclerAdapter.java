package com.gs.gscartoon.kuaikan.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gs.gscartoon.BaseRecyclerAdapter;
import com.gs.gscartoon.BaseRecyclerVH;
import com.gs.gscartoon.R;
import com.gs.gscartoon.kuaikan.bean.KuaiKanAllChapterBean.DataBean.ComicsBean;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.utils.TimeUtil;

/**
 * Created by camdora on 16-12-13.
 */

public class KuaiKanAllChapterRecyclerAdapter extends BaseRecyclerAdapter<ComicsBean,
        KuaiKanAllChapterRecyclerAdapter.KuaiKanAllChapterRecyclerHolder> {

    private Context mContext;

    public KuaiKanAllChapterRecyclerAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_kuai_kan_all_chapter;
    }

    @Override
    protected KuaiKanAllChapterRecyclerHolder createViewHolder(View itemView) {
        KuaiKanAllChapterRecyclerHolder mRecyclerHolder = new KuaiKanAllChapterRecyclerHolder(itemView);
        return mRecyclerHolder;
    }

    @Override
    public void onBindViewHolder(final KuaiKanAllChapterRecyclerHolder holder, int position) {
        ComicsBean bean = mData.get(position);
        if(bean == null){
            LogUtil.e(TAG,"bean==null");
            return;
        }

        holder.sdvCover.setImageURI(Uri.parse(bean.getCover_image_url()));

        holder.tvTitle.setText(bean.getTitle());
        holder.tvTime.setText(TimeUtil.timestampToDate(bean.getCreated_at()));
        holder.tvLike.setText(bean.getLikes_count()+"");
    }

    public class KuaiKanAllChapterRecyclerHolder extends BaseRecyclerVH<ComicsBean> {

        private RelativeLayout mRootView;
        private SimpleDraweeView sdvCover;
        private TextView tvTitle, tvTime, tvLike;

        public KuaiKanAllChapterRecyclerHolder(View itemView) {
            super(itemView);
            mRootView = (RelativeLayout) itemView.findViewById(R.id.rl_item_root_view);
            sdvCover = (SimpleDraweeView) itemView.findViewById(R.id.sdv_cover);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tvLike = (TextView) itemView.findViewById(R.id.tv_like);
        }
    }
}
