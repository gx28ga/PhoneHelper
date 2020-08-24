package com.axun.phonehelper.presenter.contract;

import com.axun.phonehelper.bean.AppInfo;
import com.axun.phonehelper.base.BasePresenter;
import com.axun.phonehelper.base.BaseView;

import java.util.List;

public interface RecommendContract {
    interface View extends BaseView {


        void showResult(List<AppInfo> datas);

        void showNoData();

        void showError(String msg);
    }
}
