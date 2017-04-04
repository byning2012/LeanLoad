package com.hzxm.easyloan.presenter;

/**
 * 作者：LMZ on 2016/12/27 0027 14:53
 * 基础认证
 */
public interface IBaseCertification {
    void baseInfoData(int uid);

    void submitInfo(int uid, String step);
}
