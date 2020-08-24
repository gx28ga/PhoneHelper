package com.axun.phonehelper.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;

import com.axun.phonehelper.AppApplication;
import com.axun.phonehelper.di.component.AppComponent;
import com.mikepenz.iconics.context.IconicsLayoutInflater;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    protected Unbinder mUnBinder;
    protected AppApplication mAppApplication;
    @Inject
    public T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResId());
        mUnBinder = ButterKnife.bind(this);

        mAppApplication = ((AppApplication) getApplication());
        setupActivityComponent(mAppApplication.getAppComponent());
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnBinder != Unbinder.EMPTY) {
            mUnBinder.unbind();
        }
    }

    public abstract int setLayoutResId();

    public abstract void init();

    public abstract void setupActivityComponent(AppComponent appComponent);
}
