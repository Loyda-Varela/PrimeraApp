package com.example.primeraapp.Procesos;

public class Transacciones {
    //nombre de la base de datos
    public static final String NameDataBase = "BD1";
    //creacion de tablas de la base de datos

    public static final String tablaEmmpleados = "Empleados";
    //escoger los campos
    public static final String id ="id";
    public static final String nombres ="nombres";
    public static final String apellidos ="apellidos";
    public static final String edad ="edad";
    public static final String correo="correo";

//sentencias sql para crear tablas

    public static final String CreateTableEmpleados = "CREATE TABLE empleados " +
        "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombres TEXT, apellidos TEXT, edad INTEGER, " +
            "correo TEXT)";


    //hacer comando para eliminar la tabla
    public static final String DropTableEmpleados ="DROP TABLE IF EXISTS empleados";
}
