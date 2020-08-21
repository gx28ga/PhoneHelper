package com.axun.phonehelper;

import android.app.Application;

import com.axun.phonehelper.di.component.AppComponent;
import com.axun.phonehelper.di.component.DaggerAppComponent;
import com.axun.phonehelper.di.module.AppModule;

public class AppApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
