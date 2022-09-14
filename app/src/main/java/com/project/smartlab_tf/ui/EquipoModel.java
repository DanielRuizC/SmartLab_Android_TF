package com.project.smartlab_tf.ui;

import android.os.Parcel;
import android.os.Parcelable;

public class EquipoModel implements Parcelable {
    private int id;
    private String nombre;
    private String descripcion;

    public EquipoModel(int id, String nombre, String descripcion){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public EquipoModel( String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    protected EquipoModel(Parcel parcel) {
        id = parcel.readInt();
        nombre = parcel.readString();
        descripcion = parcel.readString();
    }

    public static final Creator<EquipoModel> CREATOR = new Creator<EquipoModel>() {
        @Override
        public EquipoModel createFromParcel(Parcel in) {
            return new EquipoModel(in);
        }

        @Override
        public EquipoModel[] newArray(int size) {
            return new EquipoModel[size];
        }
    };



    public int getId() {
        return id;
    }



    public String getNombre() {
        return nombre;
    }



    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.nombre);
        parcel.writeString(this.descripcion);

    }
}
