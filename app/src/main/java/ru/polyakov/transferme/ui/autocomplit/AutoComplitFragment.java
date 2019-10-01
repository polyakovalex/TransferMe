package ru.polyakov.transferme.ui.autocomplit;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import ru.polyakov.transferme.R;

public class AutoComplitFragment extends Fragment implements SearchView.OnQueryTextListener {

    private AutoComplitViewModel mViewModel;
    SearchView searchView;

    public static AutoComplitFragment newInstance() {
        return new AutoComplitFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.auto_complit_fragment, container, false);

        searchView = root.findViewById(R.id.sv_autocomplit);
        searchView.setOnQueryTextListener(this);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AutoComplitViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d("sdf","sdf");
        return false;
    }
}
