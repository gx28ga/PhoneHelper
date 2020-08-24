package com.axun.phonehelper.ui.activity;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.axun.phonehelper.R;
import com.axun.phonehelper.base.BaseActivity;
import com.axun.phonehelper.di.component.AppComponent;
import com.axun.phonehelper.ui.adapter.CommonFragmentPagerAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    public int setLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        initTabLayout();
        initDrawerLayout();
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    private void initDrawerLayout() {
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        headerView.setOnClickListener(v -> Toast.makeText(MainActivity.this, "header view", Toast.LENGTH_SHORT).show());
        toolBar.inflateMenu(R.menu.menu_toolbar);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.open, R.string.close);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);
    }

    private void initTabLayout() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        CommonFragmentPagerAdapter adapter = new CommonFragmentPagerAdapter(supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        CharSequence title = item.getTitle();
        Toast.makeText(this, "" + title, Toast.LENGTH_SHORT).show();
        return false;
    }
}