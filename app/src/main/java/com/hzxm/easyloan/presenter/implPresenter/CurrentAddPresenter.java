package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.BaseModel;
import com.hzxm.easyloan.presenter.ICurrentAddress;
import com.hzxm.easyloan.presenter.implView.ICurrentAddressView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2016/12/28 0028 10:38
 */
public class CurrentAddPresenter extends BasePresenterImpl implements ICurrentAddress {
    private ICurrentAddressView mICurrentAddressView;

    public CurrentAddPresenter(ICurrentAddressView mICurrentAddressView) {
        this.mICurrentAddressView = mICurrentAddressView;
    }

    /**
     * 上传详细地址
     *
     * @param uid
     * @param address
     */
    @Override
    public void detailAddress(int uid, String address) {
        Subscription s = ApiManager.getInstance().getLoanApiService().baseAddress(System.currentTimeMillis() + "", "70f0f0cdde26660f5bf473123926d87f",
                uid + "", address)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mICurrentAddressView.showProgressDialog();
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
                        mICurrentAddressView.hiteProgressDialog();
                        mICurrentAddressView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        mICurrentAddressView.hiteProgressDialog();
                        int code = baseModel.getCode();
                        if (code == 0) {
                            mICurrentAddressView.addressSuccess();
                        } else {
                            mICurrentAddressView.showError(baseModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }
}
