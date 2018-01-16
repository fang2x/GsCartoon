package com.gs.gscartoon;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bulong on 16/12/6.
 */

public abstract class BaseRecyclerAdapter<T, VH extends BaseRecyclerVH<T>> extends RecyclerView.Adapter<VH> {

    protected final String TAG = getClass().getSimpleName();
    protected Context mContext;
    protected LayoutInflater mLayoutInflater;

    protected List<T> mData = new ArrayList<>();

    public BaseRecyclerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public T getItemData(int position) {
        if(position < 0 || position >= mData.size()){
            return null;
        }
        if (mData.isEmpty()) {
            return null;
        }
        return mData.get(position);
    }

    public void setItemData(int position, T data) {
        if(position <= mData.size() && data != null && !mData.isEmpty()){
            mData.set(position,data);
        }
    }

    public void addItem(T data, int position){
        mData.add(position, data);
        notifyItemInserted(position);
    }

    public void addItem(T data){
        addItem(data, mData.size());
    }

    public void removeItem(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }

    public void clear(){
        mData.clear();
    }

    public void addItems(List<T> data, int position){
        if(position<=mData.size() && data != null && !data.isEmpty()){
            mData.addAll(position,data);
            notifyItemRangeChanged(position, data.size());
        }
    }

    public void addItems(List<T> data) {
        addItems(data, mData.size());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(getLayoutId(), parent, false);
        return createViewHolder(view);
    }

    protected abstract int getLayoutId();

    protected abstract VH createViewHolder(View itemView);
}
