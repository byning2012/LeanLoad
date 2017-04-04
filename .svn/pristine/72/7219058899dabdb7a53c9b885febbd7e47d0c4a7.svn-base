package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.BaseModel;
import com.hzxm.easyloan.model.mine.SocialSecurityModel;
import com.hzxm.easyloan.presenter.ISocialSecurity;
import com.hzxm.easyloan.presenter.implView.ISocialSecurityView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2017/2/10 0010 10:12
 */
public class SocialSecurityPresenter extends BasePresenterImpl implements ISocialSecurity {
    private ISocialSecurityView mISocialSecurityView;

    public SocialSecurityPresenter(ISocialSecurityView mISocialSecurityView) {
        this.mISocialSecurityView = mISocialSecurityView;
    }

    /**
     * 获取社保
     *
     * @param uid
     * @param area
     * @param username
     * @param password
     */
    @Override
    public void socalSearch(String uid, String area, String username, String password) {
        Subscription s = ApiManager.getInstance().getLoanApiService().socialSecurity(System.currentTimeMillis() + "", "33721bbee545658456a6af752791258e",
                uid, area, username, password)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mISocialSecurityView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SocialSecurityModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mISocialSecurityView.hiteProgressDialog();
                        mISocialSecurityView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(SocialSecurityModel socialSecurityModel) {
                        mISocialSecurityView.hiteProgressDialog();
                        if (socialSecurityModel.getCode() == 0) {
                            mISocialSecurityView.findSuccess(socialSecurityModel.getData().getData());
                        } else if (socialSecurityModel.getData().getState().equals("9")) {
                            mISocialSecurityView.findError(socialSecurityModel.getData().getMsg());
                        } else {
                            mISocialSecurityView.showError(socialSecurityModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }

    @Override
    public void socalResult(String uid, String token, String username, String password) {
        Subscription s = ApiManager.getInstance().getLoanApiService().socialResult(System.currentTimeMillis() + "", "d07a4cd4c49d45e1487fe817de8f4fa3",
                uid, token, username, password)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mISocialSecurityView.showProgressDialog();
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
                        mISocialSecurityView.hiteProgressDialog();
                        mISocialSecurityView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        mISocialSecurityView.hiteProgressDialog();
                        if (baseModel.getCode() == 0) {
                            mISocialSecurityView.resultSuccess();
                        } else {
                            mISocialSecurityView.showError(baseModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }
}
