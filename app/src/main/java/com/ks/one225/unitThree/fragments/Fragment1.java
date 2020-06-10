package com.ks.one225.unitThree.fragments;

import android.os.Bundle;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ks.one225.R;

public class Fragment1 extends Fragment {
    public Fragment1(){

    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag1, container,false);

        Button btnGreen = v.findViewById(R.id.frag1BtnGreen);
        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentExample frag = (FragmentExample) getActivity();
                frag.newColor(Color.BLACK);
            }
        });
        return v;
    }
}
