package com.example.doppiotris;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ScacchieraFragment extends Fragment implements View.OnClickListener{

    public ScacchieraFragment(String simbolo) {
        this.simbolo = simbolo;
        this.turno = false;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.scacchiera_fragment,container,false);
        ArrayList<View> buttons = v.findViewById(R.id.scacchiera).getTouchables();


        for(int i = 0 ; i < buttons.size(); i++){

            Button b = (Button) buttons.get(i);
            b.setOnClickListener(this);
            b.setTag(i);
            scacchiera.put(i,b);

        }

        return v;
    }

    @Override
    public void onClick(View v) {

        Button b = (Button) v;
        int index = (Integer) b.getTag();

        if(!this.turno || this.result[index] || this.finePartita){
            return ;
        }

        this.result[index] = true;
        this.setValue(index,this.simbolo);
        connector.sendValue(index,this.simbolo);

    }

    public void setValue(int index,String simbolo){

        Button b = scacchiera.get(index);

        b.setClickable(false);
        b.setText(simbolo);

    }

    public void restart(){
        this.result = new boolean[9];
        ArrayList<Button> buttons = new ArrayList<Button>(this.scacchiera.values());
        for(Button e : buttons){
            e.setText("");
            e.setClickable(true);
        }

        this.finePartita = false;

    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    public void setTurno(boolean turno){
        this.turno = turno;
    }

    public boolean getTurno(){
        return this.turno;
    }

    public boolean isFinePartita() {
        return finePartita;
    }

    public void setFinePartita(boolean finePartita) {
        this.finePartita = finePartita;
    }

    public boolean verify(){

        // verifico le colonne

        int count  = 0 ;

        for(int y = 0 ; y < 3 ; y++)
            for(int i = y, iter = 0; iter < 3; i+=3,iter++){

                if(result[i]){
                    count++;
                    if(count == 3)
                        return true;
                    }

                else{
                    count = 0;
                    break;
                }


            }


        count = 0;
        //verifico le righe
        for(int i = 0; i < result.length ; i++){

            if(i % 3 == 0){
                count = 0;
            }

            if(result[i]){
                count++;
                if(count == 3)
                    return true;
            }
            else
                count = 0;


        }

        //verifico diagonali

        if(result[4]){
            if(result[2] && result[6] || result[0] && result[8])
                return true;
        }

        return false;

    }



    private String simbolo;
    private boolean turno;
    private Connector connector;
    private boolean finePartita;
    private HashMap<Integer, Button> scacchiera = new HashMap<Integer, Button>();
    private boolean[] result =new boolean[9];

}

interface Connector {
    void sendValue(int index,String simbolo);
}
