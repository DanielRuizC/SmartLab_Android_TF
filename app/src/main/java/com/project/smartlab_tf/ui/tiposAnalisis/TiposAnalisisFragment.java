package com.project.smartlab_tf.ui.tiposAnalisis;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.smartlab_tf.R;
import com.project.smartlab_tf.databinding.FragmentTiposanalisisBinding;

public class TiposAnalisisFragment extends Fragment {


    public TiposAnalisisFragment (){

    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_tiposanalisis, container, false);

        ImageButton b1 = vista.findViewById(R.id.botonFlecha1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.idPantallaDetalleAnalisis);
            }
        });
        return vista;
    }
}