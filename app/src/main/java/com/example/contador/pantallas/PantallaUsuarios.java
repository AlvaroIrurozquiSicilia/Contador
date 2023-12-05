package com.example.contador.pantallas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.contador.Jugador;
import com.example.contador.Mejora;
import com.example.contador.R;
import com.example.contador.adapters.JugadorRVAdapter;
import com.example.contador.adapters.MejoraRVAdapater;

import java.util.Arrays;
import java.util.List;

public class PantallaUsuarios extends AppCompatActivity {
    RecyclerView rv;
    List<Jugador> l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_usuarios);
        rv = findViewById(R.id.recyclerViewUsuarios);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        l = Arrays.asList(
                new Jugador("SGDHOGHSOIFJS", "asjfasjf",R.drawable.billetepng),
                new Jugador("jigsdjgpijdsgs", "aspfkas`gkasf",R.drawable.ethereummonedapng));
        rv.setAdapter(new JugadorRVAdapter(l));
    }
}