package ru.polyakov.transferme.ui.autocomplit;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.polyakov.transferme.MainActivity;
import ru.polyakov.transferme.R;
import ru.polyakov.transferme.adapter.AdapterAutoComplit;
import ru.polyakov.transferme.network.RequestApi;
import ru.polyakov.transferme.network.RequestAutocomplit;
import ru.polyakov.transferme.network.dto.PointsLocal;

public class AutoComplitFragment extends Fragment implements SearchView.OnQueryTextListener {

    private AutoComplitViewModel mViewModel;
    private SearchView searchView;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<PointsLocal> pointsLocalList;
    private AdapterAutoComplit adapterAutoComplit;
    private RequestApi requestApi;
    ProgressBar progressBar;

    public static AutoComplitFragment newInstance() {
        return new AutoComplitFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_autocomplit, container, false);

        progressBar = root.findViewById(R.id.progress_bar);
        recyclerView = root.findViewById(R.id.recycle_autocomplit);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        searchView = root.findViewById(R.id.sv_autocomplit);
        searchView.setOnQueryTextListener(this);
        fetchPointLocation();

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

    public void fetchPointLocation(){
        requestApi = RequestAutocomplit.getAutoComplit().create(RequestApi.class);
        Call<List<PointsLocal>> call = requestApi.listRepos();

        call.enqueue(new Callback<List<PointsLocal>>() {
            @Override
            public void onResponse(Call<List<PointsLocal>> call, Response<List<PointsLocal>> response) {
                progressBar.setVisibility(View.GONE);
                pointsLocalList = response.body();
                adapterAutoComplit = new AdapterAutoComplit(pointsLocalList, getActivity().getApplicationContext());
                recyclerView.setAdapter(adapterAutoComplit);
                adapterAutoComplit.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<List<PointsLocal>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getActivity().getApplicationContext(),"Error request "+t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
