package com.axun.phonehelper.bean;

public class FragmentInfo {
    private String mTitle;
    private Class<?> mClazz;

    public FragmentInfo(String title, Class<?> clazz) {
        mTitle = title;
        mClazz = clazz;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Class<?> getClazz() {
        return mClazz;
    }

    public void setClazz(Class<?> clazz) {
        mClazz = clazz;
    }
}
