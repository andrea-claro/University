package com.example.listacustom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

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
        getMenuInflater().inflate(R.menu.main, menu);
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
                settingList();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void settingList() {
        listView = (ListView) findViewById(R.id.mylistview);

        Log.d("DEBUG", "ListView create: listView=" + listView);

        CustomAdapter customAdapter =
                new CustomAdapter(this, R.layout.list_element, new ArrayList<Contact>());

        Log.d("DEBUG", "ArrayAdapter create: arrayAdapter=" + customAdapter);

        listView.setAdapter(customAdapter);

        Log.d("DEBUG", "Done!");

        for (int i = 0; i < array.length; i++) {
            Contact c = new Contact(
                    array[i],
                    "111-2222-333",
                    getResources().getDrawable(R.drawable.faceplaceholder));
            customAdapter.add(c);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listView.getItemAtPosition(position).toString();
                // Show Toast
                Toast.makeText(getApplicationContext(),
                        "Click su posizione n." + position + ": " + str, Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}
