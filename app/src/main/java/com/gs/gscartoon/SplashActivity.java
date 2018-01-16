package com.gs.gscartoon;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.gs.gscartoon.home.view.HomeActivity;

import me.wangyuwei.particleview.ParticleView;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SplashActivity";

    private Handler mHandler = new Handler();

    private ParticleView pvGs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pvGs = (ParticleView)findViewById(R.id.pv_gs);
        pvGs.startAnim();

        pvGs.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
            @Override
            public void onAnimationEnd() {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(SplashActivity.this).toBundle();
                startActivity(intent, bundle);
                finish();
            }
        });

        /*mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mHandler != null){
            mHandler.removeCallbacksAndMessages(null);
            mHandler = null;
        }
    }

    /**
     * 屏蔽了返回按键
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
