package com.hzxm.easyloan.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hzxm.easyloan.MyApplication;
import com.hzxm.easyloan.R;
import com.hzxm.easyloan.model.home.HomeModel;
import com.hzxm.easyloan.presenter.implPresenter.LoanNowPresenter;
import com.hzxm.easyloan.presenter.implView.ILoanNowView;
import com.hzxm.easyloan.utils.Constant;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.util.LogUtil;
import com.lmz.baselibrary.util.SharedPreferencesUtil;
import com.lmz.baselibrary.util.StringUtils;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 借款
 */
public class LoanActivity extends BaseActivity implements ILoanNowView {

    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_rate)
    TextView tvRate;
    @BindView(R.id.tv_formalities)
    TextView tvFormalities;
    @BindView(R.id.tv_audit)
    TextView tvAudit;
    @BindView(R.id.tv_withdraw)
    TextView tvWithdraw;
    @BindView(R.id.tv_principal)
    TextView tvPrincipal;
    @BindView(R.id.iv_go)
    ImageView ivGo;
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

    @BindView(R.id.rl_choose_card)
    RelativeLayout mChooseCard;
    @BindView(R.id.tv_bank_name)
    TextView mBankName;
    private int type;
    private float mTotleMoney, mSalaryMoney, mCrashMoney, mCheckMoney, mDepositMoney;
    private int data, mPrincipal;//日期 和本金

    private HomeModel.DataEntity mHomeModel;

    @BindString(R.string.nomal_loan)
    String nomalLoan;

    private int uid;
    private int mStaging;//分期次数
    private float mStagingMoney;
    private String carNum;

    private LoanNowPresenter mLoanNowPresenter;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_loan);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {

    }

    @Override
    protected void initData() {
        mLoanNowPresenter = new LoanNowPresenter(this);
        uid = SharedPreferencesUtil.getInstance(MyApplication.getContext()).getInt(Constant.UID, -1);
        Intent intent = getIntent();
        try {
            type = intent.getIntExtra("type", -1);
            mHomeModel = intent.getExtras().getParcelable("model");
            mTotleMoney = intent.getFloatExtra("totle", 0);
            mPrincipal = intent.getIntExtra("principal", 0);//本金
            mSalaryMoney = intent.getFloatExtra("salary_money", 0); //利息钱
            mCrashMoney = intent.getFloatExtra("crash_money", 0); //服务费
            mCheckMoney = intent.getFloatExtra("check_money", 0); //审核费
            data = intent.getIntExtra("data", 0);
            mStaging = intent.getIntExtra("time", 0);
            mDepositMoney = intent.getFloatExtra("deposit", 0);
        } catch (NullPointerException e) {
            LogUtil.e(e);
        }
//        如果是正常借款  不允许查看详情
        if (type == 2) {
            tvStyle.setText(nomalLoan);
            tvStyle.setCompoundDrawables(null, null, null, null);
            rlStyle.setOnClickListener(null);
        } else {
            tvAudit.setVisibility(View.VISIBLE);
            tvAudit.setText("押金：" + (float) (Math.round(mDepositMoney * 100)) / 100 + "元");
        }
        tvMoney.setText(mTotleMoney + "");

        tvRate.setText("利率费：" + (float) (Math.round(mSalaryMoney * 100)) / 100 + "元");
        tvFormalities.setText("手续费：" + (float) (Math.round(mCrashMoney * 100)) / 100 + "元");
        tvWithdraw.setText("提现费：" + (float) (Math.round(mCheckMoney * 100)) / 100 + "元");
        tvPrincipal.setText("本金：" + (float) (Math.round(mTotleMoney * 100)) / 100 + "元");
        tvSumMoney.setText(mPrincipal + "(元)");

    }

    @OnClick(R.id.rl_style)
    public void staging() {
        if (type == 1) {
            Bundle bundle = new Bundle();
            bundle.putFloat("TotleMoney", mTotleMoney);
            bundle.putFloat("salary", mSalaryMoney + mCrashMoney + mCheckMoney + mDepositMoney);
            bundle.putInt("data", data);
            startActivity(StagingActivity.class, bundle);
        }
    }

    @OnClick(R.id.rl_choose_card)
    public void chooseBank() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("loanActivity", true);
        startActivityForResult(BankCarManagerActivity.class, bundle, 101);
    }

    /**
     * 点击申请借款
     */
    @OnClick(R.id.btn_application)
    public void application() {
        showDialog();
    }

    protected void showDialog() {
        final Dialog dialog = new Dialog(this, R.style.dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_protocol, null);
        final TextView msgTv = (TextView) view.findViewById(R.id.et_detail_address);
        final TextView mExpandTv = (TextView) view.findViewById(R.id.tv_expand);
        final ImageView mBgIv = (ImageView) view.findViewById(R.id.iv_bg);
        final RelativeLayout mMsgRl = (RelativeLayout) view.findViewById(R.id.rl_msg);
        //删除按钮
        view.findViewById(R.id.rl_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.btn_sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type == 1) {//分期
                    mLoanNowPresenter.borrow_money(uid + "", mPrincipal + "", mSalaryMoney + "", mCheckMoney + "", mCrashMoney + "", 1
                            , mHomeModel.getNormal_salary(), mHomeModel.getNormal_check(), mHomeModel.getNormal_crash(),
                            mHomeModel.getDepart_salary(), mHomeModel.getDepart_check(), mHomeModel.getDepart_crash(), mHomeModel.getDepart_money(), carNum, mStaging + "", data + "");
                } else {//正常借款
                    mLoanNowPresenter.borrow_money(uid + "", mPrincipal + "", mSalaryMoney + "", mCheckMoney + "", mCrashMoney + "", 2
                            , mHomeModel.getNormal_salary(), mHomeModel.getNormal_check(), mHomeModel.getNormal_crash(),
                            mHomeModel.getDepart_salary(), mHomeModel.getDepart_check(), mHomeModel.getDepart_crash(), mHomeModel.getDepart_money(), carNum, "1", data + "");
                }
                dialog.dismiss();
            }
        });
        //点击展开按钮
        mExpandTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBgIv.setVisibility(View.GONE);
                ViewGroup.LayoutParams params = mMsgRl.getLayoutParams();
                params.height = StringUtils.dip2px(LoanActivity.this, 200);
                mMsgRl.setLayoutParams(params);
                mExpandTv.setVisibility(View.GONE);
                msgTv.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
        });

        dialog.setContentView(view);
        Window window = dialog.getWindow();
        assert window != null;
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.width = StringUtils.dip2px(this, 300);
        window.setGravity(Gravity.CENTER);
        dialog.onWindowAttributesChanged(wl);
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == 101) {
            if (data != null) {
                mBankName.setText(data.getStringExtra("name"));
                carNum = data.getStringExtra("number");
            }

        }
    }

    /**
     * 申请成功
     */
    @Override
    public void loanSuccess() {
        startActivity(LoanApplicationActivity.class);
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
        showToast(error, Toast.LENGTH_SHORT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoanNowPresenter.unsubcrible();
    }

}
