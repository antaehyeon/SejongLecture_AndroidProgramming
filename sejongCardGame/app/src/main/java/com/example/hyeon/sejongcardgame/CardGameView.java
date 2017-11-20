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
    Bitmap m_BackGroundImage,
           m_CardBackSide,
           m_Card_Red,
           m_Card_Green,
           m_Card_Blue;

    Card m_Shuffle[][];

    public CardGameView(Context context) {
        super(context);
        // 2. 멤버 변수 설정
        m_BackGroundImage = BitmapFactory.decodeResource(getResources(),
                R.drawable.background, null);
        m_CardBackSide = BitmapFactory.decodeResource(getResources(),
                R.drawable.backside, null);

        m_Card_Red = BitmapFactory.decodeResource(getResources(),
                R.drawable.android_front_red, null);
        m_Card_Green = BitmapFactory.decodeResource(getResources(),
                R.drawable.android_front_red, null);
        m_Card_Blue = BitmapFactory.decodeResource(getResources(),
                R.drawable.android_front_red, null);

        // 화면에 표시할 카드만큼 할당 (3x2)
        m_Shuffle = new Card[3][2];

        // 카드를 섞음
        setCardShuffle();
    } // constructor

    @Override
    public void onDraw(Canvas canvas) {
        // 3. 배경 이미지 그리기
        canvas.drawBitmap(m_BackGroundImage, 0, 0, null);
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 3; x++) {
                canvas.drawBitmap(m_CardBackSide, 35 + x * 90,
                        150 + y * 130, null);
            } // for x
        } // for y
    } // onDraw

    public void setCardShuffle() {
        // 각각의 색을 가진 카드들을 생성
        // 랜덤으로 해야 하지만 일단 단순히 고정된 값으로
        m_Shuffle[0][0] = new Card(Card.IMG_RED);
        m_Shuffle[0][1] = new Card(Card.IMG_BLUE);
        m_Shuffle[1][0] = new Card(Card.IMG_GREEN);
        m_Shuffle[1][1] = new Card(Card.IMG_GREEN);
        m_Shuffle[2][0] = new Card(Card.IMG_BLUE);
        m_Shuffle[2][1] = new Card(Card.IMG_RED);
    }
} // CardGameView Class
