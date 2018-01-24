package com.gs.gscartoon.zhijia.adapter;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.gs.gscartoon.BaseRecyclerAdapter;
import com.gs.gscartoon.BaseRecyclerVH;
import com.gs.gscartoon.R;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.zhijia.bean.ZhiJiaDetailsBean.ChaptersBean.DataBean;

/**
 * Created by camdora on 16-12-13.
 */

public class ZhiJiaSectionRecyclerAdapter extends BaseRecyclerAdapter<DataBean,
        ZhiJiaSectionRecyclerAdapter.ZhiJiaSectionRecyclerHolder> {

    private Context mContext;

    public ZhiJiaSectionRecyclerAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_zhi_jia_section;
    }

    @Override
    protected ZhiJiaSectionRecyclerHolder createViewHolder(View itemView) {
        ZhiJiaSectionRecyclerHolder mRecyclerHolder = new ZhiJiaSectionRecyclerHolder(itemView);
        return mRecyclerHolder;
    }

    @Override
    public void onBindViewHolder(final ZhiJiaSectionRecyclerHolder holder, int position) {
        DataBean bean = mData.get(position);
        if(bean == null){
            LogUtil.e(TAG,"bean==null");
            return;
        }

        holder.tvSection.setText(bean.getChapter_title());
    }

    private OnItemClickListener clickListener;

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    public class ZhiJiaSectionRecyclerHolder extends BaseRecyclerVH<DataBean>
            implements View.OnClickListener{

        private FrameLayout mFrameLayout;
        private TextView tvSection;

        public ZhiJiaSectionRecyclerHolder(View itemView) {
            super(itemView);
            mFrameLayout = (FrameLayout) itemView.findViewById(R.id.fl_item_root_view);
            tvSection = (TextView) itemView.findViewById(R.id.tv_section);

            tvSection.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                switch (v.getId()) {
                    case R.id.tv_section:
                        clickListener.onClick(itemView, getAdapterPosition());
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
