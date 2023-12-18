package com.example.contador;

import android.widget.EditText;

public class Jugador {
    String nombre;
    String monedas;
    int imagen;
    String contraseña;
    String email;
    public Jugador(String nombre, String monedas, int imagen, String contraseña, String email) {
        this.nombre = nombre;
        this.monedas = monedas;
        this.imagen = imagen;
        this.contraseña = contraseña;
        this.email = email;
    }
    public Jugador(String nombre, String monedas, int imagen) {
        this.nombre = nombre;
        this.monedas = monedas;
        this.imagen = imagen;
    }

    public Jugador(String email, String contraseña) {
        this.email = email;
        this.contraseña = contraseña;
    }

    public Jugador(String email, String contraseña, String nick) {
        this.email = email;
        this.contraseña = contraseña;

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

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}