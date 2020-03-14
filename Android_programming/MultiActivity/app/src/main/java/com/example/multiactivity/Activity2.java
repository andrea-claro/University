package com.example.multiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Activity2 extends Activity {
    public static final int REQUEST= 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
    }

    public void lanciaActivity(View v) {
        Intent i = new Intent(getApplicationContext(),Activity3.class);
        i.putExtra("INT", 20);
        i.setFlags(i.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivityForResult(i, REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST && resultCode == RESULT_OK) {
            Button b = findViewById(R.id.button);
            b.setText(data.getStringExtra("NUMERO"));
        }
    }
}
