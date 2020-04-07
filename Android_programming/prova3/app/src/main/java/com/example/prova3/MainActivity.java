package com.example.prova3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView totale;

    private int primo;
    private int secondo;
    private int contorno;
    private int frutta;
    private int tot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totale = findViewById(R.id.totale);

        primo = 0;
        secondo = 0;
        contorno = 0;
        frutta = 0;
        tot = 0;

        totale.setText("Totale: €" + tot);
    }

    public void checked(View v) {
        RadioButton b = (RadioButton) v;

        RadioGroup group = (RadioGroup) b.getParent();

        switch (group.getId()) {

            case R.id.primo:
                switch (b.getId()) {
                    case R.id.radio1:
                        primo = 3;
                        break;

                    case R.id.radio2:
                        primo = 5;
                        break;

                    case R.id.radio3:
                        primo = 7;
                        break;
                }
                break;


            case R.id.secondo:
                switch (b.getId()) {
                    case R.id.radio1:
                        secondo = 3;
                        break;

                    case R.id.radio2:
                        secondo = 5;
                        break;

                    case R.id.radio3:
                        secondo = 7;
                        break;
                }
                break;


            case R.id.contorno:
                switch (b.getId()) {
                    case R.id.radio1:
                        contorno = 3;
                        break;

                    case R.id.radio2:
                        contorno = 5;
                        break;

                    case R.id.radio3:
                        contorno = 7;
                        break;
                }
                break;


            case R.id.frutta:
                switch (b.getId()) {
                    case R.id.radio1:
                        frutta = 3;
                        break;

                    case R.id.radio2:
                        frutta = 5;
                        break;

                    case R.id.radio3:
                        frutta = 7;
                        break;
                }
                break;

            default:
                break;
        }

        tot = primo + secondo + contorno + frutta;
        totale.setText("Totale: €" + tot);
    }

    public void toCart(View v) {
        Intent i = new Intent(getApplicationContext(), SecondActivity.class);
        i.putExtra("totale", tot);
        i.putExtra("primo", primo);
        i.putExtra("secondo", secondo);
        i.putExtra("contorno", contorno);
        i.putExtra("frutta", frutta);
        startActivity(i);
    }
}
