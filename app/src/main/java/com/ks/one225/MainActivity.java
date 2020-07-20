package com.ks.one225;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ks.one225.unitFive.UnitFiveActivity;
import com.ks.one225.unitFour.UnitFourActivity;
import com.ks.one225.unitOne.UnitOneActivity;
import com.ks.one225.unitThree.UnitThreeActivity;
import com.ks.one225.unitTwo.UnitTwoActivity;

public class MainActivity extends AppCompatActivity {

    AdapterViewFlipper mAdapterViewFlipper;
    GridLayout mGridLayout;
    int [] IMAGES = {
            R.drawable.pro0,
            R.drawable.pro1,
            R.drawable.pro2,
            R.drawable.pro3,
            R.drawable.pro4,
            R.drawable.logo_dark
    };
    String [] NAMES = {
            "Sundar Pichai",
            "Leonardo Dicaprio",
            "Reagan Brogdon",
            "Hrithik Roshan",
            "Jonny Depp",
            "HeyCode Inc"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = new Toolbar(MainActivity.this);
        setSupportActionBar(toolbar);

        mAdapterViewFlipper = findViewById(R.id.adapterViewFlipper);
        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, IMAGES, NAMES);
        mAdapterViewFlipper.setAdapter(customAdapter);
        mAdapterViewFlipper.setFlipInterval(2500);
        mAdapterViewFlipper.setAutoStart(true);

        mGridLayout = findViewById(R.id.mainGrid);

        final Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move);
        final Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bouncing);
        mGridLayout.setAnimation(animation1);
        mAdapterViewFlipper.setAnimation(animation1);

    }
    static class CustomAdapter extends BaseAdapter{
        Context context;
        int[] images;
        String [] names;
        LayoutInflater inflater;

        CustomAdapter(Context context, int[] images, String[] names) {
            this.context = context;
            this.images = images;
            this.names = names;
            inflater = (LayoutInflater.from(context));
        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.adapter_view_flip,null);
            TextView name = convertView.findViewById(R.id.adapt_text);
            ImageView image = convertView.findViewById(R.id.adapt_image);
            name.setText(names[position]);
            image.setImageResource(images[position]);
            return convertView;
        }
    }

    public void unitOneCall(View view) {
        startActivity(new Intent(MainActivity.this, UnitOneActivity.class));
    }

    public void unitTwoCall(View view) {
        startActivity(new Intent(MainActivity.this, UnitTwoActivity.class));
    }

    public void unitThreeCall(View view) {
        startActivity(new Intent(MainActivity.this, UnitThreeActivity.class));
    }

    public void unitFourCall(View view) {
        startActivity(new Intent(MainActivity.this, UnitFourActivity.class));
    }
    public void unitFiveCall(View view) {
        //Toast.makeText(this, "Unit 5\nAdded Soon", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, UnitFiveActivity.class));
    }
    public void unitSixCall(View view) {
        Toast.makeText(this, "Unit 6\nAdded Soon", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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
}
