package ru.synergy.androidstartproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        et = (EditText)findViewById(R.id.et);
        tv = (TextView)findViewById(R.id.tv);

        Button btnstart = (Button)findViewById(R.id.buttonStart);
        Button btncatch = (Button)findViewById(R.id.buttonCatch);
        Button btnback = (Button)findViewById(R.id.buttonBack);

        btnstart.setOnClickListener(this);
        btncatch.setOnClickListener(this);
        btnback.setOnClickListener(this);
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data){
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode){
//            case RESULT_OK:
//                tv.setText(data.getStringExtra("et"));
//        }
//    }


    public void onClick(View v){
        Intent i;
        int REQ_C = 1;
        switch(v.getId()) {
            case R.id.buttonStart:
                i = new Intent(this, MainActivity2.class);
                startActivity(i);
                break;
            case R.id.buttonCatch:
                i = new Intent(this, ToInfActivity.class);
                String eText = et.getText().toString();
                i.putExtra("et", eText);
                startActivity(i);
                break;
//            case R.id.buttonBack:
//                i = new Intent(this, ComeBackActivity.class);
//                startActivityForResult(i, REQ_C);
        }
    }
}