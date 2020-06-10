package com.ks.one225.unitTwo.notification;

import androidx.appcompat.app.AppCompatActivity;
import android.app.NotificationManager;
import android.app.RemoteInput;
import android.os.Bundle;
import android.widget.TextView;
import com.ks.one225.R;

public class NotificationViewEx extends AppCompatActivity {

    TextView tv;
    NotificationManager nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_view_ex);

        tv= findViewById(R.id.tv);

        Bundle b1 = RemoteInput.getResultsFromIntent(getIntent());
        if(b1 != null){
            tv.setText(b1.getString(NotificationExampleActivity.myKey));
        }

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(NotificationExampleActivity.notification_ID);

    }
}
