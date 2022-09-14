package com.project.smartlab_tf.ui.MisEquipos;

import androidx.core.view.MenuProvider;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.project.smartlab_tf.R;
import com.project.smartlab_tf.databinding.FragmentMisEquiposBinding;
import com.project.smartlab_tf.ui.Constantes;

public class MisEquiposFragment extends Fragment {
    
    private FragmentMisEquiposBinding binding;
    private MisEquiposViewModel mViewModel;

    NavController navController;

    public static MisEquiposFragment newInstance() {
        return new MisEquiposFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMisEquiposBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);

        navController= Navigation.findNavController(binding.getRoot());

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                MenuItem item = menu.findItem(R.id.action_addEquipo);
                item.setVisible(true);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.action_addEquipo){
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(Constantes.MODO_EDICION, false);
                    bundle.putParcelable(Constantes.OBJ_USUARIO,null);

                    navController.navigate(R.id.nav_registroEquipo, bundle);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MisEquiposViewModel.class);
        // TODO: Use the ViewModel
    }



}