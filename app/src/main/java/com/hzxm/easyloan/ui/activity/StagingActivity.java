package com.hzxm.easyloan.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.hzxm.easyloan.R;
import com.hzxm.easyloan.adapter.home.StagingAdapter;
import com.hzxm.easyloan.model.home.StagingDetailModel;
import com.hzxm.easyloan.widget.HorizontalDecoration;
import com.lmz.baselibrary.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 分期详情
 */
public class StagingActivity extends BaseActivity {

    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.activity_staging)
    LinearLayout activityStaging;

    private float mTotleMoney;
    private float mStagingMoney;
    private int data;
    private List<StagingDetailModel> stagingDetailModels = new ArrayList<>();
    private StagingAdapter mStagingAdapter;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_staging);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.addItemDecoration(new HorizontalDecoration(this, LinearLayout.VERTICAL));
        recycleView.setFocusable(false);
        recycleView.setNestedScrollingEnabled(false);
    }

    @Override
    protected void initData() {
        mTotleMoney = getIntent().getExtras().getFloat("TotleMoney");
        mStagingMoney = getIntent().getExtras().getFloat("salary");
        data = getIntent().getExtras().getInt("data");
        for (int i = 0; i < data; i++) {
            stagingDetailModels.add(new StagingDetailModel(i, (float) (Math.round(mTotleMoney / data * 100)) / 100,
                    (float) (Math.round(mStagingMoney / data * 100)) / 100));
        }
        mStagingAdapter = new StagingAdapter(stagingDetailModels);
        recycleView.setAdapter(mStagingAdapter);
    }
}
