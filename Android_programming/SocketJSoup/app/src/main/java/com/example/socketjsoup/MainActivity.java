package com.example.socketjsoup;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private final String TAG = "DEBUG";
    private String URL = "http://www.gazzetta.it/speciali/risultati_classifiche/2016/calcio/seriea/classifica.shtml";
    private EditText textToSend;
    private ListView listViewClassifica;
    private String strToSend;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView(R.layout.layout);

        //Bind widgets
        textToSend = (EditText) findViewById(R.id.editTextToSend);
        textToSend.setText(URL);
        listViewClassifica = (ListView) findViewById(R.id.listViewClassifica);

        customAdapter = new CustomAdapter(this, R.layout.list_element, new ArrayList<Squadra>());

        listViewClassifica.setAdapter(customAdapter);

    }

    public void sendButtonClicked(View v) {
        strToSend = textToSend.getEditableText().toString();
        String str = "Send button has been clicked.\n" +
                "Sending: " + strToSend;
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();

        NetworkTask nt = new NetworkTask();
        customAdapter.clear();
        customAdapter.notifyDataSetChanged();
        nt.execute(strToSend);
    }


    public void clearButtonClicked(View v) {
        customAdapter.clear();
        customAdapter.notifyDataSetChanged();
    }

    class NetworkTask extends AsyncTask<String, Integer, Document> {

        @Override
        protected void onPreExecute() {
            Log.d(TAG, "onPreExecute()");
        }

        @Override
        protected Document doInBackground(String... values) {
            Log.d(TAG, "doInBackground: values[0]=URL=" + values[0]);

            try {
                Document doc = Jsoup.connect(values[0]).get();
                return doc;

            } catch (IOException exception) {
                exception.printStackTrace();
            }

            return null;
        }


        @Override
        protected void onPostExecute(Document doc) {
            Log.d(TAG, "onPostExecute()");
            //textSquadre.setText(doc.toString());

            Element classifica = doc.getElementById("classifica");
            //textSquadre.setText(classifica.toString());

            Elements elements_squadre = classifica.select("[class=col0]");
            //textSquadre.setText(elements_squadre.toString());

            Elements elements_punti = classifica.select("[class=col30]");
            //textSquadre.setText(elements_punti.toString());


            ArrayList<String> nomi = new ArrayList();
            ArrayList<String> punti = new ArrayList();

            boolean primo;
            int i;

            i = 0;
            primo = true;
            for (Element element_squadra : elements_squadre) {
                // Il primo elemento è il titolo della colonna
                if (!primo) {
                    nomi.add(element_squadra.text());
                    Log.d(TAG, "i=" + i + "  Adding " + element_squadra.text());
                    Log.d(TAG, "  Size of nomi is:" + nomi.size());
                    Log.d(TAG, "  Element at index " + i + ":" + nomi.get(i));
                    i++;
                }
                primo = false;
            }

            i = 0;
            // per in punti non c'è il titolo della colonna
            for (Element element_punti : elements_punti) {
                punti.add(element_punti.text());
                Log.d(TAG, "i=" + i + "  Adding " + element_punti.text());
                Log.d(TAG, "  Size of punti is:" + punti.size());
                Log.d(TAG, "  Element at index " + i + ":" + punti.get(i));
                i++;
            }

            String data_squadre = "";
            String data_punti = "";

            Log.d(TAG, "Size of nomi=" + nomi.size() + "   Size of punti=" + punti.size());

            for (i = 0; i < nomi.size(); i++) {
                Log.d(TAG, "Getting element at index i=" + i);
                Log.d(TAG, "  nome=" + nomi.get(i));
                Log.d(TAG, "  punti=" + punti.get(i));
                data_squadre += nomi.get(i) + "\n";
                data_punti += punti.get(i) + "\n";
                Squadra sq = new Squadra(nomi.get(i), Integer.parseInt(punti.get(i)));
                customAdapter.add(sq);
            }
            customAdapter.notifyDataSetChanged();
        }
    }

}