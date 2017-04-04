package com.hzxm.easyloan.presenter;

/**
 * 作者：LMZ on 2017/1/9 0009 16:47
 */
public interface IPswModify {
    void updataPsw(String uid, String hashid, String oldPsw, String newPsw, String repeatPsw);
}
