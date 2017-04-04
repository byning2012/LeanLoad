package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.adapter.home.MyBillAdapter;
import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.home.MyBillModel;
import com.hzxm.easyloan.presenter.IMyBill;
import com.hzxm.easyloan.presenter.implView.IMyBillView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2017/1/16 0016 16:01
 */
public class MyBillPresenter extends BasePresenterImpl implements IMyBill {
    private IMyBillView mIMyBillView;
    private List<MyBillModel.DataEntity> mBillsList = new ArrayList<>();
    private MyBillAdapter mMyBillAdapter;

    public MyBillPresenter(IMyBillView mIMyBillView) {
        this.mIMyBillView = mIMyBillView;
        mMyBillAdapter = new MyBillAdapter(mBillsList);
    }

    /**
     * 获得列表
     *
     * @param uid
     */
    @Override
    public void billList(int uid) {
        Subscription s = ApiManager.getInstance().getLoanApiService().billModel(System.currentTimeMillis() + "", "4b50512c9c732419a0d992ab9cd202bc", uid + "")
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIMyBillView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MyBillModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mIMyBillView.showError(e.getMessage());
                        mIMyBillView.hiteProgressDialog();
                    }

                    @Override
                    public void onNext(MyBillModel myBillModel) {
                        mIMyBillView.hiteProgressDialog();
                        if (myBillModel.getCode() == 0) {
                            mBillsList = myBillModel.getData();
                            mMyBillAdapter.setNewData(mBillsList);
                            mIMyBillView.getData(myBillModel);
                            if (mBillsList.size() == 0) {
                                mIMyBillView.empty();
                            }
                        } else {
                            mIMyBillView.showError(myBillModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }

    @Override
    public MyBillAdapter getAdapter() {
        return mMyBillAdapter;
    }


}
