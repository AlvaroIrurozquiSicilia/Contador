package com.example.contador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MejoraRVAdapater extends RecyclerView.Adapter<MejoraRVAdapater.ViewHolder> implements CallBack {
    List<Mejora> mejoras;
    CallBack cl;

    public MejoraRVAdapater(List<Mejora> modelList, CallBack cl) {
        mejoras = modelList;
        this.cl = cl;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_contenido_rv, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.descripcion.setText(mejoras.get(position).getDescripcion());
        holder.imagen.setImageResource(mejoras.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return mejoras.size();
    }

    @Override
    public void llamadaMetodo(Mejora mejora) {
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView descripcion;
        private final ImageView imagen;

        public ViewHolder(View v) {
            super(v);
            descripcion = v.findViewById(R.id.descripcion);
            imagen = v.findViewById(R.id.imageView);


        }

        void bind(@NonNull Mejora mejoras, CallBack cl) {
            descripcion.setText(mejoras.getDescripcion());
            imagen.setImageResource(mejoras.getImagen());
            imagen.setOnClickListener((view) -> cl.llamadaMetodo(mejoras));
        }
    }
}