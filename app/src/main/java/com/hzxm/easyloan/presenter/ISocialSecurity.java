package com.hzxm.easyloan.presenter;

/**
 * 作者：LMZ on 2017/2/10 0010 09:59
 */
public interface ISocialSecurity {
    void socalSearch(String uid, String area, String username, String password);
    void socalResult(String uid,String token,String username,String password);
}
