package com.library.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.andy.library.util.StringUtil;
import com.andy.library.widget.GridPasswordEditText;

/**
 * Created by luofan on 2018/5/16.
 */

public class TestGridPasswordActivity extends AppCompatActivity {

    Button mTextView;

    GridPasswordEditText mGridPasswordEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_grid_password);
        mTextView = findViewById(R.id.text);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast();
            }
        });
        mGridPasswordEditText = findViewById(R.id.edit_grid_password);
        mGridPasswordEditText.setIsPassword(true);
    }

    private void toast() {
        Toast.makeText(this, mGridPasswordEditText.getInputText(), Toast.LENGTH_SHORT).show();
    }

}
