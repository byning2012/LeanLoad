package com.hzxm.easyloan.presenter.implView;

import com.lmz.baselibrary.present.implView.IBasePresenter;

/**
 * 作者：LMZ on 2017/1/3 0003 09:46
 */
public interface IRelatedOtherDataView extends IBasePresenter {
    void uploadSuccess(String path, int mtype);

    void uploadPrograss(long hasWrittenLen, long totalLen, int mtype);

    void showPicError(String msg, int mtype);

    void showSuccess();
}
