package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.adapter.mine.RepaymentListAdapter;
import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.mine.RepaymentListModel;
import com.hzxm.easyloan.presenter.IRepaymentDetail;
import com.hzxm.easyloan.presenter.implView.IRepaymentDetailView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2017/1/17 0017 14:48
 */
public class RepaymentDetailPresenter extends BasePresenterImpl implements IRepaymentDetail {

    private IRepaymentDetailView mIRepaymentDetailView;

    private List<RepaymentListModel.DataEntity> mRepaymentLists = new ArrayList<>();

    private RepaymentListAdapter mRepaymentListAdapter;

    public RepaymentDetailPresenter(IRepaymentDetailView mIRepaymentDetailView) {
        this.mIRepaymentDetailView = mIRepaymentDetailView;
        mRepaymentListAdapter = new RepaymentListAdapter(mRepaymentLists);
    }

    /**
     * 获得列表
     *
     * @param uid
     */
    @Override
    public void repayList(int uid) {
        Subscription s = ApiManager.getInstance().getLoanApiService().repayList(System.currentTimeMillis() + "", "4b50512c9c732419a0d992ab9cd202bc", uid + "")
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIRepaymentDetailView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RepaymentListModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mIRepaymentDetailView.showError(e.getMessage());
                        mIRepaymentDetailView.hiteProgressDialog();
                    }

                    @Override
                    public void onNext(RepaymentListModel repaymentListModel) {
                        mIRepaymentDetailView.hiteProgressDialog();
                        if (repaymentListModel.getCode() == 0) {
                            mIRepaymentDetailView.success();
                            if (mRepaymentLists.size() == 0) {
                                mIRepaymentDetailView.emptyView();
                            }
                            mRepaymentLists = repaymentListModel.getData();
                            mRepaymentListAdapter.setNewData(mRepaymentLists);

                        }
                    }
                });
        addSubscription(s);
    }

    @Override
    public RepaymentListAdapter getAdapter() {
        return mRepaymentListAdapter;
    }
}
