package com.example.hyeon.sejonglectureandroidprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BroadcastActivity extends AppCompatActivity {

    EditText sendingPhoneNumberEditText;
    EditText contentEditText;
    EditText receiveTimeEditText;

    Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        sendingPhoneNumberEditText = (EditText) findViewById(R.id.eTxt_sendingPhoneNumber);
        contentEditText = (EditText) findViewById(R.id.eTxt_content);
        receiveTimeEditText = (EditText) findViewById(R.id.eTxt_receiveTime);

        checkButton = (Button) findViewById(R.id.btn_check);
        checkButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            } // onClick
        });

        // Broadcast에서 받은 Intent를 처리하는 부분 : getIntent()
        Intent passedIntent = getIntent();
        processIntent(passedIntent);

    } // FUNCTION - onCreate

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);

        super.onNewIntent(intent);
    } // FUNCTION - onNewIntent

    private void processIntent(Intent intent) {
        if (intent != null) {
            String sender = intent.getStringExtra("sender");
            String contents = intent.getStringExtra("contents");
            String receivedDate = intent.getStringExtra("receivedDate");

            sendingPhoneNumberEditText.setText(sender);
            contentEditText.setText(contents);
            receiveTimeEditText.setText(receivedDate);
        }
    }
} // CLASS - BroadcastActivity
