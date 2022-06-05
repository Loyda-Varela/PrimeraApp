package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.primeraapp.Procesos.SQLiteConexion;
import com.example.primeraapp.Procesos.Transacciones;

public class ActivityCrear extends AppCompatActivity {
    Button btnagregar;
    EditText txtnombres, txtapellidos, txtedad, txtcorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
//AQUI llamamos la funcion
        init();

        //agregar el listener
        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarEmpleado();
            }
        });

    }
    private void init(){
        txtnombres = (EditText) findViewById(R.id.txtnombres);
        txtapellidos = (EditText) findViewById(R.id.txtapellidos);
        txtedad = (EditText) findViewById(R.id.txtedad);
        txtcorreo = (EditText) findViewById(R.id.txtcorreo);

        btnagregar = (Button) findViewById(R.id.btnagregar);
    }

    private void AgregarEmpleado() {
            //conexion e insercion a la base de datos

        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        //conexion a la base de datos
        SQLiteDatabase db = conexion.getWritableDatabase();
        //contenedores de informacion
        ContentValues valores = new ContentValues();
        //pasar datos
        valores.put(Transacciones.nombres, txtnombres.getText().toString());
        valores.put(Transacciones.apellidos, txtapellidos.getText().toString());
        valores.put(Transacciones.edad, txtedad.getText().toString());
        valores.put(Transacciones.correo, txtcorreo.getText().toString());
//resltado

        Long resultado = db.insert(Transacciones.tablaEmmpleados, Transacciones.id, valores);
        Toast.makeText(getApplicationContext(),"Registro Ingresado", Toast.LENGTH_LONG).show();
        //cerramos
        db.close();
        //limpiamos la pantalla
        ClearScreen();

    }

    private void ClearScreen() {
        txtnombres.setText("");
        txtapellidos.setText("");
        txtedad.setText("");
        txtcorreo.setText("");
    }
}