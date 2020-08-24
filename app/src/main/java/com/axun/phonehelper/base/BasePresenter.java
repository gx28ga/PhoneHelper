package com.axun.phonehelper.base;

public class BasePresenter<M, V extends BaseView> {
    protected M mModel;
    protected V mView;

    public BasePresenter(M model, V view) {
        mModel = model;
        mView = view;
    }
}
