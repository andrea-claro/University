package com.example.framecerchio;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class CerchioWidget extends View {
    private double radius;
    private int color = Color.BLUE;
    private float x = 0;
    private float y = 0;

    public CerchioWidget(Context context){ super(context);}

    public double getRadius() {
        return radius;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x ;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y ;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public CerchioWidget(Context context,double radius) {
        super(context);
        this.radius = radius;
        this.x = (float) radius;
        this.y = (float) radius;
    }


    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.color);

        Log.d("DEBUG","onDraw, canvas.h="+canvas.getHeight()+"  w="+canvas.getWidth());
        canvas.drawCircle(this.x, this.y,(float) this.radius, paint);
    }

    protected void reDraw(){
        this.invalidate();
    }

}
