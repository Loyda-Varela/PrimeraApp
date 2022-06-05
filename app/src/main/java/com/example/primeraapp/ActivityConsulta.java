package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.primeraapp.Procesos.SQLiteConexion;
import com.example.primeraapp.Procesos.Transacciones;

public class ActivityConsulta extends AppCompatActivity {
//llamar la conexion
    SQLiteConexion conexion;
    //crear elementos globales
    EditText id, nombres, apellidos, edad, correo;
    Button btnbuscar, btneliminar, btnactualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        init();

        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BuscarEmpleado();
            }
        });

    }
//creamos el metodo llamar empleados
    private void BuscarEmpleado() {

        SQLiteDatabase db = conexion.getWritableDatabase();
        //parametros de Busqueda de la sentencia select

        String [] params = {id.getText().toString()};
        //campos a retornar de a sentencia selct
        String[] fields = {Transacciones.nombres,
                           Transacciones.apellidos,
                           Transacciones.edad,
                           Transacciones.correo};

        //wer condition
        String whereCondition = Transacciones.id + "=?";
        //cursores
        Cursor cdata = db.query(Transacciones.tablaEmmpleados, fields,
                whereCondition,params,null,null,null);
        cdata.moveToFirst();
        //llenarlo

        nombres.setText(cdata.getString(0));
        apellidos.setText(cdata.getString(1));
        edad.setText(cdata.getString(2));
        correo.setText(cdata.getString(3));
        //mostrar mensaje
        Toast.makeText(getApplicationContext(),"Consulta con exito !!",Toast.LENGTH_LONG).show();

    }

    private void init(){
    conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
    //llamado a los botones
        btnbuscar = (Button) findViewById(R.id.btnbuscar);
        btneliminar = (Button) findViewById(R.id.btneliminar);
        btnactualizar = (Button) findViewById(R.id.btnactualizar);

        id = (EditText) findViewById(R.id.txtcid);
        nombres = (EditText) findViewById(R.id.txtcnombres);
        apellidos = (EditText) findViewById(R.id.txtcapellidos);
        edad = (EditText) findViewById(R.id.txtcedad);
        correo = (EditText) findViewById(R.id.txtccorreo);
    }
}