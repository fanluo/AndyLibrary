package com.library.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.andy.library.activity.FragmentHolderActivity;
import com.library.demo.fragment.TestBaseFragment;
import com.library.demo.fragment.TestBaseListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button testPull = findViewById(R.id.btn_test_pull);
        testPull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHolderActivity.startMe(MainActivity.this, "测试页面", TestBaseListFragment.class.getName());
            }
        });
        Button testDrag = findViewById(R.id.btn_test_drag);
        testDrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAct(TestDragLayoutAct.class.getName());
            }
        });
        Button testLayout = findViewById(R.id.btn_test_layout);
        testLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAct(TestViewPagerActivity.class.getName());
            }
        });
    }

    private void startAct(String name) {
        Intent intent = new Intent();
        intent.setClassName(this, name);
        startActivity(intent);
    }
}
