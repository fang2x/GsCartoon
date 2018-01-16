package com.gs.gscartoon.widget.view.refresh;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListView;

import com.gs.gscartoon.R;


/**
 * Created by yinjianfeng on 16/12/6.
 */

public class JFengRefreshLayout extends SwipeRefreshLayout implements AbsListView.OnScrollListener {
    public static final String TAG = "JFengRefreshLayout";

    /**
     * 滑动到最下面时的上拉操作
     */
    private int mTouchSlop;
    /**
     * listview实例
     */
//    private ListView mListView;
//    private GridView mGridView;
    private View refreshDataView;
    private AbsListView contentView;
    private RecyclerView contentRecyclerView;
    /**
     * 上拉监听器, 到了最底部的上拉加载操作
     */
    private JFengRefreshListener mRefreshListener;
    /**
     * ListView的加载中footer
     */
    private View mListViewFooter;
    /**
     * 按下时的y坐标
     */
    private int mYDown;
    /**
     * 抬起时的y坐标, 与mYDown一起用于滑动到底部时判断是上拉还是下拉
     */
    private int mLastY;
    /**
     * 是否在加载中 ( 上拉加载更多 )
     */
    private boolean isLoading = false;
    private boolean canBottomLoad = true;

    public JFengRefreshLayout(Context context) {
        this(context, null);
    }

    public JFengRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mListViewFooter = LayoutInflater.from(context).inflate(R.layout.refresh_layout_footer, null, false);
        setColorSchemeResources(R.color.holo_blue_bright,
                R.color.holo_green_light, R.color.holo_orange_light,
                R.color.holo_red_light);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            initListView();
        }
    }

    public void setRefreshDataView(View dataView) {
        this.refreshDataView = dataView;
    }
    private void initListView(){
        if(refreshDataView==null){
            int childs = getChildCount();
            if(childs > 1) {
                refreshDataView = getChildAt(1);
            }
        }
        if(refreshDataView instanceof ListView) {
            // 设置滚动监听器给ListView, 使得滚动的情况下也可以自动加载
            ((ListView)refreshDataView).setOnScrollListener(this);
            contentView = (AbsListView) refreshDataView;
        }else if(refreshDataView instanceof GridView){
            ((GridView)refreshDataView).setOnScrollListener(this);
            contentView = (AbsListView) refreshDataView;
        }else if(refreshDataView instanceof RecyclerView) {
            contentRecyclerView = (RecyclerView) refreshDataView;
            LinearLayoutManager layoutManager = (LinearLayoutManager) contentRecyclerView.getLayoutManager();
//                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//                contentRecyclerView.setLayoutManager(layoutManager);
            contentRecyclerView.addOnScrollListener(getOnBottomListener(layoutManager));

        }
    }

    int PRELOAD_SIZE = 1;
    boolean mIsFirstTimeTouchBottom = true;
    RecyclerView.OnScrollListener getOnBottomListener(final LinearLayoutManager layoutManager) {
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView rv, int dx, int dy) {
                boolean isBottom =
                        layoutManager.findLastCompletelyVisibleItemPosition()
                                >= contentRecyclerView.getAdapter().getItemCount() - PRELOAD_SIZE;
                if (!isRefreshing() && isBottom) {
                    loadData();
                }
//                    if (!mIsFirstTimeTouchBottom) {
//                        setRefreshing(true);
//                        loadData();
//                    } else {
//                        mIsFirstTimeTouchBottom = false;
//                    }
//                }
            }
        };
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN://按下
                mYDown = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE://移动
                mLastY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_UP://抬起
//                if(canLoad()){
//                    loadData();
//                }
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    public void setOnRefreshListener(JFengRefreshListener refreshListner) {
        super.setOnRefreshListener(refreshListner);
        this.mRefreshListener = refreshListner;
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                         int totalItemCount) {
        //滚动到了底部加载更多
        if(canLoad()) {
            loadData();
        }
    }

    public void setCanBottomLoad(boolean canBottomLoad) {
        this.canBottomLoad = canBottomLoad;
    }

    /**
     * 如果当前已经滑到底部并且没有在加载中并且是上拉，就进行加载
     * @return
     */
    private boolean canLoad(){
        return canBottomLoad&&isBottom()&&!isLoading&&isPullUp();
    }
    /*private boolean canRecyclerLoad(){
        return canBottomLoad&&isRecycleBottom()&&!isLoading&&isPullUp();
    }*/
    /**
     * 判断是否到了最底部
     */
    private boolean isBottom() {
        if(contentView != null && contentView.getAdapter() != null){
            return contentView.getLastVisiblePosition() == (contentView.getAdapter().getCount()-1);
        }
        return false;
    }
   /* private boolean isRecycleBottom(){
        if (contentRecyclerView == null) {
            return false;
        }
        LayoutManager layoutManager = contentRecyclerView.getLayoutManager();
        boolean isBottom =
                layoutManager.findLastCompletelyVisibleItemPositions(new int[2])[1]
                        >= mMeizhiListAdapter.getItemCount() - PRELOAD_SIZE;
        if (!mSwipeRefreshLayout.isRefreshing() && isBottom) {
            if (!mIsFirstTimeTouchBottom) {
                mSwipeRefreshLayout.setRefreshing(true);
                mPage += 1;
                loadData();
            } else {
                mIsFirstTimeTouchBottom = false;
            }
        }
        return false;
    }*/

    /**
     * 是否是上拉操作
     */
    private boolean isPullUp(){
        return (mYDown - mLastY) >= mTouchSlop;
    }

    /**
     * 如果到了底部，而且是上拉操作，那么执行onLoad方法
     */
    private void loadData(){
        if (mRefreshListener != null) {
            startLoading();
            mRefreshListener.onLoad();
        }
    }
    /**
     * 底部显示加载图标
     */
    private void setLoading(boolean loading){
        if (contentView == null) return;
        isLoading = loading;

        try {
            if(isLoading) {
                if(contentView instanceof ListView){
                    ((ListView)contentView).addFooterView(mListViewFooter);
                }else if(contentView instanceof GridView){
                    //                ((GridView)contentView).addFooterView(mListViewFooter);
                }
            } else {
                //            mListView.removeFooterView(mListViewFooter);

                if(contentView instanceof ListView){
                    ((ListView)contentView).removeFooterView(mListViewFooter);
                }else if(contentView instanceof GridView){
                    //                ((GridView)contentView).addFooterView(mListViewFooter);
                }
                mYDown = 0;
                mLastY = 0;
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }
    public void startLoading(){
        setLoading(true);
    }
    public void finishLoading(){
        setLoading(false);
    }
    public void startRefresh(){
        if(!isRefreshing())
            post(new Runnable() {
                @Override
                public void run() {
                    setRefreshing(true);
                    if (mRefreshListener != null) {
                        mRefreshListener.onRefresh();
                    }
                }
            });

    }
    public void finishRefresh(){
        setRefreshing(false);
    }

    float xDistance, yDistance;
    float xLast, yLast;
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDistance = yDistance = 0f;
                xLast = ev.getX();
                yLast = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float curX = ev.getX();
                final float curY = ev.getY();

                xDistance += Math.abs(curX - xLast);
                yDistance += Math.abs(curY - yLast);
                xLast = curX;
                yLast = curY;

                /**
                 * X轴滑动距离大于Y轴滑动距离，也就是用户横向滑动时，返回false，ScrollView不处理这次事件，
                 * 让子控件中的TouchEvent去处理，所以横向滑动的事件交由ViewPager处理，
                 * ScrollView只处理纵向滑动事件
                 */
                if (xDistance > yDistance) {
                    return false;
                }
        }

        return super.onInterceptTouchEvent(ev);
    }
}
