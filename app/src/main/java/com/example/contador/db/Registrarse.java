package com.example.contador.db;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.contador.Jugador;
import com.example.contador.R;
import com.example.contador.pantallas.PantallaInicio;

import java.util.regex.Pattern;

public class Registrarse extends AppCompatActivity {
    EditText email;
    EditText contraseña;
    EditText nick;
    Button botonConfirmar;
    ContadorBaseDatos db;
    PopUp sgdf;
    PopUp sgdfError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        email = findViewById(R.id.email1);
        contraseña = findViewById(R.id.contraseña1);
        nick = findViewById(R.id.nick);
        botonConfirmar = findViewById(R.id.botonConfirmar1);
        sgdf = new PopUp();
        sgdfError = new PopUp();

        Bundle args = new Bundle();
        args.putString("mensaje", "Ya hay usuario creado");
        sgdf.setArguments(args);
        Bundle argsError = new Bundle();
        argsError.putString("mensaje","No has introducido un email valido");
        sgdfError .setArguments(argsError);
        botonConfirmar.setOnClickListener((view) -> {
            String emailTxt = email.getText().toString();
            Pattern patron = Pattern.compile("[a-zA-Z_]+@[a-zA-Z_.]+");
            if (patron.matcher(emailTxt).matches() == false) {
                sgdf.show(getSupportFragmentManager(), "GAME_DIALOG");

            } else {
                Jugador j = new Jugador(email.getText().toString(), contraseña.getText().toString(), nick.getText().toString());
                if (db.existe(j) == true) {
                    sgdf.show(getSupportFragmentManager(), "1");
                } else {
                    db.registrar(j);
                    Intent intent = new Intent(Registrarse.this, PantallaInicio.class);
                    startActivity(intent);
                }
            }
        });
    }

    public static class PopUp extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction.
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            String mensaje = getArguments().getString("mensage");

            builder.setMessage("Ya hay usuario creado")
                    .setPositiveButton("Aceptar", (dialog, id) -> dialog.dismiss());
            // Create the AlertDialog object and return it.
            builder.setMessage("No has introducido un email valido")
                    .setPositiveButton("Aceptar", (dialog, id) -> dialog.dismiss());
            return builder.create();
        }
    }
}