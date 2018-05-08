package com.library.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.andy.library.widget.SuperSwipeRefreshLayout;
import com.andy.library.widget.SwipeHeadView;

/**
 * Created by luofan on 2018/5/8.
 */

public class TestSwipeLayoutAct extends Activity {

    SuperSwipeRefreshLayout mRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_swipe_layout);
        mRefreshLayout = findViewById(R.id.root);
        mRefreshLayout.setHeaderView(new SwipeHeadView(this));
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRefreshLayout.setRefreshing(false);
            }
        });
    }
}
