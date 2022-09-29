package com.project.smartlab_tf.ui.historialSolicitudes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.smartlab_tf.R;

import java.util.List;

/*public class SolicitudAdapter extends RecyclerView.Adapter<SolicitudAdapter.ViewHolder> {

    private final List<SolicitudModel> listaSolicitudes;

    public SolicitudAdapter(List<SolicitudModel> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_historial_solicitudes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SolicitudModel solicitudModel = listaSolicitudes.get(position);

        String codigoSolicitud = listaSolicitudes.get(position).getIdCodigoSolicitud();
        String fechaRegistro = listaSolicitudes.get(position).getStrFechaRegistroSolicitud();
        String estadoAtencion = listaSolicitudes.get(position).getStrEstadoSolicitud();

        holder.codigo.setText(solicitudModel.getIdCodigoSolicitud());
        holder.fechaSolicitud.setText(solicitudModel.getStrFechaRegistroSolicitud());
        holder.estadoAtencion.setText(solicitudModel.getStrEstadoSolicitud());
    }
    @Override
    public int getItemCount() {
        return listaSolicitudes.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView codigo, fechaSolicitud, estadoAtencion;

        public ViewHolder(View itemView) {
            super(itemView);
            codigo = itemView.findViewById(R.id.txtCodigo);
            fechaSolicitud = itemView.findViewById(R.id.txtFechaSol);
            estadoAtencion = itemView.findViewById(R.id.txtEstadoSol);
        }
    }
}


public Context mCtx;
    private List<SolicitudModel> listaSolicitudes;

    public SolicitudAdapter(Context mCtx, List<SolicitudModel> listaSolicitudes) {
        this.mCtx = mCtx;
        this.listaSolicitudes = listaSolicitudes;
    }

    @Override
    public SolicitudViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.fila_historial_solicitudes,null);
        return new SolicitudViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SolicitudViewHolder holder, int position) {
        SolicitudModel solicitudModel = listaSolicitudes.get(position);


String codigoSolicitud = listaSolicitudes.get(position).getCodigoSolicitud();
        String fechaRegistro = listaSolicitudes.get(position).getFechaRegistroSolicitud();
        String estadoAtencion = listaSolicitudes.get(position).getEstadoSolicitud();

        holder.codigo.setText(solicitudModel.getIdCodigoSolicitud());
        holder.fechaSolicitud.setText(solicitudModel.getStrFechaRegistroSolicitud());
        holder.estadoAtencion.setText(solicitudModel.getStrEstadoSolicitud());

    }
    @Override
    public int getItemCount() {
        return listaSolicitudes.size();
    }

    class SolicitudViewHolder extends RecyclerView.ViewHolder {
        TextView codigo, fechaSolicitud, estadoAtencion;

        public SolicitudViewHolder(View itemView) {
            super(itemView);
            codigo = itemView.findViewById(R.id.txtCodigo);
            fechaSolicitud = itemView.findViewById(R.id.txtFechaSol);
            estadoAtencion = itemView.findViewById(R.id.txtEstadoSol);
        }

public static class SolicitudViewHolder extends RecyclerView.ViewHolder {
        private final TextView codigo;
        private final TextView fechaSolicitud;
        private final TextView estadoAtencion;

        public SolicitudViewHolder(@NonNull View itemView) {
            super(itemView);
            codigo = itemView.findViewById(R.id.txtCodigo);
            fechaSolicitud = itemView.findViewById(R.id.txtFechaSol);
            estadoAtencion = itemView.findViewById(R.id.txtEstadoSol);
        }
    }
    }*/





