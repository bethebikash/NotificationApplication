package com.bhattaraibikash.notificationapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.bhattaraibikash.notificationapplication.services.MyServices;

public class ServicesActivity extends AppCompatActivity {

    private Button btnStartService, btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        btnStartService = findViewById(R.id.btnStartService);
        btnStopService = findViewById(R.id.btnStopService);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartMyService();
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StopMyService();
            }
        });
    }

    private void StartMyService() {
        startService(new Intent(this, MyServices.class));
    }

    private void StopMyService() {
        stopService(new Intent(this, MyServices.class));
    }
}
