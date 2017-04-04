package com.hzxm.easyloan;

import com.hzxm.easyloan.utils.GlideImageLoader;
import com.hzxm.easyloan.utils.GlidePauseOnScrollListener;
import com.lmz.baselibrary.BaseApplication;
import com.squareup.leakcanary.LeakCanary;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ThemeConfig;

/**
 * 作者：LMZ on 2016/12/22 0022 14:08
 */
public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initGalleryFinal();
        LeakCanary.install(this);

    }

    private void initGalleryFinal() {
        //设置主题
        ThemeConfig theme = ThemeConfig.CYAN;
        //   ThemeConfig theme = new ThemeConfig.Builder()
        //    .build();
        //配置功能
        FunctionConfig functionConfig = new FunctionConfig.Builder()
                .setEnableCamera(true)
                .setEnableEdit(true)
                .setEnableCrop(true)
                .setEnableRotate(true)
                .setCropSquare(true)
                .setEnablePreview(true)
                .build();
        CoreConfig coreConfig = new CoreConfig.Builder(this, new GlideImageLoader(), theme)
                .setFunctionConfig(functionConfig)
                .setPauseOnScrollListener(new GlidePauseOnScrollListener(false, true))
                .build();
        GalleryFinal.init(coreConfig);
    }
}
