package com.example.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizActivity extends Activity {

    private TextView nQuestion;
    private TextView question;
    private TextView rightAns;
    private TextView wrongAns;
    private TextView totAns;

    private static int counter;
    private static int rightAnsCounter;
    private static int wrongAnsCounter;

    private static ArrayList<Question> domande = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nQuestion = findViewById(R.id.nQuestion);
        rightAns = findViewById(R.id.rightAns);
        wrongAns = findViewById(R.id.wrongAns);
        totAns = findViewById(R.id.totAns);
        question = findViewById(R.id.question);

        addQuestion();

        counter = 1;
        rightAns.setText("0");
        wrongAns.setText("0");

        if (savedInstanceState != null) {
            counter = Integer.parseInt(savedInstanceState.getString("counter"));
            rightAnsCounter = Integer.parseInt(savedInstanceState.getString("rightAnsCounter"));
            wrongAnsCounter = Integer.parseInt(savedInstanceState.getString("wrongAnsCounter"));

            rightAns.setText("" + rightAnsCounter);
            wrongAns.setText("" + wrongAnsCounter);
        }

        nQuestion.setText("" + counter);
        question.setText((String) domande.get(counter - 1).getQuestion());
        totAns.setText("" + (rightAnsCounter + wrongAnsCounter));


    }

    private void addQuestion() {
        domande.add(new Question("Nella squadra di calcio dell'Italia che vinse il mondiale 2006, c’erano 8 giocatori della Juventus. Vero o falso?", "true"));
        domande.add(new Question("\"One last time\" è cantata dalla famosa Nicki Minaj. Vero o falso? ", "false"));
        domande.add(new Question("Osservando l’oscillazione di una lampada appesa, Newton intuì la regolarità del moto di un pendolo. Vero o falso? ", "false"));
        domande.add(new Question("Il personaggio di Dory è presente nel cartone animato Doraemon. Vero o falso? ", "false"));
        domande.add(new Question("Quando Ghali ha iniziato la carriera di cantante si faceva chiamare Fobia. Vero o falso? ", "true"));
        domande.add(new Question("In Sam e Cat le protagoniste sono due ballerine. Vero o falso? ", "false"));
        domande.add(new Question("Gli anelli di Saturno non sono altro che piccoli e grandi frammenti di roccia che gli orbitano intorno, attirati dalla sua gravità. Vero o falso? ", "true"));
        domande.add(new Question("Prima di giocare nel Milan, Filippo Inzaghi militava nella squadra della Juventus. Vero o falso? ", "true"));
        domande.add(new Question("La vincitrice più giovane del premio Nobel per la pace è diventata celebre per il suo blog scritto all'età di tredici anni. Vero o falso? ", "true"));
        domande.add(new Question("Il vero nome di Favij è Leonardo Oste. Vero o falso? ", "false"));
        domande.add(new Question("I cani hanno un ottimo olfatto ma non riescono a vedere il verde e il rosso. Vero o falso? ", "false"));
        domande.add(new Question("Il figlio minore di Buffon si chiama Leopoldo. Vero o falso? ", "true"));
        domande.add(new Question("I papiri sono delle piante che crescono vicino ai fiumi e dalle quali gli antichi egizi ottenevano la carta. Vero o falso? ", "true"));
        domande.add(new Question("Il \"Full contact\" è una disciplina della Boxe. Vero o falso? ", "false"));
        domande.add(new Question("La quinta nota musicale è Sol. Vero o falso? ", "true"));
    }


    public void buttonClicked(View v) {
        Button button = (Button) v;

        switch ((String) button.getText()) {

            case "prev":
                if (counter != 1) {
                    counter--;
                    updateQuestion();
                }
                break;

            case "true":
                domande.get(counter - 1).setUserAnswer("true");
                judge();
                if (counter != domande.size()) {
                    counter++;
                    updateQuestion();
                }
                break;

            case "false":
                domande.get(counter - 1).setUserAnswer("false");
                judge();
                if (counter != domande.size()) {
                    counter++;
                    updateQuestion();
                }
                break;

            case "next":
                if (counter != domande.size()) {
                    counter++;
                    updateQuestion();
                }
                break;

            case "tip":
                Intent i = new Intent();
                i.setClass(getApplicationContext(), TipActivity.class);
                i.putExtra("counter", counter);
                i.putExtra("question", domande.get(counter - 1).getQuestion());
                i.putExtra("answer", domande.get(counter - 1).getAnswer());
                startActivityForResult(i, 0);

            default:
                return;
        }
    }

    private void judge() {
        if (!domande.get(counter - 1).isPlayed()) {
            if (domande.get(counter - 1).isJudgement()) {
                rightAnsCounter++;
                rightAns.setText("" + rightAnsCounter);
            } else {
                wrongAnsCounter++;
                wrongAns.setText("" + wrongAnsCounter);
            }
            totAns.setText("" + (rightAnsCounter + wrongAnsCounter));
            domande.get(counter - 1).setPlayed(true);
        }
    }

    private void updateQuestion() {
        nQuestion.setText("" + counter);
        question.setText((String) domande.get(counter - 1).getQuestion());
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("counter", Integer.toString(counter));
        savedInstanceState.putString("rightAnsCounter", Integer.toString(rightAnsCounter));
        savedInstanceState.putString("wrongAnsCounter", Integer.toString(wrongAnsCounter));
        super.onSaveInstanceState(savedInstanceState);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode != 0) return;
//        if (resultCode != Activity.RESULT_OK) return;
//        if (data != null) return;

        if (data.getBooleanExtra("showed", false)) {
            domande.get(counter - 1).setPlayed(true);
            Toast.makeText(getApplicationContext(), "Has been showed: " + domande.get(counter - 1).getQuestion(), Toast.LENGTH_LONG).show();
        }

    }
}
