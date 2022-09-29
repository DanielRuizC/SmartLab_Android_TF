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

public class SolicitudAdapter extends RecyclerView.Adapter<SolicitudAdapter.SolicitudHolder> {

    List<SolicitudModel> listaSolicitudes;

    public SolicitudAdapter(List<SolicitudModel> listaSolicitudes){
        this.listaSolicitudes = listaSolicitudes;
    }

    @NonNull
    @Override
    public SolicitudHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_historial_solicitudes,parent,false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);
        return new SolicitudHolder(vista);
    }

    @Override
    public void onBindViewHolder(SolicitudHolder holder, int position) {
        holder.codigo.setText(listaSolicitudes.get(position).getIdCodigoSolicitud().toString());
        holder.fechaSolicitud.setText(listaSolicitudes.get(position).getStrFechaRegistroSolicitud().toString());
        holder.estadoAtencion.setText(listaSolicitudes.get(position).getStrEstadoSolicitud().toString());
    }

    @Override
    public int getItemCount() {
        return listaSolicitudes.size();
    }

    public class SolicitudHolder extends RecyclerView.ViewHolder{

        TextView codigo, fechaSolicitud, estadoAtencion;

        public SolicitudHolder(View itemView) {
            super(itemView);
            codigo = itemView.findViewById(R.id.txtCodigo);
            fechaSolicitud = itemView.findViewById(R.id.txtFechaSol);
            estadoAtencion = itemView.findViewById(R.id.txtEstadoSol);
        }

    }
}








