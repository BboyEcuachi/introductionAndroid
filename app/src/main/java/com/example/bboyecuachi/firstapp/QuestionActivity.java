package com.example.bboyecuachi.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AndroidException;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class QuestionActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.bboyecuachi.firstapp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Lifecycle", "Activity Question onCreated");

        setContentView(R.layout.activity_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intentQuestion = getIntent();
        String intentData = intentQuestion.getStringExtra(EXTRA_MESSAGE);
        Log.d("debug", "get extra QuestionActivity: "+ intentData);

        TextView txt = (TextView)findViewById(R.id.textVariable);
        Log.d("debug", "Por default en txt esta escrito: " + txt.getText().toString());
        txt.setText(intentData);

        Button button = (Button)findViewById(R.id.sendQuestion);
        Log.d("debug", "Por default en button esta escrito: " + txt.getText().toString());
        button.setText("ASK QUESTION");

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.i("Lifecycle", "Activity Question onDestroy");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        Log.d("debug", "requestCode: " + requestCode + " ; resultCode: " + resultCode);

        String reponse = data.getStringExtra("reponse");

        Log.d("debug", "get extra QuestionActivity: " + reponse);

        super.onActivityResult(requestCode, resultCode, data);
        Log.i("Lifecycle", "APP onActivityResult");

        Snackbar s;
        s = Snackbar.make(findViewById(R.id.contentQuestion), reponse, Snackbar.LENGTH_LONG);
        s.show();
    }

    void sendQuestion(View v){
        EditText inputQuestion = (EditText)findViewById(R.id.inputQuestion);

        Intent intentReponse = new Intent(this, ReponseActivity.class);
        intentReponse.putExtra("question", inputQuestion.getText().toString());
        startActivityForResult(intentReponse, 1020);

        Log.d("debug", "se pulso el boton y deberia enviar la pregunta");

        // setResult(1010, intentReponse);
        // finish();
    }

}
