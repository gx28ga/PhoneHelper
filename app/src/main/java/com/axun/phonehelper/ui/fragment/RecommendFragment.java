package com.axun.phonehelper.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.axun.phonehelper.R;
import com.axun.phonehelper.bean.AppInfo;
import com.axun.phonehelper.presenter.contract.RecommendContract;
import com.axun.phonehelper.ui.adapter.RecommendAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendFragment extends Fragment implements RecommendContract.View {

    private static final String TAG = "RecommendFragment";

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    Context mContext;
    @Inject
    RecommendContract.Presenter mPresenter;
    private RecommendAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this, view);
        if (container != null) {
            mContext = container.getContext();
        }
        initRecycleView();

        mPresenter.requestDatas();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void updateData(List<AppInfo> datas) {
        mAdapter.setDatas(datas);
    }

    private void initRecycleView() {
        mAdapter = new RecommendAdapter(mContext);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

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
}
