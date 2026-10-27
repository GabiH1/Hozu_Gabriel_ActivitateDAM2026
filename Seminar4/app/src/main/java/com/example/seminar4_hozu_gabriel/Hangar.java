package com.example.seminar4_hozu_gabriel;

import java.io.Serializable;

public class Hangar implements Serializable {
    String nume;
    int capacitate;
    boolean esteDisponibil;
    String tip;
    String locatie;
    float rating;
    boolean arePaza;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public boolean isEsteDisponibil() {
        return esteDisponibil;
    }

    public void setEsteDisponibil(boolean esteDisponibil) {
        this.esteDisponibil = esteDisponibil;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isArePaza() {
        return arePaza;
    }

    public void setArePaza(boolean arePaza) {
        this.arePaza = arePaza;
    }

    public Hangar(String nume, int capacitate, boolean esteDisponibil, String tip, String locatie, float rating, boolean arePaza) {
        this.nume = nume;
        this.capacitate = capacitate;
        this.esteDisponibil = esteDisponibil;
        this.tip = tip;
        this.locatie = locatie;
        this.rating = rating;
        this.arePaza = arePaza;
    }

    @Override
    public String toString() {
        return "Hangar{" +
                "nume='" + nume + '\'' +
                ", capacitate=" + capacitate +
                ", esteDisponibil=" + esteDisponibil +
                ", tip='" + tip + '\'' +
                ", locatie='" + locatie + '\'' +
                ", rating=" + rating +
                ", arePaza=" + arePaza +
                '}';
    }

}
