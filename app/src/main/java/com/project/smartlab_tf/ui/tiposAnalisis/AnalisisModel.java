package com.project.smartlab_tf.ui.tiposAnalisis;

import android.graphics.Bitmap;

public class AnalisisModel {

    private String strTitulo;
    private String strDetalleBreve;
    private String rutaImagen;

    public AnalisisModel(){

    }

    public String getStrTitulo() {
        return strTitulo;
    }

    public void setStrTitulo(String strTitulo) {
        this.strTitulo = strTitulo;
    }

    public String getStrDetalleBreve() {
        return strDetalleBreve;
    }

    public void setStrDetalleBreve(String strDetalleBreve) {
        this.strDetalleBreve = strDetalleBreve;
    }

    public String getrutaImagen() {
        return rutaImagen;
    }

    public void setrutaImagen(String strImagen) {
        this.rutaImagen = rutaImagen;
    }
}