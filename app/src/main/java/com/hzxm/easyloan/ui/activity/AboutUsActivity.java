package com.hzxm.easyloan.ui.activity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hzxm.easyloan.R;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.util.LogUtil;

import butterknife.BindView;

/**
 * 关于我们
 */
public class AboutUsActivity extends BaseActivity {


    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.activity_about_us)
    LinearLayout activityAboutUs;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_about_us);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        SetStatusBarColor(R.color.transparent_white);
    }

    @Override
    protected void initData() {
        try {
            tvContent.setText(getIntent().getExtras().getString("content"));
        } catch (NullPointerException e) {
            LogUtil.e("空指针");
        }

    }

}
