package com.example.hyeon.sejonglectureandroidprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.eTxt_mainText);
        button = (Button) findViewById(R.id.btn_serviceOn);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MyService.class);
                intent.putExtra("command", "show");
                intent.putExtra("name", name);
                startService(intent);
            } // onClick
        }); // setOnClickListener

        Intent passedIntent = getIntent();
        processIntent(passedIntent);

    } // FUNCTION - onCreate

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);

        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent) {
        if (intent != null) {
            String command = intent.getStringExtra("command");
            String name = intent.getStringExtra("name");

            Toast.makeText(this, "command " + command + ", name : " + name, Toast.LENGTH_SHORT).show();
        }
    } // FUNCTION - processIntent
} // CLASS - MainActivity
