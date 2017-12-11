package com.example.hyeon.sejonglectureandroidprogramming;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button runServiceButton;
    Button runBroadCastButton;
    Button runEventHandlingButton;
    Button runFocusButton;
    Button runToastButton;
    Button runDialogButton;
    Button runProgressBarButton;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode) {
            case 1:
        } // FUNCTION - onCreate

        Toast.makeText(this, "" + data.getStringExtra("name"), Toast.LENGTH_SHORT).show();
    }

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

        runEventHandlingButton = (Button) findViewById(R.id.btn_eventHandling);
        runEventHandlingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), EventHandlingActivity.class));
                startActivityForResult(new Intent(getApplicationContext(), EventHandlingActivity.class), 0);
            }
        });

        runFocusButton = (Button) findViewById(R.id.btn_focus);
        runFocusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FocusActivity.class));
            }
        });

        runToastButton = (Button) findViewById(R.id.btn_toast);
        runToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ToastActivity.class));
            }
        });

        runDialogButton = (Button) findViewById(R.id.btn_Dialog);
        runDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DialogActivity.class));
            }
        });

        runProgressBarButton = (Button) findViewById(R.id.btn_progrssBar);
        runProgressBarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProgressBarActivity.class));
            }
        });

    }
}
