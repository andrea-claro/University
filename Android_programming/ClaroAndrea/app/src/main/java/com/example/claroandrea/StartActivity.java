package com.example.claroandrea;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void startHandler(View v){
        Intent gioco = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(gioco);
    }
}
