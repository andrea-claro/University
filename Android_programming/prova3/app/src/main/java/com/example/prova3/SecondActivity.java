package com.example.prova3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent i = getIntent();

        TextView totale = (TextView)findViewById(R.id.totale);
        totale.setText("Totale pasto: €"+i.getIntExtra("totale", 0));

        TextView primo = (TextView)findViewById(R.id.primo);
        primo.setText("Primo: €"+i.getIntExtra("primo", 0));

        TextView secondo = (TextView)findViewById(R.id.secondo);
        secondo.setText("Secondo: €"+i.getIntExtra("secondo", 0));

        TextView contorno = (TextView)findViewById(R.id.contorno);
        contorno.setText("Contorno: €"+i.getIntExtra("contorno", 0));

        TextView frutta = (TextView)findViewById(R.id.frutta);
        frutta.setText("Frutta: €"+i.getIntExtra("frutta", 0));
    }
}
