package com.example.wolfteinter.fobosapp;

public class classQueja {
    private  String ruta;
    private String Descripcion;

    public classQueja(String ruta, String descripcion) {
        this.ruta = ruta;
        this.Descripcion = descripcion;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
