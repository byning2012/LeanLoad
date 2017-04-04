package com.hzxm.easyloan.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.hzxm.easyloan.MyApplication;
import com.hzxm.easyloan.R;
import com.hzxm.easyloan.adapter.home.MyBillAdapter;
import com.hzxm.easyloan.model.home.MyBillModel;
import com.hzxm.easyloan.presenter.implPresenter.MyBillPresenter;
import com.hzxm.easyloan.presenter.implView.IMyBillView;
import com.hzxm.easyloan.utils.Constant;
import com.hzxm.easyloan.widget.HorizontalDecoration;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.util.AppActivityManager;
import com.lmz.baselibrary.util.LogUtil;
import com.lmz.baselibrary.util.SharedPreferencesUtil;
import com.lmz.baselibrary.util.glide.GliderHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的账单
 */
public class MyBillActivity extends BaseActivity implements IMyBillView {


    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.activity_my_bill)
    LinearLayout activityMyBill;
    @BindView(R.id.iv_error_logo)
    ImageView ivErrorLogo;
    @BindView(R.id.btn_error)
    Button btnError;
    @BindView(R.id.error_page)
    LinearLayout errorPage;


    private MyBillPresenter mMyBillPresenter;
    private MyBillAdapter mMyBillAdapter;
    private View EmptyView;
    private int uid;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_my_bill);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        SetStatusBarColor(R.color.transparent_white);
        recycleView.setHasFixedSize(true);
        recycleView.addItemDecoration(new HorizontalDecoration(this, LinearLayoutManager.VERTICAL));
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        EmptyView = getLayoutInflater().inflate(R.layout.empty_my_bill, (ViewGroup) recycleView.getParent(), false);
        EmptyView.findViewById(R.id.btn_verification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppActivityManager.getAppManager().finishActivity(MyBillActivity.this);
            }
        });
        GliderHelper.loadImage(R.drawable.net_error, ivErrorLogo, null);
        uid = SharedPreferencesUtil.getInstance(MyApplication.getContext()).getInt(Constant.UID, -1);
        recycleView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                List<MyBillModel.DataEntity> list = baseQuickAdapter.getData();
                Bundle bundle = new Bundle();
                if ("1".equals(list.get(i).getReturn_type())) {//分期还款
                    bundle.putString("id", list.get(i).getId());
                    startActivity(LoanStagingDetailActivity.class, bundle);
                } else {
                    bundle.putString("id", list.get(i).getId());
                    startActivity(LoanDetailActivity.class, bundle);
                }
            }
        });
    }

    @Override
    protected void initData() {
        mMyBillPresenter = new MyBillPresenter(this);
        mMyBillPresenter.billList(uid);
    }

    @Override
    public void getData(MyBillModel myBillModel) {
        errorPage.setVisibility(View.GONE);
        recycleView.setVisibility(View.VISIBLE);
        mMyBillAdapter = mMyBillPresenter.getAdapter();
        recycleView.setAdapter(mMyBillAdapter);
    }

    /**
     * 错误页面
     */
    @OnClick(R.id.btn_error)
    public void errorBtn() {
        mMyBillPresenter.billList(uid);
    }

    @Override
    public void empty() {
        mMyBillAdapter.setEmptyView(EmptyView);
    }

    @Override
    public void showProgressDialog() {
        createLoadingDialog();
    }

    @Override
    public void hiteProgressDialog() {
        cancleDialog();
    }

    @Override
    public void showError(String error) {
        errorPage.setVisibility(View.VISIBLE);
        recycleView.setVisibility(View.GONE);
        LogUtil.e(error);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMyBillPresenter.unsubcrible();
    }
}
