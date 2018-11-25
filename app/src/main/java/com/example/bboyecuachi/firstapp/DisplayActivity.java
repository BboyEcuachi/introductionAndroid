package com.example.bboyecuachi.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent displayActivity = getIntent();
        User user = (User)displayActivity.getParcelableExtra("User");
        Log.d("debug", "RECUPERANDO ACTIVITY" + "\n" + user.numero + "\n" + user.nom + "\n" + user.preNom +"\n" + user.date +"\n"+ user.ville);
        EditText userNom = (EditText)findViewById(R.id.userNom);
        userNom.setText(user.nom);
        EditText userpreNom = (EditText)findViewById(R.id.userpreNom);
        userpreNom.setText(user.preNom);
        EditText userVille = (EditText)findViewById(R.id.userVille);
        userVille.setText(user.ville);
        EditText userDate = (EditText)findViewById(R.id.userDate);
        userDate.setText(user.date);
        EditText userNumero = (EditText)findViewById(R.id.userNumero);
        userNumero.setText("" + (user.numero));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        }
        );
    }

}
