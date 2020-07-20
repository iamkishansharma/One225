package com.ks.one225.unitFive;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ks.one225.R;

public class SharedPreferencesEx extends AppCompatActivity {
Button save;
EditText name, address, mobileNo, email;
SharedPreferences mSharedPreferences;
SharedPreferences.Editor mEditor;
boolean checkSaved;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_ex);
        name = findViewById(R.id.edt_sp1);
        address = findViewById(R.id.edt_sp2);
        mobileNo = findViewById(R.id.edt_sp3);
        email = findViewById(R.id.edt_sp4);

        save = findViewById(R.id.btn_sp1);
        Toolbar toolbar = findViewById(R.id.sp_toolbar);
        setSupportActionBar(toolbar);

        mSharedPreferences = getSharedPreferences("stored_data", MODE_PRIVATE);

        if(mSharedPreferences !=null){
            checkSaved = mSharedPreferences.getBoolean("data_saved", false);
            if(checkSaved){
                String setName = mSharedPreferences.getString("name", "");
                String setAddress = mSharedPreferences.getString("address", "");
                String setMobileNo = mSharedPreferences.getString("mobileNo", "");
                String setEmail = mSharedPreferences.getString("email", "");

                name.setText(setName);
                address.setText(setAddress);
                mobileNo.setText(setMobileNo);
                email.setText(setEmail);
            }
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor = mSharedPreferences.edit();
                String name1 = name.getText().toString().trim();
                String address1 = address.getText().toString().trim();
                String mobileNo1 = mobileNo.getText().toString().trim();
                String email1 = email.getText().toString().trim();

                if(name1.equals("")&&address1.equals("")&&mobileNo1.equals("")&&email1.equals("")){
                    name.setError("Required Field !");
                    address.setError("Required Field !");
                    mobileNo.setError("Required Field !");
                    email.setError("Required Field !");

                }else {
                    mEditor.putBoolean("data_saved", true);
                    mEditor.putString("name", name1);
                    mEditor.putString("address", address1);
                    mEditor.putString("mobileNo", mobileNo1);
                    mEditor.putString("email", email1);
                    mEditor.apply();
                    Toast.makeText(SharedPreferencesEx.this, "Your Details Saved !", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sp_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.delete_all){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Deleting Shared Preferences Data")
                    .setMessage("Want to delete saved data?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    deleteSharedPreferences("stored_data");
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //::TODO NOTHING
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
            return true;
        }
        return false;
    }
}
