package com.example.hyeon.sejongcardgame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by hyeon on 2017. 11. 21..
 */

public class ThreadExampleView extends View {

    public ThreadExampleView(Context context) {
        super(context);
        ElevatorMoveThread thread_1 = new ElevatorMoveThread();
        thread_1.start();

        Runnable _runnable = new ElevatorMoveRunnable(this);
        Thread thread_2 = new Thread(_runnable);
        thread_2.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {

    }
}
