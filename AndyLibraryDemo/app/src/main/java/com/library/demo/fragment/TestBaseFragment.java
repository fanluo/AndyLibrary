package com.library.demo.fragment;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.andy.library.fragment.BaseFragment;
import com.andy.library.fragment.BaseSimpleFragment;
import com.library.demo.R;

/**
 * Created by luofan on 2018/5/14.
 */

public class TestBaseFragment extends BaseSimpleFragment {

    @NonNull
    @Override
    protected View genContentView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_test_base, null);
        Button button1 = view.findViewById(R.id.btn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStateLayout().showLoadingView(false);
            }
        });
        Button button2 = view.findViewById(R.id.btn_clear);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStateLayout().showContentView();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return view;
    }

    @Override
    public boolean onBackPressed() {
        showToast("拦截了返回");
        return true;
    }
}
