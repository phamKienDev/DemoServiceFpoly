package com.hlub.dev.lab01_service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hlub.dev.lab01_service.service.BoundService;
import com.hlub.dev.lab01_service.service.StartService;

public class BoundActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStartB;
    private Button btnStopB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound);


        btnStartB = (Button) findViewById(R.id.btnStartB);
        btnStopB = (Button) findViewById(R.id.btnStopB);

        btnStartB.setOnClickListener(this);
        btnStopB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, BoundService.class);
        Bundle bundle = new Bundle();
        bundle.putString("name", "Pham Van Kien");
        bundle.putString("date", "20/11/1999");
        intent.putExtra("me", bundle);
        switch (view.getId()) {
            case R.id.btnStartB:
                bindService(intent,serviceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.btnStopB:
                unbindService(serviceConnection);
                break;
        }

    }

    public ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
