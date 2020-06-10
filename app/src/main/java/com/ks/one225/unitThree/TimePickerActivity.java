package com.ks.one225.unitThree;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ks.one225.R;

public class TimePickerActivity extends AppCompatActivity {
    TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        timePicker = findViewById(R.id.pickTime);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(TimePickerActivity.this, hourOfDay+":"+minute, Toast.LENGTH_LONG).show();
            }
        });

    }
    public void getTime(View view){
        final DialogInterface dialogInterface = new DialogInterface() {
            @Override
            public void cancel() {
                //TODO:
            }

            @Override
            public void dismiss() {
                //TODO:
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(TimePickerActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(TimePickerActivity.this, hourOfDay+":"+minute, Toast.LENGTH_SHORT).show();
                    }
                },0,5,true);
        timePickerDialog.onClick(dialogInterface,1);
        timePickerDialog.show();
    }
}
