package com.andy.library.widget;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.andy.library.R;


/**
 * Created by luofan on 2018/4/19.
 */

public class SwipeHeadView extends FrameLayout implements SuperSwipeRefreshLayout.OnPullRefreshListener {

    private ImageView refreshArrow;
    private ProgressBar loadingView;
    private TextView refreshTextView;

    private String pullDownStr = "下拉刷新";
    private String releaseRefreshStr = "释放刷新";
    private String refreshingStr = "正在刷新";

    private int height;

    public SwipeHeadView(Context context) {
        this(context, null);
    }

    public SwipeHeadView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwipeHeadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.layout_swipe_head_view, this);
        refreshArrow = findViewById(R.id.img_arrow);
        refreshTextView = findViewById(R.id.text_refresh);
        loadingView = findViewById(R.id.progress_bar);
        loadingView.setVisibility(GONE);
    }

    @Override
    public void onRefresh() {
        refreshTextView.setText(refreshingStr);
        refreshArrow.setVisibility(View.GONE);
        loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPullDistance(int distance) {
        if (height > 0) {
            setTranslationY((height - distance) / 2);
            if (distance > height) {
                distance = height;
            }
            refreshArrow.setRotation(distance * 180 / height);
        }
    }

    @Override
    public void onPullEnable(boolean enable) {
        loadingView.setVisibility(GONE);
        refreshTextView.setText(enable ? releaseRefreshStr : pullDownStr);
        refreshArrow.setVisibility(View.VISIBLE);
        refreshArrow.setRotation(enable ? 180 : 0);
        height = getMeasuredHeight();
    }

    public void setArrowResource(@DrawableRes int resId) {
        refreshArrow.setImageResource(resId);
    }

    public void setTextColor(@ColorInt int color) {
        refreshTextView.setTextColor(color);
    }

    public void setPullDownStr(String pullDownStr1) {
        pullDownStr = pullDownStr1;
    }

    public void setReleaseRefreshStr(String releaseRefreshStr1) {
        releaseRefreshStr = releaseRefreshStr1;
    }

    public void setRefreshingStr(String refreshingStr1) {
        refreshingStr = refreshingStr1;
    }
}
