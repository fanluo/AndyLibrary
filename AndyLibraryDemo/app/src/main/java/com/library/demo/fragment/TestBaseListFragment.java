package com.library.demo.fragment;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;

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

    private Handler mHandler = new Handler();

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            if (getPageNum() == 1) {
                mMyAdapter.replaceData(genTestData(getPageNum(), getPageSize()));
            } else {
                mMyAdapter.addData(genTestData(getPageNum(), getPageSize()));
            }
            onRequestFinished();
        }
    };

    @Override
    protected RecyclerView.Adapter genAdapter() {
        if (mMyAdapter == null) {
            mMyAdapter = new MyAdapter();
            mMyAdapter.replaceData(genTestData(1, 10));
        }
        return mMyAdapter;
    }

    private List<String> genTestData(int pageNum, int size) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            data.add("测试数据" + (pageNum * size + i));
        }
        return data;
    }

    @Override
    protected void requestData(int pageNo, int pageSize, boolean showLoading) {
        super.requestData(pageNo, pageSize, showLoading);
        mHandler.postDelayed(mRunnable, 2000);
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
