package com.example.contador.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contador.Jugador;
import com.example.contador.R;

import java.util.List;

public class JugadorRVAdapter extends RecyclerView.Adapter<JugadorRVAdapter.ViewHolder> {
    List<Jugador> jugadores;

    public JugadorRVAdapter(List<Jugador> modelList){
        jugadores = modelList;
    }

    @NonNull
    @Override
    public JugadorRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_contenido_rv_jugador, parent, false);
        return new JugadorRVAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull JugadorRVAdapter.ViewHolder holder, int position) {
        holder.bind(jugadores.get(position));
    }

    @Override
    public int getItemCount() {
        return jugadores.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView nombre;
        public final TextView monedas;
        public final ImageView fotoPerfil;

        public ViewHolder(View v) {
            super(v);
            nombre = v.findViewById(R.id.textoNombre);
            monedas = v.findViewById(R.id.textoMonedas);
            fotoPerfil = v.findViewById(R.id.imagenPerfil);
        }

        public void bind(@NonNull Jugador jugadores) {

        }
    }
}