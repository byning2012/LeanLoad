package com.hzxm.easyloan.presenter.implView;

import com.hzxm.easyloan.model.RecodeModel;
import com.lmz.baselibrary.present.implView.IBasePresenter;

/**
 * 作者：LMZ on 2016/12/26 0026 10:38
 */
public interface IFindPswView extends IBasePresenter {
    void showSuccess();

    void getRecodeId(RecodeModel recodeModel);
}
