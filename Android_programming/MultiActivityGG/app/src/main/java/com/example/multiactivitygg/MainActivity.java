package com.example.multiactivitygg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.testo);
        activity2 = findViewById(R.id.ButtonActivity1);
        activity3 = findViewById(R.id.ButtonActivity2);

        testoActivity2 = findViewById(R.id.testoActivity1);
        testoActivity3 = findViewById(R.id.testoActivity2);

        label1 = findViewById(R.id.label1);
        label2 = findViewById(R.id.label2);

        activity2.setOnClickListener(this);
        activity3.setOnClickListener(this);
        activity2.setText("Activity 2");
        activity3.setText("Activity 3");

        label1.setText("Activity 2 : ");
        label2.setText("Activity 3 : ");

        Bundle bundle = getIntent().getBundleExtra("bundle");
        if(bundle != null){
            Messaggo messaggo = (Messaggo) bundle.getSerializable("messaggio");
            testoActivity2.setText(messaggo.getActivity2());
            testoActivity3.setText(messaggo.getActivity3());
        }


    }

    @Override
    public void onClick(View v) {

        Button button = (Button) v;

        String value = button.getText().toString();

        Messaggo mex = new Messaggo(inputText.getText().toString(),testoActivity2.getText().toString()
                ,testoActivity3.getText().toString());

        Intent i = null;

        if(value == "Activity 2")
            i = new Intent(getApplicationContext(),Activity2.class);
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

        activity2.setOnClickListener(this);
        activity3.setOnClickListener(this);
        activity2.setText("Activity 2");
        activity3.setText("Activity 3");
        label1.setText("Activity 2 : ");
        label2.setText("Activity 3 : ");


    }

    private EditText inputText;
    private Button activity2;
    private Button activity3;
    private TextView testoActivity2;
    private TextView testoActivity3;
    private TextView label1;
    private TextView label2;
}
