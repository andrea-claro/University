package com.example.debuggerapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private static String TAG = "myTAG";

    EditText numero1, numero2;
    TextView risultato;

    public static List<byte[]> list = new ArrayList<byte[]>();
    public static byte[] random_bytes = "1234567890qwertyuiopasdfghjklzxcvbnm".getBytes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate()");
        setContentView(R.layout.activity_main);
        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        risultato = findViewById(R.id.risultato);
    }

    public void somma(View v) {
        Log.d(TAG,"Executing somma");
        int num1 = 0, num2 = 0;
        String str1 = numero1.getText().toString();
        num1 = atoi(str1);
        String str2 = numero2.getText().toString();
        num2 = atoi(str2);
        int somma = num1 + num2;
        allocaMemoria();
        risultato.setText(somma + "");
    }

    int atoi(String str){
        Log.d(TAG,"Executing atoi on: "+str);
        //if (str == null || str.length()== 0) return 0;
        return Integer.parseInt(str);
    }

    public void allocaMemoria() {
        for (int i=0; i<1000000; i++) list.add(random_bytes);
        Log.d("DEBUG","list size = "+list.size());
    }
}
