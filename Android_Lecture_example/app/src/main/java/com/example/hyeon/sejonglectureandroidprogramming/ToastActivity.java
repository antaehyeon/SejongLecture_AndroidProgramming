package com.example.hyeon.sejonglectureandroidprogramming;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    EditText xEditText;
    EditText yEditText;

    Button popUpToastButton;
    Button popUpCustomToastButton;
    Button snackBarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        xEditText = (EditText) findViewById(R.id.eTxt_toastX);
        yEditText = (EditText) findViewById(R.id.eTxt_toastY);

        popUpToastButton = (Button) findViewById(R.id.btn_popUpToast);
        popUpToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast toastView = Toast.makeText(ToastActivity.this, "위치가 바뀌는 토스트입니다 :)", Toast.LENGTH_SHORT);

                    int xOffset = Integer.parseInt(xEditText.getText().toString());
                    int yOffset = Integer.parseInt(yEditText.getText().toString());

                    toastView.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                    toastView.show();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });

        popUpCustomToastButton = (Button) findViewById(R.id.btn_customToast);
        popUpCustomToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();

                View layout = inflater.inflate(
                        R.layout.toastborder,
                        (ViewGroup) findViewById(R.id.toast_layout_root));

                TextView text = (TextView) layout.findViewById(R.id.txtView_customToast);
                Toast toast = new Toast(getApplicationContext());
                text.setText("모양 바꾼 토스트");
                toast.setGravity(Gravity.CENTER, 0 , -100);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);

                toast.show();
            }
        });

        snackBarButton = (Button) findViewById(R.id.btn_snackBar);
        snackBarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "스낵바입니다", Snackbar.LENGTH_SHORT).show();
            }
        });


    }
}
