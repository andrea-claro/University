package com.example.multiactivity;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lanciaActivity(View v) {
        Intent i = new Intent(getApplicationContext(),Activity1.class);
        startActivity(i);
    }
}
