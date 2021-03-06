package com.hzxm.easyloan.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import com.hzxm.easyloan.MainActivity;
import com.hzxm.easyloan.R;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.util.AppActivityManager;
import com.lmz.baselibrary.widget.TitleLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 匹配额度
 */
public class MatchQuotaActivity extends BaseActivity {

    @BindView(R.id.title)
    TitleLayout mTitle;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.activity_match_quota)
    LinearLayout activityMatchQuota;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_match_quota);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
      //  SetStatusBarColor(R.color.transparent_white);
    }

    @Override
    protected void initData() {
//        mTitle.setOnBackButtonClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(MainActivity.class);
//                AppActivityManager.getAppManager().finishAllActivity();
//            }
//        });
    }


    /**
     * 跳转到主页面
     */
    @OnClick(R.id.btn_next)
    public void toMainActivity() {
        startActivity(MainActivity.class);
        AppActivityManager.getAppManager().finishAllActivity();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
