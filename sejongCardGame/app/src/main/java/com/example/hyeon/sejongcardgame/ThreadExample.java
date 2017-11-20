package com.example.hyeon.sejongcardgame;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by hyeon on 2017. 11. 21..
 */

public class ThreadExample extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ThreadExampleView(this));
    }
}
