package com.axun.phonehelper.presenter.contract;

import com.axun.phonehelper.bean.AppInfo;
import com.axun.phonehelper.presenter.BasePresenter;
import com.axun.phonehelper.ui.BaseView;

import java.util.List;

public interface RecommendContract {
    interface View extends BaseView {
        void showLoading();

        void dismissLoading();

        void showResult(List<AppInfo> datas);

        void showNoData();

        void showError(String msg);
    }

    interface Presenter extends BasePresenter {
        void requestDatas();
    }
}
