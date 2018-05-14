package com.library.demo.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.andy.library.fragment.BaseListFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.library.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luofan on 2018/5/14.
 */

public class TestBaseListFragment extends BaseListFragment {

    private MyAdapter mMyAdapter;

    @Override
    protected RecyclerView.Adapter genAdapter() {
        if (mMyAdapter == null) {
            mMyAdapter = new MyAdapter();
            List<String> data = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                data.add("测试数据" + i);
            }
            mMyAdapter.replaceData(data);
        }
        return mMyAdapter;
    }

    private static class MyAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public MyAdapter() {
            super(R.layout.adapter_my);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.text, item);
        }
    }
}
