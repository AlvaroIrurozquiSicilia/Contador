package com.example.contador.db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.contador.R;

public class Registrarse extends AppCompatActivity {
    EditText email;
    EditText contraseña;
    EditText confirmarContraseña;
    EditText nick;

    Button botonConfirmar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        email = findViewById(R.id.email1);
        contraseña = findViewById(R.id.contraseña1);
        confirmarContraseña = findViewById(R.id.contraseña2);
        nick = findViewById(R.id.nick);
        botonConfirmar = findViewById(R.id.botonConfirmar1);
        botonConfirmar.setOnClickListener((view) ->{
            email.getText();
            contraseña.getText();
            confirmarContraseña.getText();
            ContadorBasesDatos.registrar();
        });
    }



    /*
    Lista problemas
    -Boton confirmar, tendria que llamar al metodo registrar y compromar que no existan estos datos, si no exiten
    meterlos en la bases de datos , si existen poner un mensaje y borrar los campos
    -
     */
}