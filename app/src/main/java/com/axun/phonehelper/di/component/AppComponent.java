package com.axun.phonehelper.di.component;


import com.axun.phonehelper.data.http.ApiService;
import com.axun.phonehelper.di.module.AppModule;
import com.axun.phonehelper.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    public ApiService getApiService();
}
