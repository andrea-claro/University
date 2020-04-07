package com.example.prova1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements Connector{

    private static final int NUM_TRIS = 2; //numero di fragment

    private static Random generator = new Random(); // generatore random per avvio partita
                                                    // se false -> turno X || se true -> turno O
    private static int turni = 0;
    private static final int MAX_TURNI = 9; //numero massimo di turni prima di finire la partita
                                            //automaticamente anche senza aver avuto un vincitore
    private static boolean avviato = false; //flag per testo pulsante centrale

    private static TextView textX;
    private static TextView textO;
    private static Button replay;
    private static FrameLayout trisX;
    private static FrameLayout trisO;

    private static Tris tX;
    private static Tris tO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replay = findViewById(R.id.restart);
        replay.setText("Start");

        trisX = findViewById(R.id.trisX);
        trisX.setVisibility(View.INVISIBLE);

        trisO = findViewById(R.id.trisO);
        trisO.setVisibility(View.INVISIBLE);

        textX = findViewById(R.id.textX);
        textO = findViewById(R.id.textO);


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        tX = new Tris("X");
        tX.setConnector(this);
        int id = getResources().getIdentifier("trisX", "id", getPackageName());
        ft.add(id, tX, null);

        tO = new Tris("O");
        id = getResources().getIdentifier("trisO", "id", getPackageName());
        ft.add(id, tO, null);

        ft.commit();
    }


    protected boolean checkTurni(int n) {
        if (n == MAX_TURNI) {
            Toast.makeText(getApplicationContext(), "The match is finished!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    private void start(){
        textX.setVisibility(View.VISIBLE);
        textO.setVisibility(View.VISIBLE);

        if (generator.nextBoolean()) {
            textX.setVisibility(View.INVISIBLE);
            tO.setTurno(true);
        }

        else {
            textO.setVisibility(View.INVISIBLE);
            tX.setTurno(true);
        }
    }

    public void restart(View view) {
        if (!avviato) {
            avviato = true;
            replay.setText("Restart");
            trisX.setVisibility(View.VISIBLE);
            trisO.setVisibility(View.VISIBLE);
            this.start();
        }
        else{
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            Toast.makeText(getApplicationContext(), "Restart!", Toast.LENGTH_SHORT).show();
                            tO.restart();
                            tX.restart();
                            start();
                            turni = 0;
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            Toast.makeText(getApplicationContext(), "Go on!",Toast.LENGTH_LONG).show();
                            break;
                    }
                }
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You're starting again. Are you sure?")
                    .setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show();
        }
    }

    @Override
    public void sendValue(int k, int j, String simbolo) {
        this.turni++;
        if(tX.verify()){
            Toast.makeText(getApplicationContext(), "Player X wins!",Toast.LENGTH_LONG).show();
            replay.performClick();
        }
        else if(tO.verify()){
            Toast.makeText(getApplicationContext(), "Player O wins!",Toast.LENGTH_LONG).show();
            replay.performClick();
        }
        else if(checkTurni(this.turni))
            replay.performClick();
        else{
            if(simbolo == "X"){
                textX.setVisibility(View.INVISIBLE);
                textO.setVisibility(View.VISIBLE);

                tO.setValue(k, j, simbolo);
                tO.setTurno(true);
            }
            else{
                textO.setVisibility(View.INVISIBLE);
                textX.setVisibility(View.VISIBLE);

                tX.setValue(k, j, simbolo);
                tX.setTurno(true);
            }
        }
    }
}
