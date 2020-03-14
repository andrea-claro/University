package com.example.luglio2015;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RelativeLayout box;
    Circle circle;
    private float currentX;
    private float currentY;
    private float maxWidth;
    private float maxHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        box = findViewById(R.id.layoutPalla);
        currentX = box.getX()+20;
        currentY = box.getY()+20;
        circle = new Circle(this, currentX, currentY);
        box.addView(circle);

    }

    public void onClickRightButton(View v){
        maxWidth = box.getWidth();
        maxHeight = box.getHeight();
        box.removeAllViews();
        if (currentX + 20 < maxWidth){
            currentX += 20;
            circle = new Circle(this, currentX, currentY);
            box.addView(circle);
        }
        else {
            circle = new Circle(this, currentX, currentY);
            box.addView(circle);
            Toast.makeText(getApplicationContext(), "Non posso andare oltre", Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickUpButton(View v){
        maxWidth = box.getWidth();
        maxHeight = box.getHeight();
        box.removeAllViews();
        if (currentY - 20 > 0){
            currentY -= 20;
            circle = new Circle(this, currentX, currentY);
            box.addView(circle);
        }
        else {
            circle = new Circle(this, currentX, currentY);
            box.addView(circle);
            Toast.makeText(getApplicationContext(), "Non posso andare oltre", Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickLeftButton(View v){
        maxWidth = box.getWidth();
        maxHeight = box.getHeight();
        box.removeAllViews();
        if (currentX - 20 > 0){
            currentX -= 20;
            circle = new Circle(this, currentX, currentY);
            box.addView(circle);
        }
        else {
            circle = new Circle(this, currentX, currentY);
            box.addView(circle);
            Toast.makeText(getApplicationContext(), "Non posso andare oltre", Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickCenterButton(View v){
        maxWidth = box.getWidth();
        maxHeight = box.getHeight();
        currentX = maxWidth/2;
        currentY = maxHeight/2;
        box.removeAllViews();
        circle = new Circle(this, currentX, currentY);
        box.addView(circle);
    }
    public void onClickDownButton(View v){
        maxWidth = box.getWidth();
        maxHeight = box.getHeight();
        box.removeAllViews();
        if (currentY + 20 < maxHeight){
            currentY += 20;
            circle = new Circle(this, currentX, currentY);
            box.addView(circle);
        }
        else {
            circle = new Circle(this, currentX, currentY);
            box.addView(circle);
            Toast.makeText(getApplicationContext(), "Non posso andare oltre", Toast.LENGTH_SHORT).show();
        }
    }
}
