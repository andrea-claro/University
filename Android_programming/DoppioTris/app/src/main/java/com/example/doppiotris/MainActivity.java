package com.example.doppiotris;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Connector{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        replayButton = findViewById(R.id.replay);
        replayButton.setVisibility(View.INVISIBLE);
        this.turno = true;
        this.turni = 0;

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        int id = getResources().getIdentifier("FragmentX", "id", getPackageName());
        scacchieraX = new ScacchieraFragment("X");
        scacchieraX.setConnector(this);
        scacchieraX.setTurno(true);
        ft.add(id, scacchieraX, null);

        id = getResources().getIdentifier("FragmentO", "id", getPackageName());
        scacchieraO = new ScacchieraFragment("O");
        scacchieraO.setConnector(this);
        ft.add(id, scacchieraO, null);


        ft.commit();
    }

    @Override
    public void sendValue(int index,String simbolo) {
        this.turni++;
        scacchieraX.setTurno(!scacchieraX.getTurno());
        scacchieraX.setValue(index,simbolo);
        scacchieraO.setTurno(!scacchieraO.getTurno());
        scacchieraO.setValue(index,simbolo);

        this.turno = !this.turno;
        if(this.turno){
            textView.setText("Gioca il giocatore X");
        }else{
            textView.setText("Gioca il giocatore O");
        }


        if(turni == 9){
            textView.setText("Partita conclusa con parità" );
            textView.setTextColor(Color.RED);
            replayButton.setVisibility(View.VISIBLE);
            scacchieraX.setFinePartita(true);
            scacchieraO.setFinePartita(true);
        }

        boolean x = scacchieraX.verify() , o = scacchieraO.verify();

        if(x || o){
            textView.setText(x ? "Giocatore X vince!!" : "Giocatore O vince!!" );
            textView.setTextColor(Color.GREEN);
            replayButton.setVisibility(View.VISIBLE);
            scacchieraX.setFinePartita(true);
            scacchieraO.setFinePartita(true);
        }




    }
    public void replay(View v){


        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        Toast.makeText(getApplicationContext(), "Ok!", Toast.LENGTH_SHORT).show();
                        scacchieraO.restart();
                        scacchieraX.restart();
                        scacchieraX.setTurno(true);
                        scacchieraO.setTurno(false);
                        turno = true;
                        turni = 0;
                        textView.setText("Inizia il giocatore X");
                        textView.setTextColor(Color.BLACK);
                        replayButton.setVisibility(View.INVISIBLE);

                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        Toast.makeText(getApplicationContext(), "Azione annullata",Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Stai per ripartire da capo. Sei sicuro?")
                .setPositiveButton("Si", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();

    }




    private ScacchieraFragment scacchieraX;
    private ScacchieraFragment scacchieraO;
    private boolean turno;
    private TextView textView;
    private Button replayButton;
    private int turni;
}
