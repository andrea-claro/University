package com.example.multiactivitygg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.testo);
        activity2 = findViewById(R.id.ButtonActivity1);
        activity1 = findViewById(R.id.ButtonActivity2);

        testoActivity1 = findViewById(R.id.testoActivity1);
        testoActivity2 = findViewById(R.id.testoActivity2);

        label1 = findViewById(R.id.label1);
        label2 = findViewById(R.id.label2);

        activity2.setOnClickListener(this);
        activity1.setOnClickListener(this);
        activity2.setText("Activity 2");
        activity1.setText("Activity 1");

        label2.setText("Activity 2 : ");
        label1.setText("Activity 1 : ");


        Bundle bundle = getIntent().getBundleExtra("bundle");
        if(bundle != null){
            Messaggo messaggo = (Messaggo) bundle.getSerializable("messaggio");
            testoActivity1.setText(messaggo.getActivity1());
            testoActivity2.setText(messaggo.getActivity2());

        }



    }

    @Override
    public void onClick(View v) {

        Button button = (Button) v;

        String value = button.getText().toString();

        Messaggo mex = new Messaggo(testoActivity1.getText().toString(),testoActivity1.getText().toString()
                ,inputText.getText().toString());

        Intent i = null;

        if(value == "Activity 2")
            i = new Intent(getApplicationContext(), Activity2.class);
        else
            i = new Intent(getApplicationContext(),MainActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("messaggio", mex);

        i.putExtra("bundle",bundle);
        startActivity(i);


    }

    @Override
    protected void onResume() {
        super.onResume();

        activity2.setOnClickListener(this);
        activity1.setOnClickListener(this);
        activity2.setText("Activity 2");
        activity1.setText("Activity 1");

        label1.setText("Activity 1 : ");
        label2.setText("Activity 2 : ");


    }

    private EditText inputText;
    private Button activity2;
    private Button activity1;
    private TextView testoActivity2;
    private TextView testoActivity1;
    private TextView label1;
    private TextView label2;
}
