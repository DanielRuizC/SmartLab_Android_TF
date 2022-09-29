package com.project.smartlab_tf.ui.historialSolicitudes;

public class SolicitudModel {
    private String idCodigoSolicitud;
    private String strFechaRegistroSolicitud;
    private String strEstadoSolicitud;

    public SolicitudModel(String numeroSolicitud, String fechaRegistroSolicitud, String estadoSolicitud) {
        this.idCodigoSolicitud = numeroSolicitud;
        this.strFechaRegistroSolicitud = fechaRegistroSolicitud;
        this.strEstadoSolicitud = estadoSolicitud;
    }

    public String getIdCodigoSolicitud() {
        return idCodigoSolicitud;
    }

    public String getStrFechaRegistroSolicitud() {
        return strFechaRegistroSolicitud;
    }

    public String getStrEstadoSolicitud() {
        return strEstadoSolicitud;
    }
}
