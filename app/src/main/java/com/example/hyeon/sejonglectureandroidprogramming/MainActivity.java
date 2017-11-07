package com.example.hyeon.sejonglectureandroidprogramming;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    Button button;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast toastView = Toast.makeText(getApplicationContext(),
                            "위치가 바뀐 토스트 메세지입니다.",
                            Toast.LENGTH_LONG);

                    int xOffset = Integer.parseInt(editText.getText().toString());
                    int yOffset = Integer.parseInt(editText2.getText().toString());

                    toastView.setGravity(Gravity.TOP|Gravity.LEFT, xOffset, yOffset);
                    toastView.show();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                } // catch
            } // onClick
        }); // button setOnclickListener

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();

                View layout = inflater.inflate(
                        R.layout.toastborder,
                        (ViewGroup) findViewById(R.id.toast_layout_root));

                TextView text = (TextView) layout.findViewById(R.id.text);
                Toast toast = new Toast(getApplicationContext());
                text.setText("모양 바꾼 토스트");
                toast.setGravity(Gravity.CENTER, 0, -100);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            } // onClick
        }); //


    } // onCreate
} // MainActivity
