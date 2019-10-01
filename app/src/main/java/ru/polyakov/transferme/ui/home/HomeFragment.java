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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import ru.polyakov.transferme.R;

public class HomeFragment extends Fragment{

    private HomeViewModel homeViewModel;
    private EditText etFrom,etTo;
    private Button btSearch;
    NavController navController;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
       // navController = Navigation.findNavController(root);

        etFrom = root.findViewById(R.id.et_from);
        etTo = root.findViewById(R.id.et_from);
        etFrom.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.autoComplitFragment));
        etTo.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.autoComplitFragment));

        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                etFrom.setText(s);
            }
        });
        return root;
    }

   /* @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.et_from:
               // Navigation.findNavController(v).navigate(R.id.autoComplitFragment);
                break;
        }


    }*/
}