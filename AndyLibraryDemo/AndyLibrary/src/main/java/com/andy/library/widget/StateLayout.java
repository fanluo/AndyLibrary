package com.andy.library.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by luofan on 2018/4/25.
 */

public class StateLayout extends FrameLayout {

    private DefaultEmptyView mEmptyView;

    private DefaultLoadingView mLoadingView;

    private DefaultErrorView mErrorView;

    private View mCustomEmptyView;

    private View mCustomLoadingView;

    private View mCustomErrorView;

    private View mContentView;

    private View mCurrentShowingView;

    private OnClickListener mErrorViewClickListener;

    private OnClickListener mEmptyViewClickListener;

    public StateLayout(@NonNull Context context) {
        this(context, null);
    }

    public StateLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StateLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mEmptyView = new DefaultEmptyView(getContext());
        mEmptyView.setVisibility(GONE);
        mErrorView = new DefaultErrorView(getContext());
        mErrorView.setVisibility(GONE);
        mLoadingView = new DefaultLoadingView(getContext());
        mLoadingView.setVisibility(GONE);
        addView(mEmptyView);
        addView(mErrorView);
        addView(mLoadingView);
    }

    private void switchView(View toBeView) {
        mCurrentShowingView.setVisibility(GONE);
        toBeView.setVisibility(VISIBLE);
        mCurrentShowingView = toBeView;
    }

    public void showContentView() {
        switchView(mContentView);
    }

    public void showEmptyView() {
        showEmptyView(null);
    }

    public void showEmptyView(String msg) {
        View view = mEmptyView != null ? mEmptyView : mCustomEmptyView;
        if (mEmptyView != null && !TextUtils.isEmpty(msg)) {
            mEmptyView.setText(msg);
        }
        switchView(view);
    }

    public void showErrorView() {
        showErrorView(null);
    }

    public void showErrorView(String msg) {
        View view = mErrorView != null ? mErrorView : mCustomErrorView;
        if (mErrorView != null && !TextUtils.isEmpty(msg)) {
            mErrorView.setText(msg);
        }
        switchView(view);
    }

    public void showLoadingView() {
        View view = mLoadingView != null ? mLoadingView : mCustomLoadingView;
        switchView(view);
    }

    public void setCustomEmptyView(@NonNull View view) {
        if (mEmptyView != null) {
            removeView(mEmptyView);
            mEmptyView = null;
        }
        if (mCustomEmptyView != null) {
            removeView(mCustomEmptyView);
            mCustomEmptyView = null;
        }
        mCustomEmptyView = view;
        addView(mCustomEmptyView);
        mCustomEmptyView.setOnClickListener(mEmptyViewClickListener);
    }

    public void setCustomErrorView(@NonNull View view) {
        if (mErrorView != null) {
            removeView(mErrorView);
            mErrorView = null;
        }
        if (mCustomErrorView != null) {
            removeView(mCustomErrorView);
            mCustomErrorView = null;
        }
        mCustomErrorView = view;
        addView(mCustomErrorView);
        mCustomErrorView.setOnClickListener(mErrorViewClickListener);
    }

    public void setCurrentShowingView(@NonNull View view) {
        if (mLoadingView != null) {
            removeView(mLoadingView);
            mLoadingView = null;
        }
        if (mCustomLoadingView != null) {
            removeView(mCustomLoadingView);
            mCustomLoadingView = null;
        }
        mCustomLoadingView = view;
        addView(mCustomLoadingView);
    }

    public void setErrorViewClickListener(OnClickListener errorViewClickListener) {
        mErrorViewClickListener = errorViewClickListener;
        if (mErrorView != null) {
            mErrorView.setOnClickListener(errorViewClickListener);
        } else if (mCustomErrorView != null) {
            mCustomErrorView.setOnClickListener(errorViewClickListener);
        }
    }

    public void setEmptyViewClickListener(OnClickListener emptyViewClickListener) {
        mEmptyViewClickListener = emptyViewClickListener;
        if (mEmptyView != null) {
            mEmptyView.setOnClickListener(mEmptyViewClickListener);
        } else if (mCustomEmptyView != null) {
            mCustomEmptyView.setOnClickListener(mEmptyViewClickListener);
        }
    }

    public void setEmptyString(String emptyString) {
        if (mEmptyView != null) {
            mEmptyView.setText(emptyString);
        }
    }

    public void setErrorString(String netErrorString) {
        if (mErrorView != null) {
            mErrorView.setText(netErrorString);
        }
    }

    public void setEmptyImgResId(int resId) {
        if (mEmptyView != null) {
            mEmptyView.setImageResId(resId);
        }
    }

    public void setErrorImgResId(int resId) {
        if (mErrorView != null) {
            mErrorView.setImageResId(resId);
        }
    }

    /**
     * addView
     */

    @Override
    public void addView(View child) {
        checkIsContentView(child);
        super.addView(child);
    }

    @Override
    public void addView(View child, int index) {
        checkIsContentView(child);
        super.addView(child, index);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        checkIsContentView(child);
        super.addView(child, index, params);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        checkIsContentView(child);
        super.addView(child, params);
    }

    @Override
    public void addView(View child, int width, int height) {
        checkIsContentView(child);
        super.addView(child, width, height);
    }

    @Override
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params) {
        checkIsContentView(child);
        return super.addViewInLayout(child, index, params);
    }

    @Override
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        checkIsContentView(child);
        return super.addViewInLayout(child, index, params, preventRequestLayout);
    }

    private void checkIsContentView(View view) {
        if (mContentView == null && view != mErrorView && view != mLoadingView && view != mEmptyView) {
            mContentView = view;
            mCurrentShowingView = mContentView;
        }
    }
}
