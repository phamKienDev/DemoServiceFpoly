package com.hlub.dev.lab01_service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hlub.dev.lab01_service.service.StartService;

public class MainActivity extends AppCompatActivity {
    private Button btnBoundService;
    private Button btnStartService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnBoundService = (Button) findViewById(R.id.btnBoundService);
        btnStartService = (Button) findViewById(R.id.btnStartService);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });
        btnBoundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, BoundActivity.class);
                startActivity(intent);
            }
        });

    }
}
