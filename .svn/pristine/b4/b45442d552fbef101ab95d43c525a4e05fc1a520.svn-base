package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.BaseModel;
import com.hzxm.easyloan.model.home.RepaymentModel;
import com.hzxm.easyloan.presenter.IRepayMent;
import com.hzxm.easyloan.presenter.implView.IRepaymentView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2017/1/16 0016 10:01
 */
public class RepaymentPresenter extends BasePresenterImpl implements IRepayMent {
    private IRepaymentView mIRepaymentView;

    public RepaymentPresenter(IRepaymentView mIRepaymentView) {
        this.mIRepaymentView = mIRepaymentView;
    }

    /**
     * 还款
     *
     * @param uid
     * @param id
     */
    @Override
    public void repayment(int uid, String id) {
        Subscription s = ApiManager.getInstance().getLoanApiService().repayment(System.currentTimeMillis() + "", "cf4108d9eee06fecf9f6d5e867002ef0", uid + "", id)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIRepaymentView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RepaymentModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mIRepaymentView.hiteProgressDialog();
                        mIRepaymentView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(RepaymentModel repaymentModel) {
                        mIRepaymentView.hiteProgressDialog();
                        if (repaymentModel.getCode() == 0) {
                            mIRepaymentView.data(repaymentModel);
                        } else {
                            mIRepaymentView.showError(repaymentModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }

    /**
     * 提交还款
     *
     * @param uid
     * @param id
     * @param overdue
     */
    @Override
    public void repaymentCheck(int uid, String id, String overdue) {
        Subscription s = ApiManager.getInstance().getLoanApiService().repaymentCheck(System.currentTimeMillis() + "", "951f65d9a10d13d57bbda3c44d729547",
                uid + "", id, overdue)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIRepaymentView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mIRepaymentView.hiteProgressDialog();
                        mIRepaymentView.repaymentFaild(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        mIRepaymentView.hiteProgressDialog();
                        if (baseModel.getCode() == 0) {
                            mIRepaymentView.repaymentSuccess();
                        } else {
                            mIRepaymentView.repaymentFaild(baseModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }
}
