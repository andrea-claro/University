package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends Activity {

    private TextView text;

    private String operation;
    private String operator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        operation = "";
        operator = "";

        if (savedInstanceState != null) {
            operator = savedInstanceState.getString("operator");
            operation = savedInstanceState.getString("operation");
            text.setText(savedInstanceState.getString("text"));
        }
    }


    public void clicked(View v) {

        Button button = (Button) v;
        if (button.getText().equals("=")) {
            this.text.setText(Double.toString(eval(operation)));
            operator = "";
        } else if (button.getText().equals("+") || button.getText().equals("-") || button.getText().equals("/") || button.getText().equals("*") || button.getText().equals("%")) {
            operation += button.getText();
            operator = (String) button.getText();
            text.setText(operation);
        } else if (button.getText().equals("AC")) {
            operation = "";
            text.setText(operation);
        } else if (button.getText().equals("C")) {
            String op = operation.substring(0, operation.length() - 1);
            operation = op;
            text.setText(operation);
        } else {
            operation += button.getText();
            text.setText(operation);
        }
    }


    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("operator", operator);
        savedInstanceState.putString("operation", operation);
        savedInstanceState.putString("text", (String) text.getText());
        super.onSaveInstanceState(savedInstanceState);
    }

    
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}