package com.library.demo;


import android.os.Bundle;
import android.support.annotation.Nullable;


import com.andy.library.activity.BaseViewPagerActivity;
import com.andy.library.adapter.SimpleTabPagerAdapter;
import com.library.demo.fragment.TestBaseListFragment;


import java.util.ArrayList;
import java.util.List;


public class TestViewPagerActivity extends BaseViewPagerActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("测试viewpaager");
    }

    @Override
    protected List<SimpleTabPagerAdapter.PagerData> genPagerDataList() {
        List<String> titleList = new ArrayList<>();
        titleList.add("全部");
        titleList.add("审核中");
        titleList.add("已完成");
        titleList.add("已取消");
        String fragmentName = TestBaseListFragment.class.getName();
        int size = titleList.size();
        List<SimpleTabPagerAdapter.PagerData> pagerDataList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            SimpleTabPagerAdapter.PagerData data = new SimpleTabPagerAdapter.PagerData();
            data.setTitle(titleList.get(i));
            data.setFragmentName(fragmentName);
            data.setPosition(i);
            pagerDataList.add(data);
        }
        return pagerDataList;
    }
}
