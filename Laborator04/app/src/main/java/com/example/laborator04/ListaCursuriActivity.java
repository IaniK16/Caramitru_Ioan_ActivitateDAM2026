
package com.example.laborator04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaCursuriActivity extends AppCompatActivity {

    private static final int REQUEST_MODIFICARE = 200;

    private ArrayList<CursInformatica> listaCursuri;
    private CursAdapter adapter;
    private int pozitieSelectata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cursuri);

        ListView listView = findViewById(R.id.listViewCursuri);

        listaCursuri = getIntent().getParcelableArrayListExtra("listaCursuri");

        if (listaCursuri == null) {
            listaCursuri = new ArrayList<>();
        }

        adapter = new CursAdapter(
                listaCursuri,
                this,
                R.layout.item_curs
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            pozitieSelectata = position;

            Intent intent = new Intent(
                    this,
                    AdaugaCursInformaticaActivity.class
            );

            intent.putExtra("curs", listaCursuri.get(position));
            startActivityForResult(intent, REQUEST_MODIFICARE);
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            listaCursuri.remove(position);
            adapter.notifyDataSetChanged();

            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("listaCursuri", listaCursuri);
            setResult(RESULT_OK, intent);

            Toast.makeText(this, "Curs sters", Toast.LENGTH_SHORT).show();

            return true;
        });
    }

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            @Nullable Intent data
    ) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_MODIFICARE
                && resultCode == RESULT_OK
                && data != null) {

            CursInformatica curs = data.getParcelableExtra("curs");

            if (curs != null) {
                listaCursuri.set(pozitieSelectata, curs);
                adapter.notifyDataSetChanged();

                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("listaCursuri", listaCursuri);
                setResult(RESULT_OK, intent);
            }
        }
    }

    public void inapoi(View view) {
        finish();
    }
}
