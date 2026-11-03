package com.example.laborator04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CursAdapter extends BaseAdapter {

    private ArrayList<CursInformatica> listaCursuri;
    private Context context;
    private int resursaLayout;

    public CursAdapter(ArrayList<CursInformatica> listaCursuri,
                       Context context, int resursaLayout) {
        this.listaCursuri = listaCursuri;
        this.context = context;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return listaCursuri.size();
    }

    @Override
    public Object getItem(int position) {
        return listaCursuri.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(resursaLayout, parent, false);

        TextView tvNume = v.findViewById(R.id.tvNumeCurs);
        TextView tvProfesor = v.findViewById(R.id.tvProfesor);
        TextView tvCredite = v.findViewById(R.id.tvCredite);
        TextView tvObligatoriu = v.findViewById(R.id.tvObligatoriu);
        TextView tvDificultate = v.findViewById(R.id.tvDificultate);

        CursInformatica curs = (CursInformatica) getItem(position);

        tvNume.setText(curs.getNumeCurs());
        tvProfesor.setText("Profesor: " + curs.getProfesor());
        tvCredite.setText("Credite: " + curs.getNumarCredite());
        tvObligatoriu.setText("Obligatoriu: " + curs.isObligatoriu());
        tvDificultate.setText("Dificultate: " + curs.getDificultate());

        return v;
    }

}