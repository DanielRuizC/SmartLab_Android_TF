package com.project.smartlab_tf.ui.historialSolicitudes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.smartlab_tf.databinding.FragmentHistorialsolicitudesBinding;

public class HistorialSolicitudesFragment extends Fragment {

    private FragmentHistorialsolicitudesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HistorialSolicitudesViewModel historialSolicitudesViewModel =
                new ViewModelProvider(this).get(HistorialSolicitudesViewModel.class);

        binding = FragmentHistorialsolicitudesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textView38;
        historialSolicitudesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}