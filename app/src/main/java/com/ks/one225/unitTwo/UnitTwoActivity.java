package com.ks.one225.unitTwo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ks.one225.R;
import com.ks.one225.unitTwo.alarm.AlarmManagerExample;
import com.ks.one225.unitTwo.notification.NotificationExampleActivity;

public class UnitTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_two);

        Toolbar toolbar = new Toolbar(UnitTwoActivity.this);
        setSupportActionBar(toolbar);
    }


    public void callAlarm(View view) {
        startActivity(new Intent(UnitTwoActivity.this, AlarmManagerExample.class));
    }

    public void callNotification(View view) {
        startActivity(new Intent(UnitTwoActivity.this, NotificationExampleActivity.class));
    }
}
