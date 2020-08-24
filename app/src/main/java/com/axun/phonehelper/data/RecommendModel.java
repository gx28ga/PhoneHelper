package com.axun.phonehelper.data;

import com.axun.phonehelper.base.BaseModel;
import com.axun.phonehelper.bean.AppInfo;
import com.axun.phonehelper.bean.PageBean;
import com.axun.phonehelper.data.http.ApiService;

import retrofit2.Callback;

public class RecommendModel {

    private ApiService mApiService;

    public RecommendModel(ApiService apiService) {
        mApiService = apiService;
    }

    private static final String TAG = "RecommendModel";

    public void getApps(Callback<PageBean<AppInfo>> callback) {

        mApiService.getApps("{'page': 0}").enqueue(callback);
    }

}
