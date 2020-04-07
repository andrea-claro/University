package com.example.prova6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = findViewById(R.id.numero);
        grid = findViewById(R.id.grid);
        timer = findViewById(R.id.time);

        generator = new Random();

        int n = generator.nextInt(10);
        while (n == 0)
            n = generator.nextInt(10);

        numero.setText(n + "");

        ArrayList<View> buttons = grid.getTouchables();


        for (View v : buttons) {
            Button b = (Button) v;

            b.setOnClickListener(new Button.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Button b = (Button) v;

                    if (b.getText().toString().equals(numero.getText().toString())) {
                        int n = Integer.parseInt(numero.getText().toString()) + 1;

                        if (n == 10) {
                            Intent i = new Intent(getApplicationContext(), EndActivity.class);
                            i.putExtra("tempo", timer.getText().toString());
                            startActivity(i);
                        }

                        numero.setText(n + "");
                    } else {
                        int n = Integer.parseInt(timer.getText().toString()) + 1;
                        timer.setText(n + "");
                    }
                }
            });

            while (n == 0)
                n = generator.nextInt(10);

            while (tabella.contains(n))
                n = generator.nextInt(10);

            b.setText(n + "");
            tabella.add(n);
        }

        MainActivity.TimerTask timerTask = (TimerTask) new TimerTask().execute();
    }

    private class TimerTask extends AsyncTask<Void, Long, Long> {

        @Override
        protected Long doInBackground(Void... voids) {
            int k = 0;
            try {
                while (true) {
                    Thread.sleep(1000);
                    k++;
                    publishProgress((long) k);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1L;
        }

        @Override
        protected void onProgressUpdate(Long... longs) {
            super.onProgressUpdate(longs);

            timer.setText(longs[0] + "");
        }

        @Override
        protected void onPostExecute(Long result) {
            super.onPostExecute(result);
        }
    }


    private Random generator;
    private static ArrayList<Integer> tabella = new ArrayList<>();

    private TextView timer;
    private TextView numero;
    private GridLayout grid;

}
