package ru.synergy.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    private static final String LogcatTag = "CALCULATOR_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.calc);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LogcatTag, "Button have been pushed");
                calculateAnswer();
            }
        });
    }
        public void calculateAnswer() {
            EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal);
            EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);

            RadioButton add = (RadioButton) findViewById(R.id.add);
            RadioButton sub = (RadioButton) findViewById(R.id.sub);
            RadioButton mul = (RadioButton) findViewById(R.id.mul);
            RadioButton div = (RadioButton) findViewById(R.id.div);

            TextView answer = (TextView) findViewById(R.id.res);

            Log.d(LogcatTag, "All Views have been found");

            float n1 = Integer.parseInt(numOne.getText().toString());
            float n2 = Integer.parseInt(numTwo.getText().toString());

            Log.d(LogcatTag, "Successfully grabbed data from input fields");
            Log.d(LogcatTag, "n1 = " + n1 + ", n2 = " + n2);
            float res = 0;

            if (add.isChecked()) {
                Log.d(LogcatTag, "Operation is addition");
                res = n1 + n2;
            }
            if (sub.isChecked()) {
                Log.d(LogcatTag, "Operation is subsctraction");
                res = n1 - n2;
            }
            if (mul.isChecked()) {
                Log.d(LogcatTag, "Operation is multiply");
                res = n1 * n2;
            }
            if (div.isChecked()) {
                Log.d(LogcatTag, "Operation is divide");
                if (n2 == 0) {
                   // Toast.makeText(this, "Number two cannot be zero!", Toast.LENGTH_SHORT).show();
                    Log.d(LogcatTag, "WARNING! Dividing by zero! Finishing!");
                    Log.d(LogcatTag, "-------------------------------------------");
                    answer.setText("Number two cannot be zero! Cannot divide by zero!");
                    return;
                }
                res = n1 / n2;
            }

            Log.d(LogcatTag, "The result of operation is " + res);
            answer.setText("The answer is " + res);
            Log.d(LogcatTag, "-------------------------------------------");
        }
}