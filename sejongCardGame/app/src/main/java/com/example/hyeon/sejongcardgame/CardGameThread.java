package com.example.hyeon.sejongcardgame;

/**
 * Created by hyeon on 2017. 11. 21..
 */

public class CardGameThread extends Thread {
    CardGameView m_View;
    CardGameThread(CardGameView _View) {
        m_View = _View;
    } // Constructor

    public void run() {
        while (true) m_View.checkMatch();
    }
}
