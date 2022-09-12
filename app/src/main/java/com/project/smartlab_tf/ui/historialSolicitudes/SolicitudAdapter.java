package com.project.smartlab_tf.ui.historialSolicitudes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.project.smartlab_tf.R;

import java.util.List;

public class SolicitudAdapter extends RecyclerView.Adapter<SolicitudAdapter.ViewHolder> {

    private final List<SolicitudModel> listaSolicitudes;

    public SolicitudAdapter(List<SolicitudModel> lista) {
        this.listaSolicitudes = lista;
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

        holder.numeroSol.setText(listaSolicitudes.get(position).getNumeroSolicitud());
        holder.fechaSol.setText(listaSolicitudes.get(position).getFechaRegistroSolicitud());
        holder.estadoSol.setText(listaSolicitudes.get(position).getEstadoSolicitud());

        if (listaSolicitudes.get(position).getEstadoSolicitud().equals("Atendido"))
            holder.img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.reporte_listo));
        else if (listaSolicitudes.get(position).getEstadoSolicitud().equals("Pendiente"))
            holder.img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.reporte_en_proceso));
    }

    @Override
    public int getItemCount() {
        return listaSolicitudes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView numeroSol;
        private final TextView fechaSol;
        private final TextView estadoSol;
        private final ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numeroSol = itemView.findViewById(R.id.txtNumeroSol);
            fechaSol = itemView.findViewById(R.id.txtFechaSol);
            estadoSol = itemView.findViewById(R.id.txtEstadoSol);
            img = itemView.findViewById(R.id.imgEstado);
        }
    }
}
