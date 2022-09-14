package com.project.smartlab_tf.ui.historialSolicitudes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.navigation.Navigation;
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

        String numeroSol = listaSolicitudes.get(position).getNumeroSolicitud();
        String fechaSol = listaSolicitudes.get(position).getFechaRegistroSolicitud();
        String estadoSol = listaSolicitudes.get(position).getEstadoSolicitud();

        holder.numSoli.setText(numeroSol);
        holder.fechaReg.setText(fechaSol);
        holder.estadoSoli.setText(estadoSol);

        if (listaSolicitudes.get(position).getEstadoSolicitud().equals("Atendido"))
            holder.img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.reporte_listo));
        else if (listaSolicitudes.get(position).getEstadoSolicitud().equals("Pendiente"))
            holder.img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.reporte_en_proceso));

        holder.imgEditar.setOnClickListener(v->{
            Bundle bundle = new Bundle();
            bundle.putBoolean(Constantes.MODO_EDICION, true);
            bundle.putParcelable(Contantes.OBJ_SOLICITUD, listaSolicitudes.get(position));
            Navigation.findNavController(holder.itemView).navigate(R.id.newSolicitudFragment, bundle);
        });

        holder.imgDelete.setOnClickListener(v->{
            DAOSolicitudes daoSolicitudes = new DAOSolicitudes(context);
            int result = daoSolicitudes.eliminarSolicitud(listaSolicitudes.get(position).getId());
            if(result<=0){
                Toast.makeText(context, "Error al eliminar", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context, "Se eliminó correctamente", Toast.LENGTH_SHORT).show();
                listaSolicitudes.remove(holder.getAdapterPosition());
                notifyItemRemoved(position);
            }
        });

        holder.itemView.setOnClickListener(v->{
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constantes.OBJ_USUARIO, listaSolicitudes.get(position));
            Navigation.findNavController(holder.itemView).navigate(R.id.detallesAnalisisFragment, bundle);
        });

    }

    @Override
    public int getItemCount() {
        return listaSolicitudes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView numSoli;
        private final TextView fechaReg;
        private final TextView estadoSoli;
        private final ImageView img, imgEditar, imgDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numSoli = itemView.findViewById(R.id.txtNumeroSol);
            fechaReg = itemView.findViewById(R.id.txtFechaSol);
            estadoSoli = itemView.findViewById(R.id.txtEstadoSol);
            img = itemView.findViewById(R.id.imgEstado);
            imgEditar = itemView.findViewById(R.id.imgEdit);
            imgDelete = itemView.findViewById(R.id.imgDelete);
        }
    }
}
