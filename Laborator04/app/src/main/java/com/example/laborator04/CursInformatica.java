
package com.example.laborator04;

import android.os.Parcel;
import android.os.Parcelable;

public class CursInformatica implements Parcelable {

    private String numeCurs;
    private String profesor;
    private int numarCredite;
    private boolean obligatoriu;
    private float dificultate;

    public CursInformatica(String numeCurs, String profesor, int numarCredite,
                           boolean obligatoriu, float dificultate) {
        this.numeCurs = numeCurs;
        this.profesor = profesor;
        this.numarCredite = numarCredite;
        this.obligatoriu = obligatoriu;
        this.dificultate = dificultate;
    }

    protected CursInformatica(Parcel in) {
        numeCurs = in.readString();
        profesor = in.readString();
        numarCredite = in.readInt();
        obligatoriu = in.readByte() != 0;
        dificultate = in.readFloat();
    }

    public static final Creator<CursInformatica> CREATOR =
            new Creator<CursInformatica>() {
                @Override
                public CursInformatica createFromParcel(Parcel in) {
                    return new CursInformatica(in);
                }

                @Override
                public CursInformatica[] newArray(int size) {
                    return new CursInformatica[size];
                }
            };

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

    @Override
    public String toString() {
        return "Curs: " + getNumeCurs() +
                "\nProfesor: " + getProfesor() +
                "\nCredite: " + getNumarCredite() +
                "\nObligatoriu: " + isObligatoriu() +
                "\nDificultate: " + getDificultate();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(numeCurs);
        dest.writeString(profesor);
        dest.writeInt(numarCredite);
        dest.writeByte((byte) (obligatoriu ? 1 : 0));
        dest.writeFloat(dificultate);
    }
}
