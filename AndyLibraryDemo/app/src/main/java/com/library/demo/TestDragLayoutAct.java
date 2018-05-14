package com.library.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;
import com.lcodecore.tkrefreshlayout.header.SinaRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luofan on 2018/5/8.
 */

public class TestDragLayoutAct extends Activity {

    TwinklingRefreshLayout mRefreshLayout;

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_drag_layout);
        mRefreshLayout = findViewById(R.id.refreshLayout);
        mRefreshLayout.setHeaderView(new SinaRefreshView(this));
        mRefreshLayout.setBottomView(new LoadingView(this));
        mRecyclerView = findViewById(R.id.recycler_view);
        MyAdapter adapter = new MyAdapter();
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("测试数据" + i);
        }
        adapter.replaceData(data);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mRefreshLayout.finishRefreshing();
                mRefreshLayout.finishLoadmore();
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
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
