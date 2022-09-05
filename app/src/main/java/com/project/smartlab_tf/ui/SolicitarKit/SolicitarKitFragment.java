package com.project.smartlab_tf.ui.SolicitarKit;

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
import android.widget.ImageButton;

import com.project.smartlab_tf.R;
import com.project.smartlab_tf.ui.registroEquipo.registroEquipoViewModel;

public class SolicitarKitFragment extends Fragment {

    private SolicitarKitViewModel mViewModel;

    public static SolicitarKitFragment newInstance() {
        return new SolicitarKitFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(SolicitarKitViewModel.class);
        View root = inflater.inflate(R.layout.fragment_solicitar_kit,container,false);
        return root;



    }
}