package com.andy.library.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andy.library.R;
import com.andy.library.widget.StateLayout;

/**
 * Created by luofan on 2018/5/14.
 */

public abstract class BaseSimpleFragment extends BaseFragment{

    private StateLayout mStateLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base, container, false);
        mStateLayout = rootView.findViewById(R.id.state_layout);
        mStateLayout.addView(genContentView(inflater));
        return rootView;
    }

    @NonNull
    protected abstract View genContentView(LayoutInflater inflater);

    @NonNull
    protected StateLayout getStateLayout() {
        return mStateLayout;
    }

}
