package com.ks.one225;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class ScrollViewActivity extends AppCompatActivity {

    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);


        mImageView = findViewById(R.id.stImg);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ScrollViewActivity.this);
                builder.setTitle("Rate Us ?");
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.activity_rating, viewGroup, false);
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }


    public void OpenRa1(View view) {
        Intent in = new Intent(ScrollViewActivity.this, ScrollViewActivity2.class);
        startActivity(in);

    }
    public void OpenRa2(View view) {
        Intent in1 = new Intent(ScrollViewActivity.this, ToolBarActivity.class);
        startActivity(in1);
    }
    public void OpenRa3(View view) {
        Intent in2 = new Intent(ScrollViewActivity.this, ProgressBarActivity.class);
        startActivity(in2);

    }

    public void OpenRa4(View view) {
        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.customToast_id));

        // Toast...
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 200, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }

    public void OpenRa5(View view) {
        startActivity(new Intent(ScrollViewActivity.this, AlarmManagerExample.class));
    }
    public void OpenRa6(View view) {

        startActivity(new Intent(ScrollViewActivity.this,NotificationExampleActivity.class));
    }
}
