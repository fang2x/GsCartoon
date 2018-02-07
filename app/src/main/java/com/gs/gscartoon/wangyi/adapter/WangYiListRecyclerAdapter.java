package com.gs.gscartoon.wangyi.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gs.gscartoon.BaseRecyclerAdapter;
import com.gs.gscartoon.BaseRecyclerVH;
import com.gs.gscartoon.R;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.utils.PicassoRoundTransform;
import com.gs.gscartoon.wangyi.bean.WangYiListBean.DataBean.BooksBean;
import com.squareup.picasso.Picasso;


/**
 * Created by camdora on 16-12-13.
 */

public class WangYiListRecyclerAdapter extends BaseRecyclerAdapter<BooksBean,
        WangYiListRecyclerAdapter.WangYiListRecyclerHolder> {

    private Context mContext;

    public WangYiListRecyclerAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_wang_yi_list;
    }

    @Override
    protected WangYiListRecyclerHolder createViewHolder(View itemView) {
        WangYiListRecyclerHolder mRecyclerHolder = new WangYiListRecyclerHolder(itemView);
        return mRecyclerHolder;
    }

    @Override
    public void onBindViewHolder(final WangYiListRecyclerHolder holder, int position) {
        BooksBean bean = mData.get(position);
        if(bean == null){
            LogUtil.e(TAG,"bean==null");
            return;
        }

        //holder.sdvCover.setImageURI(Uri.parse(bean.getCover()));

        Picasso.with(mContext).load(bean.getCover()).placeholder(R.drawable.ic_wangyi_default_image_vertical)
                .error(R.drawable.ic_wangyi_default_image_vertical)
                .transform(new PicassoRoundTransform(7))
                .config(Bitmap.Config.RGB_565)
                .fit()
                .into(holder.ivCover);

        holder.ivCover.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        holder.ivCover.setColorFilter(Color.parseColor("#44000000"));
                        break;
                    case MotionEvent.ACTION_UP:
                        holder.ivCover.setColorFilter(null);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        holder.ivCover.setColorFilter(null);
                        break;
                }
                //这里一定要return false，不然该方法会拦截事件，造成不能响应点击等操作
                return false;
            }
        });

        holder.tvTitle.setText(bean.getTitle());
        if(bean.getTotalSection() == 0){
            if(bean.getLatest().contains("话") || bean.getLatest().contains("-") ||
                    bean.getLatest().contains("上") || bean.getLatest().contains("下") ||
                    bean.getLatest().contains("卷") || bean.getLatest().contains("章") ||
                    bean.getLatest().contains("局")) {
                holder.tvName.setText("更至" + bean.getLatest());
            }else {
                holder.tvName.setText("更至" + bean.getLatest() + "话");
            }
        }else {
            holder.tvName.setText("全" + bean.getTotalSection() + "话");
        }
    }

    private OnItemClickListener clickListener;

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    public class WangYiListRecyclerHolder extends BaseRecyclerVH<BooksBean>
            implements View.OnClickListener {

        private RelativeLayout mRootView;
        private ImageView ivCover;
        private TextView tvTitle, tvName;

        public WangYiListRecyclerHolder(View itemView) {
            super(itemView);
            mRootView = (RelativeLayout) itemView.findViewById(R.id.rl_item_root_view);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);

            mRootView.setOnClickListener(this);
            ivCover.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                switch (v.getId()) {
                    case R.id.rl_item_root_view:
                        clickListener.onClick(itemView, getAdapterPosition());
                        break;
                    case R.id.iv_cover:
                        clickListener.onClick(itemView, getAdapterPosition());
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
