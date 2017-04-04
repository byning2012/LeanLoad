package com.hzxm.easyloan.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hzxm.easyloan.R;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.util.AppActivityManager;
import com.lmz.baselibrary.widget.ClearEditText;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 学校选择
 */
public class ChooseSchoolActivity extends BaseActivity {

    @BindView(R.id.et_text)
    ClearEditText etText;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.activity_choose_school)
    LinearLayout activityChooseSchool;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_choose_school);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        SetStatusBarColor(R.color.transparent_white);
    }

    @Override
    protected void initData() {

    }

    /**
     * 取消搜索
     */
    @OnClick(R.id.tv_cancel)
    public void cacel() {
        AppActivityManager.getAppManager().finishActivity(this);
    }
}
