package com.project.smartlab_tf.ui.tiposAnalisis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.smartlab_tf.databinding.FragmentTiposanalisisBinding;

public class TiposAnalisisFragment extends Fragment {

    private FragmentTiposanalisisBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TiposAnalisisViewModel tiposAnalisisViewModel =
                new ViewModelProvider(this).get(TiposAnalisisViewModel.class);

        binding = FragmentTiposanalisisBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textView11;
        tiposAnalisisViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}