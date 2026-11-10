package com.example.maimultaexersare;

import android.os.Parcel;
import android.os.Parcelable;

public class Tableta implements Parcelable {
    int idTableta;
    String model;
    int spatiuMemorie;
    boolean esteOled;

    protected Tableta(Parcel in) {
        idTableta = in.readInt();
        model = in.readString();
        spatiuMemorie = in.readInt();
        esteOled = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idTableta);
        dest.writeString(model);
        dest.writeInt(spatiuMemorie);
        dest.writeByte((byte) (esteOled ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Tableta> CREATOR = new Creator<Tableta>() {
        @Override
        public Tableta createFromParcel(Parcel in) {
            return new Tableta(in);
        }

        @Override
        public Tableta[] newArray(int size) {
            return new Tableta[size];
        }
    };

    public int getIdTableta() {
        return idTableta;
    }

    public void setIdTableta(int idTableta) {
        this.idTableta = idTableta;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpatiuMemorie() {
        return spatiuMemorie;
    }

    public void setSpatiuMemorie(int spatiuMemorie) {
        this.spatiuMemorie = spatiuMemorie;
    }

    public boolean isEsteOled() {
        return esteOled;
    }

    public void setEsteOled(boolean esteOled) {
        this.esteOled = esteOled;
    }

    public Tableta(int idTableta, String model, int spatiuMemorie, boolean esteOled) {
        this.idTableta = idTableta;
        this.model = model;
        this.spatiuMemorie = spatiuMemorie;
        this.esteOled = esteOled;
    }

    @Override
    public String toString() {
        return "Tableta{" +
                "idTableta=" + idTableta +
                ", model='" + model + '\'' +
                ", spatiuMemorie=" + spatiuMemorie +
                ", esteOled=" + esteOled +
                '}';
    }
}
