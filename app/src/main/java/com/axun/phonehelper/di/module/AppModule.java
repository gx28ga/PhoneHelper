package com.axun.phonehelper.di.module;

import com.axun.phonehelper.AppApplication;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    private AppApplication  mAppApplication;

    public AppModule(AppApplication appApplication) {
        mAppApplication = appApplication;
    }

    @Singleton
    @Provides
    AppApplication provideAppApplication() {
        return mAppApplication;
    }

    @Singleton
    @Provides
    Gson provideGson() {
        return new Gson();
    }
}
