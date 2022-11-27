package ru.synergy.androidstartproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQ_C = 1;
    EditText et;
    TextView tv;
    
    ActivityResultLauncher<Intent> mStartActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent intent = result.getData();
                    tv.setText(intent.getStringExtra("tv"));
                }
            }
    );

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
            case R.id.buttonBack:
                i = new Intent(this, ComeBackActivity.class);
                mStartActivityForResult.launch(i);
        }
    }
}