package com.ks.one225.unitFour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ks.one225.R;

public class UnitFourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_four);
    }

    public void callCustomView(View view) {
        startActivity(new Intent(UnitFourActivity.this, CustomViewActivity.class));
    }
}
