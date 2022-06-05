package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtnombre, txtapellido;
    Button btnmostrar,btnenviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre = (EditText)findViewById(R.id.txtnombre);
        txtapellido = (EditText)findViewById(R.id.txtapellido);

        btnmostrar = (Button) findViewById(R.id.btnmostrar);
        btnenviar = (Button) findViewById(R.id.btnenviar);

        //evento onclick
        btnmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mostrar mensaje
                Toast.makeText(getApplicationContext(), "Nombre:" + txtnombre.getText().toString(),Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "Apellido:" + txtapellido.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });

        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //declarar un untent para mostrar en la otra pagina
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("Nombre:", txtnombre.getText().toString());
                intent.putExtra("Apellido:", txtapellido.getText().toString());
                startActivity(intent);
                }
        });
    }
}