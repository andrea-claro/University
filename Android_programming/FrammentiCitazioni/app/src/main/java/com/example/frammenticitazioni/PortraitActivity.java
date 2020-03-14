package com.example.frammenticitazioni;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PortraitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portrait_activity);

        Intent i = getIntent();
        int index = i.getIntExtra("index", 0);

        FragmentCitazioni fc = (FragmentCitazioni)
                getFragmentManager().findFragmentById(R.id.fragmentCitazioni);

        if (fc != null) {
            fc.mostraCitazione(index);
        }
    }

}
