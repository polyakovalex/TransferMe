package ru.polyakov.transferme.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import ru.polyakov.transferme.R;
import ru.polyakov.transferme.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment{

    FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        //homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        /*final TextView textView = binding.etFrom;*/
      //  DataBindingUtil.setContentView(binding.getRoot(), R.layout.fragment_home);

        View view = binding.getRoot();


/*
        etFrom = root.findViewById(R.id.et_from);
        etTo = root.findViewById(R.id.et_from);
        etFrom.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.autoComplitFragment));
        etTo.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.autoComplitFragment));*/

        /*homeViewModel.getFrom().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });*/
        return view;
    }

}