
package com.example.laborator04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CURS = 100;
    private static final int REQUEST_LISTA = 200;

    private ArrayList<CursInformatica> listaCursuri = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );
                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );
                    return insets;
                }
        );
    }

    public void deschideAdaugare(View view) {
        Intent intent = new Intent(
                this,
                AdaugaCursInformaticaActivity.class
        );
        startActivityForResult(intent, REQUEST_CURS);
    }

    public void deschideLista(View view) {
        Intent intent = new Intent(
                this,
                ListaCursuriActivity.class
        );
        intent.putParcelableArrayListExtra("listaCursuri", listaCursuri);
        startActivityForResult(intent, REQUEST_LISTA);
    }

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            @Nullable Intent data
    ) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK || data == null) {
            return;
        }

        if (requestCode == REQUEST_CURS) {

            CursInformatica curs = data.getParcelableExtra("curs");

            if (curs != null) {
                listaCursuri.add(curs);
                actualizeazaAfisare();

                Toast.makeText(
                        this,
                        "Numar cursuri: " + listaCursuri.size(),
                        Toast.LENGTH_SHORT
                ).show();
            }
        }

        if (requestCode == REQUEST_LISTA) {

            ArrayList<CursInformatica> listaNoua =
                    data.getParcelableArrayListExtra("listaCursuri");

            if (listaNoua != null) {
                listaCursuri = listaNoua;
                actualizeazaAfisare();
            }
        }
    }

    private void actualizeazaAfisare() {

        TextView tvRezultat = findViewById(R.id.tvRezultat);

        if (listaCursuri.isEmpty()) {
            tvRezultat.setText("Niciun curs salvat");
            return;
        }

        String rezultat = "";

        for (CursInformatica curs : listaCursuri) {
            rezultat += curs.toString() + "\n\n";
        }

        tvRezultat.setText(rezultat);
    }
}
