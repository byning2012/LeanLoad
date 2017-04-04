package com.hzxm.easyloan.presenter.implPresenter;

import android.content.Context;

import com.hzxm.easyloan.adapter.chamberlain.CommonProblemAdapte;
import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.chamberlain.CommonProblemModel;
import com.hzxm.easyloan.model.home.SystemMsgModel;
import com.hzxm.easyloan.presenter.IChamberlain;
import com.hzxm.easyloan.presenter.implView.IChamberlainView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;
import com.lmz.baselibrary.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2017/1/6 0006 16:23
 */
public class ChamberlainPresenter extends BasePresenterImpl implements IChamberlain {
    private IChamberlainView mIChamberlainView;
    private CommonProblemAdapte mCommonProblemAdapte;
    List<CommonProblemModel.DataEntity> mProblem = new ArrayList<>();
    Context context;

    public ChamberlainPresenter(Context context, IChamberlainView mIChamberlainView) {
        this.mIChamberlainView = mIChamberlainView;
        this.context = context;
    }

    /**
     * 获取信息
     */
    @Override
    public void getsystem() {
        Subscription s = ApiManager.getInstance().getLoanApiService().getProblem(System.currentTimeMillis() + "", "70ffcb2a3569065c4420776b8a81809b")
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIChamberlainView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CommonProblemModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mIChamberlainView.hiteProgressDialog();
                        mIChamberlainView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(CommonProblemModel commonProblemModel) {
                        mIChamberlainView.hiteProgressDialog();
                        if (commonProblemModel.getCode() == 0) {
                            mProblem = commonProblemModel.getData();
                            LogUtil.e(mProblem.size());
                            mCommonProblemAdapte = new CommonProblemAdapte(context, mProblem);
                            mIChamberlainView.getAdapter(mCommonProblemAdapte);
                        } else {
                            mIChamberlainView.showError(commonProblemModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }

    /**
     * 获取管家资料
     */
    @Override
    public void chamberlainMsg() {
        Subscription s = ApiManager.getInstance().getLoanApiService().systemMsg(System.currentTimeMillis() + "", "9f7a999afac43e6b50ef7204f69f93b7"
                , "4")
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIChamberlainView.showProgressDialog();
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
                        mIChamberlainView.showError(e.getMessage());
                        mIChamberlainView.hiteProgressDialog();
                    }

                    @Override
                    public void onNext(SystemMsgModel systemMsgModel) {
                        mIChamberlainView.hiteProgressDialog();
                        if (systemMsgModel.getCode() == 0) {
                            mIChamberlainView.getMsg(systemMsgModel.getData());
                        } else {
                            mIChamberlainView.showError(systemMsgModel.getMsg());
                        }
                    }
                });
        addSubscription(s);

    }
}
