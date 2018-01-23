package com.gs.gscartoon.kuaikan.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gs.gscartoon.BaseRecyclerAdapter;
import com.gs.gscartoon.BaseRecyclerVH;
import com.gs.gscartoon.R;
import com.gs.gscartoon.kuaikan.bean.KuaiKanListBean.DataBean.ComicsBean;
import com.gs.gscartoon.utils.ColorUtil;
import com.gs.gscartoon.utils.LogUtil;
import com.squareup.picasso.Picasso;

/**
 * Created by camdora on 16-12-13.
 */

public class KuaiKanListRecyclerAdapter extends BaseRecyclerAdapter<ComicsBean,
        KuaiKanListRecyclerAdapter.KuaiKanListRecyclerHolder> {

    private Context mContext;

    public KuaiKanListRecyclerAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_kuai_kan_list;
    }

    @Override
    protected KuaiKanListRecyclerHolder createViewHolder(View itemView) {
        KuaiKanListRecyclerHolder mRecyclerHolder = new KuaiKanListRecyclerHolder(itemView);
        return mRecyclerHolder;
    }

    @Override
    public void onBindViewHolder(final KuaiKanListRecyclerHolder holder, int position) {
        ComicsBean bean = mData.get(position);
        if(bean == null){
            LogUtil.e(TAG,"bean==null");
            return;
        }

        String lableColor = bean.getLabel_color();
        Drawable originalDrawable = ContextCompat.getDrawable(mContext, R.drawable.bg_circle_corner_button_fill_white);
        Drawable tintDrawable = DrawableCompat.wrap(originalDrawable).mutate();

        if(!TextUtils.isEmpty(lableColor)){
            DrawableCompat.setTint(tintDrawable, Color.parseColor(lableColor));
            holder.tvLabel.setBackground(tintDrawable);
        }else {
            DrawableCompat.setTint(tintDrawable, ColorUtil.getColor(R.color.BLACK));
            holder.tvLabel.setBackground(tintDrawable);
        }
        String lableTextColor = bean.getLabel_text_color();
        if(!TextUtils.isEmpty(lableTextColor)){
            holder.tvLabel.setTextColor(Color.parseColor(lableTextColor));
        }else {
            holder.tvLabel.setTextColor(ColorUtil.getColor(R.color.WHITE));
        }
        holder.tvLabel.setText(bean.getLabel_text());

        if(bean.getTopic() != null){
            holder.mtvTopic.setText(bean.getTopic().getTitle());
            if(bean.getTopic().getUser() != null){
                holder.mtvAuthor.setText(bean.getTopic().getUser().getNickname());
            }else {
                holder.mtvAuthor.setText(R.string.not_set);
            }
        }else {
            holder.mtvTopic.setText(R.string.not_set);
            holder.mtvAuthor.setText(R.string.not_set);
        }

        //holder.sdvCover.setImageURI(Uri.parse(bean.getCover_image_url()));
        Picasso.with(mContext).load(bean.getCover_image_url()).placeholder(R.drawable.ic_kuaikan_default_image)
                .error(R.drawable.ic_kuaikan_default_image)
                .into(holder.ivCover);

        holder.tvTitle.setText(bean.getTitle());
        holder.tvCommon.setText(bean.getComments_count()+"");
        holder.tvLike.setText(bean.getLikes_count()+"");
    }

    private OnItemClickListener clickListener;

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface OnItemClickListener {
        void onClick(View view, int position);
        void onAllClick(int position);
    }

    public class KuaiKanListRecyclerHolder extends BaseRecyclerVH<ComicsBean>
            implements View.OnClickListener {

        private FrameLayout mFrameLayout;
        private RelativeLayout rlTopic;
        private ImageView ivCover;
        private TextView tvLabel, mtvTopic, mtvAuthor, tvTitle, tvCommon, tvLike;

        public KuaiKanListRecyclerHolder(View itemView) {
            super(itemView);
            mFrameLayout = (FrameLayout) itemView.findViewById(R.id.fl_item_root_view);
            rlTopic = (RelativeLayout) itemView.findViewById(R.id.rl_topic);
            tvLabel = (TextView) itemView.findViewById(R.id.tv_label);
            mtvTopic = (TextView) itemView.findViewById(R.id.mtv_topic);
            mtvAuthor = (TextView) itemView.findViewById(R.id.mtv_author);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvCommon = (TextView) itemView.findViewById(R.id.tv_common);
            tvLike = (TextView) itemView.findViewById(R.id.tv_like);

            mFrameLayout.setOnClickListener(this);
            rlTopic.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                switch (v.getId()) {
                    case R.id.fl_item_root_view:
                        clickListener.onClick(itemView, getAdapterPosition());
                        break;
                    case R.id.rl_topic:
                        clickListener.onAllClick(getAdapterPosition());
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
