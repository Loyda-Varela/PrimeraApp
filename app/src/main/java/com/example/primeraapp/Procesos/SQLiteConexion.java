package com.example.primeraapp.Procesos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteConexion extends SQLiteOpenHelper {
//constructor de clase
    public SQLiteConexion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //hacer la coneion a la base de datos
        db.execSQL(Transacciones.CreateTableEmpleados);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db , int i, int i1) {
        db.execSQL(Transacciones.DropTableEmpleados);
        onCreate(db);
    }
}
