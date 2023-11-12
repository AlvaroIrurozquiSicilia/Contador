package com.example.contador;

public class Mejora {
    private final String descripcion;
    private final int imagen;
    public Mejora (String descripcion, int imagen){
        this.descripcion = descripcion;
        this.imagen = imagen;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public int getImagen() {
        return imagen;
    }
}