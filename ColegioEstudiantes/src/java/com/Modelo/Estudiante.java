package com.Modelo;

public class Estudiante {
    
    private int id;
    private String nombres;
    private String apellido;
    private String celular;
    private String documento;
    private String FechaCreacion;

    public Estudiante() {
    }

    public Estudiante(int id, String nombres, String apellido, String celular, String documento, String FechaCreacion) {
        this.id = id;
        this.nombres = nombres;
        this.apellido = apellido;
        this.celular = celular;
        this.documento = documento;
        this.FechaCreacion = FechaCreacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }
    
    
    
}
