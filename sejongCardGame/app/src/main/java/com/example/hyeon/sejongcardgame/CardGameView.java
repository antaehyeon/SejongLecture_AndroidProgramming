package com.example.hyeon.sejongcardgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
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

    // 1-1. 게임 상태 변수 추가
    public static final int STATE_READY = 0;
    public static final int STATE_GAME = 1;
    public static final int STATE_END = 2;
    private int m_State = STATE_READY;

    // 짝 맞추기 비교를 위한 변수
    private Card m_SelectedCard_1 = null;
    private Card m_SelectedCard_2 = null;

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

        // 짝맞추기를 검사하는 스레드 실행
        CardGameThread _thread = new CardGameThread(this);
        _thread.start();
    } // constructor

    @Override
    public void onDraw(Canvas canvas) {
        // 3. 배경 이미지 그리기
        canvas.drawBitmap(m_BackGroundImage, 0, 0, null);
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 3; x++) {
                canvas.drawBitmap(m_CardBackSide, 35 + x * 90,
                        150 + y * 130, null);

                // 색상 값에 따라 다른 이미지 그려주기
                if(m_Shuffle[x][y].m_Color == Card.IMG_RED)
                    canvas.drawBitmap(m_Card_Red, 35 + x * 90, 150 + y * 130, null);
                else if (m_Shuffle[x][y].m_Color == Card.IMG_GREEN)
                    canvas.drawBitmap(m_Card_Green, 35 + x * 90, 150 + y * 130, null);
                else if (m_Shuffle[x][y].m_Color == Card.IMG_RED)
                    canvas.drawBitmap(m_Card_Blue, 35 + x * 90, 150 + y * 130, null);

                // 카드 앞면을 그려야 하는 경우
                if(m_Shuffle[x][y].m_State == Card.CARD_SHOW ||
                    m_Shuffle[x][y].m_State == Card.CARD_PLAYEROPEN ||
                    m_Shuffle[x][y].m_State == Card.CARD_MATCHED) {
                    // 색상에 따라 카드 앞면 그리기
                } // if
                else { // 카드 뒷면을 그려야 하는 경우
                    canvas.drawBitmap(m_CardBackSide, 35 + x * 90,
                            150 + y * 130, null);
                } // else
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

    public void startGame() {
        m_Shuffle[0][0].m_State = Card.CARD_CLOSE;
        m_Shuffle[0][1].m_State = Card.CARD_CLOSE;
        m_Shuffle[1][0].m_State = Card.CARD_CLOSE;
        m_Shuffle[1][1].m_State = Card.CARD_CLOSE;
        m_Shuffle[2][0].m_State = Card.CARD_CLOSE;
        m_Shuffle[2][1].m_State = Card.CARD_CLOSE;

        invalidate(); // 화면을 갱신합니다.
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(m_State == STATE_READY) {
            startGame(); // 게임을 시작합니다.
            m_State = STATE_GAME;
        } else if (m_State == STATE_GAME) {
            // 카드 뒤집는 처리
            int px = (int)event.getX();
            int py = (int)event.getY();
            for (int y = 0; y < 2; y++) {
                for (int x = 0; x < 3; x++ ) {
                    // 각 카드의 박스 값을 생성
                    Rect box_card = new Rect(35 + x * 90, 150 + y * 130,
                            35 + x * 90 + 80, 150 + y * 130 + 115);
                    if (box_card.contains(px, py)) { // 선택된 카드 뒤집기
                        // (x, y)에 위치한 카드가 선택되었다.
                        if(m_Shuffle[x][y].m_State != Card.CARD_MATCHED) {
                            // 맞춘 카드는 뒤집을 필요가 없습니다.
                            if(m_SelectedCard_1 == null) { // 첫 카드를 뒤집는다면
                                m_SelectedCard_1 = m_Shuffle[x][y];
                                m_SelectedCard_1.m_State = Card.CARD_PLAYEROPEN;
                            } // if
                            else {
                               if (m_SelectedCard_1 != m_Shuffle[x][y]) { // 중복 뒤집기 방지
                                   m_SelectedCard_2 = m_Shuffle[x][y];
                                   m_SelectedCard_2.m_State = Card.CARD_PLAYEROPEN;
                               } // if
                            } // else
                        } // if
                    } // if box_card.contains(px, py)
                } // for x
            } // for y
        } else if (m_State == STATE_END) {
            m_State = STATE_READY;
        }
        invalidate(); // 화면을 갱신합니다.
        // return super.onTouchEvent(event);
        return true;
    } // onTouchEvent

    public void checkMatch() {
        // 두 카드 중 하나라도 선택이 안 되었다면 비교할 필요가 없습니다.
        if (m_SelectedCard_1 == null || m_SelectedCard_2 == null) return;
        // 두 카드의 색상을 비교합니다.
        if (m_SelectedCard_1.m_Color == m_SelectedCard_2.m_Color) {
            // 두 카드의 색상이 같으면 두 카드를 맞춘 상태로 바꿉니다
            m_SelectedCard_1.m_State = Card.CARD_MATCHED;
            m_SelectedCard_2.m_State = Card.CARD_MATCHED;
            // 다시 선택할 수 있도록 null로 설정
            m_SelectedCard_1 = null;
            m_SelectedCard_2 = null;
        } // if
        else {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { }
            // 두 카드의 색상이 다른 경우 두 카드를 이전처럼 뒷면으로 돌려줍니다
            m_SelectedCard_1.m_State = Card.CARD_CLOSE;
            m_SelectedCard_2.m_State = Card.CARD_CLOSE;
            // 다시 선택할 수 있도록 null로 설정
            m_SelectedCard_1 = null;
            m_SelectedCard_2 = null;
        } // else
        // invalidate(); // 스레드에서 사용하므로
        postInvalidate();
    } // checkMatch


} // CardGameView Class
