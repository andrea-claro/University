package com.example.datastoragepreferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextView textViewCounter;
    TextView textViewHighScore;
    EditText nome;
    Button increaseButton;
    Button decreaseButton;

    String recordman1;
    String recordman2;
    String recordman3;

    int highScore1;
    int highScore2;
    int highScore3;

    int counter;
    int screenw_px;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Size
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        screenw_px = size.x;
        //Densità
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float screen_density = metrics.density;

        textViewCounter = (TextView) findViewById(R.id.textview_counter);
        textViewHighScore = (TextView) findViewById(R.id.textview_highscore);
        increaseButton = (Button) findViewById(R.id.button_increase);
        decreaseButton = (Button) findViewById(R.id.button_decrease);
        nome = (EditText) findViewById(R.id.textview_nameplayer);

        textViewCounter.setTextSize(screenw_px / (10*screen_density));
        textViewHighScore.setTextSize(screenw_px / (30*screen_density));
        increaseButton.setTextSize(screenw_px / (10*screen_density));
        decreaseButton.setTextSize(screenw_px / (10 * screen_density));

        //prefs = getPreferences(MODE_PRIVATE);
        //prefs = getSharedPreferences("File",MODE_PRIVATE);
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        highScore1 = prefs.getInt("HIGHSCORE1", 0);
        highScore2 = prefs.getInt("HIGHSCORE2", 0);
        highScore3 = prefs.getInt("HIGHSCORE3", 0);

        recordman1 = prefs.getString("RECORDMAN1", "");
        recordman2 = prefs.getString("RECORDMAN2", "");
        recordman3 = prefs.getString("RECORDMAN3", "");

        counter = prefs.getInt("SCORE", 0);

        textViewCounter.setText("" + counter);
        String str = prefs.getString("PLAYER","");
        nome.setText(str);

        textViewHighScore.setText("Highscore: " + highScore1 +
                "  (" + recordman1 + ")");

        nome.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                // you can call or do what you want with your EditText here
                counter = 0;
                textViewCounter.setText("" + counter);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

    }

    private boolean controllaNome() {
        String str = nome.getText().toString();
        if (str.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Devi inseriri il nome per giocare!!!",
                    Toast.LENGTH_LONG).show();
            ;
            return false;
        }
        return true;
    }

    private void aggiornaHighscore() {
        //highScore1 = counter;
        //recordman1 = nome.getText().toString();
        textViewHighScore.setText("Highscore: " + counter +
                "  (" + nome.getText().toString() + ")");
        return;
    }

    public void buttonIncrease(View v) {
        if (!controllaNome()) return;
        counter++;
        textViewCounter.setText("" + counter);

        if (counter > highScore1) {
            aggiornaHighscore();
        }
        return;
    }


    public void buttonDecrease(View v) {
        if (!controllaNome()) return;
        counter--;
        textViewCounter.setText("" + counter);
        return;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("DEBUG", "onStop: saving preferences");
        Log.d("DEBUG", "  highscore=" + highScore1 + "  hs_player=" + recordman1);
    }

    private void saveStateToPreferences() {
        SharedPreferences.Editor editor = prefs.edit();

        Log.d("DEBUG","hs1="+highScore1+"  hs2="+highScore2+"  hs3="+highScore3);
        Log.d("DEBUG","rm1="+recordman1+"  rm2="+recordman2+"  rm3="+recordman3);
        Log.d("DEBUG","counter="+counter);
        if (counter > highScore1) {
            Log.d("DEBUG","CASO1");
            highScore3 = highScore2; recordman3 = recordman2;
            highScore2 = highScore1; recordman2 = recordman1;
            highScore1 = counter; recordman1 = nome.getText().toString();
        }
        else if (counter > highScore2) {
            Log.d("DEBUG","CASO2");
            highScore3 = highScore2; recordman3 = recordman2;
            highScore2 = counter; recordman2 = nome.getText().toString();
        }
        else if (counter > highScore3) {
            Log.d("DEBUG","CASO3");
            highScore3 = counter; recordman3 = nome.getText().toString();
        }

        editor.putString("RECORDMAN1", recordman1);
        editor.putString("RECORDMAN2", recordman2);
        editor.putString("RECORDMAN3", recordman3);
        editor.putInt("HIGHSCORE1", highScore1);
        editor.putInt("HIGHSCORE2", highScore2);
        editor.putInt("HIGHSCORE3", highScore3);
        editor.putInt("SCREENW_PX", screenw_px);
        editor.putString("PLAYER", nome.getText().toString());
        editor.putInt("SCORE",counter);
        editor.commit();
    }

    public void launchHighScoreActivity(View v) {
        saveStateToPreferences();
        Intent i = new Intent();
        i.setClass(getApplicationContext(),HighScore.class);
        startActivity(i);
    }
}