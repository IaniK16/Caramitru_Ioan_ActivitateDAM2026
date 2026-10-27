package com.example.laborator04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaCursuriActivity extends AppCompatActivity {

    private ArrayList<CursInformatica> listaCursuri;
    private ArrayAdapter<CursInformatica> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cursuri);

        ListView listView = findViewById(R.id.listViewCursuri);

        listaCursuri = (ArrayList<CursInformatica>) getIntent()
                .getSerializableExtra("listaCursuri");

        if (listaCursuri == null) {
            listaCursuri = new ArrayList<>();
        }

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listaCursuri
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            CursInformatica curs = (CursInformatica) parent.getItemAtPosition(position);

            Toast.makeText(this, curs.toString(), Toast.LENGTH_LONG).show();
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            listaCursuri.remove(position);
            adapter.notifyDataSetChanged();

            Intent intent = new Intent();
            intent.putExtra("listaCursuri", listaCursuri);
            setResult(RESULT_OK, intent);

            Toast.makeText(this, "Curs sters", Toast.LENGTH_SHORT).show();

            return true;
        });
    }

    public void inapoi(View view) {
        finish();
    }
}