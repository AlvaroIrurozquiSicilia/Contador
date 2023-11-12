package com.example.contador;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class PantallaOpcion extends AppCompatActivity {
    Button atras;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_opcion);
        atras = findViewById(R.id.botonAtras2);
        atras.setOnClickListener((view) -> {
            Intent intent = new Intent(PantallaOpcion.this, PantallaInicio.class);
            startActivity(intent);
            finish();
        });
        //Se queda vacia por el momento
    }
}