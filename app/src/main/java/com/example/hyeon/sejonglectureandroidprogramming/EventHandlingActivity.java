package com.example.hyeon.sejonglectureandroidprogramming;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class EventHandlingActivity extends AppCompatActivity {

    View firstView;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_handling);

        textView = (TextView) findViewById(R.id.textView);

        firstView = (View) findViewById(R.id.view);
        firstView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                int action = motionEvent.getAction();

                float curX = motionEvent.getX();
                float curY = motionEvent.getY();

                if (action == MotionEvent.ACTION_DOWN) {
                    println("손가락 눌림 : " + curX + ", " + curY);
                } else if (action == MotionEvent.ACTION_MOVE) {
                    println("손가락 움직임 : " + curX + ", " + curY);
                } else if (action == MotionEvent.ACTION_UP) {
                    println("손가락 뗌 : " + curX + ", " + curY);
                }

                return true;
            }
        });
    } // onCreate

    public void println(String data) {
        textView.append(data + "\n");
    }

}
