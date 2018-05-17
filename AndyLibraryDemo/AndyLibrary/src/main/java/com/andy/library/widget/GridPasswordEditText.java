package com.andy.library.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andy.library.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luofan on 2018/5/17.
 */

public class GridPasswordEditText extends FrameLayout {

    private EditText mEditText;

    private LinearLayout mLayout;

    private int mMaxLength = 6;

    private boolean mIsPassword = true;

    private OnInputCompleteListener mCompleteListener;

    private List<TextView> mTextViewList = new ArrayList<>();

    TextWatcher mTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            setTextValue(s.toString());
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

    };

    public GridPasswordEditText(@NonNull Context context) {
        this(context, null);
    }

    public GridPasswordEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GridPasswordEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.widget_grid_password, this, true);
        mEditText = findViewById(R.id.edit_input);
        mLayout = findViewById(R.id.layout_grid);
        mEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(mMaxLength)});
        mEditText.addTextChangedListener(mTextWatcher);
        initGridLayout(mMaxLength);
    }

    public void setMaxInputLenght(int maxLength) {
        mMaxLength = maxLength;
        mEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(mMaxLength)});
        initGridLayout(mMaxLength);
    }

    public void setIsPassword(boolean isPassword) {
        mIsPassword = isPassword;
    }

    private void initGridLayout(int length) {
        mTextViewList.clear();
        mLayout.removeAllViews();
        for (int i = 0; i < length; i++) {
            LinearLayout.LayoutParams textLP = new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT);
            textLP.weight = 1;
            TextView textView = new TextView(getContext());
            textView.setBackgroundColor(Color.WHITE);
            textView.setGravity(Gravity.CENTER);
            mLayout.addView(textView, textLP);
            mTextViewList.add(textView);
            if (i != length - 1) {
                LinearLayout.LayoutParams dividerLP = new LinearLayout.LayoutParams(2, LayoutParams.MATCH_PARENT);
                View divider = new View(getContext());
                divider.setBackgroundColor(Color.BLUE);
                mLayout.addView(divider, dividerLP);
            }
        }
    }

    private void setTextValue(String str) {
        int len = str.length();
        for (int i = 0; i < mMaxLength; i++) {
            if (i < len) {
                if (mIsPassword) {
                    mTextViewList.get(i).setText("*");
                } else {
                    mTextViewList.get(i).setText(str.substring(i, i + 1));
                }
            } else {
                mTextViewList.get(i).setText("");
            }
        }
        if (len == mMaxLength && mCompleteListener != null) {
            mCompleteListener.OnInputComplete(str);
        }
    }

    public String getInputText() {
        return mEditText.getText().toString();
    }

    public interface OnInputCompleteListener {
        void OnInputComplete(String result);
    }
}
