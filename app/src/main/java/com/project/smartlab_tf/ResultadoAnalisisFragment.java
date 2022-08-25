package com.project.smartlab_tf;

import static androidx.navigation.Navigation.findNavController;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.smartlab_tf.MainActivity;
import com.project.smartlab_tf.R;
import com.project.smartlab_tf.ResultadoAnalisisFragment;

public class ResultadoAnalisisFragment extends Fragment {

    public ResultadoAnalisisFragment(){

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista1 = inflater.inflate(R.layout.fragment_resultado_analisis, container, false);

        ImageButton button = vista1.findViewById(R.id.chatButton1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                findNavController(v2).navigate(R.id.idPantallaComentario);
            }
        });

        return vista1;
    }
}