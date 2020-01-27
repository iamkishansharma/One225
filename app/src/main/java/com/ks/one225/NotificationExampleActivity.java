package com.ks.one225;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NotificationExampleActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_example);

        textView = findViewById(R.id.textView);
        //getting the notification message
        String message=getIntent().getStringExtra("Message Raaaa...");
        textView.setText(message);
    }
}
