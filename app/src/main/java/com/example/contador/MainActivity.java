package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {
    TextView contadorTexto;
    ImageView sumarImagen;
    Button atras;
    Button mejoras;
    BigInteger auxContador;
    BigInteger contador;
    BigInteger incremento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auxContador = BigInteger.valueOf(0);
        contador = BigInteger.valueOf(0);
        incremento = BigInteger.valueOf(0);
        contadorTexto = findViewById(R.id.texto);
        sumarImagen = findViewById(R.id.sumarImagen);
        sumarImagen.setOnClickListener((view) -> sumar());
        atras = findViewById(R.id.botonAtras1);
        atras.setOnClickListener((view) -> {
            Intent intent1 = new Intent(MainActivity.this, PantallaInicio.class);
            startActivity(intent1);
            finish();
        });
        mejoras = findViewById(R.id.botonMejora);
        mejoras.setOnClickListener((view) -> {
            //pasar datos de una activity a otra
            Intent intent2 = new Intent(MainActivity.this, PantallaMejora.class);
            intent2.putExtra("incremento", String.valueOf(incremento));
            intent2.putExtra("contador", String.valueOf(contador));
            startActivity(intent2);
        });

    }

    public void mostrar() {
        if (contador.compareTo(BigInteger.valueOf(1000)) == 1 && contador.compareTo(BigInteger.valueOf(1000000)) == -1) {
            auxContador = contador.divide(BigInteger.valueOf(1000));
            contadorTexto.setText(Integer.toString(auxContador.intValue()) + "K");
        } else if (contador.compareTo(BigInteger.valueOf(1000000)) >= 0) {
            auxContador = contador.divide(BigInteger.valueOf(1000000));
            contadorTexto.setText(Integer.toString(contador.intValue()) + "M");
        } else {
            contadorTexto.setText(Integer.toString(contador.intValue()));
        }
    }

    public void sumar() {
        if (incremento.compareTo(BigInteger.valueOf(0)) > 0) {
            contador = contador.add(incremento);
            mostrar();
        } else if (contador.compareTo(BigInteger.valueOf(100)) == 1 || contador.compareTo(BigInteger.valueOf(100)) == 0) {
            contador = contador.add(BigInteger.valueOf(2));
            mostrar();
        } else {
            contador = contador.add(BigInteger.valueOf(1));
            mostrar();
        }
        ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        fade_in.setDuration(100);
        sumarImagen.startAnimation(fade_in);
    }
}