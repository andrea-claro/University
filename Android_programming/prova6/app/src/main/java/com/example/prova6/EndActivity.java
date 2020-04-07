package com.example.prova6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Intent i = getIntent();
        TextView tempo = findViewById(R.id.tempo);

        String time = i.getStringExtra("tempo");
        tempo.setText(time);
    }

    public void startingGame(View v) {
        Intent i = new Intent(getApplicationContext(), StartActivity.class);
        startActivity(i);
    }
}
