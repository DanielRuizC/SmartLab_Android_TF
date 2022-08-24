package com.project.smartlab_tf.ui.historialSolicitudes;

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

    private HistorialSolicitudesViewModel mViewModel;

    public static HistorialSolicitudesFragment newInstance() { return new HistorialSolicitudesFragment();}

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
                             ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(HistorialSolicitudesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_historialsolicitudes, container, false);

        Button b1 = root.findViewById(R.id.button2);
        b1.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), MainActivity.class));
        });

        return root;
    }
}