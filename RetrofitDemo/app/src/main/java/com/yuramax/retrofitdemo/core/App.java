package com.yuramax.retrofitdemo.core;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;

/**
 * 作者：weijun
 * 日期：2019/4/3
 * 作用：
 */

public class App extends Application {

    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        Utils.init(this);
    }

    public static Context getAppContext() {
        return appContext;
    }
}
