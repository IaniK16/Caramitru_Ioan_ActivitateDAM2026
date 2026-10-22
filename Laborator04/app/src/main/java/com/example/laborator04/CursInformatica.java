package com.example.laborator04;

import java.io.Serializable;

public class CursInformatica implements Serializable {

    private String numeCurs;
    private String profesor;
    private int numarCredite;
    private boolean obligatoriu;
    private float dificultate;

    public CursInformatica(String numeCurs, String profesor, int numarCredite, boolean obligatoriu, float dificultate) {
        this.numeCurs = numeCurs;
        this.profesor = profesor;
        this.numarCredite = numarCredite;
        this.obligatoriu = obligatoriu;
        this.dificultate = dificultate;
    }

    public String getNumeCurs() {
        return numeCurs;
    }

    public String getProfesor() {
        return profesor;
    }

    public int getNumarCredite() {
        return numarCredite;
    }

    public boolean isObligatoriu() {
        return obligatoriu;
    }

    public float getDificultate() {
        return dificultate;
    }
}