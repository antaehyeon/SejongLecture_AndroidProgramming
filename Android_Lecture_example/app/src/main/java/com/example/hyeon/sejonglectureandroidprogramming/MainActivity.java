package com.example.hyeon.sejonglectureandroidprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button runServiceButton;
    Button runBroadCastButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runServiceButton = (Button) findViewById(R.id.btn_entryServiceActivity);
        runServiceButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ServiceActivity.class);
                startActivity(intent);
            }
        });

        runBroadCastButton = (Button) findViewById(R.id.btn_entryBroadcastActivity);
        runBroadCastButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BroadcastActivity.class);
                startActivity(intent);
            }
        });
    } // FUNCTION - onCreate
}
