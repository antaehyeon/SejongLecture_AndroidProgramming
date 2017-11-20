package com.example.hyeon.sejongcardgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by hyeon on 2017. 11. 20..
 */

public class CardGameView extends View {
    // 1. 멤버 변수 추가
    Bitmap m_BackGroundImage;

    public CardGameView(Context context) {
        super(context);
        // 2. 멤버 변수 설정
        m_BackGroundImage = BitmapFactory.decodeResource(getResources(),
                R.drawable.background, null);
    }

    @Override
    public void onDraw(Canvas canvas) {
        // 3. 배경 이미지 그리기
        canvas.drawBitmap(m_BackGroundImage, 0, 0, null);
    }
}
