package com.gs.gscartoon.aboutme.view;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gs.gscartoon.R;
import com.gs.gscartoon.utils.AppInforUtil;
import com.gs.gscartoon.utils.StatusBarUtil;
import com.gs.gscartoon.utils.ToolbarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AboutMeActivity extends AppCompatActivity {
    private static final String TAG = "AboutMeActivity";

    @BindView(R.id.tb_about_me)
    Toolbar tbToolbar;
    @BindView(R.id.sdv_launcher)
    SimpleDraweeView sdvLauncher;
    @BindView(R.id.tv_version)
    TextView tvVersion;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        StatusBarUtil.enableTranslucentStatusBar(this);
        //LightStatusBarUtil.setLightStatusBar(this, true);
        unbinder = ButterKnife.bind(this);

        initView();
    }

    private void initView(){
        ToolbarUtil.initToolbar(this, tbToolbar);

        sdvLauncher.setImageURI(Uri.parse("res://"+
                this.getPackageName()+"/" + R.drawable.ic_launcher));
        tvVersion.setText("版本："+ AppInforUtil.getAppVersionName(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
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
}
