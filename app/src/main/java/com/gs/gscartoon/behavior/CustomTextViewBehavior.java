package com.gs.gscartoon.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.gs.gscartoon.R;
import com.gs.gscartoon.utils.DisplayUtil;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.utils.ToolbarUtil;


//泛型为child类型
public class CustomTextViewBehavior extends CoordinatorLayout.Behavior<TextView> {
    private final static String TAG = "CustomTextViewBehavior";
    private Context mContext;

    private float mStartY = -1;//起始Y

    private float mStartX = -1;//起始X

    private float mSize = -1;//文字的大小，textSize设置的属性

    private int mLableHeight = -1;//图片下面的Lable高度

    private Toolbar mToolBar;
    private int mToolBarHeight = -1;

    public CustomTextViewBehavior(Context context, Toolbar toolbar) {
        mContext = context;
        mLableHeight = mContext.getResources().getDimensionPixelSize(R.dimen.toolbar_label_height);
        mToolBar = toolbar;
        //LogUtil.e("a","CustomBehavior mLableHeight=" + mLableHeight);
    }

    public CustomTextViewBehavior(Context context, AttributeSet attrs) {
        mContext = context;
        mLableHeight = mContext.getResources().getDimensionPixelSize(R.dimen.toolbar_label_height);
        //LogUtil.e("a","CustomBehavior mLableHeight=" + mLableHeight);
    }

    // 如果dependency为AppBarLayout
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    //当dependency变化的时候调用
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        /*Log.e("a","getY="+dependency.getY()+" getX="+dependency.getX()
                +" getHeight="+dependency.getHeight()+" getWidth="+dependency.getWidth()
                +" getTop="+dependency.getTop()+" getScrollY="+dependency.getScrollY()
                +" getScrollX="+dependency.getScrollX()+" getScaleY="+dependency.getScaleY());*/
        if(mToolBar == null) {
            mToolBarHeight = ToolbarUtil.getSystemActionBarSize();
            //LogUtil.e("a","初始ToolBar getHeight="+mToolBar.getHeight());
        }else {
            mToolBarHeight = mToolBar.getHeight();
        }

        if(mStartY == -1){
            mStartY = dependency.getHeight() - mLableHeight - child.getHeight();
            //LogUtil.e("a","初始Y坐标="+mStartY);
        }
        if(mStartX == -1){
            mStartX = child.getX();
            //LogUtil.e("a","初始X坐标="+mStartX);
        }

        if(mSize == -1){
            mSize = child.getTextSize();
            //LogUtil.e("a","TextView文字size="+mSize);
        }

        //减去toolbar的高度后，得出的比例是AppBarLayout的缩放率
        float percent = (dependency.getHeight() + dependency.getY() - mToolBarHeight) /
                (float)(dependency.getHeight() - mToolBarHeight);

        //让TextView跟随AppBarLayout垂直移动
        int finalY = (mToolBarHeight - child.getHeight() + DisplayUtil.getStatusBarHeight()) / 2;//TextView在Y轴最终的位置
        child.setY(mStartY * percent + finalY * (1 - percent));

        //让TextView跟随AppBarLayout水平移动
        int finalX = (DisplayUtil.getScreenWidth() - child.getWidth()) / 2;//TextView在X轴最终的位置
        child.setX(mStartX * percent + finalX * (1 - percent));

        //让TextView字体大小随AppBarLayout变化
        child.setTextSize(DisplayUtil.px2sp(mContext, mSize * percent + mSize));

        return true;
    }
}
