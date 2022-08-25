package com.project.smartlab_tf.ui.registroEquipo;

import static androidx.navigation.Navigation.findNavController;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.smartlab_tf.MainActivity;
import com.project.smartlab_tf.R;

public class registroEquipoFragment extends Fragment {

    private registroEquipoViewModel mViewModel;

    public static registroEquipoFragment newInstance() {
        return new registroEquipoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(registroEquipoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_registro_equipo,container,false);

        Button b1 = root.findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.nav_registroComponente);
            }
        });;

        return root;


    }

}