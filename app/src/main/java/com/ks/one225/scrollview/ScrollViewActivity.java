package com.ks.one225.scrollview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ks.one225.DatePickerActivity;
import com.ks.one225.ProgressBarActivity;
import com.ks.one225.R;
import com.ks.one225.TimePickerActivity;
import com.ks.one225.ToolBarActivity;
import com.ks.one225.alarm.AlarmManagerExample;
import com.ks.one225.fragments.FragmentExample;

public class ScrollViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

    }

    public void ratingBarFun(View view){

        View view2;
        LayoutInflater layoutInflater = LayoutInflater.from(ScrollViewActivity.this);
        view2 = layoutInflater.inflate(R.layout.activity_rating, null);
        final RatingBar bar = view2.findViewById(R.id.ratingBar);
        bar.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in));

        AlertDialog.Builder builder = new AlertDialog.Builder(ScrollViewActivity.this);
        builder.setTitle("Rate Us ?");
        builder.setIcon(R.drawable.ic_check_black_24dp);
        builder.setView(view2);
        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ScrollViewActivity.this, "You Got: "+bar.getRating(), Toast.LENGTH_SHORT).show();

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
    public void horizontalScrollViewFun(View view) {
        Intent in = new Intent(ScrollViewActivity.this, HorizontalScrollView.class);
        startActivity(in);

    }
    public void customToolBarFun(View view) {
        Intent in1 = new Intent(ScrollViewActivity.this, ToolBarActivity.class);
        startActivity(in1);
    }
    public void progressBarFun(View view) {
        Intent in2 = new Intent(ScrollViewActivity.this, ProgressBarActivity.class);
        startActivity(in2);
    }

    public void customToastFun(View view) {
        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.customToast_id));
        // Toast...
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public void alarmExampleFun(View view) {
        startActivity(new Intent(ScrollViewActivity.this, AlarmManagerExample.class));
    }
    public void notificationExampleFun(View view) {

        startActivity(new Intent(ScrollViewActivity.this,com.ks.one225.notification.NotificationExampleActivity.class));
    }
    public void fragmentExampleFun(View view) {
        startActivity(new Intent(ScrollViewActivity.this, FragmentExample.class));
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ScrollViewActivity.this);
        builder.setTitle("Close the App?")
                .setMessage("Tap on 'Yes' to Exit form the App.")
                .setIcon(R.drawable.ic_check_black_24dp)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void datePickerFun(View view) {
        startActivity(new Intent(ScrollViewActivity.this, DatePickerActivity.class));
    }
    public void TimePickerFun(View view) {
        startActivity(new Intent(ScrollViewActivity.this, TimePickerActivity.class));
    }
}
