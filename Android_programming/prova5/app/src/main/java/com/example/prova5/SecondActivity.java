package com.example.prova5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        HashMap<String, Float> tabella = (HashMap<String, Float>) intent.getSerializableExtra("tabella");

        int k = 1;

        for (Map.Entry<String, Float> entry : tabella.entrySet()) {
            String key = entry.getKey();
            float value = entry.getValue();

            RelativeLayout layout = new RelativeLayout(this);
            RelativeLayout.LayoutParams Lparams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            layout.setLayoutParams(Lparams);

            TextView txt = new TextView(this);
            txt.setTextSize(150);
            txt.setText(k + ". " + key + "€" + value);

            layout.addView(txt);
        }
        TextView totale = (TextView) findViewById(R.id.totale);
        totale.setText("€ " + tabella.get("totale"));

    }
}
