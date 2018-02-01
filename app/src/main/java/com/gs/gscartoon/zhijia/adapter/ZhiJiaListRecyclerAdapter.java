package com.gs.gscartoon.zhijia.adapter;

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
import com.gs.gscartoon.zhijia.bean.ZhiJiaListBean;
import com.squareup.picasso.Picasso;

/**
 * Created by camdora on 16-12-13.
 */

public class ZhiJiaListRecyclerAdapter extends BaseRecyclerAdapter<ZhiJiaListBean,
        ZhiJiaListRecyclerAdapter.ZhiJiaListRecyclerHolder> {

    private Context mContext;

    public ZhiJiaListRecyclerAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_zhi_jia_list;
    }

    @Override
    protected ZhiJiaListRecyclerHolder createViewHolder(View itemView) {
        ZhiJiaListRecyclerHolder mRecyclerHolder = new ZhiJiaListRecyclerHolder(itemView);
        return mRecyclerHolder;
    }

    @Override
    public void onBindViewHolder(final ZhiJiaListRecyclerHolder holder, int position) {
        ZhiJiaListBean bean = mData.get(position);
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
        holder.tvName.setText(bean.getLast_update_chapter_name());
    }

    private OnItemClickListener clickListener;

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    public class ZhiJiaListRecyclerHolder extends BaseRecyclerVH<ZhiJiaListBean>
            implements View.OnClickListener {

        private RelativeLayout mRootView;
        private ImageView ivCover;
        private TextView tvTitle, tvName;

        public ZhiJiaListRecyclerHolder(View itemView) {
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
