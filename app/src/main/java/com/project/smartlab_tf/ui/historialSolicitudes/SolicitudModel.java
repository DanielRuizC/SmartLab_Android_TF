package com.project.smartlab_tf.ui.historialSolicitudes;

public class SolicitudModel {
    private String idCodigoSolicitud;
    private String strFechaRegistroSolicitud;
    private String strEstadoSolicitud;

    public String getIdCodigoSolicitud() {
        return idCodigoSolicitud;
    }

    public String getStrFechaRegistroSolicitud() {
        return strFechaRegistroSolicitud;
    }

    public String getStrEstadoSolicitud() {
        return strEstadoSolicitud;
    }

    public void setIdCodigoSolicitud(String idCodigoSolicitud) {
        this.idCodigoSolicitud = idCodigoSolicitud;
    }

    public void setStrFechaRegistroSolicitud(String strFechaRegistroSolicitud) {
        this.strFechaRegistroSolicitud = strFechaRegistroSolicitud;
    }

    public void setStrEstadoSolicitud(String strEstadoSolicitud) {
        this.strEstadoSolicitud = strEstadoSolicitud;
    }
}
