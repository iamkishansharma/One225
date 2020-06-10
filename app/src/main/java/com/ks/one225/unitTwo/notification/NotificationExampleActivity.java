package com.ks.one225.unitTwo.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RemoteViews;

import com.ks.one225.R;

public class NotificationExampleActivity extends AppCompatActivity {

    ImageView imageView;
    NotificationManager notificationManager;

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
        RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.small_notification);
        RemoteViews notificationLayoutExpanded = new RemoteViews(getPackageName(), R.layout.big_notification);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channel_ID);
        builder.setSmallIcon(R.drawable.ic_announcement)
                .setContentTitle("My Notification")
                .setContentText("This is my new Notification")
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setCustomContentView(notificationLayout)
                .setCustomBigContentView(notificationLayoutExpanded)
                .build();

               builder .setContentIntent(pi);


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