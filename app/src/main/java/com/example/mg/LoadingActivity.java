package com.example.mg;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pnikosis.materialishprogress.ProgressWheel;

public class LoadingActivity extends AppCompatActivity {
    ProgressWheel progressWheel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_main);

        progressWheel = (ProgressWheel) findViewById(R.id.progress_wheel);
        progressWheel.spin();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
