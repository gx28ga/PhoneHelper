package com.axun.phonehelper;

import android.app.Application;

import com.axun.phonehelper.di.component.AppComponent;
import com.axun.phonehelper.di.component.DaggerAppComponent;
import com.axun.phonehelper.di.module.AppModule;
import com.axun.phonehelper.di.module.HttpModule;

public class AppApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this))
                .httpModule(new HttpModule()).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
