package com.example.test;

import android.os.Parcel;
import android.os.Parcelable;

public class Bicicleta implements Parcelable {
    int idBicicleta;
    String model;
    float pret;
    String tip;
    String marca;
    boolean esteElectrica;
    boolean areFraneDisc;
    float rating;

    protected Bicicleta(Parcel in) {
        idBicicleta = in.readInt();
        model = in.readString();
        pret = in.readFloat();
        tip = in.readString();
        marca = in.readString();
        esteElectrica = in.readByte() != 0;
        areFraneDisc = in.readByte() != 0;
        rating = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idBicicleta);
        dest.writeString(model);
        dest.writeFloat(pret);
        dest.writeString(tip);
        dest.writeString(marca);
        dest.writeByte((byte) (esteElectrica ? 1 : 0));
        dest.writeByte((byte) (areFraneDisc ? 1 : 0));
        dest.writeFloat(rating);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Bicicleta> CREATOR = new Creator<Bicicleta>() {
        @Override
        public Bicicleta createFromParcel(Parcel in) {
            return new Bicicleta(in);
        }

        @Override
        public Bicicleta[] newArray(int size) {
            return new Bicicleta[size];
        }
    };

    public int getIdBicicleta() {
        return idBicicleta;
    }

    public void setIdBicicleta(int idBicicleta) {
        this.idBicicleta = idBicicleta;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isEsteElectrica() {
        return esteElectrica;
    }

    public void setEsteElectrica(boolean esteElectrica) {
        this.esteElectrica = esteElectrica;
    }

    public boolean isAreFraneDisc() {
        return areFraneDisc;
    }

    public void setAreFraneDisc(boolean areFraneDisc) {
        this.areFraneDisc = areFraneDisc;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "idBicicleta=" + idBicicleta +
                ", model='" + model + '\'' +
                ", pret=" + pret +
                ", tip='" + tip + '\'' +
                ", marca='" + marca + '\'' +
                ", esteElectrica=" + esteElectrica +
                ", areFraneDisc=" + areFraneDisc +
                ", rating=" + rating +
                '}';
    }

    public Bicicleta(int idBicicleta, String model, float pret, String tip, String marca, boolean esteElectrica, boolean areFraneDisc, float rating) {
        this.idBicicleta = idBicicleta;
        this.model = model;
        this.pret = pret;
        this.tip = tip;
        this.marca = marca;
        this.esteElectrica = esteElectrica;
        this.areFraneDisc = areFraneDisc;
        this.rating = rating;
    }
}
