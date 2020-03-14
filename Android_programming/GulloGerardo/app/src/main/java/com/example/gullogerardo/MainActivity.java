package com.example.gullogerardo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animation =  AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fire_effect);
        cannoneFoto = findViewById(R.id.cannone);
        fireButton = findViewById(R.id.fireButton);

        radioGroup = findViewById(R.id.radioGroup);

        cannone = new CannoneGame();

        basso = findViewById(R.id.textBasso);
        medio = findViewById(R.id.textMedio);
        alto = findViewById(R.id.textAlto);


    }

    public void fireHandler(View view) {

        if(radioGroup.getCheckedRadioButtonId() == -1){
            Toast.makeText(getApplicationContext(),"Seleziona una direzione prima",Toast.LENGTH_SHORT).show();
            return ;
        }


        cannoneFoto.startAnimation(animation);
        fireButton.setImageResource(R.drawable.bang);
        fireButton.setEnabled(false);

        //aspetto l'animazione.

        new Handler().postDelayed(new Runnable() { // permette di esegure un tread dopo il delay.

            @Override
            public void run() {
                fireButton.setEnabled(true); //ad animazione finita rendo ricliccabile il bottone.
                fireButton.setImageResource(R.drawable.fire);

            }
        },2000);

        String value = this.cannone.getDirezione();

        if(value.equals("Basso"))
            this.cannone.setBassoCount(this.cannone.getBassoCount() + 1);

        else if(value.equals("Medio"))
            this.cannone.setMedioCount(this.cannone.getMedioCount() + 1);

        else if(value.equals("Alto"))
            this.cannone.setAltoCount(this.cannone.getAltoCount() + 1);

        this.basso.setText(this.cannone.getBassoCount()+"");
        this.medio.setText(this.cannone.getMedioCount()+"");
        this.alto.setText(this.cannone.getAltoCount()+"");






    }

    public void onRadioButtonHandler(View view) {

        RadioButton radio = (RadioButton) view;
        String value = radio.getText().toString();

        if(value.equals("Basso"))
            cannone.setDirezione(CannoneGame.BASSO);
        else if(value.equals("Medio"))
            cannone.setDirezione(CannoneGame.MEDIO);
        else if(value.equals("Alto"))
            cannone.setDirezione(CannoneGame.ALTO);
    }

    private CannoneGame cannone;
    private TextView basso;
    private TextView medio;
    private TextView alto;
    private RadioGroup radioGroup;
    private Animation animation;
    private ImageView cannoneFoto;
    private ImageButton fireButton;

    public void restartHandler(View view) {


        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        cannone.restart();
                        basso.setText(cannone.getBassoCount()+"");
                        medio.setText(cannone.getMedioCount()+"");
                        alto.setText(cannone.getAltoCount()+"");
                        Toast.makeText(getApplicationContext(), "Nuova Partita!", Toast.LENGTH_SHORT).show();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        Toast.makeText(getApplicationContext(), "Azione annullata",Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Sei sicuro di voler ricominciare?")
                .setPositiveButton("Si", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }
}
