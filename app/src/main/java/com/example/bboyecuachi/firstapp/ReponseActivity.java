package com.example.bboyecuachi.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.*;
import android.view.View;
import android.widget.*;


public class ReponseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reponse);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intentQuestion = getIntent();
        String intentData = intentQuestion.getStringExtra("question");
        Log.d("debug", "get extra ReponseActivity question: " + intentData);

        TextView txt = (TextView)findViewById(R.id.question);
        Log.d("debug", "Por default en txt esta escrito: " + txt.getText().toString());
        txt.setText(intentData);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText reponse = (EditText)findViewById(R.id.inputReponse);
                Intent intentReponse = new Intent(ReponseActivity.this, QuestionActivity.class);
                intentReponse.putExtra("reponse", reponse.getText().toString());
                setResult(1020, intentReponse);
                finish();
            }
        });
    }

}
