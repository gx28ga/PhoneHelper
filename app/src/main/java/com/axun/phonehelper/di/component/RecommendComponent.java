package com.axun.phonehelper.di.component;

import com.axun.phonehelper.di.ano.FragmentScope;
import com.axun.phonehelper.di.module.RecommendModule;
import com.axun.phonehelper.ui.fragment.RecommendFragment;

import dagger.Component;

@FragmentScope
@Component(modules = {RecommendModule.class}, dependencies = {AppComponent.class})
public interface RecommendComponent {
    void inject(RecommendFragment fragment);
}
