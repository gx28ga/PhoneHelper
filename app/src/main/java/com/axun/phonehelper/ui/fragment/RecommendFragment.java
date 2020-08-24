package com.axun.phonehelper.ui.fragment;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.axun.phonehelper.R;
import com.axun.phonehelper.base.BaseFragment;
import com.axun.phonehelper.bean.AppInfo;
import com.axun.phonehelper.di.component.AppComponent;
import com.axun.phonehelper.di.component.DaggerRecommendComponent;
import com.axun.phonehelper.di.module.RecommendModule;
import com.axun.phonehelper.presenter.RecommendPresenter;
import com.axun.phonehelper.presenter.contract.RecommendContract;
import com.axun.phonehelper.ui.adapter.RecommendAdapter;

import java.util.List;

import butterknife.BindView;


public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.View {

    private static final String TAG = "RecommendFragment";

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private RecommendAdapter mAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public int setLayoutResId() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void init() {
        initRecycleView();
        Log.d(TAG, "init: " + mPresenter);
        mPresenter.requestDatas();

    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerRecommendComponent.builder().appComponent(appComponent).recommendModule(new RecommendModule(this)).build().inject(this);

    }

    private void updateData(List<AppInfo> datas) {
        mAdapter.setDatas(datas);
    }

    private void initRecycleView() {
        mAdapter = new RecommendAdapter(getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
    }


    @Override
    public void showResult(List<AppInfo> datas) {
        updateData(datas);
    }

    @Override
    public void showNoData() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }
}
