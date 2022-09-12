package com.project.smartlab_tf.ui.historialSolicitudes;

public class SolicitudModel {
    private int numeroSolicitud;
    private String fechaRegistroSolicitud;
    private String estadoSolicitud;

    public SolicitudModel(int numeroSolicitud, String fechaRegistroSolicitud, String estadoSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
        this.fechaRegistroSolicitud = fechaRegistroSolicitud;
        this.estadoSolicitud = estadoSolicitud;
    }

    public int getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public String getFechaRegistroSolicitud() {
        return fechaRegistroSolicitud;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }
}
