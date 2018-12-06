package com.example.bboyecuachi.fragmentsapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class simple extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple, container, false);
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        Button boton = (Button) getView().findViewById(R.id.buttonFragment);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText texto = (EditText) getView().findViewById(R.id.editTextFragment);

                Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                        "vous avez ecrit dans un fragment: " + texto.getText().toString(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        Log.i("Lifecycle", "fragmento ya creado");
        super.onActivityCreated(savedInstanceState);
    }
}
