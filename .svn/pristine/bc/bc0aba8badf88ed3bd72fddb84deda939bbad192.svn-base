package com.hzxm.easyloan.presenter.implPresenter;

import com.cpoopc.retrofitrxcache.RxCacheResult;
import com.hzxm.easyloan.api.ApiCacheManager;
import com.hzxm.easyloan.model.mine.MineModel;
import com.hzxm.easyloan.presenter.IMine;
import com.hzxm.easyloan.presenter.implView.IMineView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2017/1/17 0017 14:21
 */
public class MinePresenter extends BasePresenterImpl implements IMine {
    private IMineView mIMineView;

    public MinePresenter(IMineView mIMineView) {
        this.mIMineView = mIMineView;
    }

    /**
     * 获取个人信息
     *
     * @param uid
     */
    @Override
    public void mineMsg(int uid) {
        Subscription s = ApiCacheManager.getInstance().getLoanCacheService().mineMsg(System.currentTimeMillis() + "", "4b50512c9c732419a0d992ab9cd202bc", uid + "")
                .subscribeOn(Schedulers.io())
                .materialize()
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIMineView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .<RxCacheResult<MineModel>>dematerialize()
                .map(new Func1<RxCacheResult<MineModel>, MineModel>() {
                    @Override
                    public MineModel call(RxCacheResult<MineModel> mineModelRxCacheResult) {
                        return mineModelRxCacheResult.getResultModel();
                    }
                })
                .subscribe(new Subscriber<MineModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mIMineView.showError(e.getMessage());
                        mIMineView.hiteProgressDialog();
                    }

                    @Override
                    public void onNext(MineModel mineModel) {
                        mIMineView.hiteProgressDialog();
                        if (mineModel.getCode() == 0) {
                            mIMineView.getData(mineModel);
                        } else {
                            mIMineView.showError(mineModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }
}
