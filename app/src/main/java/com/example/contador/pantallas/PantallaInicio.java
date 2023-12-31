package com.example.contador.pantallas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contador.R;

public class PantallaInicio extends AppCompatActivity {
    Intent intent;
    Button salir;
    Button info;
    Button jugar;
    Button opcion;
    Button usuarios;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
        jugar = findViewById(R.id.jugar);
        salir = findViewById(R.id.cerrar);
        opcion = findViewById(R.id.opcion);
        info = findViewById(R.id.informacion);
        usuarios =findViewById(R.id.usuarios);
        jugar.setOnClickListener((view) -> {
            intent = new Intent(PantallaInicio.this, MainActivity.class);
            startActivity(intent);
        });
        opcion.setOnClickListener((view) -> {
            intent = new Intent(PantallaInicio.this, PantallaOpcion.class);
            startActivity(intent);
        });
        info.setOnClickListener((view) -> {
            intent = new Intent(PantallaInicio.this, PantallaInformacion.class);
            startActivity(intent);
        });
        usuarios.setOnClickListener((view)->{
            intent = new Intent(PantallaInicio.this, PantallaUsuarios.class);
            startActivity(intent);
        });
        salir.setOnClickListener((view) ->
                finish()
        );

    }
}