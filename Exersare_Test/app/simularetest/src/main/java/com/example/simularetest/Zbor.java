package com.example.simularetest;

import android.os.Parcel;
import android.os.Parcelable;

public class Zbor implements Parcelable {
    String companie;
    int nrLocuri;
    boolean esteDirect;
    String destinatie;
    float pret;

    public Zbor(String companie, int nrLocuri, boolean esteDirect, String destinatie, float pret) {
        this.companie = companie;
        this.nrLocuri = nrLocuri;
        this.esteDirect = esteDirect;
        this.destinatie = destinatie;
        this.pret = pret;
    }

    protected Zbor(Parcel in) {
        companie = in.readString();
        nrLocuri = in.readInt();
        esteDirect = in.readByte() != 0;
        destinatie = in.readString();
        pret = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(companie);
        dest.writeInt(nrLocuri);
        dest.writeByte((byte) (esteDirect ? 1 : 0));
        dest.writeString(destinatie);
        dest.writeFloat(pret);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Zbor> CREATOR = new Creator<Zbor>() {
        @Override
        public Zbor createFromParcel(Parcel in) {
            return new Zbor(in);
        }

        @Override
        public Zbor[] newArray(int size) {
            return new Zbor[size];
        }
    };

    public String getCompanie() {
        return companie;
    }

    public void setCompanie(String companie) {
        this.companie = companie;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    public boolean isEsteDirect() {
        return esteDirect;
    }

    public void setEsteDirect(boolean esteDirect) {
        this.esteDirect = esteDirect;
    }

    public String getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Zbor{" +
                "companie='" + companie + '\'' +
                ", nrLocuri=" + nrLocuri +
                ", esteDirect=" + esteDirect +
                ", destinatie='" + destinatie + '\'' +
                ", pret=" + pret +
                '}';
    }
}
