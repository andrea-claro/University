package com.example.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TipActivity extends Activity {

    private TextView nQuestion;
    private TextView query;
    private TextView answer;

    private Button showButton;

    private Question question;

    private static int counter;
    private static boolean showed = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);

        nQuestion = findViewById(R.id.number);
        showButton = findViewById(R.id.showButton);
        query = findViewById(R.id.question);
        answer = findViewById(R.id.answer);

        Intent i = getIntent();
        question = new Question(i.getStringExtra("question"), i.getStringExtra("answer"));
        counter = i.getIntExtra("counter", 1);

        nQuestion.setText(""+counter);

        setReturnIntent();
    }

    private void setReturnIntent(){
        Intent data = new Intent();
        data.putExtra("showed", showed);
        setResult(RESULT_OK, data);
    }

    public void buttonClicked(View v){
        Button button = (Button) v;

        switch((String) button.getText()){

            case "show":
                query.setText(question.getQuestion());
                answer.setText(question.getAnswer());
                showButton.setVisibility(View.GONE);
                showed = true;
                setReturnIntent();
                break;

            case "back":
                setReturnIntent();
                finish();
                break;

            default:
                return;
        }
    }
}
