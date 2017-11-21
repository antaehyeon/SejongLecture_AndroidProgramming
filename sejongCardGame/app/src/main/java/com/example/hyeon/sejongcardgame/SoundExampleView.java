package com.example.hyeon.sejongcardgame;

import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.view.View;

/**
 * Created by HYEON on 2017-11-21.
 */

public class SoundExampleView extends View {

    MediaPlayer m_Sound_Background; // 배경음악
    MediaPlayer m_Sound_1;          // 효과음1
    MediaPlayer m_Sound_2;          // 효과음2

    public SoundExampleView(Context context) {
        super(context);

        // 사운드 리소스 로딩
        m_Sound_Background = MediaPlayer.create(context, R.raw.backgroundV2);
        m_Sound_1 = MediaPlayer.create(context, R.raw.backgroundV2);
        m_Sound_2 = MediaPlayer.create(context, R.raw.backgroundV2);

        m_Sound_Background.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {

    }
}
