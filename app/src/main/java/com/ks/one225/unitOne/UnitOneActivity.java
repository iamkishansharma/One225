package com.ks.one225.unitOne;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ks.one225.R;

public class UnitOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_one);

        Toolbar toolbar = new Toolbar(UnitOneActivity.this);
        toolbar.setContentInsetEndWithActions(R.menu.menu);
        setSupportActionBar(toolbar);
    }

    public void callVerticalScrollView(View view) {
        startActivity(new Intent(UnitOneActivity.this, ScrollViewActivity.class));
    }

    public void callHorizontalScrollView(View view) {
        startActivity(new Intent(UnitOneActivity.this, HorizontalScrollViewActivity.class));
    }

    public void callToolBar(View view) {

        startActivity(new Intent(UnitOneActivity.this, ToolBarActivity.class));
    }

    public void callRatingBar(View view) {

        startActivity(new Intent(UnitOneActivity.this, RatingActivity.class));
    }

    public void callSplashScreen(View view) {

        startActivity(new Intent(UnitOneActivity.this, SplashScreen.class));
    }

    public void callProgressBar(View view) {

        startActivity(new Intent(UnitOneActivity.this, ProgressBarActivity.class));
    }

    public void callCustomToast(View view) {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.customToast_id));
        // Toast...
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
