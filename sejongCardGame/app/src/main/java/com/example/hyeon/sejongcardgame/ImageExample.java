package com.example.hyeon.sejongcardgame;

import android.app.Activity;
import android.os.Bundle;

public class ImageExample extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(new com.example.hyeon.sejongcardgame.ImageView(this));

        // CardGameView 그리기
        setContentView(new CardGameView(this));

        // SoundExample 그리기
        // setContentView(new SoundExampleView(this));


//        setContentView(R.layout.activity_image_example);
    }
}
