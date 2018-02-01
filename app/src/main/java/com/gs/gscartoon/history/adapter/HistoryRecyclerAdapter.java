package com.gs.gscartoon.history.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gs.gscartoon.BaseRecyclerAdapter;
import com.gs.gscartoon.BaseRecyclerVH;
import com.gs.gscartoon.R;
import com.gs.gscartoon.history.bean.HistoryBean;
import com.gs.gscartoon.utils.AppConstants;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.utils.PicassoRoundTransform;
import com.gs.gscartoon.utils.TimeUtil;
import com.loopeer.itemtouchhelperextension.Extension;
import com.squareup.picasso.Picasso;

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
        return R.layout.item_history_main;
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

        //holder.sdvCover.setImageURI(Uri.parse(bean.getCoverUrl()));
        Picasso.with(mContext).load(bean.getCoverUrl()).placeholder(R.drawable.ic_wangyi_default_image_vertical)
                .error(R.drawable.ic_wangyi_default_image_vertical)
                .transform(new PicassoRoundTransform(7))
                .config(Bitmap.Config.RGB_565)
                .fit()
                .into(holder.ivCover);

        holder.mtvTitle.setText(bean.getComicName());
        holder.tvTime.setText(TimeUtil.timestampToDate(bean.getUpdateTime().getTime()/1000, "yyyy-MM-dd hh:mm:ss"));
        holder.tvSee.setText("看到"+bean.getChapterTitle());

        if(bean.getOrigin() == AppConstants.KUAI_KAN_INT){
            holder.tvOrigin.setText("来源：" + mContext.getString(R.string.kuaikan));
            holder.tvOrigin.setTextColor(mContext.getResources().getColor(R.color.KuaiKanColor));
        }else if(bean.getOrigin() == AppConstants.ZHI_JIA_INT){
            holder.tvOrigin.setText("来源：" + mContext.getString(R.string.zhijia));
            holder.tvOrigin.setTextColor(mContext.getResources().getColor(R.color.ZhiJiaColor));
        }else {//未知
            holder.tvOrigin.setText("来源：" + mContext.getString(R.string.not_set));
            holder.tvOrigin.setTextColor(mContext.getResources().getColor(R.color.BLACK));
        }
    }

    private OnItemClickListener clickListener;

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface OnItemClickListener {
        void onClick(View view, int position);
        void Continue(View view, int position);
        void onDeleteClick(int position);
    }

    public class HistoryRecyclerHolder extends BaseRecyclerVH<HistoryBean>
            implements View.OnClickListener, Extension {

        public RelativeLayout mRootView;
        private ImageView ivCover;
        private TextView mtvTitle, tvTime, tvSee, tvContinue, tvOrigin;
        //main中的组件
        private LinearLayout mLinearLayout;
        private TextView tvDelete;

        public HistoryRecyclerHolder(View itemView) {
            super(itemView);
            mRootView = (RelativeLayout) itemView.findViewById(R.id.rl_item_root_view);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);
            mtvTitle = (TextView) itemView.findViewById(R.id.mtv_title);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tvSee = (TextView) itemView.findViewById(R.id.tv_see);
            tvContinue = (TextView) itemView.findViewById(R.id.tv_continue);
            tvOrigin = (TextView) itemView.findViewById(R.id.tv_origin);
            //main中的组件
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.ll_action);
            tvDelete = (TextView) itemView.findViewById(R.id.tv_action_delete);

            mRootView.setOnClickListener(this);
            tvContinue.setOnClickListener(this);
            tvDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                switch (v.getId()) {
                    case R.id.rl_item_root_view:
                        clickListener.onClick(itemView, getAdapterPosition());
                        break;
                    case R.id.tv_continue:
                        clickListener.Continue(itemView, getAdapterPosition());
                        break;
                    case R.id.tv_action_delete:
                        clickListener.onDeleteClick(getAdapterPosition());
                        break;
                    default:
                        break;
                }
            }
        }

        @Override
        public float getActionWidth() {
            return mLinearLayout.getWidth();
        }
    }
}
