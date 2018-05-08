package com.library.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button testPull = findViewById(R.id.btn_test_pull);
        testPull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAct(TestSwipeLayoutAct.class.getName());
            }
        });
    }

    private void startAct(String name) {
        Intent intent = new Intent();
        intent.setClassName(this, name);
        startActivity(intent);
    }
}
