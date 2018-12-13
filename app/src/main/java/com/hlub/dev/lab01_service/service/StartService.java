package com.hlub.dev.lab01_service.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class StartService extends Service {

    //phc thức bắt buộc phải ghi đè  và nó thuộc kiểu Bound Service
    //phương thức này không có tác dụng ở Start Service.
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //phương thức khởi tạo service
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "OnCreate StartService", Toast.LENGTH_SHORT).show();
    }

    //hàm thường dùng để xử lý logic cho Service
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String name = null;
        String date = null;
        if (intent != null) {
            Bundle bundle = intent.getBundleExtra("me");
            name = bundle.getString("name");
            date = bundle.getString("date");
        }


        Toast.makeText(this, "onStartCommand StartService: \n" + name + "\n" + date, Toast.LENGTH_SHORT).show();

        //stopSelf(), để cho nó huỷ bất kì lúc nào bạn muốn
        return START_NOT_STICKY;

    }

    //hàm được gọi khi service bị huỷ do người dùng gọi phương thức stopService() hoặc hàm  stopSelf()
    @Override
    public void onDestroy() {
        Toast.makeText(this, "onDestroy StartService", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
