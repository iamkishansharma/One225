package com.ks.one225;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarActivity extends AppCompatActivity {

    ProgressBar pgb1, pgb2;
    Button start, reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        pgb1 = findViewById(R.id.progressbar1);
        pgb2 = findViewById(R.id.progressbar2);
        start = findViewById(R.id.prog_start);
        reset = findViewById(R.id.prog_reset);



    }
}
