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
    private static final String LifeCycleTag = "LIFECYCLE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LifeCycleTag, "I'm onCreate(), and I'm started");
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

    @Override
    protected void onStart() {
        Log.d(LifeCycleTag, "I'm onStart(), and I'm started");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.d(LifeCycleTag, "I'm onPause(), and I'm started");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.d(LifeCycleTag, "I'm onRestart(), and I'm started");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d(LifeCycleTag, "I'm onResume(), and I'm started");
        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.d(LifeCycleTag, "I'm onStop(), and I'm started");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(LifeCycleTag, "I'm onDestroy(), and I'm started");
        super.onDestroy();
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

            float n1=0, n2=0;
            String s = numOne.getText().toString();
            Log.d(LogcatTag, "s = \"" + s + "\", s.length() = " + s.length());

            if (s.length() > 0) n1 = Float.parseFloat(s);
            s = numTwo.getText().toString();
            if (s.length() > 0) n2 = Float.parseFloat(s);

            Log.d(LogcatTag, "Successfully grabbed data from input fields");
            Log.d(LogcatTag, "n1 = " + n1 + ", n2 = " + n2);
            float res = 0;

            if (add.isChecked()) {
                Log.d(LogcatTag, "Operation is addition");
                res = n1 + n2;
            }
            else if (sub.isChecked()) {
                Log.d(LogcatTag, "Operation is subsctraction");
                res = n1 - n2;
            }
            else if (mul.isChecked()) {
                Log.d(LogcatTag, "Operation is multiply");
                res = n1 * n2;
            }
            else if (div.isChecked()) {
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
            else {
                Log.d(LogcatTag, "Operation is not chosen");
                answer.setText("Please choose operation");
                return;
            }

            Log.d(LogcatTag, "The result of operation is " + res);
            answer.setText("The answer is " + res);
            Log.d(LogcatTag, "-------------------------------------------");
        }
}