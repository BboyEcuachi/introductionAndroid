package com.example.bboyecuachi.firstapp;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.util.*;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    public int count;
    private SharedPreferences share;

    /* este metodo guardara un valor int en "memoria" */
    public SharedPreferences.Editor shareEditInt(String key , int value){
        return this.share.edit().putInt(key, value);
    }
    public SharedPreferences.Editor shareEditString(String key, String value){
        return this.share.edit().putString(key, value);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Lifecycle", "Creacion de la APP");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.share = getSharedPreferences("XML", Context.MODE_PRIVATE);

        if (savedInstanceState != null) {
            this.count = savedInstanceState.getInt("count");
            Log.d("debug", "se recupero algo: " + this.count);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Log.d("debug", "Se toca la app " + MainActivity.this.count);
            MainActivity.this.count += 1;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onStart() {
        this.count = this.share.getInt("count", 0); // se setea en cero si no existe aun
        String prenom1 = this.share.getString("prenom", "");
        String nom1 = this.share.getString("nom", "");
        String date_de_naissance1 = this.share.getString("date_de_naissance", "");
        String ville_de_naissance1 = this.share.getString("ville_de_naissance", "");
        String numero1 = this.share.getString("numero", "");


        EditText prenom = findViewById(R.id.PRENOM2);
        EditText nom = findViewById(R.id.NOM2);
        EditText date_de_naissance = findViewById(R.id.DATE2);
        EditText ville_de_naissance = findViewById(R.id.VILLE2);
        EditText numero = findViewById(R.id.numero);

        prenom.setText(prenom1);
        nom.setText(nom1);
        date_de_naissance.setText(date_de_naissance1);
        ville_de_naissance.setText(ville_de_naissance1);
        numero.setText(numero1);

        if (this.count != 0)
            Log.d("debug", "valor count recuperado: " + this.count);

        TextView txt = (TextView)findViewById(R.id.un_texto);
        txt.setText(" " + this.count + " ");

        Log.i("Lifecycle", "APP onStart");
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i("Lifecycle", "APP onSave instances");
        outState.putInt("count", this.count);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i("Lifecycle", "APP onRestore instances");
        this.count = savedInstanceState.getInt("count");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        Log.i("Lifecycle", "APP onResumen");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("Lifecycle", "APP onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        this.shareEditInt("count", this.count).apply();

        EditText prenom = findViewById(R.id.PRENOM2);
        EditText nom = findViewById(R.id.NOM2);
        EditText date_de_naissance = findViewById(R.id.DATE2);
        EditText ville_de_naissance = findViewById(R.id.VILLE2);
        EditText numero = findViewById(R.id.numero);

        this.shareEditString("prenom", prenom.getText().toString()).apply();
        this.shareEditString("nom", nom.getText().toString()).apply();
        this.shareEditString("date_de_naissance", date_de_naissance.getText().toString()).apply();
        this.shareEditString("ville_de_naissance", ville_de_naissance.getText().toString()).apply();
        this.shareEditString("numero", numero.getText().toString()).apply();

        Log.i("Lifecycle", "APP onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Lifecycle", "APP onDestroy");
    }

    /*
    public void validateAction (View v){
        EditText Prenom = findViewById(R.id.PRENOM2);
        EditText Nom = findViewById(R.id.NOM2);
        EditText Date_de_naissance = findViewById(R.id.DATE2);
        EditText Ville_de_naissance = findViewById(R.id.VILLE2);
        String textToShow = new String (Prenom.getText().toString() + "\n" +Nom.getText().toString() + "\n" + Date_de_naissance.getText().toString() + "\n" + Ville_de_naissance.getText().toString());
        Toast.makeText(getApplicationContext(), textToShow, Toast.LENGTH_LONG).show();

    }
    */
    public void validateAction(View v) {
        EditText prenom = findViewById(R.id.PRENOM2);
        EditText nom = findViewById(R.id.NOM2);
        EditText date_de_naissance = findViewById(R.id.DATE2);
        EditText ville_de_naissance = findViewById(R.id.VILLE2);
        EditText numero = findViewById(R.id.numero);

        this.shareEditString("prenom", prenom.getText().toString()).apply();
        this.shareEditString("nom", nom.getText().toString()).apply();
        this.shareEditString("date_de_naissance", date_de_naissance.getText().toString()).apply();
        this.shareEditString("ville_de_naissance", ville_de_naissance.getText().toString()).apply();
        this.shareEditString("numero", numero.getText().toString()).apply();

        String textToShow = new String(prenom.getText().toString() + " - " +
                nom.getText().toString() + " - " +
                date_de_naissance.getText().toString() + " - " +
                ville_de_naissance.getText().toString() + " - " +
                numero.getText().toString());
        Snackbar s;
        s = Snackbar.make(findViewById(R.id.Principal_Layout), textToShow, Snackbar.LENGTH_LONG);
        s.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("debug", "Se crea el menu");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean resetAction(MenuItem item) {
        Log.d("debug", "opcion 1");

        EditText prenom = findViewById(R.id.PRENOM2);
        EditText nom = findViewById(R.id.NOM2);
        EditText date_de_naissance = findViewById(R.id.DATE2);
        EditText ville_de_naissance = findViewById(R.id.VILLE2);
        EditText numero = findViewById(R.id.numero);

        prenom.setText("");
        nom.setText("");
        date_de_naissance.setText("");
        ville_de_naissance.setText("");
        numero.setText("");

        return true;
    }

    public void addNumero(View v) {
        LinearLayout li=new LinearLayout(this);
        EditText et=new EditText(this);
        Button b=new Button(this);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int pos=(Integer) v.getTag();

            }
        });

    }

    public void removeNumero(View v) {
        EditText numero = findViewById(R.id.numero);
        numero.setVisibility(View.INVISIBLE);
        Log.d("debug", "" + View.INVISIBLE);
    }


    /* TP2 */
    public void clickAndroid(View v) {
        MainActivity.this.count += 1;
        Log.d("debug", "cuando se pega en la cara " + MainActivity.this.count);
        TextView txt = (TextView)findViewById(R.id.un_texto);
        txt.setText(" " + this.count + " ");
    }
}

