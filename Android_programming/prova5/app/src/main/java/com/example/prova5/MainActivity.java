package com.example.prova5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.totale = findViewById(R.id.totale);

        this.pizza = (float) 5.3;
        this.pasta = (float) 7.8;
        this.carne = (float) 12;
        this.insalata = (float) 4;
        this.acqua = (float) 1.5;
        this.vino = (float) 2.5;
        this.gelato = (float) 1.8;
        this.caffe = (float) 0.9;
        this.amaro = (float) 3;

        this.tot = 0;

        this.tabella = new HashMap<>();

        this.intent = new Intent(getApplicationContext(), SecondActivity.class);
    }

    private void updateTot() {
        this.totale.setText("ToT: € " + this.tot);
        this.tabella.put("totale", this.tot);
    }

    public void onCheckHandler(View v) {
        CheckBox check = (CheckBox) v;
        RelativeLayout layout = (RelativeLayout) check.getParent();

        if (check.isChecked()) {
            switch (layout.getId()) {

                case R.id.pizza:
                    this.tot += this.pizza;
                    this.tabella.put("pizza", this.pizza);
                    break;

                case R.id.pasta:
                    this.tot += this.pasta;
                    this.tabella.put("pasta", this.pasta);
                    break;

                case R.id.carne:
                    this.tot += this.carne;
                    this.tabella.put("carne", this.carne);
                    break;

                case R.id.insalata:
                    this.tot += this.insalata;
                    this.tabella.put("insalata", this.insalata);
                    break;

                case R.id.acqua:
                    this.tot += this.acqua;
                    this.tabella.put("acqua", this.acqua);
                    break;

                case R.id.vino:
                    this.tot += this.vino;
                    this.tabella.put("vino", this.vino);
                    break;

                case R.id.gelato:
                    this.tot += this.gelato;
                    this.tabella.put("gelato", this.gelato);
                    break;

                case R.id.caffe:
                    this.tot += this.caffe;
                    this.tabella.put("caffe", this.caffe);
                    break;

                case R.id.amaro:
                    this.tot += this.amaro;
                    this.tabella.put("amaro", this.amaro);
                    break;

                default:
                    break;
            }
        } else {
            switch (layout.getId()) {

                case R.id.pizza:
                    this.tot -= this.pizza;
                    this.tabella.remove("pizza");
                    break;

                case R.id.pasta:
                    this.tot -= this.pasta;
                    this.tabella.remove("pasta");
                    break;

                case R.id.carne:
                    this.tot -= this.carne;
                    this.tabella.remove("carne");
                    break;

                case R.id.insalata:
                    this.tot -= this.insalata;
                    this.tabella.remove("insalata");
                    break;

                case R.id.acqua:
                    this.tot -= this.acqua;
                    this.tabella.remove("acqua");
                    break;

                case R.id.vino:
                    this.tot -= this.vino;
                    this.tabella.remove("vino");
                    break;

                case R.id.gelato:
                    this.tot -= this.gelato;
                    this.tabella.remove("gelato");
                    break;

                case R.id.caffe:
                    this.tot -= this.caffe;
                    this.tabella.remove("caffe");
                    break;

                case R.id.amaro:
                    this.tot -= this.amaro;
                    this.tabella.remove("amaro");
                    break;

                default:
                    break;
            }
        }
        this.updateTot();
        this.intent.putExtra("tabella", this.tabella);
    }

    public void onButtonHandler(View v) {
        startActivity(intent);
    }

    private float pizza;
    private float pasta;
    private float carne;
    private float insalata;
    private float acqua;
    private float vino;
    private float gelato;
    private float caffe;
    private float amaro;

    private float tot;

    private HashMap<String, Float> tabella;

    private Button totale;

    private Intent intent;
}
