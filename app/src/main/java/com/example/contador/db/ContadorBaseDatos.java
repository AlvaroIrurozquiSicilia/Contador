package com.example.contador.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.contador.Jugador;

public class ContadorBaseDatos extends SQLiteOpenHelper {
    public static final int VERSION = 1;
    public static final String NOMBRE = "DBContador.db";

    public ContadorBaseDatos(Context context) {
        super(context, NOMBRE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuario(nombre VARCHAR (24), monedas VARCHAR (250), imagen integer );");
    }

    /*
    No uso bajo ninguna circustancia los int que paso por parametro ya que al atualizar la base de datos
    borro todo y lo vuelvo a crear, para simplificar el codigo
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int VersionVieja, int VersionNueva) {
        db.execSQL("DROP TABLE IF EXISTS usuario;");
        onCreate(db);
    }

    public void registrar(Jugador j) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO usuario (nombre, monedas, imagen, contraseña, correo) VALUES (?,?,?,?,?)", new Object[]{
                j.getNombre(),
                j.getMonedas(),
                j.getImagen(),
                j.getContraseña(),
                j.getEmail()
        });
        db.close();
    }

    public boolean iniciarSesion(Jugador j) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT nombre, monedas, imagenes, contraseña, correo FROM usuario WHERE correo=? AND contraseña=?", new String[]{
                j.getEmail(),
                j.getContraseña()
        });
        boolean logueado = c.getCount() > 0;
        return logueado;
    }

    public boolean existe(Jugador j) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT nombre, monedas, imagenes, contraseña, correo FROM usuario WHERE correo=?", new String[]{
                j.getEmail()        });
        boolean existe = c.getCount() > 0;
        return existe;
    }
}