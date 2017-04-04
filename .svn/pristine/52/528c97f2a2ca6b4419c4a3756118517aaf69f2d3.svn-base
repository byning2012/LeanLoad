package com.hzxm.easyloan.ui.activity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hzxm.easyloan.R;
import com.lmz.baselibrary.ui.BaseActivity;

import butterknife.BindView;

/**
 * 用户帮助中心
 */
public class HelpCenterActivity extends BaseActivity {
    @BindView(R.id.tv_problem)
    TextView tvProblem;
    @BindView(R.id.tv_answer)
    TextView tvAnswer;
    @BindView(R.id.activity_help_center)
    LinearLayout activityHelpCenter;
    private String problem;
    private String title;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_help_center);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {

    }

    @Override
    protected void initData() {
        try {
            problem = getIntent().getStringExtra("problem");
            title = getIntent().getStringExtra("title");
        } catch (Exception e) {
            problem = "未知问题";
            title = "未知问题";
        }
        tvProblem.setText("Q：" + title);
        tvAnswer.setText(problem);

    }
}
