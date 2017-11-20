package com.example.hyeon.sejongcardgame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by hyeon on 2017. 11. 21..
 */

public class TouchEventExampleView extends View {

    int m_x, m_y;

    public TouchEventExampleView(Context context) {
        super(context);
    } // Constructor

    @Override
    protected void onDraw(Canvas canvas) {

    } // onDraw

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 좌표를 얻어옵니다
        m_x = (int) event.getX();
        m_y = (int) event.getY();

        // 기타 액션 이벤트
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

        }

        invalidate(); // 화면을 갱신합니다
        //return super.onTouchEvent(event);
        // ACTION_MOVE나 ACTION_UP의 액션 이벤트 처리를 위해서는
        // TRUE를 반환해야 합니다
        return true;
    } // onTouchEvent
}
