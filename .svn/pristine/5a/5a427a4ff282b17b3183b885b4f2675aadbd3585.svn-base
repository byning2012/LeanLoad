package com.hzxm.easyloan.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.hzxm.easyloan.MainActivity;
import com.hzxm.easyloan.MyApplication;
import com.hzxm.easyloan.R;
import com.hzxm.easyloan.utils.Constant;
import com.lmz.baselibrary.util.AppActivityManager;
import com.lmz.baselibrary.util.SharedPreferencesUtil;

import butterknife.BindView;

public class SplashActivity extends Activity {

    @BindView(R.id.activity_splash)
    ImageView activitySplash;

    private Handler handler;

    private boolean isLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isLogin = SharedPreferencesUtil.getInstance(MyApplication.getApplication()).getBoolean(Constant.IS_LOGIN, false);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isLogin) {
                    Intent intent = new Intent();
                    intent.setClass(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent();
                    intent.setClass(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                AppActivityManager.getAppManager().finishActivity(SplashActivity.this);
            }
        }, 1500);
    }

}
