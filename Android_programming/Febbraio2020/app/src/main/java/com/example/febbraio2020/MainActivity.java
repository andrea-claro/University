package com.example.febbraio2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.scacchiera = new HashMap<Integer, ArrayList>();
        this.contaMosse = findViewById(R.id.contatoreMosse);
        this.valoreAddizionale = findViewById(R.id.valoreMotiplicante);

        this.game = new Game(new int[][]{
                {3,2,6},
                {1,3,1},
                {5,6,8},
        });



        this.buttons = findViewById(R.id.scacchiera).getTouchables();

        for(int i = 0, c = 0, r = 0; i < buttons.size(); i++, c++){

            Button b = (Button) buttons.get(i);
            b.setOnClickListener(this);
            b.setTag(i);

            if(c % SIZE_SCACCHIERA == 0 && c != 0){
                c = 0;
                r += 1;
            }

            ArrayList<Integer> position = new ArrayList<Integer>();
            position.add(r);
            position.add(c);

            scacchiera.put(i,position);

        }

        updateView();
    }

    private void updateView() {

        this.contaMosse.setText(this.game.getContaMosse() + "");

        for(View v : this.buttons){
            Button b = (Button) v;
            int index = (Integer) b.getTag();

            ArrayList<Integer> position = scacchiera.get(index);
            int r = position.get(0);
            int c = position.get(1);

            b.setText(this.game.getValue(r,c)+"");

            if(this.game.isWin())
                Toast.makeText(getApplicationContext(), "Hai vinto!!", Toast.LENGTH_SHORT).show();
        }

    }

    public void azzeraHandler(View view) {
        this.game.azzera();
        updateView();
    }

    @Override
    public void onClick(View v) {

        Button b = (Button) v;
        int index = (Integer) b.getTag();

        int valore;

        try{
            valore = Integer.parseInt(this.valoreAddizionale.getText().toString());
        }catch (Exception e){
            valore = 0;
        }

        this.game.setValoreIncrementate(valore);

        ArrayList<Integer> position = scacchiera.get(index);
        int r = position.get(0);
        int c = position.get(1);

        this.game.doMossa(r,c);

        updateView();

    }



    public static int SIZE_SCACCHIERA = 3;
    private ArrayList<View> buttons;
    private HashMap<Integer,ArrayList> scacchiera;
    private TextView contaMosse;
    private EditText valoreAddizionale;
    private Game game;


}
