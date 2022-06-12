package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.primeraapp.Procesos.Empleados;
import com.example.primeraapp.Procesos.SQLiteConexion;
import com.example.primeraapp.Procesos.Transacciones;

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

            ArregloEmpleados.add(listaempleados.get(i).getId() + " + "
                    + listaempleados.get(i).getNombres() + " + "
                    + listaempleados.get(i).getApelidos());
        }
    }
}