package com.ks.one225.unitOne;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ks.one225.R;

public class RatingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
    }

    public void ratingBarFun(View view){
        View view2;
        LayoutInflater layoutInflater = LayoutInflater.from(RatingActivity.this);
        view2 = layoutInflater.inflate(R.layout.rating_bar_view, null);

        final RatingBar bar = view2.findViewById(R.id.ratingBar);
        bar.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in));

        AlertDialog.Builder builder = new AlertDialog.Builder(RatingActivity.this);
        builder.setTitle("Rate Us ?");
        builder.setIcon(R.drawable.ic_check_black_24dp);
        builder.setView(view2);
        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(RatingActivity.this, "You Got: "+bar.getRating(), Toast.LENGTH_SHORT).show();

            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TODO:: NEGATIVE
                        dialog.dismiss();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
