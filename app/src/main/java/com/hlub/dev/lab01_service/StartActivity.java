package com.hlub.dev.lab01_service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hlub.dev.lab01_service.service.StartService;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStart;
    private Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(StartActivity.this, StartService.class);
        Bundle bundle = new Bundle();
        bundle.putString("name", "Pham Van Kien");
        bundle.putString("date", "20/11/1999");
        intent.putExtra("me", bundle);
        switch (view.getId()) {
            case R.id.btnStart:
                startService(intent);
                break;
            case R.id.btnStop:
                stopService(intent);
                break;
        }
    }
}
