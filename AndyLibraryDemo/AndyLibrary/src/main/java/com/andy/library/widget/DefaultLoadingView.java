package com.andy.library.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.andy.library.R;

/**
 * 默认加载中页面
 * Created by luofan on 2018/4/25.
 */

public class DefaultLoadingView extends FrameLayout {

    public DefaultLoadingView(@NonNull Context context) {
        this(context, null);
    }

    public DefaultLoadingView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DefaultLoadingView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_default_loading_view, this);
    }
}
