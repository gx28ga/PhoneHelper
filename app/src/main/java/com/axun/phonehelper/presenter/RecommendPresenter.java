package com.axun.phonehelper.presenter;

import com.axun.phonehelper.bean.AppInfo;
import com.axun.phonehelper.bean.PageBean;
import com.axun.phonehelper.data.RecommendModel;
import com.axun.phonehelper.presenter.contract.RecommendContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommendPresenter implements RecommendContract.Presenter {
    private RecommendContract.View mView;
    private RecommendModel mModel;
    public RecommendPresenter(RecommendContract.View view) {
        mView = view;

    }

    @Override
    public void requestDatas() {
        mView.showLoading();

        mModel.getApps(new Callback<PageBean<AppInfo>>() {
            @Override
            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {
                if (response != null) {
                    mView.showResult(response.body().getDatas());
                } else {
                    mView.showNoData();
                }

                mView.dismissLoading();
            }

            @Override
            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {

                mView.dismissLoading();
                mView.showError(t.getMessage());
            }
        });
    }
}
