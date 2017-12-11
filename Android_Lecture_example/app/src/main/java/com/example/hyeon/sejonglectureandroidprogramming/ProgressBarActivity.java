package com.example.hyeon.sejonglectureandroidprogramming;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarActivity extends AppCompatActivity {

    Button  showProgressButton,
            closeProgressButton;

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        // 프로그레스 바 구현 부분
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setIndeterminate(false);
        progressBar.setMax(100);
        progressBar.setProgress(80);

        showProgressButton = (Button) findViewById(R.id.btn_showProgressBar);
        showProgressButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ProgressDialog(ProgressBarActivity.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setMessage("데이터를 확인하는 중입니다");
                dialog.show();
            }
        });

        closeProgressButton = (Button) findViewById(R.id.btn_closeProgressBar);
        closeProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialog != null) {
                    dialog.dismiss();
                } // if
            } // onClick
        }); // closeProgressButton
    }
}
