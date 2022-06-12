package com.example.primeraapp.Procesos;

public class Empleados {

    private Integer id;
    private String nombres;
    private String apelidos;
    private String edad;
    private String correo;

    //getter y seters
    //son constructor vacios
    public Empleados(){

    }
    public Empleados(Integer id, String nombres, String apelidos, String edad, String correo) {
        this.id = id;
        this.nombres = nombres;
        this.apelidos = apelidos;
        this.edad = edad;
        this.correo = correo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
