package com.project.smartlab_tf.ui.historialSolicitudes;

import static androidx.navigation.Navigation.findNavController;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.smartlab_tf.MainActivity;
import com.project.smartlab_tf.R;
import com.project.smartlab_tf.ResultadoAnalisisFragment;

public class HistorialSolicitudesFragment extends Fragment {

    public HistorialSolicitudesFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
                             ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_historialsolicitudes, container, false);

        Button b1 = vista.findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.idPantallaResultadoAnalisis);
            }
        });

        return vista;
    }
}