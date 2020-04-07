package com.example.prova4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static Random generator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clicked(View v) {
        Button b = (Button) v;

        if (b.getTag() == null || b.getTag().equals("0")) {
            int n = generator.nextInt(10);

            b.setText(n + "");
            b.setTag(n + "");
        } else {
            int n = Integer.parseInt(b.getTag().toString());

            View layout = (GridLayout) b.getParent();
            ArrayList<View> buttons = layout.getTouchables();

            int s = 0;

            for (View view : buttons) {
                Button button = (Button) view;

                if(button.getTag() != null)
                    s = (Integer.parseInt(button.getTag().toString()) + n) % 10;

                button.setTag(s + "");
                button.setText(s + "");
            }
        }
    }

    public void azzeramento(View v) {
        Button b = (Button) v;

        View layout = (RelativeLayout) b.getParent();
        ArrayList<View> buttons = layout.getTouchables();

        for (View view : buttons) {
            if(view == v)
                continue;
            Button button = (Button) view;
            button.setText(0 + "");
            button.setTag(0 + "");
        }
    }
}
