package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.primeraapp.Procesos.Empleados;
import com.example.primeraapp.Procesos.SQLiteConexion;
import com.example.primeraapp.Procesos.Transacciones;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {
    SQLiteConexion conexion;
    ListView listemple;

    // dos arreglos para traer la list de empleados

    ArrayList<Empleados> listaempleados;
    ArrayList<String> ArregloEmpleados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

    //traer la lista
        listemple = (ListView) findViewById(R.id.listviewEmple);
        conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        //obtener la lista

        ObtenerListaEmpleados();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ArregloEmpleados);
        //llenar el objeto
        listemple.setAdapter(adp);
    /////elemento global
        listemple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String Info = "ID: " + listaempleados.get(i).getId() + "\n"
                                     + listaempleados.get(i).getNombres();
                Snackbar.make(view, Info,Snackbar.LENGTH_LONG).show();
                       //compartir informacion
                Intent intentShare = new Intent();
                intentShare.setAction(Intent.ACTION_SEND);
                intentShare.putExtra(Intent.EXTRA_TEXT, Info);
                intentShare.setType("txt/plain");//texto plano

                //levantar el intent
                Intent Share = Intent.createChooser(intentShare, null);
                startActivity(Share);
            }
        });
    }

    private void ObtenerListaEmpleados() {
        //modo lectura
        SQLiteDatabase db = conexion.getReadableDatabase();
        Empleados empleado = null; ///variable vacia

        listaempleados = new ArrayList<Empleados>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Transacciones.tablaEmmpleados, null);

        //navegar el cursor
        while(cursor.moveToNext()){
            empleado = new Empleados();
            empleado.setId(cursor.getInt(0));
            empleado.setNombres(cursor.getString(1));
            empleado.setApelidos(cursor.getString(2));
            empleado.setEdad(cursor.getString(3));
            empleado.setCorreo(cursor.getString(4));
            listaempleados.add(empleado);
        }
        cursor.close();
        fillList();
    }

    private void fillList() {
        ArregloEmpleados = new ArrayList<String>();
        //por cada elemnto
        for(int i = 0; i<listaempleados.size(); i ++){

            ArregloEmpleados.add(listaempleados.get(i).getId() + "  "
                    + listaempleados.get(i).getNombres() + "  "
                    + listaempleados.get(i).getApelidos());
        }
    }
}