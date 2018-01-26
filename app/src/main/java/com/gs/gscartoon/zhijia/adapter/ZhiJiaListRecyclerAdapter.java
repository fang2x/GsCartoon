package com.gs.gscartoon.zhijia.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gs.gscartoon.BaseRecyclerAdapter;
import com.gs.gscartoon.BaseRecyclerVH;
import com.gs.gscartoon.R;

import com.gs.gscartoon.utils.ColorUtil;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.utils.OkHttpUtil;
import com.gs.gscartoon.utils.PicassoRoundTransform;
import com.gs.gscartoon.zhijia.bean.ZhiJiaListBean;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;


/**
 * Created by camdora on 16-12-13.
 */

public class ZhiJiaListRecyclerAdapter extends BaseRecyclerAdapter<ZhiJiaListBean,
        ZhiJiaListRecyclerAdapter.ZhiJiaListRecyclerHolder> {

    private Context mContext;
    private Picasso mPicasso;

    public ZhiJiaListRecyclerAdapter(Context context) {
        super(context);
        mContext = context;

        OkHttpClient okHttpClient = OkHttpUtil.getHeaderOkHttpClientBuilder().build();
        mPicasso = new Picasso.Builder(mContext)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();
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

        mPicasso.load(bean.getCover()).placeholder(R.drawable.ic_kuaikan_default_image_vertical)
                .error(R.drawable.ic_kuaikan_default_image_vertical)
                .transform(new PicassoRoundTransform(7))
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
