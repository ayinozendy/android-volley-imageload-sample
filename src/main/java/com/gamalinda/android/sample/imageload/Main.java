package com.gamalinda.android.sample.imageload;

import android.app.Application;
import android.content.Context;

public class Main extends Application {
    private static Main main;
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        main = this;
        main.setAppContext(getApplicationContext());
    }

    public static Main getInstance() {
        return main;
    }

    public static Context getAppContext() {
        return appContext;
    }

    public void setAppContext(Context context) {
        appContext = context;
    }
}
