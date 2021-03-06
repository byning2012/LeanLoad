package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.BaseModel;
import com.hzxm.easyloan.model.mine.BaseCertificationModel;
import com.hzxm.easyloan.presenter.ICompleteInfo;
import com.hzxm.easyloan.presenter.implView.ICompleteInfoView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2017/1/4 0004 17:06
 */
public class CompleteInfoPresenter extends BasePresenterImpl implements ICompleteInfo {
    private ICompleteInfoView mICompleteInfoView;

    public CompleteInfoPresenter(ICompleteInfoView mICompleteInfoView) {
        this.mICompleteInfoView = mICompleteInfoView;
    }

    /**
     * 请求下一步
     *
     * @param uid
     */
    @Override
    public void next(String uid) {
        Subscription s = ApiManager.getInstance().getLoanApiService().baseStep(System.currentTimeMillis() + "", "17af1feb6de14aac1c7ace201e077b30",
                uid, "2")
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mICompleteInfoView.showProgressDialog();
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
                        mICompleteInfoView.hiteProgressDialog();
                        mICompleteInfoView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        mICompleteInfoView.hiteProgressDialog();
                        mICompleteInfoView.showSuccess();
                    }
                });
        addSubscription(s);
    }

    /**
     * 获得基础数据
     *
     * @param uid
     */
    @Override
    public void baseInfoData(int uid) {
        Subscription s = ApiManager.getInstance().getLoanApiService().baseInfoData(System.currentTimeMillis() + "", "4b50512c9c732419a0d992ab9cd202bc", uid + "")
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mICompleteInfoView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseCertificationModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mICompleteInfoView.hiteProgressDialog();
                        mICompleteInfoView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseCertificationModel baseCertificationModel) {
                        mICompleteInfoView.hiteProgressDialog();
                        int code = baseCertificationModel.getCode();
                        if (code == 0) {
                            mICompleteInfoView.data(baseCertificationModel);
                        } else {
                            mICompleteInfoView.showError(baseCertificationModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }
}
