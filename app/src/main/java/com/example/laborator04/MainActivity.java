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

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CURS = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void deschideAdaugare(View view) {
        Intent it = new Intent(this, AdaugaCursInformaticaActivity.class);
        startActivityForResult(it, REQUEST_CURS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CURS && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras();

            if (bundle != null) {
                CursInformatica curs = (CursInformatica) bundle.getSerializable("curs");

                if (curs != null) {
                    TextView tvRezultat = findViewById(R.id.tvRezultat);

                    tvRezultat.setText(
                            "Curs: " + curs.getNumeCurs() +
                                    "\nProfesor: " + curs.getProfesor() +
                                    "\nCredite: " + curs.getNumarCredite() +
                                    "\nObligatoriu: " + curs.isObligatoriu() +
                                    "\nDificultate: " + curs.getDificultate()
                    );

                    Toast.makeText(this, "Curs salvat", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}