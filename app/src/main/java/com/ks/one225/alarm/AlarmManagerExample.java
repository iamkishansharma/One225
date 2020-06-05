package com.ks.one225.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ks.one225.R;

public class AlarmManagerExample extends AppCompatActivity {

    Button start,restart,cancel;
    EditText edt_pi;
    int i;
    Intent intent;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager_example);

        start = findViewById(R.id.start_pi);
        restart = findViewById(R.id.restart_pi);
        cancel = findViewById(R.id.cancel_pi);
        edt_pi = findViewById(R.id.edt_pi);

        intent = new Intent(AlarmManagerExample.this, com.ks.one225.alarm.AlarmManagerBroadcast.class);
        pendingIntent = PendingIntent.getBroadcast(AlarmManagerExample.this, 234, intent, 0);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_pi.length()!=0){
                    i = Integer.parseInt(edt_pi.getText().toString());
                    alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(i*1000), pendingIntent);
                    Toast.makeText(AlarmManagerExample.this, "Alarm set in "+i+" seconds", Toast.LENGTH_LONG).show();
                }else{
                    edt_pi.setError("Error Input!");
                }
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),(1000*5), pendingIntent);
                Toast.makeText(AlarmManagerExample.this, "Repeating Alarm in 5 Seconds", Toast.LENGTH_LONG).show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmManager.cancel(pendingIntent);
                Toast.makeText(AlarmManagerExample.this, "Alarm Cancelled!!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
