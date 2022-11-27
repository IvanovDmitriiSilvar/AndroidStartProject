package ru.synergy.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ComeBackActivity extends AppCompatActivity {

    EditText textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_back);

        textView = (EditText)findViewById(R.id.backtv);
        button = (Button)findViewById(R.id.sendBack);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();  //создали интент
                intent.putExtra("tv", textView.getText().toString());   //взяли данные из текствью и положили в интент с ключом "tv"
                setResult(RESULT_OK, intent); //выставили интент как результат нашей активности
                finish();   //вызвали финиш. Говорят, надо.
            }
        });
    }
}