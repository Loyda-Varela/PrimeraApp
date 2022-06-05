package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText nombre, apellidos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombre=(EditText) findViewById(R.id.nombre);
        apellidos=(EditText) findViewById(R.id.apellidos);

        nombre.setText(getIntent().getExtras().getString("Nombre:"));
        apellidos.setText(getIntent().getExtras().getString("Apellido:"));
    }
}