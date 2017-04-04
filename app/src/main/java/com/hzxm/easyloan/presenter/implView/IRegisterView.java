package com.hzxm.easyloan.presenter.implView;

import com.hzxm.easyloan.model.RegisterModel;
import com.lmz.baselibrary.present.implView.IBasePresenter;

/**
 * 作者：LMZ on 2016/12/24 0024 16:52
 * 注册
 */
public interface IRegisterView extends IBasePresenter {
    void showSuccess();

    void registerData(RegisterModel registerModel);
}
