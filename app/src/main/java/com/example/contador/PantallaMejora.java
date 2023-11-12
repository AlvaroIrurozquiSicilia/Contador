package com.example.contador;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class PantallaMejora extends AppCompatActivity implements CallBack{
    RecyclerView rv;
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.getMainLooper());
    BigInteger coste;
    BigInteger costeAuto;
    BigInteger metales;
    BigInteger incremento;
    BigInteger autoIncremento;
    BigInteger auxMetales;
    boolean mejoraAuto = false;
    Button atras;
    TextView datos;
    TextView metalesTexto;
    List<Mejora> l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_mejora);
        datos = findViewById(R.id.textView2);
        Bundle extra = getIntent().getExtras();
        metales = BigInteger.valueOf(extra.getInt("contador"));
        incremento = BigInteger.valueOf(extra.getInt("incremento"));
        datos.setText(String.valueOf(metales));
        incremento = BigInteger.valueOf(0);
        coste = BigInteger.valueOf(100);
        costeAuto = BigInteger.valueOf(100);
        autoIncremento = BigInteger.valueOf(0);
        rv= findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        l = Arrays.asList(
                new Mejora("SGDHOGHSOIFJS", R.drawable.billetepng),
                new Mejora("jigsdjgpijdsgs", R.drawable.ethereummonedapng),
                );
        rv.setAdapter(new MejoraRVAdapater(l, this));

        atras = findViewById(R.id.button);
        atras.setOnClickListener((view) -> {
            Intent intent = new Intent(PantallaMejora.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
    @Override
    public void llamadaMetodo(Mejora mejora) {
        int i = 0;
        if(rv.findViewHolderForAdapterPosition(new MejoraRVAdapater.ViewHolder(v)) = 1){
            mejora1();
        }else{
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
        /*
        ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        fade_in.setDuration(100);
        mejoraImagen.startAnimation(fade_in);
        */
    }
    public void mejora2() {
        if (metales.compareTo(costeAuto) == 0 || metales.compareTo(costeAuto) == 1) {
            mejoraAuto = true;
            metales = metales.subtract(costeAuto);
            mostrar();
            costeAuto = costeAuto.add(BigInteger.valueOf(150));
            autoIncremento = autoIncremento.add(BigInteger.valueOf(1));
            executor.execute(() -> {
                while (mejoraAuto) {
                    try {
                        Thread.sleep(1000);
                        metales = metales.add(autoIncremento);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    handler.post(this::mostrar);
                }
            });
            /*
            ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            fade_in.setDuration(100);
            mejoraAutoBoton.startAnimation(fade_in);
             */
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