package com.example.contador.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.contador.R;
import com.example.contador.db.Iniciar_Sesion;
import com.example.contador.db.Registrarse;

public class PantallaPortada extends AppCompatActivity {
    Intent intent;
    Button iniciarSesion;
    Button registrarse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_portada);
        iniciarSesion = findViewById(R.id.sesion);
        registrarse = findViewById(R.id.registrarse);
        iniciarSesion.setOnClickListener((view) ->{
            intent = new Intent(PantallaPortada.this, Iniciar_Sesion.class);
            startActivity(intent);
        });
        registrarse.setOnClickListener((view) -> {
            intent = new Intent(PantallaPortada.this, Registrarse.class);
            startActivity(intent);
        });
    }
}