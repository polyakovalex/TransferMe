package ru.polyakov.transferme.ui.sugglestion;

import androidx.lifecycle.ViewModelProviders;

import android.app.SearchManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.polyakov.transferme.R;
import ru.polyakov.transferme.adapter.AdapterSugglestion;
import ru.polyakov.transferme.network.RequestApi;
import ru.polyakov.transferme.network.RequestSugglestion;
import ru.polyakov.transferme.network.dto.PrepareQuery;
import ru.polyakov.transferme.network.dto.Suggestion;
import ru.polyakov.transferme.repo.SugglestionRepository;

public class SugglestionFragment extends Fragment implements SearchView.OnQueryTextListener {

    private SugglestionViewModel sViewModel;
    private SearchView searchView;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Suggestion> sugglestionArrayList = new ArrayList<>();
    private AdapterSugglestion adapterSugglestion;
    ProgressBar progressBar;
    String v = "V";

    public static SugglestionFragment newInstance() {
        return new SugglestionFragment();
    }


    /*
    @Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    FragmentTest binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false);
    Item item = new Item();
    item.setName("Thomas");
    binding.setItem(item);
    return binding.getRoot();
}
    */

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sugglestion, container, false);

        progressBar = root.findViewById(R.id.progress_bar);
        recyclerView = root.findViewById(R.id.recycleSugglestion);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        searchView = root.findViewById(R.id.sv_autocomplit);
        searchView.setOnQueryTextListener(this);

        //adapterSugglestion = new AdapterSugglestion(suggestions,getActivity().getApplicationContext());
        //recyclerView.setAdapter(adapterSugglestion);
        sViewModel = ViewModelProviders.of(this).get(SugglestionViewModel.class);
        sViewModel.init();
        sViewModel.getSugglestionRepository().observe(this, suggestion -> {
            List<Suggestion> sugglestionArrayList = suggestion.getSuggestions();

            //suggestions.addAll(sugglestions);
            adapterSugglestion.notifyDataSetChanged();
        });
        //fetchSuggestion(query,v);

       /* searchManager = (SearchManager) getActivity().getSystemService(getActivity().getApplicationContext().SEARCH_SERVICE);
        searchView = root.findViewById(R.id.sv_autocomplit);
        searchView.setIconifiedByDefault(false);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setOnQueryTextListener(this);*/

        setupRecyclerView();
        return root;
    }

    private void setupRecyclerView() {
        if (adapterSugglestion == null) {
            adapterSugglestion = new AdapterSugglestion(sugglestionArrayList, getActivity().getApplicationContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
            recyclerView.setAdapter(adapterSugglestion);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setNestedScrollingEnabled(true);
        } else {
            adapterSugglestion.notifyDataSetChanged();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // mViewModel = ViewModelProviders.of(this).get(SugglestionViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d("onQueryTextSubmit",query);
        fetchSuggestion(query,v);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d("onQueryTextChange",newText);
        fetchSuggestion(newText,v);
        return false;
    }

    public void fetchSuggestion(String query,String v){

        //mViewModel.getSugglestion();
                /*adapterAutoComplit = new AdapterSugglestion(suggestions, getActivity().getApplicationContext());
                recyclerView.setAdapter(adapterAutoComplit);
                adapterAutoComplit.notifyDataSetChanged();*/


            }
   /* public void fetchSuggestion(String query,String v){
        requestApi = RequestSugglestion.getSugglestion().create(RequestApi.class);
        Call<PrepareQuery> call = requestApi.listSugglestion(query,v);

        call.enqueue(new Callback<PrepareQuery>() {
            @Override
            public void onResponse(Call<PrepareQuery> call, Response<PrepareQuery> response) {
                progressBar.setVisibility(View.GONE);
                prepareQuery = response.body();
                suggestions = prepareQuery.getSuggestions();
                adapterAutoComplit = new AdapterSugglestion(suggestions, getActivity().getApplicationContext());
                recyclerView.setAdapter(adapterAutoComplit);
                adapterAutoComplit.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<PrepareQuery> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getActivity().getApplicationContext(),"Error request "+t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }*/
}
