package com.example.hyeon.sejongcardgame;

/**
 * Created by hyeon on 2017. 11. 21..
 */

public class ElevatorMoveRunnable implements Runnable {
    public ThreadExampleView m_View;

    public ElevatorMoveRunnable(ThreadExampleView _view) {
        m_View = _view;
    }

    public void run() {
        // 엘레베이터를 움직이는 동작
    }
}
