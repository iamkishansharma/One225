package com.ks.one225.unitFive;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.ks.one225.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InternalStorageEx extends AppCompatActivity {

    TextInputEditText data;
    Button write, read;
    TextView readTextView;
    String textFileName = "TxtFil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage_ex);

        data = findViewById(R.id.ins_edit_text);
        write = findViewById(R.id.write_btn);
        read = findViewById(R.id.read_btn);
        readTextView = findViewById(R.id.readText);
    }

    public void writeBtnClick(View view) {
        String data1 = data.getText().toString();
        if(data1.equals("")){
            data.setError("Enter some text");
        }else {
            try{
                FileOutputStream fileOutputStream = openFileOutput(textFileName,MODE_PRIVATE);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                outputStreamWriter.write(data1);
                outputStreamWriter.close();

                //displaying success message
                Toast.makeText(InternalStorageEx.this, "File Saved Successfully!", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void readBtnClick(View view) {
        try {
            FileInputStream fileInputStream = openFileInput(textFileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
            fileInputStream.close();
            inputStreamReader.close();
            //displaying success message
            Toast.makeText(InternalStorageEx.this, "File Read Successfully!", Toast.LENGTH_SHORT).show();
            readTextView.setText(stringBuilder.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}