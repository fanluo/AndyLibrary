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

    TextView mAmountText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_string);
        mTextView = findViewById(R.id.text);
        mAmountText = findViewById(R.id.text_amount);
        testHideString();
        testAmount();
    }

    private void testAmount(){
        String amount = "1398.13";
        mAmountText.setText(StringUtil.getFormatMoney(amount));

        String amount1 = "";
        mAmountText.setText(StringUtil.getFormatMoney(amount1));
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
