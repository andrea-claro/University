package com.example.multiactivitygg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.testo);
        activity1 = findViewById(R.id.ButtonActivity1);
        activity3 = findViewById(R.id.ButtonActivity2);

        testoActivity1 = findViewById(R.id.testoActivity1);
        testoActivity3 = findViewById(R.id.testoActivity2);

        label1 = findViewById(R.id.label1);
        label3 = findViewById(R.id.label2);

        activity1.setOnClickListener(this);
        activity3.setOnClickListener(this);
        activity1.setText("Activity 1");
        activity3.setText("Activity 3");

        label1.setText("Activity 1 : ");
        label3.setText("Activity 3 : ");

        Bundle bundle = getIntent().getBundleExtra("bundle");
        if(bundle != null){
            Messaggo messaggo = (Messaggo) bundle.getSerializable("messaggio");
            testoActivity1.setText(messaggo.getActivity1());
            testoActivity3.setText(messaggo.getActivity3());

        }




    }

    @Override
    public void onClick(View v) {

        Button button = (Button) v;

        String value = button.getText().toString();

        Messaggo mex = new Messaggo(testoActivity1.getText().toString(),inputText.getText().toString()
                ,testoActivity3.getText().toString());

        Intent i = null;

        if(value == "Activity 1")
            i = new Intent(getApplicationContext(),MainActivity.class);
        else
            i = new Intent(getApplicationContext(),Activity3.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("messaggio", mex);

        i.putExtra("bundle",bundle);
        startActivity(i);


    }

    @Override
    protected void onResume() {
        super.onResume();

        activity1.setOnClickListener(this);
        activity3.setOnClickListener(this);
        activity1.setText("Activity 1");
        activity3.setText("Activity 3");

        label1.setText("Activity 1 : ");
        label3.setText("Activity 3 : ");


    }

    private EditText inputText;
    private Button activity1;
    private Button activity3;
    private TextView testoActivity1;
    private TextView testoActivity3;
    private TextView label1;
    private TextView label3;
}
