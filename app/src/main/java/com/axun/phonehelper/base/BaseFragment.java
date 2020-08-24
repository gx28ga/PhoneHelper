package com.axun.phonehelper.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.axun.phonehelper.AppApplication;
import com.axun.phonehelper.di.component.AppComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    private View mRootView;
    private Unbinder mUnBinder;
    private AppApplication mApplication;
    @Inject
    public T mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(setLayoutResId(), container, false);
        Unbinder mUnBinder = ButterKnife.bind(this, mRootView);
        init();

        return mRootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnBinder != Unbinder.EMPTY) {
            mUnBinder.unbind();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mApplication = (AppApplication) getActivity().getApplication();
        setupActivityComponent(mApplication.getAppComponent());
    }

    public abstract int setLayoutResId();

    public abstract void init();

    public abstract void setupActivityComponent(AppComponent appComponent);
}
