package com.axun.phonehelper.di.component;


import com.axun.phonehelper.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
}
