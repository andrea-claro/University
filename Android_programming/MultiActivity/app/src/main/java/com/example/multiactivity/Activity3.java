package com.example.multiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Activity3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        TextView t = findViewById(R.id.textView);
        Intent i = getIntent();
        int a = i.getIntExtra("INT", 0);
        t.setText(""+a);
    }

    public void lanciaActivity(View v) {
        //Intent i = new Intent(getApplicationContext(),MainActivity.class);
        //startActivity(i);
        Intent i = new Intent();
        i.putExtra("NUMERO", "10");
        setResult(RESULT_OK, i);
        finish();
    }
}
