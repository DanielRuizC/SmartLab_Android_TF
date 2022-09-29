package com.project.smartlab_tf.ui.historialSolicitudes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.smartlab_tf.R;

import java.util.Date;
import java.util.List;

public class SolicitudAdapter extends RecyclerView.Adapter<SolicitudAdapter.ViewHolder> {

    private final List<SolicitudModel> listaSolicitudes;

    public SolicitudAdapter(List<SolicitudModel> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_historial_solicitudes,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        String codigoSolicitud = listaSolicitudes.get(position).getCodigoSolicitud();
        Date fechaRegistro = listaSolicitudes.get(position).getFechaRegistroSolicitud();
        String estadoAtencion = listaSolicitudes.get(position).getEstadoSolicitud();

        holder.codigoSoli.setText(codigoSolicitud);

    }
    @Override
    public int getItemCount() {
        return listaSolicitudes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView codigoSoli;
        private final TextView fechaRegistro;
        private final TextView estadoAtencion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            codigoSoli = itemView.findViewById(R.id.txtNumeroSol);
            fechaRegistro = itemView.findViewById(R.id.txtFechaSol);
            estadoAtencion = itemView.findViewById(R.id.txtEstadoSol);
        }
    }
}
