package ru.polyakov.transferme.ui.autocomplit;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.polyakov.transferme.R;

public class AutoComplitFragment extends Fragment {

    private AutoComplitViewModel mViewModel;

    public static AutoComplitFragment newInstance() {
        return new AutoComplitFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.auto_complit_fragment, container, false);
      /*  NavController navController = Navigation.findNavController(root, R.id.autoComplitFragment);
        NavigationUI.setupActionBarWithNavController(root, navController);*/

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AutoComplitViewModel.class);
        // TODO: Use the ViewModel
    }


}
