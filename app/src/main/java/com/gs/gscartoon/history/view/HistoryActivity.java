package com.gs.gscartoon.history.view;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
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
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.utils.StatusBarUtil;
import com.gs.gscartoon.utils.StringUtil;
import com.gs.gscartoon.utils.ToolbarUtil;
import com.gs.gscartoon.widget.view.MarqueTextView;
import com.gs.gscartoon.zhijia.view.ZhiJiaBrowseActivity;
import com.gs.gscartoon.zhijia.view.ZhiJiaDetailsActivity;
import com.squareup.picasso.Picasso;

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

    private HistoryContract.Presenter mPresenter;
    private HistoryRecyclerAdapter mRecyclerAdapter;
    private Unbinder unbinder;

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
        mRecyclerAdapter.setClickListener(new HistoryRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                LogUtil.i(TAG,"点击item position="+position);
                HistoryBean bean = mRecyclerAdapter.getItemData(position);
                if(bean == null){
                    return;
                }
                Intent intent;
                if(bean.getOrigin() == AppConstants.KUAI_KAN_INT){
                    intent = new Intent(HistoryActivity.this, KuaiKanAllChapterActivity.class);
                    intent.putExtra(AppConstants.COMIC_ID, bean.getComicId()+"");
                    startActivity(intent);
                }else if(bean.getOrigin() == AppConstants.ZHI_JIA_INT){
                    intent = new Intent(HistoryActivity.this, ZhiJiaDetailsActivity.class);
                    ImageView imageView = view.findViewById(R.id.iv_cover);
                    BitmapDrawable mDrawable =  (BitmapDrawable) imageView.getDrawable();
                    intent.putExtra(AppConstants.COMIC_ID, bean.getComicId()+"");
                    intent.putExtra(AppConstants.ZHI_JIA_COVER_BITMAP, mDrawable.getBitmap());
                    ActivityOptionsCompat options =
                            ActivityOptionsCompat.makeSceneTransitionAnimation(HistoryActivity.this,
                                    imageView, getString(R.string.transition_name_zhi_jia_cover));
                    startActivity(intent, options.toBundle());
                }else if(bean.getOrigin() == AppConstants.WANG_YI_INT){

                }

            }

            @Override
            public void Continue(View view, int position) {
                LogUtil.i(TAG,"点击Continue position="+position);
                HistoryBean bean = mRecyclerAdapter.getItemData(position);
                if(bean == null){
                    return;
                }
                Intent intent;
                if(bean.getOrigin() == AppConstants.KUAI_KAN_INT){
                    intent = new Intent(HistoryActivity.this, KuaiKanBrowseActivity.class);
                    intent.putExtra(AppConstants.CHAPTER_ID, bean.getChapterId()+"");
                    intent.putExtra(AppConstants.COMIC_ID, bean.getComicId()+"");
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

                }
            }
        });
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
        if(mRecyclerAdapter.getItemCount() < 1){
            if(tvEmptyTitle != null){
                tvEmptyTitle.setText(getString(R.string.data_is_empty));
            }
            dataIsEmpty();
        }else {
            dataIsNotEmpty();
        }
    }

    @Override
    public void refreshDataFailure() {
        if(mRecyclerAdapter != null) {
            if (mRecyclerAdapter.getItemCount() < 1) {
                if(tvEmptyTitle != null) {
                    tvEmptyTitle.setText("获取数据失败");
                }
                dataIsEmpty();
            } else {
                dataIsNotEmpty();
            }
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

    private void dataIsEmpty(){
        if(llEmpty != null) {
            llEmpty.setVisibility(View.VISIBLE);
        }
    }

    private void dataIsNotEmpty(){
        if(llEmpty != null) {
            llEmpty.setVisibility(View.GONE);
        }
    }
}
