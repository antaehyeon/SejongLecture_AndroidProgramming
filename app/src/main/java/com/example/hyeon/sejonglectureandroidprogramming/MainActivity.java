package com.example.hyeon.sejonglectureandroidprogramming;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView alertTextView,
             seekBarText;

    EditText editText,
             editText2;

    Button  button,
            button2,
            snackBarButton,
            alertButton,
            showProgressButton,
            closeProgressButton;

    ProgressDialog dialog;

    private SeekBar seekBar;
    private int brightness = 100;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // (Custom) Toast 구현 부분
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
        }); // button setOnClickListener


        // 스낵바 구현 부분
        snackBarButton = (Button) findViewById(R.id.btn_snackBar);
        snackBarButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "스낵바입니다", Snackbar.LENGTH_LONG).show();
            }
        });


        // Alert Dialog 구현 부분
        alertTextView = (TextView) findViewById(R.id.txt_showAlertResult);
        alertButton = (Button) findViewById(R.id.btn_showAlert);
        alertButton.setOnClickListener(new Button.OnClickListener() {
            @Override

            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("안내");
                builder.setMessage("종료하시겠습니까?");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String message = "예 버튼이 눌렸습니다.";
                        alertTextView.setText(message);
                    } // onClick
                }); // setPositiveButton

                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String message = "취소 버튼이 눌렸습니다.";
                        alertTextView.setText(message);
                    } // onClick
                }); // setNeutralButton

                builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String message = "아니오 버튼이 눌렸습니다";
                        alertTextView.setText(message);
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            } // onClick
        }); // alertButton onClickListener


        // 프로그레스 바 구현 부분
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setIndeterminate(false);
        progressBar.setMax(100);
        progressBar.setProgress(80);

        showProgressButton = (Button) findViewById(R.id.btn_showProgressBar);
        showProgressButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ProgressDialog(MainActivity.this);
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




    } // onCreate
} // MainActivity
