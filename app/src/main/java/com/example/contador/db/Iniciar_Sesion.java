package com.example.contador.db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.contador.R;

public class Iniciar_Sesion extends AppCompatActivity {
    EditText contraseña;
    EditText email;
    Button botonConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        contraseña = findViewById(R.id.contraseña3);
        email = findViewById(R.id.email2);
        botonConfirmar = findViewById(R.id.botonConfirmar2);
        botonConfirmar.setOnClickListener((view) ->{
            email.getText();
            contraseña.getText();

            ContadorBaseDatos.iniciarSesion();
        });
    }

}