package com.andy.library.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.andy.library.R;

/**
 * 默认空页面
 * Created by luofan on 2018/4/25.
 */

public class DefaultEmptyView extends FrameLayout {

    private ImageView mImageView;

    private TextView mTextView;

    public DefaultEmptyView(@NonNull Context context) {
        this(context, null);
    }

    public DefaultEmptyView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DefaultEmptyView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_default_empty_view, this);
        mImageView = findViewById(R.id.image);
        mTextView = findViewById(R.id.text);
    }

    public ImageView getImageView() {
        return mImageView;
    }

    public TextView getTextView() {
        return mTextView;
    }

    public void setText(String str) {
        mTextView.setText(str);
    }

    public void setTextResId(int resId) {
        mTextView.setText(resId);
    }

    public void setImageResId(int resId) {
        mImageView.setImageResource(resId);
    }
}
