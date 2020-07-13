package com.example.alart2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int year = 2020;
        int month = 6;
        int date = 10;
        int hour = 15;
        int minute = 41;
        Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
        PendingIntent senderIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Calendar alertDay = Calendar.getInstance();
        alertDay.set(year, month, date, hour,minute, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        if(alarmManager != null) {
            alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(alertDay.getTimeInMillis(), null), senderIntent);
            //alarmManager.setExact(AlarmManager.RTC_WAKEUP, today.getTimeInMillis(), senderIntent);
        }
    }
}