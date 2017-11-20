package com.example.hyeon.sejongcardgame;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageExample extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new com.example.hyeon.sejongcardgame.ImageView(this));


//        setContentView(R.layout.activity_image_example);
    }
}
