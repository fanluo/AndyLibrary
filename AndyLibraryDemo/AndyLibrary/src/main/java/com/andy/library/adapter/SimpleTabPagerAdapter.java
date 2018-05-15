package com.andy.library.adapter;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.andy.library.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;


public class SimpleTabPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    private List<PagerData> mPagerDataList = new ArrayList<>();

    public SimpleTabPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    public void replaceData(List<PagerData> pagerDataList) {
        mPagerDataList.clear();
        if (pagerDataList != null) {
            mPagerDataList.addAll(pagerDataList);
        }
        notifyDataSetChanged();
    }

    public PagerData getPagerData(int position) {
        return mPagerDataList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        PagerData pagerData = getPagerData(position);
        Bundle bundle = pagerData.getBundle();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt(BaseFragment.FRAGMENT_POSITION, position);
        return Fragment.instantiate(mContext, pagerData.getFragmentName(), bundle);
    }

    @Override
    public int getCount() {
        return mPagerDataList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return getPagerData(position).getTitle();
    }

    public static final class PagerData implements Parcelable {

        private String title;

        private String fragmentName;

        private Bundle bundle;

        private int position;

        public PagerData() {

        }

        public PagerData(Parcel in) {
            title = in.readString();
            fragmentName = in.readString();
            position = in.readInt();
            bundle = in.readBundle(getClass().getClassLoader());
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public static final Creator<PagerData> CREATOR = new Creator<PagerData>() {
            @Override
            public PagerData createFromParcel(Parcel in) {
                return new PagerData(in);
            }

            @Override
            public PagerData[] newArray(int size) {
                return new PagerData[size];
            }
        };

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFragmentName() {
            return fragmentName;
        }

        public void setFragmentName(String fragmentName) {
            this.fragmentName = fragmentName;
        }

        public Bundle getBundle() {
            return bundle;
        }

        public void setBundle(Bundle bundle) {
            this.bundle = bundle;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(title);
            dest.writeString(fragmentName);
            dest.writeInt(position);
            dest.writeBundle(bundle);
        }
    }
}
