package com.library.demo;

import com.andy.library.activity.BaseNavigationActivity;
import com.library.demo.fragment.TestBaseFragment;
import com.library.demo.fragment.TestBaseListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luofan on 2018/5/15.
 */

public class TestMainActivity extends BaseNavigationActivity {
    @Override
    protected List<NavigationData> getNavigationDataList() {

        List<NavigationData> list = new ArrayList<>();
        NavigationData home = new NavigationData();
        home.setFragmentName(TestBaseFragment.class.getName());
        home.setNavigationTitle("首页");
        home.setOrder(1);
        home.setNavigationImageResId(R.mipmap.home_check);
        list.add(home);
        NavigationData mine = new NavigationData();
        mine.setFragmentName(TestBaseListFragment.class.getName());
        mine.setNavigationTitle("生活");
        mine.setOrder(2);
        mine.setNavigationImageResId(R.mipmap.credit_life_check);
        list.add(mine);
        return list;
    }
}
