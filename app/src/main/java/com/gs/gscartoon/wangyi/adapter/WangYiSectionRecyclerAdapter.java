package com.gs.gscartoon.wangyi.adapter;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.gs.gscartoon.BaseRecyclerAdapter;
import com.gs.gscartoon.BaseRecyclerVH;
import com.gs.gscartoon.R;
import com.gs.gscartoon.utils.AppConstants;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.wangyi.bean.WangYiSectionBean.DataBean.SectionsBeanX.SectionsBean;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by camdora on 16-12-13.
 */

public class WangYiSectionRecyclerAdapter extends BaseRecyclerAdapter<SectionsBean,
        WangYiSectionRecyclerAdapter.WangYiSectionRecyclerHolder> {

    private Context mContext;

    public WangYiSectionRecyclerAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_wang_yi_section;
    }

    @Override
    protected WangYiSectionRecyclerHolder createViewHolder(View itemView) {
        WangYiSectionRecyclerHolder mRecyclerHolder = new WangYiSectionRecyclerHolder(itemView);
        return mRecyclerHolder;
    }

    @Override
    public void onBindViewHolder(final WangYiSectionRecyclerHolder holder, int position) {
        SectionsBean bean = mData.get(position);
        if(bean == null){
            LogUtil.e(TAG,"bean==null");
            return;
        }

        holder.tvSection.setText(bean.getIndex());
    }

    /**
     * 排序，就是对集合的倒序。服务器默认是按顺序返回的，所以只要第一次状态匹配，之后倒置就可以了
     */
    public void order(){
        Collections.reverse(mData);
        notifyDataSetChanged();
    }

    private OnItemClickListener clickListener;

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    public class WangYiSectionRecyclerHolder extends BaseRecyclerVH<SectionsBean>
            implements View.OnClickListener{

        private FrameLayout mFrameLayout;
        private TextView tvSection;

        public WangYiSectionRecyclerHolder(View itemView) {
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
