package com.andy.library.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.andy.library.R;
import com.andy.library.adapter.SimpleTabPagerAdapter;

import java.util.List;


/**
 * 基础viewpager activity
 * Created by luofan on 2018/4/23.
 */

public abstract class BaseViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Toolbar mToolbar;
    private TextView mTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideActionBar();
        setContentView(R.layout.activity_base_view_pager);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            getActionBar().hide();
            getSupportActionBar().hide();
        }
        initView();
        initToolBar();
    }

    private void hideActionBar() {
        if (getActionBar() != null) {
            getActionBar().hide();
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    private void initToolBar() {
        mToolbar = findViewById(R.id.toolbar);
        mTitle = findViewById(R.id.tvTitle);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    protected void setTitle(String title) {
        mTitle.setText(title);
    }

    private void initView() {
        viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
        initPagerList(genPagerDataList());
    }

    public ViewPager getViewPager() {
        return viewPager;
    }

    protected abstract List<SimpleTabPagerAdapter.PagerData> genPagerDataList();

    private void initPagerList(List<SimpleTabPagerAdapter.PagerData> pagerDataList) {
        SimpleTabPagerAdapter adapter = new SimpleTabPagerAdapter(getSupportFragmentManager(), this);
        adapter.replaceData(pagerDataList);
        viewPager.setAdapter(adapter);
    }
}
