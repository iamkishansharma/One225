package com.ks.one225.unitThree.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ks.one225.R;

public class FragmentExample extends AppCompatActivity implements FragmentExampleInterface {

    Button mainBtn;
    int count = 0;
    LinearLayout frag1BG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);

        mainBtn = findViewById(R.id.mainBtn);
        frag1BG = findViewById(R.id.frag1BG);

        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if (count%2!=0){
                    frag1BG.setBackgroundColor(Color.WHITE);
                }else{
                    frag1BG.setBackgroundColor(Color.DKGRAY);
                }
            }
        });
    }
    public void changeColor(View v){
        Fragment2 fragment2 = (Fragment2)getSupportFragmentManager().findFragmentByTag("fragg2");
        fragment2.updateColor(Color.BLUE);
    }
    @Override
    public void newColor(int green) {
        Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentByTag("fragg2");
        fragment2.updateColor(green);
    }
}
