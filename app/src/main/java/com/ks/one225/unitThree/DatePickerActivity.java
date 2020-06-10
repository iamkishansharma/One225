package com.ks.one225.unitThree;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ks.one225.R;

public class DatePickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        DatePicker pickDate = findViewById(R.id.pickDate);

        pickDate.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(DatePickerActivity.this, "Date is: "+year+"/"+monthOfYear+"/"+dayOfMonth, Toast.LENGTH_LONG).show();
            }
        });

    }

    public void getDate(View view) {
        DialogInterface dialogInterface = new DialogInterface() {
            @Override
            public void cancel() {
                //TODO::
            }

            @Override
            public void dismiss() {
                //TODO::
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(this);
        datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(DatePickerActivity.this, year+"/"+month+"/"+dayOfMonth, Toast.LENGTH_SHORT).show();
            }
        });
        datePickerDialog.onClick(dialogInterface,2);
        datePickerDialog.show();
    }
}
