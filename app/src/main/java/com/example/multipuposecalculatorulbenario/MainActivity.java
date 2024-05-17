package com.example.multipuposecalculatorulbenario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    TextView Input;
    Button C, equals, squared, dot;
    Button one, two, three, four, five, six, seven, eight, nine, zero;
    Button open, close, add, subtract, multiply, divide;
    String operation;
    Double Num1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Input = findViewById(R.id.inputBar);
        C = findViewById(R.id.clearButton);
        equals = findViewById(R.id.equalsButton);
        squared = findViewById(R.id.squareButton);
        dot = findViewById(R.id.dotButton);
        one = findViewById(R.id.button1);
        two = findViewById(R.id.button2);
        three = findViewById(R.id.button3);
        four = findViewById(R.id.button4);
        five = findViewById(R.id.button5);
        six = findViewById(R.id.button6);
        seven = findViewById(R.id.button7);
        eight = findViewById(R.id.button8);
        nine = findViewById(R.id.button9);
        zero = findViewById(R.id.button0);
        add = findViewById(R.id.plusButon);
        subtract = findViewById(R.id.minusButton);
        multiply = findViewById(R.id.multButton);
        divide = findViewById(R.id.dividButton);

        ArrayList<Button> numButtons = new ArrayList<>();
        numButtons.add(one);
        numButtons.add(two);
        numButtons.add(three);
        numButtons.add(four);
        numButtons.add(five);
        numButtons.add(six);
        numButtons.add(seven);
        numButtons.add(eight);
        numButtons.add(nine);
        numButtons.add(zero);

        C.setOnClickListener(v -> {
            Input.setText("");
        });

        for (Button b : numButtons){
            b.setOnClickListener(v -> {
                if (!Input.getText().toString().equals("0")) {
                    Input.setText(Input.getText().toString() + b.getText().toString());
                }
                else {
                    Input.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> operator = new ArrayList<>();
        operator.add(add);
        operator.add(subtract);
        operator.add(multiply);
        operator.add(divide);
        operator.add(squared);
        for (Button b : operator) {
            b.setOnClickListener(v -> {
                Num1 = Double.parseDouble(Input.getText().toString());
                operation = b.getText().toString();
                Input.setText("");
            });
        }

        dot.setOnClickListener(v -> {
            Input.setText(Input.getText().toString() + ".");
        });


        equals.setOnClickListener(v -> {
            double Num2 = Double.parseDouble(Input.getText().toString());
            double answer = 0;
            switch (operation) {
                case "x":
                    answer = Num1*Num2;
                    break;
                case "÷":
                    answer = Num1/Num2;
                    break;
                case "+":
                    answer = Num1+Num2;
                    break;
                case "-":
                    answer = Num1-Num2;
                    break;
                case "^":
                    answer = Math.pow(Num1,Num2);
                    break;

                default:
                    answer = Num1+Num2;

            }
            Input.setText(String.valueOf(answer));


        });
    }
}