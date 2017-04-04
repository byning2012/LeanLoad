package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.BaseModel;
import com.hzxm.easyloan.presenter.IFeedBack;
import com.hzxm.easyloan.presenter.implView.IFeedBackView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2017/1/7 0007 13:47
 */
public class FeedBackPresenter extends BasePresenterImpl implements IFeedBack {
    private IFeedBackView mIFeedBackView;

    public FeedBackPresenter(IFeedBackView mIFeedBackView) {
        this.mIFeedBackView = mIFeedBackView;
    }

    /**
     * 意见反馈
     *
     * @param uid
     * @param tel
     * @param content
     */
    @Override
    public void feedBack(String uid, String tel, String content) {
        Subscription s = ApiManager.getInstance().getLoanApiService().feedBack(System.currentTimeMillis() + "", "0d674b54a5f1a1f7b578e6add30cb5ef",
                uid, tel, content)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIFeedBackView.showProgressDialog();
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
                        mIFeedBackView.showError(e.getMessage());
                        mIFeedBackView.hiteProgressDialog();
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        mIFeedBackView.hiteProgressDialog();
                        if (baseModel.getCode() == 0) {
                            mIFeedBackView.suggestSuccess();
                        } else {
                            mIFeedBackView.showError(baseModel.getMsg());
                        }

                    }
                });
        addSubscription(s);
    }
}
