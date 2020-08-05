package com.ks.one225.unitOne;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ks.one225.R;

public class ProgressBarActivity extends AppCompatActivity {

    ProgressBar pgb1, pgb2;
    Button start, reset;
    private ProgressBar mProgressBar;
    TextView progress_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        //Two Progress Bars
        pgb1 = findViewById(R.id.progressbar1);
        pgb1.setProgress(0);
        pgb2 = findViewById(R.id.progressbar2);
        pgb2.setProgress(0);

        //Progress Action Settings
        mProgressBar = new ProgressBar(ProgressBarActivity.this);
        mProgressBar.setMax(100);
        mProgressBar.setIndeterminate(true);

        //Buttons
        start = findViewById(R.id.prog_start);
        reset = findViewById(R.id.prog_reset);
        progress_text = findViewById(R.id.progress_text);

        //------------- AFTER START BUTTON PRESSED-----------
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int totalTime = 100;
                Thread t = new Thread(){
                    @Override
                    public void run() {
                        int jumpTime = 0;
                        while (jumpTime < totalTime){
                            try{
                                sleep(200);
                                jumpTime += 5;
                                pgb1.setProgress(jumpTime);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }
                };
                t.start();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int totalTime = 100;
                Thread t = new Thread(){
                    @Override
                    public void run() {
                        int jumpTime = 0;
                        while (jumpTime < totalTime){
                            try{
                                sleep(200);
                                jumpTime += 5;
                                pgb2.setProgress(jumpTime);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }
                };
                t.start();
            }

        });


    }
}
