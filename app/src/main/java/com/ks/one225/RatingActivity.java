package com.ks.one225;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingActivity extends AppCompatActivity {


    RatingBar mRatingBar;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        mRatingBar = findViewById(R.id.ratingBar);
        btn = findViewById(R.id.rateButton);

        final String rating = String.valueOf(mRatingBar.getRating());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RatingActivity.this, "Your Gave "+rating+" stars.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
