package com.bhattaraibikash.notificationapplication.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyServices extends Service {

    public Context context = this;
    public Handler handler = null;
    public Runnable runnable = null;

    public MyServices() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Services Created", Toast.LENGTH_SHORT).show();

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                double randomNo = getRandomDoubleBetweenRange(1, 100);
                Toast.makeText(context, "Random No : " + randomNo, Toast.LENGTH_SHORT).show();
                handler.postDelayed(runnable, 2000);

            }
        };
        handler.postDelayed(runnable, 2000);
        super.onCreate();
    }

    public static double getRandomDoubleBetweenRange(double min, double max){
        return (Math.random()* ((min-max)+ 1))+min;
    }

    @Override
    public void onDestroy() {
        handler.removeCallbacks(runnable);
        Toast.makeText(context, "Service Stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
