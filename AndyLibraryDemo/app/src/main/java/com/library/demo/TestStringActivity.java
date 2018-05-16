package com.library.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.andy.library.util.StringUtil;

/**
 * Created by luofan on 2018/5/16.
 */

public class TestStringActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_string);
        mTextView = findViewById(R.id.text);
        testHideString();
    }

    private void testHideString() {
        String phoneNum = "18583285123";
        mTextView.setText(StringUtil.getHidePhoneNum(phoneNum));

        String bankCardNum = "12345678901234567899876";
        mTextView.setText(StringUtil.getHideBankCardNum(bankCardNum));

        String str = "12345678901234567899876";
        mTextView.setText(StringUtil.getHideString(str, 2, 6));
    }
}
