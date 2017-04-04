package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.home.SystemMsgModel;
import com.hzxm.easyloan.presenter.ISeeting;
import com.hzxm.easyloan.presenter.implView.ISeetingView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2017/1/9 0009 14:22
 */
public class SeetingPresenter extends BasePresenterImpl implements ISeeting {
    private ISeetingView mISeetingView;

    public SeetingPresenter(ISeetingView mISeetingView) {
        this.mISeetingView = mISeetingView;
    }

    /**
     * 获得联系电话
     */
    @Override
    public void systemTelMsg() {
        Subscription s = ApiManager.getInstance().getLoanApiService().systemMsg(System.currentTimeMillis() + "", "9f7a999afac43e6b50ef7204f69f93b7", "1")
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mISeetingView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SystemMsgModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mISeetingView.hiteProgressDialog();
                        mISeetingView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(SystemMsgModel systemMsgModel) {
                        mISeetingView.hiteProgressDialog();
                        if (systemMsgModel.getCode() == 0) {
                            mISeetingView.tel(systemMsgModel.getData());
                        } else {
                            mISeetingView.showError(systemMsgModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }

    /**
     * 关于我们
     */
    @Override
    public void systemAboutUs() {
        Subscription s = ApiManager.getInstance().getLoanApiService().systemMsg(System.currentTimeMillis() + "", "9f7a999afac43e6b50ef7204f69f93b7", "3")
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mISeetingView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SystemMsgModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mISeetingView.hiteProgressDialog();
                        mISeetingView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(SystemMsgModel systemMsgModel) {
                        mISeetingView.hiteProgressDialog();
                        if (systemMsgModel.getCode() == 0) {
                            mISeetingView.aboutUs(systemMsgModel.getData());
                        } else {
                            mISeetingView.showError(systemMsgModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }
}
