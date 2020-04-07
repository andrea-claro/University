package com.example.claroandrea;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.counterApp = findViewById(R.id.counterApp);
        this.counterPlayer = findViewById(R.id.counterPlayer);
        this.counter = findViewById(R.id.counter);
        this.appChoice = findViewById(R.id.app);
        this.playerChoice = findViewById(R.id.player);
        this.doppio = findViewById(R.id.doppioButton);
        this.sasso = findViewById(R.id.sasso);
        this.carta = findViewById(R.id.carta);
        this.forbici = findViewById(R.id.forbici);
        this.layout = findViewById(R.id.layoutBottoni);

        appChoice.setVisibility(View.INVISIBLE);
        playerChoice.setVisibility(View.INVISIBLE);

        ArrayList<View> bottoni = layout.getTouchables();
        for (View v : bottoni) {
            Button b = (Button) v;

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button button = (Button) v;

                    counter.setText( (Integer.parseInt(counter.getText().toString())+1)+"" );
                    sasso.setVisibility(View.INVISIBLE);
                    carta.setVisibility(View.INVISIBLE);
                    forbici.setVisibility(View.INVISIBLE);

                    SassoCartaForbici.Scelta application = null;
                    SassoCartaForbici.Scelta player = null;

                    if(button.getId() == R.id.sasso)
                        player = SassoCartaForbici.Scelta.SASSO;
                    else if (button.getId() == R.id.forbici)
                        player = SassoCartaForbici.Scelta.FORBICI;
                    else if (button.getId() == R.id.carta)
                        player = SassoCartaForbici.Scelta.CARTA;

                    int n = generator.nextInt(3);

                    switch (n) {
                        case 0:
                            application = SassoCartaForbici.Scelta.SASSO;
                            break;

                        case 1:
                            application = SassoCartaForbici.Scelta.CARTA;
                            break;

                        case 2:
                            application = SassoCartaForbici.Scelta.FORBICI;
                            break;

                        default:
                            break;
                    }

                    gioco.setPlayer(player);
                    gioco.setApplication(application);

                    Log.e("gioco",gioco.getApplication()+"  "+gioco.getPlayer());

                    settingChoice(gioco.getApplication(), appChoice);
                    settingChoice(gioco.getPlayer(), playerChoice);



                    appChoice.setVisibility(View.VISIBLE);
                    playerChoice.setVisibility(View.VISIBLE);

                    // a causa di un problema di sincronizzazione delle immagini non riesco a fare in modo
                    // che compaiano ed appaiano in sincronia ad ogni click del bottone di gioco
                    // quindi per il corretto funzionamento dell'applicazione, quando si gioca,
                    // verrà visualizzando la puntata sopra il le alternative possibili
//                    try {
//                        Thread.sleep(1500);
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    new Handler().postDelayed(new Runnable() { // permette di esegure un tread dopo il delay.
                        @Override
                        public void run() {
                            sasso.setVisibility(View.VISIBLE);
                            carta.setVisibility(View.VISIBLE);
                            forbici.setVisibility(View.VISIBLE);

                            appChoice.setVisibility(View.INVISIBLE);
                            playerChoice.setVisibility(View.INVISIBLE);
                        }
                    },1000);



                    int winner = gioco.verify();
                    if(!MODE){
                        if (winner == 1)
                            counterPlayer.setText((Integer.parseInt(counterPlayer.getText().toString()) + 1) + "");
                        else if(winner == 0)
                            counterApp.setText((Integer.parseInt(counterApp.getText().toString()) + 1) + "");
                        else
                            return;
                    } else {
                        if (winner == 1)
                            counterPlayer.setText((Integer.parseInt(counterPlayer.getText().toString()) + 2) + "");
                        else if(winner == 0)
                            counterApp.setText((Integer.parseInt(counterApp.getText().toString()) + 2) + "");
                        else
                            return;
                    }

//                    sasso.setVisibility(View.VISIBLE);
//                    carta.setVisibility(View.VISIBLE);
//                    forbici.setVisibility(View.VISIBLE);
                }
            });
        }
    }

    private void settingChoice(SassoCartaForbici.Scelta scelta, TextView tx){

        if(scelta == SassoCartaForbici.Scelta.SASSO)
            tx.setBackgroundResource(R.drawable.sasso);
        else if(scelta == SassoCartaForbici.Scelta.CARTA)
            tx.setBackgroundResource(R.drawable.carta);
        else if(scelta == SassoCartaForbici.Scelta.FORBICI)
            tx.setBackgroundResource(R.drawable.forbici);
    }

    public void doppioHandler(View v) {
        if(this.MODE){
            this.MODE = false;
            this.doppio.setText("doppio");

        }
        else{
            this.MODE = true;
            this.doppio.setText("normale");
        }

        Toast.makeText(getApplicationContext(), "Modalità cambiata", Toast.LENGTH_LONG).show();
    }

    public void restartHandler(View v){

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {

                    case DialogInterface.BUTTON_POSITIVE:
                        counter.setText(0+"");
                        counterApp.setText(0+"");
                        counterPlayer.setText(0+"");
                        appChoice.setVisibility(View.INVISIBLE);
                        playerChoice.setVisibility(View.INVISIBLE);
                        Toast.makeText(getApplicationContext(), "Partita ricominciata!", Toast.LENGTH_SHORT).show();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        Toast.makeText(getApplicationContext(), "Azione annullata", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Sei sicuro di voler ricominciare?")
                .setPositiveButton("Si", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }

    private static SassoCartaForbici gioco = new SassoCartaForbici();
    private static Random generator = new Random(); // se 0 -> sasso || se 1 -> carta || se 2 -> forbici
    private static boolean MODE = false; // se false -> modalità 1 punto || se true -> modalità doppia

    private RelativeLayout layout;
    private TextView counterApp;
    private TextView counterPlayer;
    private TextView counter;
    private TextView appChoice;
    private TextView playerChoice;
    private Button doppio;
    private Button sasso;
    private Button carta;
    private Button forbici;
}
