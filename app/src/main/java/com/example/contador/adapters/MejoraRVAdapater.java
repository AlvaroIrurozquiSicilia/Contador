package com.example.contador.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contador.interfaces.CallBack;
import com.example.contador.Mejora;
import com.example.contador.R;

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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_contenido_rv_mejora, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mejoras.get(position), cl);
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

        public void bind(@NonNull Mejora mejoras, CallBack cl) {
            descripcion.setText(mejoras.getDescripcion());
            imagen.setImageResource(mejoras.getImagen());
            imagen.setOnClickListener((view -> {
                cl.llamadaMetodo(mejoras);
                ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                fade_in.setDuration(100);
                imagen.startAnimation(fade_in);
            }));
        }
    }
}