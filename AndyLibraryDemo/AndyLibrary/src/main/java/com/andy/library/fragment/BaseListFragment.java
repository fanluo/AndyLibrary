package com.andy.library.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andy.library.R;
import com.andy.library.widget.StateLayout;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;
import com.lcodecore.tkrefreshlayout.header.SinaRefreshView;

/**
 * 基础列表fragment
 * Created by luofan on 2018/5/14.
 */

public abstract class BaseListFragment extends BaseFragment {

    private StateLayout mStateLayout;

    private RecyclerView mRecyclerView;

    private TwinklingRefreshLayout mRefreshLayout;

    protected int mPageNum = 1;

    protected int mPageSize = 10;

    private boolean mIsRequestData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base_list, container, false);
        mStateLayout = rootView.findViewById(R.id.state_layout);
        mStateLayout.setErrorViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestData(mPageNum, mPageSize, true);
            }
        });
        mRecyclerView = rootView.findViewById(R.id.recycle_view);
        mRefreshLayout = rootView.findViewById(R.id.refresh_layout);
        mRefreshLayout.setHeaderView(new SinaRefreshView(getContext()));
        mRefreshLayout.setBottomView(new LoadingView(getContext()));
        mRefreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {

            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                if (!mIsRequestData) {
                    mPageNum = 1;
                    requestData(mPageNum, mPageSize, false);
                }
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                if (!mIsRequestData) {
                    mPageNum++;
                    requestData(mPageNum, mPageSize, false);
                }
            }
        });
        mRecyclerView.setAdapter(genAdapter());
        mRecyclerView.setLayoutManager(genLayoutManager());
        RecyclerView.ItemDecoration decoration = genItemDecoration();
        if (decoration != null) {
            mRecyclerView.addItemDecoration(genItemDecoration());
        }
        return rootView;
    }

    public int getPageNum() {
        return mPageNum;
    }

    public void setPageNum(int pageNum) {
        mPageNum = pageNum;
    }

    public int getPageSize() {
        return mPageSize;
    }

    public void setPageSize(int pageSize) {
        mPageSize = pageSize;
    }

    public boolean isRequestData() {
        return mIsRequestData;
    }

    protected void requestData(int pageNo, int pageSize, boolean showLoading) {
        mIsRequestData = true;
        if (showLoading) {
            mStateLayout.showLoadingView();
        }
    }

    protected void onRequestFinished() {
        mIsRequestData = false;
        mStateLayout.showContentView();
        if (mPageNum == 1) {
            mRefreshLayout.finishRefreshing();
        } else {
            mRefreshLayout.finishLoadmore();
        }
    }

    protected RecyclerView.LayoutManager genLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return layoutManager;
    }

    protected abstract RecyclerView.Adapter genAdapter();

    protected RecyclerView.ItemDecoration genItemDecoration() {
        return null;
    }

    @NonNull
    protected StateLayout getStateLayout() {
        return mStateLayout;
    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    public TwinklingRefreshLayout getRefreshLayout() {
        return mRefreshLayout;
    }
}
