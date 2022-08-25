package com.project.smartlab_tf.ui.registroComponente;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.smartlab_tf.R;

public class registroComponenteFragment extends Fragment {

    private RegistroComponenteViewModel mViewModel;

    public static registroComponenteFragment newInstance() {
        return new registroComponenteFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registro_componente, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RegistroComponenteViewModel.class);
        // TODO: Use the ViewModel
    }

}