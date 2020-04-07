package com.example.prova2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    private static boolean MODE = false; //se MODE = false -> verticale || altrimenti orizzontale

    private EditText name;
    private EditText surname;
    private EditText cellphone;
    private static ListView list;

    private ContactAdapter contatti;

    private static ArrayList<String> dati = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        //Dimensione display, in pixel reali
        Point size = new Point();
        display.getSize(size);
        int screenw_px = size.x;
        int screenh_px = size.y;
        //Densità
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float screen_density = metrics.density;
        //Dimensioni in dip
        int screenw_dp = (int) (screenw_px / screen_density);
        int screenh_dp = (int) (screenh_px / screen_density);
        //Dimensioni in cm
        float screenw_cm = 2.54f * screenw_dp / 160;
        float screenh_cm = 2.54f * screenh_dp / 160;

        if (screenw_px < screenh_px)
            MODE = false;
        else
            MODE = true;

        if(!MODE)
            setContentView(R.layout.activity_main);
        else
            setContentView(R.layout.activity_main2);

        name = findViewById(R.id.nomeElemento);
        surname = findViewById(R.id.cognomeElemento);
        cellphone = findViewById(R.id.numeroTelefono);
        list = findViewById(R.id.contactList);

        contatti = new ContactAdapter(this, R.layout.list_element, new ArrayList<Contatto>());

        list.setAdapter(contatti);
        list.setOnItemClickListener(this);

        if (savedInstanceState != null) {
            dati = savedInstanceState.getStringArrayList("dati");
            for(int k = 0; k < dati.size(); k++){
                contatti.add(new Contatto(dati.get(k), dati.get(k), getResources().getDrawable(R.drawable.profilo)));
            }
        }
    }

    public void insertInList(View v) {
        String nome = name.getText() + " " + surname.getText().toString();
        String cell = cellphone.getText().toString();
        Contatto c = new Contatto(nome, cell, getResources().getDrawable(R.drawable.profilo));
        contatti.add(c);
        dati.add(nome);
        dati.add(cell);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        contatti.remove(contatti.getItem(position));
                        Toast.makeText(getApplicationContext(), "Elemento rimosso!", Toast.LENGTH_SHORT).show();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        Toast.makeText(getApplicationContext(), "Azione annullata", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Sei sicuro di voler cancellare questo contatto?")
                .setPositiveButton("Si", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putStringArrayList("dati", dati);
        super.onSaveInstanceState(savedInstanceState);
    }
}
