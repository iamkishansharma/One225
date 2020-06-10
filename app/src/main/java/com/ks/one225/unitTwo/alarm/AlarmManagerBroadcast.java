package com.ks.one225.unitTwo.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import com.ks.one225.R;

public class AlarmManagerBroadcast extends BroadcastReceiver {

    MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {
        mp = MediaPlayer.create(context, R.raw.alarm_sound);
        mp.start();
        Toast.makeText(context, "Message", Toast.LENGTH_LONG).show();
    }
}
