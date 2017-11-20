package com.example.hyeon.sejongcardgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by hyeon on 2017. 11. 20..
 */

public class ImageView extends View {

    public ImageView(Context context) {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {
        Bitmap _android = BitmapFactory.decodeResource(getResources(),
                R.drawable.android);
        canvas.drawBitmap(_android, 0, 0, null);
    }
}
