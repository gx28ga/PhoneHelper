package com.axun.phonehelper.data.http;

import com.axun.phonehelper.bean.AppInfo;
import com.axun.phonehelper.bean.PageBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    public static String BASE_URL = "http://112.124.22.238:8081/course_api/cniaoplay/";

    @GET("featured")
    public Call<PageBean<AppInfo>> getApps(@Query("p") String jsonParam);
}
