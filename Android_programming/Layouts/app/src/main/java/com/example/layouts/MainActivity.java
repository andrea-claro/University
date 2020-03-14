package com.example.layouts;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            case R.id.menu1:
                setContentView(R.layout.activity_main);
                return true;
            case R.id.menu2:
                setContentView(R.layout.grid_layout);
                return true;
            case R.id.menu3:
                setContentView(R.layout.linear_layout);
                return true;
            case R.id.menu4:
                setContentView(R.layout.linear_layout_no_weigth);
                return true;
            case R.id.menu5:
                setContentView(R.layout.linear_layout_with_frames);
                return true;
            case R.id.menu6:
                setContentView(R.layout.linear_layout_wrap_content);
                return true;
            case R.id.menu7:
                setContentView(R.layout.padding_margins_strings);
                return true;
            case R.id.menu8:
                setContentView(R.layout.relative_layout);
                return true;
            case R.id.menu9:
                setContentView(R.layout.widgets);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
