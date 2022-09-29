package com.project.smartlab_tf.ui.historialSolicitudes;

import java.util.Date;

public class SolicitudModel {
    private String codigoSolicitud;
    private Date fechaRegistroSolicitud;
    private String estadoSolicitud;

    public SolicitudModel(String numeroSolicitud, Date fechaRegistroSolicitud, String estadoSolicitud) {
        this.codigoSolicitud = numeroSolicitud;
        this.fechaRegistroSolicitud = fechaRegistroSolicitud;
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public Date getFechaRegistroSolicitud() {
        return fechaRegistroSolicitud;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }
}
