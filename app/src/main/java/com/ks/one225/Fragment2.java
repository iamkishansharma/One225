package com.ks.one225;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    LinearLayout parentF2;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.frag2,container, false);
        parentF2 = v.findViewById(R.id.frag2parent);
        return v;
    }

    public void updateColor(int c){
        parentF2.setBackgroundColor(c);
    }
}
