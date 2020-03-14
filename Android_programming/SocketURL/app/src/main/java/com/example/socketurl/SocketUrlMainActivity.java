package com.example.socketurl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SocketUrlMainActivity extends Activity {
    private final String TAG = "DEBUG";
    private String URL_SERIE_A = "http://www.gazzetta.it/speciali/risultati_classifiche/2016/calcio/seriea/classifica.shtml";
    private String URL = "http://web.unisa.it";
    private EditText textToSend;
    private TextView textResponse;
    private String strToSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView(R.layout.layout);

        //Bind widgets
        textToSend = (EditText) findViewById(R.id.editTextToSend);
        textResponse = (TextView) findViewById(R.id.textViewResponse);
        textResponse.setMovementMethod(new ScrollingMovementMethod());
        textToSend.setText(URL);
    }

    public void classificaButton(View v) {
        textToSend.setText(URL_SERIE_A);
    }

    public void sendButtonClicked(View v) {
        Log.d("DEBUG", "sendButtonClicked");
        //Controlliamo se c'è la connessione a Internet
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Log.d("DEBUG", "  la connessione c'è");
            // fetch data
            strToSend = textToSend.getEditableText().toString();
            String str = "Send button has been clicked.\n" +
                    "Sending: " + strToSend;
            Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();

            NetworkTask nt = new NetworkTask();
            textResponse.setText("");
            nt.execute(strToSend);
        } else {
            Log.d("DEBUG", "  connessione non disponibile");

            //Errore: connessione non disponibile
            Toast.makeText(getApplicationContext(), "Connessione non disponibile!", Toast.LENGTH_LONG);
        }
    }


    public void clearButtonClicked(View v) {
        textResponse.setText("");
    }

    class NetworkTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            Log.d(TAG, "onPreExecute()");
        }

        @Override
        protected String doInBackground(String... values) {
            Log.d(TAG, "doInBackground: values[0]=URL=" + values[0]);
            String received_data = "";

            HttpURLConnection httpUrlConnection = null;

            try {
                httpUrlConnection = (HttpURLConnection) new URL(values[0])
                        .openConnection();

                InputStream in = new BufferedInputStream(
                        httpUrlConnection.getInputStream());

                received_data = readStream(in);

            } catch (MalformedURLException exception) {
                Log.e(TAG, "MalformedURLException");
            } catch (IOException exception) {
                Log.e(TAG, "IOException");
            } finally {
                if (null != httpUrlConnection)
                    httpUrlConnection.disconnect();
            }
            return received_data;
        }

        private String readStream(InputStream in) {
            BufferedReader reader = null;
            StringBuffer data = new StringBuffer("");
            try {
                reader = new BufferedReader(new InputStreamReader(in));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    data.append(line + "\n");
                }
            } catch (IOException e) {
                Log.e(TAG, "IOException");
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return data.toString();
        }

        @Override
        protected void onPostExecute(String data) {
            Log.d(TAG, "onPostExecute()");
            textResponse.setText(data);
        }
    }

}