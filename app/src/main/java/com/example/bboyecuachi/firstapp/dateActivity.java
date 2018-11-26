package com.example.bboyecuachi.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class dateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intentDate = getIntent();
        String fecha = intentDate.getStringExtra("fecha");

        TextView f1 = (TextView)findViewById(R.id.f1);
        TextView f2 = (TextView)findViewById(R.id.f2);
        TextView f3 = (TextView)findViewById(R.id.f3);

        f1.setText(fecha.split("/")[0]);
        f2.setText(fecha.split("/")[1]);
        f3.setText(fecha.split("/")[2]);

    }

    public void b1(View v){


    }
    public void b2(View v){

    }

}
