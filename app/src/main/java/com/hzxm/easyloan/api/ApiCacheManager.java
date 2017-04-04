package com.hzxm.easyloan.api;

import com.cpoopc.retrofitrxcache.BasicCache;
import com.cpoopc.retrofitrxcache.RxCacheCallAdapterFactory;
import com.hzxm.easyloan.MyApplication;
import com.hzxm.easyloan.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：LMZ on 2016/12/20 0020 16:11
 */
public class ApiCacheManager {
    private static ApiCacheManager apiManager;

    public static ApiCacheManager getInstance() {
        synchronized (ApiCacheManager.class) {
            if (apiManager == null) {
                apiManager = new ApiCacheManager();
            }
        }
        return apiManager;
    }

    LoanApi loanApi;
    private Object object = new Object();


    public LoanApi getLoanCacheService() {
        //缓存的数据 必须每次都请求
        loanApi = new Retrofit.Builder()
                .baseUrl(Constant.WebSite)
                .addCallAdapterFactory(RxCacheCallAdapterFactory.create(BasicCache.fromCtx(MyApplication.getApplication()), false))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(LoanApi.class);
        return loanApi;
    }

}
