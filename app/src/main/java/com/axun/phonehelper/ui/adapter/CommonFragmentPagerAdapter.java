package com.axun.phonehelper.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.axun.phonehelper.bean.FragmentInfo;
import com.axun.phonehelper.ui.fragment.CategoryFragment;
import com.axun.phonehelper.ui.fragment.GamesFragment;
import com.axun.phonehelper.ui.fragment.RankingFragment;
import com.axun.phonehelper.ui.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

public class CommonFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<FragmentInfo> mFragmentInfoList = new ArrayList<>(4);


    public CommonFragmentPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        initFragments();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment) mFragmentInfoList.get(position).getClazz().newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mFragmentInfoList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentInfoList.get(position).getTitle();
    }

    private void initFragments() {
        mFragmentInfoList.add(new FragmentInfo("推荐", RecommendFragment.class));
        mFragmentInfoList.add(new FragmentInfo("排行", RankingFragment.class));
        mFragmentInfoList.add(new FragmentInfo("游戏", GamesFragment.class));
        mFragmentInfoList.add(new FragmentInfo("分类", CategoryFragment.class));
    }
}
