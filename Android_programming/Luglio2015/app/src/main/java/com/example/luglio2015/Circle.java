package com.example.luglio2015;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Circle extends View {

    private float x;
    private float y;

    private Paint paint;
    public Circle(Context context, float x, float y) {
        super(context);
        this.x = x;
        this.y = y;
        paint = new Paint();
        paint.setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(x,y, 20, paint);
    }
}
