package com.ks.one225.unitSix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ks.one225.R;

public class UnitSixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_six);
    }

    public void callNavigationEx(View view) {
        startActivity(new Intent(UnitSixActivity.this, NavigationExActivity.class));
    }

    public void callViewPagerEx(View view) {
        startActivity(new Intent(UnitSixActivity.this, ViewPagerExActivity.class));
    }
}
