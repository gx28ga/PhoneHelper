package com.axun.phonehelper.di.module;


import android.content.Context;

import com.axun.phonehelper.data.RecommendModel;
import com.axun.phonehelper.data.http.ApiService;
import com.axun.phonehelper.presenter.RecommendPresenter;
import com.axun.phonehelper.presenter.contract.RecommendContract;
import com.axun.phonehelper.ui.adapter.RecommendAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class RecommendModule {
    private RecommendContract.View mView;

    public RecommendModule(RecommendContract.View view) {
        mView = view;
    }

    @Provides
    public RecommendContract.Presenter providePresenter(RecommendContract.View view) {
        return new RecommendPresenter(view);
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
