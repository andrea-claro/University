package com.example.datastoragepreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HighScore extends Activity {
    TextView textViewHighScoreName1;
    TextView textViewHighScoreName2;
    TextView textViewHighScoreName3;
    int screenw_px;
    int highscore;
    String hs_player;
    SharedPreferences prefs;

    String recordman1;
    String recordman2;
    String recordman3;

    int highScore1;
    int highScore2;
    int highScore3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        Log.d("DEBUG", "onCreate HighScore Activity");

        textViewHighScoreName1 = (TextView) findViewById(R.id.textview_highscore1_name);
        textViewHighScoreName2 = (TextView) findViewById(R.id.textview_highscore2_name);
        textViewHighScoreName3 = (TextView) findViewById(R.id.textview_highscore3_name);

        //prefs = getPreferences(MODE_PRIVATE);
        //prefs = getSharedPreferences("filename",MODE_PRIVATE);
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        highScore1 = prefs.getInt("HIGHSCORE1", 0);
        highScore2 = prefs.getInt("HIGHSCORE2", 0);
        highScore3 = prefs.getInt("HIGHSCORE3", 0);

        recordman1 = prefs.getString("RECORDMAN1", "");
        recordman2 = prefs.getString("RECORDMAN2", "");
        recordman3 = prefs.getString("RECORDMAN3", "");

        screenw_px = prefs.getInt("SCREENW_PX",0);

        if (screenw_px > 0) {
            textViewHighScoreName1.setTextSize(screenw_px/30);
            textViewHighScoreName2.setTextSize(screenw_px/30);
            textViewHighScoreName3.setTextSize(screenw_px/30);
        }

        String str = "Highscore "+highScore1+" by "+recordman1;
        textViewHighScoreName1.setText(str);
        str = "Highscore "+highScore2+" by "+recordman2;
        textViewHighScoreName2.setText(str);
        str = "Highscore "+highScore3+" by "+recordman3;
        textViewHighScoreName3.setText(str);
    }
}
