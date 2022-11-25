package ru.synergy.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.calc);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

            float n1 = Integer.parseInt(numOne.getText().toString());
            float n2 = Integer.parseInt(numTwo.getText().toString());
            float res = 0;

            if (add.isChecked()) {
                res = n1 + n2;
            }
            if (sub.isChecked()) {
                res = n1 - n2;
            }
            if (mul.isChecked()) {
                res = n1 * n2;
            }
            if (div.isChecked()) {
                if (n2 == 0) {
                    Toast.makeText(this, "Number two cannot be zero!", Toast.LENGTH_SHORT).show();
                    return;
                }
                res = n1 / n2;
            }
            answer.setText("The answer is " + res);
        }
}