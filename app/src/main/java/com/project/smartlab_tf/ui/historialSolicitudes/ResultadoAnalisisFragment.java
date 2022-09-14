package com.project.smartlab_tf.ui.historialSolicitudes;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ResultadoAnalisisFragment extends Fragment {

    private SolicitudModel mSolicitud;
    private ResultadoAnalisisFragmentBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            mSolicitud = getArguments().getParcelable(Constantes.OBJ_SOLICITUD);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = ResultadoAnalisisFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /*@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imgFotoUsuario = binding.imgFotoUsuario;
        TextView txtNombresUsuario = binding.txtNombresUsuario;
        TextView txtEmailUsuario = binding.txtEmailUsuario;
        TextView txtFechaNacUsuario = binding.txtFechaNacUsuario;
        TextView txtSexoUsuario = binding.txtSexoUsuario;

        if(mUsuario.getSexo().equals("Masculino"))
            imgFotoUsuario.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.user_masculino));
        else
            imgFotoUsuario.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.user_femenino));

        txtNombresUsuario.setText(mUsuario.getNombres());
        txtEmailUsuario.setText(mUsuario.getEmail());
        txtFechaNacUsuario.setText(mUsuario.getFechaNac());
        txtSexoUsuario.setText(mUsuario.getSexo());*/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}