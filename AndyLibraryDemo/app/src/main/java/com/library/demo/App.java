package com.library.demo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by luofan on 2018/5/14.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
    }
}
