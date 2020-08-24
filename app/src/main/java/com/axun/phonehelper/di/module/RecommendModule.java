package com.axun.phonehelper.di.module;


import com.axun.phonehelper.data.RecommendModel;
import com.axun.phonehelper.data.http.ApiService;
import com.axun.phonehelper.presenter.contract.RecommendContract;

import dagger.Module;
import dagger.Provides;

@Module
public class RecommendModule {
    private RecommendContract.View mView;

    public RecommendModule(RecommendContract.View view) {
        mView = view;
    }

    @Provides
    public RecommendContract.View provideView() {
        return mView;
    }

    @Provides
    public RecommendModel provideModel(ApiService apiService) {
        return new RecommendModel(apiService);
    }
}
