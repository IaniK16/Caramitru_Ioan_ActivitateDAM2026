package com.example.laborator04;

import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdaugaCursInformaticaActivity extends AppCompatActivity {

    private Spinner spinnerCredite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_curs_informatica);

        spinnerCredite = findViewById(R.id.spinnerCredite);

        String[] credite = {"3", "4", "5", "6"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, credite);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCredite.setAdapter(adapter);
    }

    public void culegeDate(View view) {
        EditText etNume = findViewById(R.id.etNumeCurs);
        EditText etProfesor = findViewById(R.id.etProfesor);
        CheckBox cbObligatoriu = findViewById(R.id.cbObligatoriu);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        String numeCurs = etNume.getText().toString();
        String profesor = etProfesor.getText().toString();
        int numarCredite = Integer.parseInt(spinnerCredite.getSelectedItem().toString());
        boolean obligatoriu = cbObligatoriu.isChecked();
        float dificultate = ratingBar.getRating();

        CursInformatica curs = new CursInformatica(numeCurs, profesor, numarCredite, obligatoriu, dificultate);

        Toast.makeText(this, "Curs salvat", Toast.LENGTH_SHORT).show();

        Intent it = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("curs", curs);

        it.putExtras(bundle);
        setResult(RESULT_OK, it);
        finish();
    }
}