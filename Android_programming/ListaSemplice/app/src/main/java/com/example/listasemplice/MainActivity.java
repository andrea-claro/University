package com.example.listasemplice;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public ListView listView;

    String[] array = {"Pasquale", "Maria", "Michele", "Antonella", "Vincenzo",
            "Teresa", "Roberto", "Rossella", "Antonio", "Luca", "Liliana", "Stefania",
            "Francesca", "Andrea", "Marco", "Elisa", "Anna", "Lorenzo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        super.onOptionsItemSelected(item);

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                setContentView(R.layout.activity_second);
                listView = (ListView) findViewById(R.id.mylistview);

                Log.d("DEBUG", "ListView create: listView=" + listView);

                ArrayAdapter<String> arrayAdapter =
                        new ArrayAdapter<String>(this, R.layout.list_element, R.id.textViewList, array);

                Log.d("DEBUG", "ArrayAdapter create: arrayAdapter=" + arrayAdapter);

                listView.setAdapter(arrayAdapter);

                Log.d("DEBUG", "Done!");

                listView.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String str = listView.getItemAtPosition(position).toString();
                        // Show Toast
                        Toast.makeText(getApplicationContext(),
                                "Click su posizione n." + position + ": " + str, Toast.LENGTH_LONG)
                                .show();
                    }
                });
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
