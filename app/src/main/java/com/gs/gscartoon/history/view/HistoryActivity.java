package com.gs.gscartoon.history.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gs.gscartoon.R;
import com.gs.gscartoon.history.HistoryContract;
import com.gs.gscartoon.history.adapter.HistoryRecyclerAdapter;
import com.gs.gscartoon.history.bean.HistoryBean;
import com.gs.gscartoon.history.model.HistoryModel;
import com.gs.gscartoon.history.presenter.HistoryPresenter;
import com.gs.gscartoon.kuaikan.view.KuaiKanAllChapterActivity;
import com.gs.gscartoon.kuaikan.view.KuaiKanBrowseActivity;
import com.gs.gscartoon.utils.AppConstants;
import com.gs.gscartoon.utils.ItemTouchHelperCallback;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.utils.StatusBarUtil;
import com.gs.gscartoon.utils.TimeUtil;
import com.gs.gscartoon.utils.ToolbarUtil;
import com.gs.gscartoon.utils.decoration.PinnedSectionDecoration;
import com.gs.gscartoon.utils.decoration.SectionDecoration;
import com.gs.gscartoon.utils.listener.PinnedRecyclerHeadersTouchListener;
import com.gs.gscartoon.wangyi.view.WangYiBrowseActivity;
import com.gs.gscartoon.wangyi.view.WangYiDetailsActivity;
import com.gs.gscartoon.zhijia.view.ZhiJiaBrowseActivity;
import com.gs.gscartoon.zhijia.view.ZhiJiaDetailsActivity;
import com.loopeer.itemtouchhelperextension.ItemTouchHelperExtension;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class HistoryActivity extends AppCompatActivity implements HistoryContract.View,
        View.OnClickListener{
    private static final String TAG = "HistoryActivity";

    @BindView(R.id.tb_history)
    Toolbar tbToolbar;
    @BindView(R.id.rv_history)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_toolbar_history_title)
    TextView tvTitle;
    @BindView(R.id.tv_toolbar_history_edit)
    TextView tvEdit;
    @BindView(R.id.ll_empty)
    LinearLayout llEmpty;
    @BindView(R.id.tv_empty_title)
    TextView tvEmptyTitle;
    @BindView(R.id.iv_empty_image)
    ImageView ivEmptyImage;

    private HistoryContract.Presenter mPresenter;
    private HistoryRecyclerAdapter mRecyclerAdapter;
    private Unbinder unbinder;
    private int clickPosition = 0;
    //++++++左滑显示菜单
    public ItemTouchHelperExtension mItemTouchHelper;
    public ItemTouchHelperExtension.Callback mCallback;
    //------左滑显示菜单

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        StatusBarUtil.enableTranslucentStatusBar(this);
        unbinder = ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        ToolbarUtil.initToolbar(this, tbToolbar);

        // Create the presenter
        new HistoryPresenter(
                new HistoryModel(getApplicationContext()), this);

        mRecyclerAdapter = new HistoryRecyclerAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mCallback = new ItemTouchHelperCallback();
        mItemTouchHelper = new ItemTouchHelperExtension(mCallback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerAdapter.setClickListener(new HistoryRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                LogUtil.i(TAG,"点击item position="+position);
                clickPosition = position;
                mItemTouchHelper.closeOpened();//点击item时关闭左侧滑动菜单
                HistoryBean bean = mRecyclerAdapter.getItemData(position);
                if(bean == null){
                    return;
                }
                Intent intent;
                if(bean.getOrigin() == AppConstants.KUAI_KAN_INT){
                    intent = new Intent(HistoryActivity.this, KuaiKanAllChapterActivity.class);
                    intent.putExtra(AppConstants.COMIC_ID, bean.getComicId());
                    startActivity(intent);
                }else if(bean.getOrigin() == AppConstants.ZHI_JIA_INT){
                    intent = new Intent(HistoryActivity.this, ZhiJiaDetailsActivity.class);
                    ImageView imageView = view.findViewById(R.id.iv_cover);
                    BitmapDrawable mDrawable =  (BitmapDrawable) imageView.getDrawable();
                    intent.putExtra(AppConstants.COMIC_ID, bean.getComicId());
                    intent.putExtra(AppConstants.ZHI_JIA_COVER_BITMAP, mDrawable.getBitmap());
                    ActivityOptionsCompat options =
                            ActivityOptionsCompat.makeSceneTransitionAnimation(HistoryActivity.this,
                                    imageView, getString(R.string.transition_name_zhi_jia_cover));
                    startActivity(intent, options.toBundle());
                }else if(bean.getOrigin() == AppConstants.WANG_YI_INT){
                    intent = new Intent(HistoryActivity.this, WangYiDetailsActivity.class);
                    intent.putExtra(AppConstants.COMIC_ID, bean.getComicId());
                    startActivity(intent);
                }

            }

            @Override
            public void Continue(View view, int position) {
                LogUtil.i(TAG,"点击Continue position="+position);
                clickPosition = position;
                mItemTouchHelper.closeOpened();//点击Continue时关闭左侧滑动菜单
                HistoryBean bean = mRecyclerAdapter.getItemData(position);
                if(bean == null){
                    return;
                }
                Intent intent;
                if(bean.getOrigin() == AppConstants.KUAI_KAN_INT){
                    intent = new Intent(HistoryActivity.this, KuaiKanBrowseActivity.class);
                    intent.putExtra(AppConstants.CHAPTER_ID, bean.getChapterId());
                    intent.putExtra(AppConstants.COMIC_ID, bean.getComicId());
                    startActivity(intent);
                }else if(bean.getOrigin() == AppConstants.ZHI_JIA_INT){
                    intent = new Intent(HistoryActivity.this, ZhiJiaBrowseActivity.class);
                    intent.putExtra(AppConstants.COMIC_ID, bean.getComicId());
                    intent.putExtra(AppConstants.CHAPTER_ID, bean.getChapterId());
                    intent.putExtra(AppConstants.COMIC_TITLE, bean.getComicName());//为了保存在历史记录中
                    intent.putExtra(AppConstants.COVER_URL, bean.getCoverUrl());//为了保存在历史记录中
                    Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(
                            HistoryActivity.this).toBundle();
                    startActivity(intent, bundle);
                }else if(bean.getOrigin() == AppConstants.WANG_YI_INT){
                    intent = new Intent(HistoryActivity.this, WangYiBrowseActivity.class);
                    intent.putExtra(AppConstants.COMIC_ID, bean.getComicId());
                    intent.putExtra(AppConstants.CHAPTER_ID, bean.getChapterId());
                    intent.putExtra(AppConstants.COMIC_TITLE, bean.getComicName());//为了保存在历史记录中
                    intent.putExtra(AppConstants.COVER_URL, bean.getCoverUrl());//为了保存在历史记录中
                    Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(
                            HistoryActivity.this).toBundle();
                    startActivity(intent, bundle);
                }
            }

            @Override
            public void onDeleteClick(int position) {
                LogUtil.i(TAG,"点击删除 position="+position);
                clickPosition = position;
                showDeleteDialog();
            }

            @Override
            public void onHeaderClick(View view, int position) {
                LogUtil.i(TAG,"点击粘性头部 position="+position+" view="+view);
                //View view1 = view.findViewById(R.id.tv_group_id);
                //LogUtil.i(TAG,"view1"+view1+" "+view1.getId()+ " "+((TextView)view1).getText());
            }
        });

        tvEmptyTitle.setVisibility(View.GONE);
        //setSectionDecoration();
        setPinnedSectionDecoration();
    }

    /**
     * 非粘性头部标签
     */
    private void setSectionDecoration(){
        if(mRecyclerView == null || mRecyclerAdapter == null){
            return;
        }

        mRecyclerView.addItemDecoration(new SectionDecoration(this, new SectionDecoration.DecorationCallback() {
            @Override
            public String getGroupId(int position) {
                HistoryBean bean = mRecyclerAdapter.getItemData(position);
                if(bean == null){
                    return null;
                }
                return TimeUtil.timestampToDate(bean.getUpdateTime().getTime()/1000);
            }

            @Override
            public String getGroupFirstLine(int position) {
                HistoryBean bean = mRecyclerAdapter.getItemData(position);
                if(bean == null){
                    return null;
                }
                return TimeUtil.timestampToDate(bean.getUpdateTime().getTime()/1000);
            }
        }));
    }

    /**
     * 粘性头部标签
     */
    private void setPinnedSectionDecoration(){
        if(mRecyclerView == null || mRecyclerAdapter == null){
            return;
        }

        PinnedSectionDecoration mDecoration = new PinnedSectionDecoration(mRecyclerAdapter);
        mRecyclerView.addItemDecoration(mDecoration);
        mRecyclerView.addOnItemTouchListener(new PinnedRecyclerHeadersTouchListener(mRecyclerView, mDecoration));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.refreshData();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mPresenter.destroy();
    }

    @Override
    public void setPresenter(HistoryContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        if(item.getItemId() == android.R.id.home) {
            finishAfterTransition();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showRefreshData(List<HistoryBean> mData) {
        mRecyclerAdapter.clear();
        mRecyclerAdapter.addItems(mData);
        mRecyclerAdapter.notifyDataSetChanged();
        isEmpty();
    }

    @Override
    public void refreshDataFailure() {
        isEmpty();
    }

    @Override
    public void removeRecycleData() {
        if(mRecyclerAdapter != null) {
            mRecyclerAdapter.removeItem(clickPosition);
            mItemTouchHelper.closeOpened();//删除最后一条数据，再添加一条还是会展开左侧菜单
            isEmpty();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_toolbar_history_edit:
                break;
            default:
                break;
        }
    }

    private void isEmpty(){
        if(mRecyclerAdapter == null) {
            return;
        }

        if(mRecyclerAdapter.getItemCount() < 1){
            if(ivEmptyImage != null){
                ivEmptyImage.setImageResource(R.drawable.ic_history_none);
            }
            dataIsEmpty();
        }else {
            dataIsNotEmpty();
        }
    }

    private void dataIsEmpty(){
        if(llEmpty != null && mRecyclerView != null) {
            llEmpty.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        }
    }

    private void dataIsNotEmpty(){
        if(llEmpty != null && mRecyclerView != null) {
            llEmpty.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
        }
    }

    private void showDeleteDialog(){
        final AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setMessage("清除已选中的历史记录吗？");
        normalDialog.setPositiveButton(getString(R.string.determine),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        HistoryBean bean = mRecyclerAdapter.getItemData(clickPosition);
                        if(bean != null) {
                            mPresenter.deleteData(bean.getId());
                        }else {
                            LogUtil.e(TAG, "bean == null");
                        }
                    }
                });
        normalDialog.setNegativeButton(getString(R.string.cancel),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        normalDialog.show();
    }
}
