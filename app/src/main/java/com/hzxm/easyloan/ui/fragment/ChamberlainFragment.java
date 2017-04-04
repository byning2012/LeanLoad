package com.hzxm.easyloan.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hzxm.easyloan.R;
import com.hzxm.easyloan.adapter.chamberlain.CommonProblemAdapte;
import com.hzxm.easyloan.presenter.implPresenter.ChamberlainPresenter;
import com.hzxm.easyloan.presenter.implView.IChamberlainView;
import com.lmz.baselibrary.ui.BaseFragment;
import com.lmz.baselibrary.util.LogUtil;
import com.lmz.baselibrary.util.glide.GliderHelper;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.OnClick;
import ca.barrenechea.widget.recyclerview.decoration.DividerDecoration;

/**
 * 作者：LMZ on 2016/12/22 0022 14:59
 * 管家
 */
public class ChamberlainFragment extends BaseFragment implements IChamberlainView {
    @BindView(R.id.iv_news_remind)
    ImageView ivNewsRemind;
    @BindView(R.id.fl_news)
    FrameLayout flNews;
    @BindView(R.id.tv_msg)
    TextView tvMsg;
    @BindView(R.id.tv_common_proble)
    TextView tvCommonProble;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;

    @BindColor(R.color.home_blue)
    int mBlueColor;
    @BindView(R.id.iv_error_logo)
    ImageView ivErrorLogo;
    @BindView(R.id.btn_error)
    Button btnError;
    @BindView(R.id.error_page)
    LinearLayout errorPage;
    @BindView(R.id.ll_chamberlain)
    LinearLayout llChamberlain;


    private ChamberlainPresenter mChamberlainPresenter;

    @Override
    public int setFragmentLayoutID() {
        return R.layout.fragment_chamberlain;
    }

    @Override
    protected void initView(View rootView) {
        SetStatusBarColor(R.color.home_blue);
        //设置RecycleView
        recycleView.setLayoutManager(new LinearLayoutManager(context));
        recycleView.addItemDecoration(new DividerDecoration.Builder(context)
                .setHeight(R.dimen.dim2)
                .setColorResource(R.color.divide_line)
                .build());
        recycleView.setHasFixedSize(true);
        GliderHelper.loadImage(R.drawable.net_error, ivErrorLogo, null);
    }


    @Override
    protected void initData() {
        mChamberlainPresenter = new ChamberlainPresenter(getActivity(), this);
        mChamberlainPresenter.chamberlainMsg();
        mChamberlainPresenter.getsystem();
    }

    /**
     * 错误页面
     */
    @OnClick(R.id.btn_error)
    public void errorBtn() {
        mChamberlainPresenter.chamberlainMsg();
        mChamberlainPresenter.getsystem();
    }

    @Override
    public void getAdapter(CommonProblemAdapte commonProblemAdapte) {
        llChamberlain.setVisibility(View.VISIBLE);
        errorPage.setVisibility(View.GONE);
        recycleView.setAdapter(commonProblemAdapte);
    }

    /**
     * 获得管家信息
     *
     * @param msg
     */
    @Override
    public void getMsg(String msg) {
//        //改变字体颜色
        try {
            SpannableString ss = new SpannableString(msg);
            ss.setSpan(new ForegroundColorSpan(mBlueColor), msg.indexOf("\"") + 1, msg.length() - 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tvMsg.setText(ss);
        } catch (Exception e) {
            LogUtil.e(e);
        }
        llChamberlain.setVisibility(View.VISIBLE);
        errorPage.setVisibility(View.GONE);

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
        llChamberlain.setVisibility(View.GONE);
        errorPage.setVisibility(View.VISIBLE);
        LogUtil.e(error);
    }

    @Override
    public void onDestroy() {
        mChamberlainPresenter.unsubcrible();
        super.onDestroy();
    }

}
