package com.example.contador.db;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.contador.Jugador;
import com.example.contador.R;
import com.example.contador.pantallas.PantallaInicio;

public class Iniciar_Sesion extends AppCompatActivity {
    EditText contraseña;
    EditText email;
    Button botonConfirmar;
    ContadorBaseDatos db;
    StartGameDialogFragment sgdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        db = new ContadorBaseDatos(this);
        contraseña = findViewById(R.id.contraseña3);
        email = findViewById(R.id.email2);
        botonConfirmar = findViewById(R.id.botonConfirmar2);
        sgdf = new StartGameDialogFragment();
        botonConfirmar.setOnClickListener((view) -> {
            Jugador j = new Jugador(email.getText().toString(), contraseña.getText().toString());

            if (db.iniciarSesion(j) == true) {
                Intent intent = new Intent(Iniciar_Sesion.this, PantallaInicio.class);
                startActivity(intent);
            } else {
                sgdf.show(getSupportFragmentManager(), "GAME_DIALOG");
            }
        });
    }

    public static class StartGameDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction.
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("No hay usuario creado")
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
            // Create the AlertDialog object and return it.
            return builder.create();
        }
    }
}