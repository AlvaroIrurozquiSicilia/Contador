package com.example.contador.pantallas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.contador.Mejora;
import com.example.contador.R;
import com.example.contador.adapters.MejoraRVAdapater;
import com.example.contador.interfaces.CallBack;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class PantallaMejora extends AppCompatActivity implements CallBack {
    RecyclerView rv;
    BigInteger coste;
    BigInteger costeAuto;
    BigInteger metales;
    BigInteger incremento;
    BigInteger autoIncremento;
    BigInteger auxMetales;
    boolean mejoraAuto = false;
    Button atras;
    TextView metalesTexto;
    List<Mejora> l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_mejora);
        metalesTexto = findViewById(R.id.textView2);
        Bundle extra = getIntent().getExtras();
        incremento = BigInteger.valueOf(0);
        coste = BigInteger.valueOf(100);
        costeAuto = BigInteger.valueOf(100);
        auxMetales = BigInteger.valueOf(0);
        autoIncremento = BigInteger.valueOf(0);
        metales = (BigInteger) (extra.getSerializable("contador"));
        incremento = (BigInteger) (extra.getSerializable("incremento"));
        metalesTexto.setText(String.valueOf(metales));
        rv = findViewById(R.id.recyclerViewMejoras);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        l = Arrays.asList(new Mejora("SGDHOGHSOIFJS", R.drawable.billetepng), new Mejora("jigsdjgpijdsgs", R.drawable.ethereummonedapng));
        rv.setAdapter(new MejoraRVAdapater(l, this));
        atras = findViewById(R.id.botonAtras5);
        atras.setOnClickListener((view) -> {
            Intent intent = new Intent(PantallaMejora.this, MainActivity.class);
            intent.putExtra("contador", metales);
            intent.putExtra("incremento", incremento);
            intent.putExtra("automatico", mejoraAuto);
            intent.putExtra("incrementoAutomatico", autoIncremento);
            setResult(0, intent);
            finish();
        });
    }

    @Override
    public void llamadaMetodo(Mejora mejora) {
        if (mejora.getImagen() == R.drawable.billetepng) {
            mejora1();
        } else {
            mejora2();
        }
    }

    public void mejora1() {
        if (metales.compareTo(coste) == 0 || metales.compareTo(coste) == 1) {
            incremento = incremento.add(BigInteger.valueOf(2));
            metales = metales.subtract(coste);
            mostrar();
            coste = coste.add(BigInteger.valueOf(20));
        }
    }

    public void mejora2() {
        if (metales.compareTo(costeAuto) == 0 || metales.compareTo(costeAuto) == 1) {
            mejoraAuto = true;
            metales = metales.subtract(costeAuto);
            mostrar();
            costeAuto = costeAuto.add(BigInteger.valueOf(150));
            autoIncremento = autoIncremento.add(BigInteger.valueOf(1));
        }
    }

    public void mostrar() {
        if (metales.compareTo(BigInteger.valueOf(1000)) == 1 && metales.compareTo(BigInteger.valueOf(1000000)) == -1) {
            auxMetales = metales.divide(BigInteger.valueOf(1000));
            metalesTexto.setText(Integer.toString(auxMetales.intValue()) + "K");
        } else if (metales.compareTo(BigInteger.valueOf(1000000)) >= 0) {
            auxMetales = metales.divide(BigInteger.valueOf(1000000));
            metalesTexto.setText(Integer.toString(auxMetales.intValue()) + "M");
        } else {
            metalesTexto.setText(Integer.toString(auxMetales.intValue()));
        }
    }
}