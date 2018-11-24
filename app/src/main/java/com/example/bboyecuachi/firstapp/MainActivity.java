package com.example.bboyecuachi.firstapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import android.content.SharedPreferences;

import java.io.Serializable;


public class MainActivity extends AppCompatActivity {
    public int count;
    private SharedPreferences share;

    public final static String EXTRA_MESSAGE = "com.example.bboyecuachi.firstapp";

    /* este metodo guardara un valor int en "memoria" */
    public SharedPreferences.Editor shareEditInt(String key, int value) {
        return this.share.edit().putInt(key, value);
    }

    public SharedPreferences.Editor shareEditString(String key, String value) {
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
        } else {
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

            TextView txt = (TextView) findViewById(R.id.un_texto);
            txt.setText(" " + this.count + " ");
        }

    }

    @Override
    protected void onStart() {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("debug", "Se crea el menu");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Log.d("debug", "Se toca la app " + MainActivity.this.count);
            MainActivity.this.count += 1;
        }
        return super.onTouchEvent(event);
    }

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
        LinearLayout li = new LinearLayout(this);
        EditText et = new EditText(this);
        Button b = new Button(this);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int pos = (Integer) v.getTag();

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
        TextView txt = (TextView) findViewById(R.id.un_texto);
        txt.setText(" " + this.count + " ");
    }

    /* TP3 */
    public void questionAction(MenuItem item) {
        Intent intentQuestion = new Intent(this, QuestionActivity.class);
        intentQuestion.putExtra(EXTRA_MESSAGE, "Enter your qestion");
        startActivityForResult(intentQuestion, 1010);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("debug", "requestCode: " + requestCode + " ; resultCode: " + resultCode);

        Log.d("debug", "get extra MainActivity:" + data.getStringExtra("chao"));

        super.onActivityResult(requestCode, resultCode, data);
        Log.i("Lifecycle", "APP onActivityResult");
    }

    public void wiki(MenuItem item) {
        EditText ville = findViewById(R.id.VILLE2);

        String villeStr = ville.getText().toString();

        if (villeStr.isEmpty()) {
            Snackbar s;
            s = Snackbar.make(findViewById(R.id.Principal_Layout), "Escriba un lugar de nacimiento", Snackbar.LENGTH_LONG);
            s.show();
        } else {
            Intent intentQuestion = new Intent();
            intentQuestion.setAction(Intent.ACTION_VIEW);

            intentQuestion.setData(Uri.parse("http://fr.wikipedia.org/?search=" + villeStr));
            startActivity(intentQuestion);
        }
    }

    public void share(MenuItem item) {
        EditText ville = findViewById(R.id.VILLE2);

        String villeStr = ville.getText().toString();

        if (villeStr.isEmpty()) {
            Snackbar s;
            s = Snackbar.make(findViewById(R.id.Principal_Layout), "Escriba un lugar de nacimiento", Snackbar.LENGTH_LONG);
            s.show();
        }
        else {
            Intent intentQuestion = new Intent();
            intentQuestion.setAction(Intent.ACTION_SEND);
            intentQuestion.putExtra(Intent.EXTRA_TEXT, villeStr);
            intentQuestion.setType("text/plain");
            startActivity(intentQuestion);
        }
    }

}


