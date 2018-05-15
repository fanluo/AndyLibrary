package com.andy.library.activity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.andy.library.R;
import com.blankj.utilcode.util.FragmentUtils;

import java.util.List;

/**
 * 基础主activity(底部包含页面切换按钮)
 * Created by luofan on 2018/5/15.
 */

public abstract class BaseNavigationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mBottomNavigationView;

    private List<NavigationData> mNavigationDataList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_main);
        mBottomNavigationView = findViewById(R.id.navigation);
        mBottomNavigationView.setItemIconTintList(null);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        initBottomNavigationView(getNavigationDataList());
        if (mNavigationDataList.size() > 0) {
            switchFragment(mNavigationDataList.get(0).getFragmentName());
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int index = item.getItemId();
        NavigationData data = mNavigationDataList.get(index);
        switchFragment(data.getFragmentName());
        return true;
    }

    private void initBottomNavigationView(List<NavigationData> list) {
        mNavigationDataList = list;
        Menu menu = mBottomNavigationView.getMenu();
        int itemId = 0;
        for (NavigationData data : list) {
            menu.add(0, itemId, data.getOrder(), data.getNavigationTitle()).setIcon(data.getNavigationImageResId());
            itemId++;
        }
    }

    public BottomNavigationView getBottomNavigationView() {
        return mBottomNavigationView;
    }

    //获取底部导航的数据
    protected abstract List<NavigationData> getNavigationDataList();

    public void switchFragment(String fragmentName) {
        //先隐藏所有Fragment,在显示指定的Fragment
        FragmentUtils.hide(getSupportFragmentManager());
        Fragment showFragment = getSupportFragmentManager().findFragmentByTag(fragmentName);
        if (showFragment == null) {
            showFragment = Fragment.instantiate(this, fragmentName);
            FragmentUtils.add(getSupportFragmentManager(), showFragment, R.id.layout_content);
            FragmentUtils.show(showFragment);
        } else {
            FragmentUtils.show(showFragment);
        }
    }

    public static final class NavigationData implements Parcelable {
        //顺序
        private int mOrder;
        //导航对应的fragment
        private String mFragmentName;
        //导航标题
        private String mNavigationTitle;
        //导航对应的图片
        private int mNavigationImageResId;

        public NavigationData() {

        }

        protected NavigationData(Parcel in) {
            mOrder = in.readInt();
            mFragmentName = in.readString();
            mNavigationTitle = in.readString();
            mNavigationImageResId = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(mOrder);
            dest.writeString(mFragmentName);
            dest.writeString(mNavigationTitle);
            dest.writeInt(mNavigationImageResId);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<NavigationData> CREATOR = new Creator<NavigationData>() {
            @Override
            public NavigationData createFromParcel(Parcel in) {
                return new NavigationData(in);
            }

            @Override
            public NavigationData[] newArray(int size) {
                return new NavigationData[size];
            }
        };

        public int getOrder() {
            return mOrder;
        }

        public void setOrder(int order) {
            mOrder = order;
        }

        public String getFragmentName() {
            return mFragmentName;
        }

        public void setFragmentName(String fragmentName) {
            mFragmentName = fragmentName;
        }

        public String getNavigationTitle() {
            return mNavigationTitle;
        }

        public void setNavigationTitle(String navigationTitle) {
            mNavigationTitle = navigationTitle;
        }

        public int getNavigationImageResId() {
            return mNavigationImageResId;
        }

        public void setNavigationImageResId(int navigationImageResId) {
            mNavigationImageResId = navigationImageResId;
        }
    }
}
