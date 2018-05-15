package com.andy.library.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * 基础fragment (下拉后续替换下拉刷新view)
 * Created by luofan on 2018/5/14.
 */

public abstract class BaseFragment extends Fragment implements FragmentBackListener {

    public static final String FRAGMENT_POSITION = "fragment_position";

    private int fragmentPosition;

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            fragmentPosition = bundle.getInt(FRAGMENT_POSITION);
        }
    }

    public int getFragmentPosition() {
        return fragmentPosition;
    }

    protected void showToast(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

}
