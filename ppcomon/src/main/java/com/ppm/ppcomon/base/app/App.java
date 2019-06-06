package com.ppm.ppcomon.base.app;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.BuildConfig;
import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author by lpc on 2018/1/12.
 */
public class App extends Application {

    public static final boolean IS_TEST = true;
    public static final boolean IS_DEBUG = true;

    private static App mContext;


    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        saveMerchantInfo();

        Fresco.initialize(this);

        if (BuildConfig.DEBUG) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    protected String getAppId() {
        return "";
    }

    protected String getSecret() {
        return "";
    }

    protected void saveMerchantInfo() {
    }

}
