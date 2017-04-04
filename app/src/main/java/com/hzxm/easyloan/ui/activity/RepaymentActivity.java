package com.hzxm.easyloan.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hzxm.easyloan.MyApplication;
import com.hzxm.easyloan.R;
import com.hzxm.easyloan.model.home.RepaymentModel;
import com.hzxm.easyloan.presenter.implPresenter.RepaymentPresenter;
import com.hzxm.easyloan.presenter.implView.IRepaymentView;
import com.hzxm.easyloan.utils.Constant;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.util.LogUtil;
import com.lmz.baselibrary.util.SharedPreferencesUtil;
import com.lmz.baselibrary.util.glide.GliderHelper;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 还款记录
 */
public class RepaymentActivity extends BaseActivity implements IRepaymentView {
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_rate)
    TextView tvRate;
    @BindView(R.id.tv_formalities)
    TextView tvFormalities;
    @BindView(R.id.tv_withdraw)
    TextView tvWithdraw;
    @BindView(R.id.tv_audit)
    TextView tvAudit;
    @BindView(R.id.tv_overdue_money)
    TextView tvOverdueMoney;
    @BindView(R.id.tv_principal)
    TextView tvPrincipal;
    @BindView(R.id.tv_style)
    TextView tvStyle;
    @BindView(R.id.rl_style)
    RelativeLayout rlStyle;
    @BindView(R.id.tv_sum_money)
    TextView tvSumMoney;
    @BindView(R.id.btn_application)
    Button btnApplication;
    @BindView(R.id.activity_loan)
    LinearLayout activityLoan;
    @BindView(R.id.iv_error_logo)
    ImageView ivErrorLogo;
    @BindView(R.id.btn_error)
    Button btnError;
    @BindView(R.id.error_page)
    LinearLayout errorPage;
    private String id;
    private int uid;
    private RepaymentPresenter mRepaymentPresenter;
    private RepaymentModel repaymentModel;

    @BindString(R.string.nomal_repayment)
    String mNomalRepayment;

    @BindString(R.string.periods_repayment)
    String mPeriodsRepayment;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_repayment);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        GliderHelper.loadImage(R.drawable.net_error, ivErrorLogo, null);
    }

    @Override
    protected void initData() {
        uid = SharedPreferencesUtil.getInstance(MyApplication.getContext()).getInt(Constant.UID, -1);
        id = getIntent().getStringExtra("id");
        mRepaymentPresenter = new RepaymentPresenter(this);
        mRepaymentPresenter.repayment(uid, id);
    }

    /**
     * 错误页面
     */
    @OnClick(R.id.btn_error)
    public void errorBtn() {
        mRepaymentPresenter.repayment(uid, id);
    }


    /**
     * 获得首页数据
     *
     * @param repaymentModel
     */
    @Override
    public void data(RepaymentModel repaymentModel) {
        errorPage.setVisibility(View.GONE);
        activityLoan.setVisibility(View.VISIBLE);
        this.repaymentModel = repaymentModel;
        if (repaymentModel.getData().getOverdue() != null) {
            tvOverdueMoney.setVisibility(View.VISIBLE);
            tvOverdueMoney.setText("逾期费用：" + repaymentModel.getData().getOverdue() + "元");
        }
        tvMoney.setText(repaymentModel.getData().getRepay_money());
        tvRate.setText("利率费：" + repaymentModel.getData().getRate_money() + "元");
        tvFormalities.setText("手续费：" + repaymentModel.getData().getChecked_money() + "元");
        tvWithdraw.setText("提现费：" + repaymentModel.getData().getCash_money() + "元");
        tvPrincipal.setText("本金：" + repaymentModel.getData().getBorrow_money() + "元");
        //1分期，2正常
        if ("1".equals(repaymentModel.getData().getReturn_type())) {
            tvStyle.setText(mPeriodsRepayment);
        } else if ("2".equals(repaymentModel.getData().getReturn_type())) {
            tvStyle.setText(mNomalRepayment);
        }
        tvSumMoney.setText(repaymentModel.getData().getReslly_repay_money() + "(元)");
    }

    @OnClick(R.id.btn_application)
    public void repaymentCheck() {
        if (repaymentModel != null) {
            if (repaymentModel.getData().getOverdue() != null) { //逾期
                mRepaymentPresenter.repaymentCheck(uid, id, repaymentModel.getData().getOverdue());
            } else {
                mRepaymentPresenter.repaymentCheck(uid, id, "");
            }
        }
    }

    /**
     * 还款成功
     */
    @Override
    public void repaymentSuccess() {
        startActivity(RepaymentApplicationActivity.class);
    }

    /**
     * 还款失败
     *
     * @param error
     */
    @Override
    public void repaymentFaild(String error) {
        LogUtil.e(error);
        showToast(error, Toast.LENGTH_SHORT);
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
        activityLoan.setVisibility(View.GONE);
        LogUtil.e(error);
        showToast(error, Toast.LENGTH_SHORT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRepaymentPresenter.unsubcrible();
    }

}
