package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.adapter.home.LoanStagingAdapter;
import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.home.LoanStagingModel;
import com.hzxm.easyloan.presenter.ILoanStagingDetail;
import com.hzxm.easyloan.presenter.implView.ILoanStagingDetailView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2017/1/16 0016 18:14
 */
public class LoanStagingPresenter extends BasePresenterImpl implements ILoanStagingDetail {
    private ILoanStagingDetailView mILoanStagingDetailView;
    private LoanStagingAdapter mLoanStagingAdapter;
    private List<LoanStagingModel.DataEntity> list = new ArrayList<>();

    public LoanStagingPresenter(ILoanStagingDetailView mILoanStagingDetailView) {
        this.mILoanStagingDetailView = mILoanStagingDetailView;
        mLoanStagingAdapter = new LoanStagingAdapter(list);
    }

    /**
     * 获取订单列表
     *
     * @param uid
     * @param id
     */
    @Override
    public void billListDetail(int uid, String id) {
        Subscription s = ApiManager.getInstance().getLoanApiService().loanStaging(System.currentTimeMillis() + "", "cf4108d9eee06fecf9f6d5e867002ef0", uid + "", id)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mILoanStagingDetailView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoanStagingModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mILoanStagingDetailView.hiteProgressDialog();
                        mILoanStagingDetailView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(LoanStagingModel loanStagingModel) {
                        mILoanStagingDetailView.hiteProgressDialog();
                        if (loanStagingModel.getCode() == 0) {
                            list = loanStagingModel.getData();
                            if (list.size() == 0) {
                                mILoanStagingDetailView.emptyView();
                            }
                            mLoanStagingAdapter.setNewData(list);
                            mILoanStagingDetailView.getData(loanStagingModel);
                        } else {
                            mILoanStagingDetailView.showError(loanStagingModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }

    @Override
    public LoanStagingAdapter getAdapter() {
        return mLoanStagingAdapter;
    }
}
