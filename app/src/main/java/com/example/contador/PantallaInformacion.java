package com.example.contador;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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