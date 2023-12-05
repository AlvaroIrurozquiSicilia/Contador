package com.example.contador.pantallas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contador.Informacion;
import com.example.contador.R;
import com.example.contador.adapters.InformacionLVAdapter;

import java.util.Arrays;
import java.util.List;

public class PantallaInformacion extends AppCompatActivity{
    ListView lv;
    Button atras;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_informacion);
        lv = findViewById(R.id.listView);
        List<Informacion> informacion = Arrays.asList(
                new Informacion("Nombre real: Alvaro Irurozqui Sicilia"),
                new Informacion("Nombre artistico: Someone lost in code"),
                new Informacion("Lenguaje de la aplicacion: Java")
        );
        InformacionLVAdapter adapter = new InformacionLVAdapter(this, R.layout.activity_pantalla_informacion, informacion);
        lv.setAdapter(adapter);
        lv.getAdapter();

        atras = findViewById(R.id.botonAtras3);
        atras.setOnClickListener((view) -> {
            Intent intent = new Intent(PantallaInformacion.this, PantallaInicio.class);
            startActivity(intent);
            finish();
        });
    }
}