package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.BaseModel;
import com.hzxm.easyloan.model.mine.BaseCertificationModel;
import com.hzxm.easyloan.presenter.IBaseCertification;
import com.hzxm.easyloan.presenter.implView.IBaseCertificationView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2016/12/27 0027 15:01
 * 基础认证
 */
public class BaseCertifyPresenter extends BasePresenterImpl implements
        IBaseCertification {
    private IBaseCertificationView mIBaseCertificationView;
    private int uid;

    public BaseCertifyPresenter(IBaseCertificationView mIBaseCertificationView, int uid) {
        this.mIBaseCertificationView = mIBaseCertificationView;
        this.uid = uid;
    }

    /**
     * 获取认证基础信息
     *
     * @param uid
     */
    @Override
    public void baseInfoData(int uid) {
        this.uid = uid;
        Subscription s = ApiManager.getInstance().getLoanApiService().baseInfoData(System.currentTimeMillis() + "", "4b50512c9c732419a0d992ab9cd202bc", uid + "")
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIBaseCertificationView.showProgressDialog();
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
                        mIBaseCertificationView.showError(e.getMessage());
                        mIBaseCertificationView.hiteProgressDialog();
                    }

                    @Override
                    public void onNext(BaseCertificationModel baseCertificationModel) {
                        mIBaseCertificationView.hiteProgressDialog();
                        int code = baseCertificationModel.getCode();
                        if (code == 0) {
                            mIBaseCertificationView.data(baseCertificationModel);
                        } else {
                            mIBaseCertificationView.showError(baseCertificationModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }

    /**
     * 提交资料审核
     *
     * @param uid
     * @param step
     */
    @Override
    public void submitInfo(int uid, String step) {
        Subscription s = ApiManager.getInstance().getLoanApiService().baseStep(System.currentTimeMillis() + "", "17af1feb6de14aac1c7ace201e077b30"
                , uid + "", step)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIBaseCertificationView.showProgressDialog();
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
                        mIBaseCertificationView.showError(e.getMessage());
                        mIBaseCertificationView.hiteProgressDialog();
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        mIBaseCertificationView.hiteProgressDialog();
                        if (baseModel.getCode() == 0) {
                            mIBaseCertificationView.submitSuccess();
                        } else {
                            mIBaseCertificationView.showError(baseModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }
}
