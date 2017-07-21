package com.example.stickview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.stickview.coordinatorLayout.activity.CoordinatorMainActivity;
import com.example.stickview.scrollablelayout.activity.ScrollAbleMainActivity;
import com.example.stickview.sticknavi.activity.StickNaviActivity;
import com.example.stickview.texttopview.activity.TextTopMainActivity;

public class MainActivity extends AppCompatActivity {
    private TextView coordinatorTextView;
    private TextView scrollablelayout;
    private TextView stickerviewLayout;
    private TextView stickNaviLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        initView();
        initEvents();
    }

    private void initView() {
        coordinatorTextView = (TextView) findViewById(R.id.coorninatorlayout);
        scrollablelayout = (TextView) findViewById(R.id.scrollablelayout);
        stickerviewLayout = (TextView) findViewById(R.id.stickerviewLayout);
        stickNaviLayout = (TextView) findViewById(R.id.stickNaviLayout);
    }


    private void initEvents() {
        coordinatorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CoordinatorMainActivity.class);
                startActivity(intent);
            }
        });

        scrollablelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollAbleMainActivity.class);
                startActivity(intent);
            }
        });

        stickerviewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TextTopMainActivity.class);
                startActivity(intent);
            }
        });

        stickNaviLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StickNaviActivity.class);
                startActivity(intent);
            }
        });
    }

}
