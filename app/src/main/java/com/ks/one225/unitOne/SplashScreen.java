package com.ks.one225.unitOne;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ks.one225.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final ImageView img = findViewById(R.id.imgs);
        final TextView tv = findViewById(R.id.texts);
        RelativeLayout splash = findViewById(R.id.splash);

        final Animation animation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.zoom_in);
        img.setVisibility(View.VISIBLE);
        tv.setVisibility(View.VISIBLE);
        tv.startAnimation(animation);
        img.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {

            public void run() {
                startActivity(new Intent(SplashScreen.this, com.ks.one225.MainActivity.class));
                finish();
            }

        }, 4000);
    }
}
