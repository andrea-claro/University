package com.example.prova1;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class Tris extends Fragment implements View.OnClickListener {

    private boolean turno = false;

    private static String[][] tris = {
            {"", "", ""},
            {"", "", ""},
            {"", "", ""}
    };
    private String simbolo;

    private static Connector connector;

    private ArrayList<View> allButtons;

    public Tris() {

    }

    public Tris(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tris, container, false);
        allButtons = (v.findViewById(R.id.tris)).getTouchables();

        int k = 0, j = 0;
        for (View element : allButtons) {
            Button b = (Button) element;

            b.setOnClickListener(this);
            b.setTag(k + "+" + j);

            if (j == 2) {
                k++;
                j = 0;
                continue;
            }
            j++;
        }
        return v;
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        String tag = (String) b.getTag();
        String[] indexes = tag.split("\\+");
        int k = Integer.parseInt(indexes[0]);
        int j = Integer.parseInt(indexes[1]);

        if (turno && tris[k][j] == "") {
            b.setText(simbolo);
            b.setClickable(false);

            tris[k][j] = simbolo;
            connector.sendValue(k, j, simbolo);

            turno = false;
        }
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    public void setValue(int k, int j, String simbolo) {
        for (View element : allButtons) {
            Button b = (Button) element;
            if (b.getTag().equals(k + "+" + j)) {
                b.setClickable(false);
                b.setText(simbolo);
            }
        }
    }

    public void restart() {
        turno = false;
        for (int k = 0; k < 3; k++) {
            for (int j = 0; j < 3; j++)
                tris[k][j] = "";
        }
        for (View element : allButtons) {
            Button b = (Button) element;
            b.setClickable(true);
            b.setText("");
        }
    }

    public boolean verify(){
        int count = 0;

        if(tris[1][1].equals(simbolo)){
            if(tris[0][0].equals(simbolo)  &&  tris[2][2].equals(simbolo)  ||  tris[0][2].equals(simbolo)  &&  tris[2][0].equals(simbolo))
                return true;
        }

        for(int k = 0; k < 3; k++){
            for(int j = 0; j < 3; j++){
                if(tris[k][j].equals(simbolo)){
                    count++;
                    if(count == 3)
                        return true;
                }
                else
                    count = 0;

            }
        }

        count = 0;

        for(int k = 0; k < 3; k++){
            for(int j = 0; j < 3; j++){
                if(tris[j][k].equals(simbolo)){
                    count++;
                    if(count == 3)
                        return true;
                }
                else
                    count = 0;
            }
        }

        return false;
    }
}
