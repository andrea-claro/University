package com.example.frammenticitazioni;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragmentAutori.Communicator {

    FragmentAutori fragmentAutori;
    FragmentCitazioni fragmentCitazioni;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getFragmentManager();

        fragmentAutori = (FragmentAutori) fm.findFragmentById(R.id.fragmentAutori);
        fragmentAutori.setCommunicator(this);
    }

    @Override
    public void respond(int index) {
        fragmentCitazioni = (FragmentCitazioni) fm.findFragmentById(R.id.fragmentCitazioni);

        Intent i = new Intent(this, PortraitActivity.class);
        i.putExtra("index",index);
        startActivity(i);
    }
}
