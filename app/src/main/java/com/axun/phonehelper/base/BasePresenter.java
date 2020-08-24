package com.axun.phonehelper.base;

public class BasePresenter<M, V extends BaseView> {
    public M mModel;
    public V mView;

    public BasePresenter(M model, V view) {
        mModel = model;
        mView = view;
    }
}
