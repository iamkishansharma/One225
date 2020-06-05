package com.ks.one225;

import android.os.Bundle;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class RatingActivity extends AppCompatActivity {


    RatingBar mRatingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        mRatingBar = findViewById(R.id.ratingBar);
        mRatingBar.setBackgroundColor(getColor(android.R.color.holo_red_dark));
    }
}
