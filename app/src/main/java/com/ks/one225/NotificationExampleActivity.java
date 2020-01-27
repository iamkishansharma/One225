package com.ks.one225;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NotificationExampleActivity extends AppCompatActivity {

    ImageView imageView;
    NotificationManager notificationManager;
    Button button;

    public static final String channel_ID = "My Channel ID";
    public static final int notification_ID = 10;
    public static final String myKey = "Remote Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_example);

        imageView = findViewById(R.id.iv);
        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data){
//
//    }

    public void showNotification(View view) {
        myNotificationChannel();

        Intent i = new Intent(NotificationExampleActivity.this, NotificationViewEx.class);
        PendingIntent pi = PendingIntent.getActivity(NotificationExampleActivity.this, 1, i, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channel_ID);
        builder.setSmallIcon(R.drawable.ic_announcement)
                .setContentTitle("My Notification")
                .setContentText("This is my new Notification")
                .setLights(Color.RED, 3000, 3000)
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setContentIntent(pi);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            //RemoteInput ri = new RemoteInput.Builder(myKey).setLabel("Replying....").build();
            androidx.core.app.RemoteInput ri = new androidx.core.app.RemoteInput.Builder(myKey).setLabel("Replying.....").build();
            NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_check_black_24dp, "Reply!", pi)
                    .addRemoteInput(ri).build();


            builder.addAction(action);
        }

        builder.setAutoCancel(true);
        notificationManager.notify(notification_ID, builder.build());
    }

    public void myNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String name = "My Channel Name";
            String desc = "My Channel Description";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel notificationChannel = new NotificationChannel(channel_ID, name, importance);
            notificationChannel.setDescription(desc);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.canShowBadge();

            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

}