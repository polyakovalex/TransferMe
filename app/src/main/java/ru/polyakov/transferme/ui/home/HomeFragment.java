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
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import ru.polyakov.transferme.R;
import ru.polyakov.transferme.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment{

    private HomeViewModel homeViewModel;
    FragmentHomeBinding binding;
    public ObservableField<String> stateFrom = new ObservableField<>("Test");
    public ObservableField<String> stateTo = new ObservableField<>("Test2");
    public EditText etFrom;
    public EditText etTo;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        //homeViewModel = new HomeViewModel();
        homeViewModel = new HomeViewModel(stateFrom,stateTo);
        //Add Binding layout/fragment
        binding.setHomeViewModel(homeViewModel);
        View view = binding.getRoot();
        etFrom = binding.etFrom;
        etTo = binding.etTo;
        etFrom.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.autoComplitFragment));
        etTo.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.autoComplitFragment));

        return view;
    }

}