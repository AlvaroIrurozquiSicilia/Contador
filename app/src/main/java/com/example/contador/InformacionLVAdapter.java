package com.example.contador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class InformacionLVAdapter extends ArrayAdapter<Informacion> {

    public InformacionLVAdapter(@NonNull Context context, int resource, @NonNull List<Informacion> objects){
        super(context, resource, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Informacion i = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.activity_contenido_lv, parent, false);

        }
        ((TextView)convertView.findViewById(R.id.textView2)).setText(i.getTexto());
        return convertView;
    }
}