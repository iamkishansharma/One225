package com.ks.one225.unitFive;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ks.one225.R;

public class UnitFiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_five);
    }

    public void callSharedPreference(View view) {
        startActivity(new Intent(UnitFiveActivity.this, SharedPreferencesEx.class));
    }
    public void callInternalStorage(View view) {
        startActivity(new Intent(UnitFiveActivity.this, InternalStorageEx.class));
    }
}

