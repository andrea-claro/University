package com.example.framecerchio;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.cerchioWidget = new CerchioWidget(getApplicationContext(),30);

        container = findViewById(R.id.container);
        cerchioWidget.setColor(Color.GRAY);
        container.addView(cerchioWidget);

    }

    public void moveHandler(View view) {

        Button button = (Button) view;
        String value = (String) button.getText();
        int maxWidth = container.getWidth();
        int maxHeight = container.getHeight();

        if(value.equals("right") && cerchioWidget.getX() + cerchioWidget.getRadius()  + 30 < maxWidth)
            cerchioWidget.setX(cerchioWidget.getX()+30);

        else if(value.equals("left") && cerchioWidget.getX() - cerchioWidget.getRadius() - 30 > 0)
            cerchioWidget.setX(cerchioWidget.getX()-30);

        else if(value.equals("center")){
            cerchioWidget.setX( cerchioWidget.getWidth()/2 );
            cerchioWidget.setY( cerchioWidget.getHeight()/2 );
        }

        else if(value.equals("up") && cerchioWidget.getY() - cerchioWidget.getRadius()-30 > 0)
            cerchioWidget.setY(cerchioWidget.getY()-30);

        else if(value.equals("down") && cerchioWidget.getY() + cerchioWidget.getRadius() +30 < maxHeight)
            cerchioWidget.setY(cerchioWidget.getY()+30);


        cerchioWidget.reDraw();


    }

    private CerchioWidget cerchioWidget;
    private RelativeLayout container;
}
