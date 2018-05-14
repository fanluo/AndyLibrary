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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base_list, container, false);
        mStateLayout = rootView.findViewById(R.id.state_layout);
        mRecyclerView = rootView.findViewById(R.id.recycle_view);
        mRefreshLayout = rootView.findViewById(R.id.refresh_layout);
        mRefreshLayout.setHeaderView(new SinaRefreshView(getContext()));
        mRefreshLayout.setBottomView(new LoadingView(getContext()));
        mRecyclerView.setAdapter(genAdapter());
        mRecyclerView.setLayoutManager(genLayoutManager());
        RecyclerView.ItemDecoration decoration = genItemDecoration();
        if (decoration != null) {
            mRecyclerView.addItemDecoration(genItemDecoration());
        }
        return rootView;
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
