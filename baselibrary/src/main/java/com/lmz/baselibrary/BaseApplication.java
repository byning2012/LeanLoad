package com.lmz.baselibrary;

import android.app.Application;
import android.content.Context;

/**
 * 作者：LMZ on 2016/12/20 0020 14:18
 */
public class BaseApplication extends Application {
    private static BaseApplication baseApplication;
    private BaseApplication application;
    private static int MainID;

    public static Application getContext() {
        return baseApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        MainID = android.os.Process.myTid();
    }

    /**
     * 获取application
     */
    public static Context getApplication() {
        return baseApplication;
    }

    /**
     * 获取主线程ID
     */
    public static int getMainID() {
        return MainID;
    }

}
