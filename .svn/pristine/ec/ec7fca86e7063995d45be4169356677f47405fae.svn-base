package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.home.LoanDetailModel;
import com.hzxm.easyloan.presenter.ILoanDetailNomal;
import com.hzxm.easyloan.presenter.implView.ILoanDetailView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2017/1/17 0017 10:50
 */
public class LoanDetailPresenterr extends BasePresenterImpl implements ILoanDetailNomal {
    private ILoanDetailView mILoanDetailView;

    public LoanDetailPresenterr(ILoanDetailView mILoanDetailView) {
        this.mILoanDetailView = mILoanDetailView;
    }

    /**
     * 获得数据
     *
     * @param id
     */
    @Override
    public void nomalDetail(String id) {
        Subscription s = ApiManager.getInstance().getLoanApiService().loanDetail(System.currentTimeMillis() + "", "39a851a7218472226ece36d1377f3cf0", id)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mILoanDetailView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoanDetailModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mILoanDetailView.hiteProgressDialog();
                        mILoanDetailView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(LoanDetailModel loanDetailModel) {
                        mILoanDetailView.hiteProgressDialog();
                        if (loanDetailModel.getCode() == 0) {
                            mILoanDetailView.getData(loanDetailModel);
                        } else {
                            mILoanDetailView.showError(loanDetailModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }
}
