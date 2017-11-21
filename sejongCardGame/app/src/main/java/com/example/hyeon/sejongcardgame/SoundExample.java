package com.example.hyeon.sejongcardgame;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by HYEON on 2017-11-21.
 */

public class SoundExample extends Activity {

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(new SoundExampleView(this));

    }


}
