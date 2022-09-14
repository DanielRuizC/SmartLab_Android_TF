package com.project.smartlab_tf.ui.historialSolicitudes;

public class SolicitudModel {
    private String numeroSolicitud;
    private String fechaRegistroSolicitud;
    private String estadoSolicitud;

    public SolicitudModel(String numeroSolicitud, String fechaRegistroSolicitud, String estadoSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
        this.fechaRegistroSolicitud = fechaRegistroSolicitud;
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public String getFechaRegistroSolicitud() {
        return fechaRegistroSolicitud;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }
}
