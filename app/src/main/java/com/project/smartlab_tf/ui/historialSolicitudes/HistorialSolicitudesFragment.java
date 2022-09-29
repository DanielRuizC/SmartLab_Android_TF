package com.project.smartlab_tf.ui.historialSolicitudes;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.project.smartlab_tf.databinding.FragmentHistorialsolicitudesBinding;

import java.util.ArrayList;

public class HistorialSolicitudesFragment extends Fragment {

    private FragmentHistorialsolicitudesBinding binding;
    private RequestQueue cola;
    private ArrayList<SolicitudModel> habitaciones;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHistorialsolicitudesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        cola = Volley.newRequestQueue(getContext());

        obtenerHistorial();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void obtenerHistorial(){
        final String url = "http://181.66.138.91:8080/laboratorio_db/select_solicitudes.php";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,null, x-> {
            Log.e("Log","Entro");
        },error -> {
            Log.e("Log",error.toString());
        });

        this.cola.add(request);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}