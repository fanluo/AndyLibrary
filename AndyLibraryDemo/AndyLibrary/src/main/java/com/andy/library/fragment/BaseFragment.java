package com.andy.library.fragment;


import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * 基础fragment (下拉后续替换下拉刷新view)
 * Created by luofan on 2018/5/14.
 */

public abstract class BaseFragment extends Fragment implements FragmentBackListener {

    protected void showToast(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

}
