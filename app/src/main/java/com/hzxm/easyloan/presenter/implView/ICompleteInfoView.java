package com.hzxm.easyloan.presenter.implView;

import com.hzxm.easyloan.model.mine.BaseCertificationModel;
import com.lmz.baselibrary.present.implView.IBasePresenter;

/**
 * 作者：LMZ on 2017/1/4 0004 17:05
 */
public interface ICompleteInfoView extends IBasePresenter {
    void data(BaseCertificationModel baseCertificationModel);

    void showSuccess();
}
