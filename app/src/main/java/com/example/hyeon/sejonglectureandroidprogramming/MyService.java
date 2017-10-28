package com.example.hyeon.sejonglectureandroidprogramming;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate() 호출됨");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() 호출됨");

        if (intent == null) {
            return Service.START_STICKY;
        } else {
            processCommand(intent);
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d("Myservice", "onDestory() 호출됨.");
    }

    public void processCommand(Intent intent) {
        String command = intent.getStringExtra("command");
        String name = intent.getStringExtra("name");

        Log.d(TAG, "command : " + command + ", name :" + name);

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {};

            Log.d(TAG, "Waiting " + i + " seconds.");
        } // for

        Intent showIntent = new Intent(getApplicationContext(), ServiceActivity.class);
        showIntent.addFlags(    Intent.FLAG_ACTIVITY_NEW_TASK |
                                Intent.FLAG_ACTIVITY_SINGLE_TOP |
                                Intent.FLAG_ACTIVITY_CLEAR_TOP);
        showIntent.putExtra("command", "show");
        showIntent.putExtra("name", name + " from service.");
        startActivity(showIntent);
    } // FUNCTION - processCommand
} // CLASS - MyService
