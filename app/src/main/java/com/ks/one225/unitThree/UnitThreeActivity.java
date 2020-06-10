package com.ks.one225.unitThree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ks.one225.R;
import com.ks.one225.unitThree.fragments.FragmentExample;

public class UnitThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_three);
    }

    public void callFragments(View view) {
        startActivity(new Intent(UnitThreeActivity.this, FragmentExample.class));
    }
    public void callDatePicker(View view) {
        startActivity(new Intent(UnitThreeActivity.this, DatePickerActivity.class));
    }
    public void callTimePicker(View view) {
        startActivity(new Intent(UnitThreeActivity.this, TimePickerActivity.class));
    }

}
