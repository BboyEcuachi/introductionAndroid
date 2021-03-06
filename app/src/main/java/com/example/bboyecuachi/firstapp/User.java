package com.example.bboyecuachi.firstapp;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    String numero;
    String nom;
    String preNom;
    String ville;
    String date;

    public User(String nom, String preNom, String ville, String date, String numeros){
        this.numero = numeros;
        this.nom = nom;
        this.preNom = preNom;
        this.ville = ville;
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.numero);
        out.writeString(this.nom);
        out.writeString(this.preNom);
        out.writeString(this.ville);
        out.writeString(this.date);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    private User(Parcel in) {
        this.numero = in.readString();
        this.nom = in.readString();
        this.preNom = in.readString();
        this.ville = in.readString();
        this.date = in.readString();
    }

}
