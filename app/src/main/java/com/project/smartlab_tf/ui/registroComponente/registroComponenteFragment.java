package com.project.smartlab_tf.ui.registroComponente;

import static androidx.navigation.Navigation.findNavController;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.smartlab_tf.R;
import com.project.smartlab_tf.ui.registroEquipo.registroEquipoViewModel;

public class registroComponenteFragment extends Fragment {

    private RegistroComponenteViewModel mViewModel;

    public static registroComponenteFragment newInstance() {
        return new registroComponenteFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        mViewModel = new ViewModelProvider(this).get(RegistroComponenteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_registro_componente,container,false);

        Button b11 = root.findViewById(R.id.button3);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.nav_registroComponente);
            }
        });;

        Button b12 = root.findViewById(R.id.cancelar2);
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.nav_perfil);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RegistroComponenteViewModel.class);
        // TODO: Use the ViewModel
    }


    }

