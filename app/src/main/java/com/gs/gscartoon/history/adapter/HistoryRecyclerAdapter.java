package com.gs.gscartoon.history.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gs.gscartoon.BaseRecyclerAdapter;
import com.gs.gscartoon.BaseRecyclerVH;
import com.gs.gscartoon.R;
import com.gs.gscartoon.history.bean.HistoryBean;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.utils.TimeUtil;

/**
 * Created by camdora on 16-12-13.
 */

public class HistoryRecyclerAdapter extends BaseRecyclerAdapter<HistoryBean,
        HistoryRecyclerAdapter.HistoryRecyclerHolder> {

    private Context mContext;

    public HistoryRecyclerAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_history;
    }

    @Override
    protected HistoryRecyclerHolder createViewHolder(View itemView) {
        HistoryRecyclerHolder mRecyclerHolder = new HistoryRecyclerHolder(itemView);
        return mRecyclerHolder;
    }

    @Override
    public void onBindViewHolder(final HistoryRecyclerHolder holder, int position) {
        HistoryBean bean = mData.get(position);
        if(bean == null){
            LogUtil.e(TAG,"bean==null");
            return;
        }

        holder.sdvCover.setImageURI(Uri.parse(bean.getCoverUrl()));

        holder.mtvTitle.setText(bean.getComicName());
        holder.tvTime.setText(TimeUtil.timestampToDate(bean.getUpdateTime().getTime()/1000, "yyyy-MM-dd hh:mm:ss"));
        //holder.tvLike.setText(bean.getLikes_count()+"");
    }

    private OnItemClickListener clickListener;

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    public class HistoryRecyclerHolder extends BaseRecyclerVH<HistoryBean>
            implements View.OnClickListener{

        private RelativeLayout mRootView;
        private SimpleDraweeView sdvCover;
        private TextView mtvTitle, tvTime, tvLike;

        public HistoryRecyclerHolder(View itemView) {
            super(itemView);
            mRootView = (RelativeLayout) itemView.findViewById(R.id.rl_item_root_view);
            sdvCover = (SimpleDraweeView) itemView.findViewById(R.id.sdv_cover);
            mtvTitle = (TextView) itemView.findViewById(R.id.mtv_title);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tvLike = (TextView) itemView.findViewById(R.id.tv_like);

            mRootView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                switch (v.getId()) {
                    case R.id.rl_item_root_view:
                        clickListener.onClick(itemView, getAdapterPosition());
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
