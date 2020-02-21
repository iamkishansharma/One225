package com.ks.one225;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentExample extends AppCompatActivity implements FragmentExampleInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);
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
