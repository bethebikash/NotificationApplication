package com.bhattaraibikash.notificationapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.nio.channels.Channel;

public class MainActivity extends AppCompatActivity {

    private Button btnNotification1, btnNotification2;
    private NotificationManagerCompat notificationManagerCompat;
    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        btnNotification1 = findViewById(R.id.btnNotification1);
        btnNotification2 = findViewById(R.id.btnNotification2);

        btnNotification1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                DisplayNotification1();
            }
        });

        btnNotification2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                DisplayNotification2();
            }
        });
    }

    private  void DisplayNotification1() {
        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentTitle("First Message")
                .setContentText("Message of first notification")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(count, notification);
    }

    private  void DisplayNotification2() {
        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_attachment_black_24dp)
                .setContentTitle("Second Message")
                .setContentText("Message of second notification")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(count, notification);
    }
}
