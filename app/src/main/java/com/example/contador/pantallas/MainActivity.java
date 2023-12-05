package com.example.contador.pantallas;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.contador.R;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.getMainLooper());
    TextView metalesTexto;
    ImageView sumarImagen;
    Button atras;
    Button mejoras;
    BigInteger auxMetales;
    BigInteger metales;
    BigInteger incremento;
    BigInteger autoIncremento;
    Boolean mejoraAuto = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extra = getIntent().getExtras();
        if (metales == null) {
            metales = BigInteger.valueOf(0);
            incremento = BigInteger.valueOf(0);
            autoIncremento = BigInteger.valueOf(1);
        }
        auxMetales = BigInteger.valueOf(0);
        metalesTexto = findViewById(R.id.texto);
        sumarImagen = findViewById(R.id.sumarImagen);
        sumarImagen.setOnClickListener((view) -> sumar());
        atras = findViewById(R.id.botonAtras1);
        atras.setOnClickListener((view) -> {
            Intent intent1 = new Intent(MainActivity.this, PantallaInicio.class);
            startActivity(intent1);
            finish();
        });
        mejoras = findViewById(R.id.botonMejora);
        ActivityResultLauncher launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (result) -> {
            metales = (BigInteger) result.getData().getSerializableExtra("contador");
            incremento = (BigInteger) result.getData().getSerializableExtra("incremento");
            mejoraAuto = (Boolean) result.getData().getSerializableExtra("automatico");
            autoIncremento = (BigInteger) result.getData().getSerializableExtra("incrementoAutomatico");
            if (mejoraAuto) {
                mejora2();
            }
        });
        mejoras.setOnClickListener((view) -> {
            //pasar datos de una activity a otra
            Intent intent2 = new Intent(MainActivity.this, PantallaMejora.class);
            intent2.putExtra("incremento", incremento);
            intent2.putExtra("contador", metales);
            launcher.launch(intent2);

        });
    }

    public void mostrar() {
        if (metales.compareTo(BigInteger.valueOf(1000)) == 1 && metales.compareTo(BigInteger.valueOf(1000000)) == -1) {
            auxMetales = metales.divide(BigInteger.valueOf(1000));
            metalesTexto.setText(Integer.toString(auxMetales.intValue()) + "K");
        } else if (metales.compareTo(BigInteger.valueOf(1000000)) >= 0) {
            auxMetales = metales.divide(BigInteger.valueOf(1000000));
            metalesTexto.setText(Integer.toString(metales.intValue()) + "M");
        } else {
            metalesTexto.setText(Integer.toString(metales.intValue()));
        }
    }

    public void sumar() {
        if (incremento.compareTo(BigInteger.valueOf(0)) > 0) {
            metales = metales.add(incremento);
            mostrar();
        } else if (metales.compareTo(BigInteger.valueOf(100)) == 1 || metales.compareTo(BigInteger.valueOf(100)) == 0) {
            metales = metales.add(BigInteger.valueOf(2));
            mostrar();
        } else {
            metales = metales.add(BigInteger.valueOf(1));
            mostrar();
        }
        ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        fade_in.setDuration(100);
        sumarImagen.startAnimation(fade_in);
    }

    public void mejora1() {
        incremento = incremento.add(BigInteger.valueOf(2));
        mostrar();
    }

    public void mejora2() {
        mejoraAuto = true;
        mostrar();
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
    }
}