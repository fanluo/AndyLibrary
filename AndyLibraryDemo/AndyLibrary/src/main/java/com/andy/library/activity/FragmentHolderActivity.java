package com.andy.library.activity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.andy.library.R;
import com.andy.library.fragment.FragmentBackListener;
import com.blankj.utilcode.util.FragmentUtils;

/**
 * Created by luofan on 2018/5/14.
 */

public class FragmentHolderActivity extends AppCompatActivity {

    protected static final String FRAGMENT_TITLE = "fragment_title";
    protected static final String FRAGMENT_NAME = "fragment_name";
    private Toolbar mToolbar;
    private TextView mTitle;
    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        hideActionBar();
        initToolBar();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString(FRAGMENT_NAME);
            String title = bundle.getString(FRAGMENT_TITLE);
            attachFragment(name);
            setTitle(title);
        }
    }

    private void hideActionBar() {
        if (getActionBar() != null) {
            getActionBar().hide();
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    protected void setTitle(String title) {
        mTitle.setText(title);
    }

    private void initToolBar() {
        mToolbar = findViewById(R.id.toolbar);
        mTitle = findViewById(R.id.tvTitle);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doBackPressed();
            }
        });
    }

    private void doBackPressed() {
        if (mCurrentFragment != null && mCurrentFragment instanceof FragmentBackListener) {
            FragmentBackListener listener = (FragmentBackListener) mCurrentFragment;
            if (!listener.onBackPressed()) {
                finish();
            }
        } else {
            finish();
        }
    }

    protected void attachFragment(String fragmentName) {
        FragmentUtils.removeAll(getSupportFragmentManager());
        Fragment showFragment = Fragment.instantiate(this, fragmentName);
        mCurrentFragment = showFragment;
        FragmentUtils.add(getSupportFragmentManager(), showFragment, R.id.layout_content);
    }

    public static void startMe(Context context, String title, String fragmentName) {
        Intent intent = new Intent();
        intent.setClass(context, FragmentHolderActivity.class);
        intent.putExtra(FRAGMENT_NAME, fragmentName);
        intent.putExtra(FRAGMENT_TITLE, title);
        context.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        doBackPressed();
    }
}
