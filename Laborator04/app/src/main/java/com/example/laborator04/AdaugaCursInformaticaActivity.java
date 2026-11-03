
package com.example.laborator04;

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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                credite
        );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerCredite.setAdapter(adapter);

        Intent intent = getIntent();

        if (intent.hasExtra("curs")) {

            CursInformatica curs = intent.getParcelableExtra("curs");

            if (curs != null) {

                EditText etNume = findViewById(R.id.etNumeCurs);
                EditText etProfesor = findViewById(R.id.etProfesor);
                CheckBox cbObligatoriu = findViewById(R.id.cbObligatoriu);
                RatingBar ratingBar = findViewById(R.id.ratingBar);

                etNume.setText(curs.getNumeCurs());
                etProfesor.setText(curs.getProfesor());
                cbObligatoriu.setChecked(curs.isObligatoriu());
                ratingBar.setRating(curs.getDificultate());

                for (int i = 0; i < credite.length; i++) {
                    if (Integer.parseInt(credite[i]) == curs.getNumarCredite()) {
                        spinnerCredite.setSelection(i);
                        break;
                    }
                }
            }
        }
    }

    public void culegeDate(View view) {

        EditText etNume = findViewById(R.id.etNumeCurs);
        EditText etProfesor = findViewById(R.id.etProfesor);
        CheckBox cbObligatoriu = findViewById(R.id.cbObligatoriu);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        String numeCurs = etNume.getText().toString();
        String profesor = etProfesor.getText().toString();

        int numarCredite = Integer.parseInt(
                spinnerCredite.getSelectedItem().toString()
        );

        boolean obligatoriu = cbObligatoriu.isChecked();
        float dificultate = ratingBar.getRating();

        CursInformatica curs = new CursInformatica(
                numeCurs,
                profesor,
                numarCredite,
                obligatoriu,
                dificultate
        );

        Intent it = new Intent();
        Bundle bundle = new Bundle();

        bundle.putParcelable("curs", curs);
        it.putExtras(bundle);

        setResult(RESULT_OK, it);

        Toast.makeText(
                this,
                "Curs salvat",
                Toast.LENGTH_SHORT
        ).show();

        finish();
    }
}
