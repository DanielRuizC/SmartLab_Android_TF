package com.project.smartlab_tf.ui.tiposAnalisis;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.project.smartlab_tf.R;
import com.project.smartlab_tf.ui.historialSolicitudes.VolleySingleton;

import java.util.List;

public class AnalisisAdapter extends RecyclerView.Adapter<AnalisisAdapter.AnalisisHolder> {

    List<AnalisisModel> listaAnalisis;
    RequestQueue request;
    Context context;

    public AnalisisAdapter(List<AnalisisModel> listaAnalisis, Context context){
        this.listaAnalisis = listaAnalisis;
        this.context=context;
        request = Volley.newRequestQueue(context);
    }

    @Override
    public AnalisisHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_analisis,parent,false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);
        return new AnalisisHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AnalisisHolder holder, int position) {
        holder.titulo.setText(listaAnalisis.get(position).getStrTitulo().toString());
        holder.detalleBreve.setText(listaAnalisis.get(position).getStrDetalleBreve().toString());
        cargarImagenWebService(listaAnalisis.get(position).getrutaImagen(),holder);
    }

    private void cargarImagenWebService(String rutaImagen, final AnalisisHolder holder) {

        String urlImagen = "http://192.168.0.109:8080/laboratorio_db/analisis.php" + rutaImagen;
        urlImagen=urlImagen.replace(" ","%20");

        ImageRequest imageRequest=new ImageRequest(urlImagen, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                holder.imagen.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.CENTER, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Error al cargar la imagen",Toast.LENGTH_SHORT).show();
            }
        });
        request.add(imageRequest);
    }

    @Override
    public int getItemCount() {
        return listaAnalisis.size();
    }

    public class AnalisisHolder extends RecyclerView.ViewHolder{
        TextView titulo, detalleBreve;
        ImageView imagen;

        public AnalisisHolder(View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.txtTituloAnalisis);
            detalleBreve = (TextView) itemView.findViewById(R.id.txtDetalleBreve);
            imagen = (ImageView) itemView.findViewById(R.id.imgAnalisis);
        }
    }
}
