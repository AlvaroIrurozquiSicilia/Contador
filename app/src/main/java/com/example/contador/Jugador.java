package com.example.contador;

public class Jugador {
    String nombre;
    String monedas;
    int imagen;
    String contraseña;
    String correo;
    public Jugador(String nombre, String monedas, int imagen, String contraseña, String correo) {
        this.nombre = nombre;
        this.monedas = monedas;
        this.imagen = imagen;
        this.contraseña = contraseña;
        this.correo = correo;
    }
    public Jugador(String nombre, String monedas, int imagen) {
        this.nombre = nombre;
        this.monedas = monedas;
        this.imagen = imagen;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMonedas(){
        return monedas;
    }

    public void setMonedas(String monedas) {
        this.monedas = monedas;
    }

    public int getImagen(){
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getContraseña(){
        return contraseña;
    }

    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }
}