package com.example.listacustomgg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView)findViewById(R.id.lista);
        nome = (EditText) findViewById(R.id.nome);
        cognome = (EditText) findViewById(R.id.cognome);
        telefono = (EditText) findViewById(R.id.telefono);

        customAdapter =
                new CustomAdapter(this, R.layout.list_element, new ArrayList<Contatto>());

        listView.setAdapter(customAdapter);


        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {


        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        customAdapter.remove(customAdapter.getItem(position));
                        Toast.makeText(getApplicationContext(), "Elemento rimosso!", Toast.LENGTH_SHORT).show();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        Toast.makeText(getApplicationContext(), "Azione annullata",Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Sei sicuro di voler cancellare questo contatto?")
                .setPositiveButton("Si", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }


    public void inserisciHendler(View view) {


        Contatto c = new Contatto(nome.getText()+" "+cognome.getText(),telefono.getText().toString(),
                getResources().getDrawable(R.drawable.faceplaceholder));

        customAdapter.add(c);

    }







    private ListView listView;
    private EditText nome;
    private EditText cognome;
    private EditText telefono;
    private CustomAdapter customAdapter;

}
