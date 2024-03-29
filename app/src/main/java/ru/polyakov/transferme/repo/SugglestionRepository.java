package ru.polyakov.transferme.repo;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.polyakov.transferme.network.RequestApi;
import ru.polyakov.transferme.network.RequestSugglestion;
import ru.polyakov.transferme.network.dto.PrepareQuery;
import ru.polyakov.transferme.network.dto.Suggestion;

public class SugglestionRepository {
    private static final String TAG = "SuggestionRepository";
    private static SugglestionRepository sugglestionRepository;

    public static SugglestionRepository getInstance(){
        if (sugglestionRepository == null){
            sugglestionRepository = new SugglestionRepository();
        }
        return sugglestionRepository;
    }

    private RequestApi requestApi;

    public SugglestionRepository(){
        requestApi = RequestSugglestion.cteateService(RequestApi.class);
    }

    public MutableLiveData<PrepareQuery> getSuggl(String queryFrom, String v){
        MutableLiveData<PrepareQuery> sugglestionData = new MutableLiveData<>();
        requestApi.listSugglestion(queryFrom, v).enqueue(new Callback<PrepareQuery>() {
            @Override
            public void onResponse(Call<PrepareQuery> call,
                                   Response<PrepareQuery> response) {
                if (response.isSuccessful()){
                    sugglestionData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PrepareQuery> call, Throwable t) {
                sugglestionData.setValue(null);
            }
        });
        return sugglestionData;
    }
}

   /* private List<Suggestion> suggestions = new ArrayList<>();
    //private MutableLiveData<List<Suggestion>> mutableLiveData = new MutableLiveData<>();
    private String query = "df";
    private String v = "V";



    public List<Suggestion> getSuggestionsApi(String query, String v) {

        final RequestApi requestApi = RequestSugglestion.getSugglestion().create(RequestApi.class);
        Call<PrepareQuery> call = requestApi.listSugglestion(query, v);
        call.enqueue(new Callback<PrepareQuery>() {
            @Override
            public void onResponse(Call<PrepareQuery> call, Response<PrepareQuery> response) {
                // progressBar.setVisibility(View.GONE);
                PrepareQuery prepareQuery = response.body();
                suggestions = prepareQuery.getSuggestions();
                *//*if (suggestions != null) {
                    //suggestions = suggestions.
                    mutableLiveData.setValue(suggestions);
                }*//*
            }

            @Override
            public void onFailure(Call<PrepareQuery> call, Throwable t) {

            }
        });
        return suggestions;
    }*/

    /*public MutableLiveData<List<Suggestion>> getMutableLiveData(String query, String v) {

        final RequestApi requestApi = RequestSuggestion.getAutoComplit().create(RequestApi.class);
        Call<PrepareQuery> call = requestApi.listRepos(query, v);
        call.enqueue(new Callback<PrepareQuery>() {
            @Override
            public void onResponse(Call<PrepareQuery> call, Response<PrepareQuery> response) {
                // progressBar.setVisibility(View.GONE);
                PrepareQuery prepareQuery = response.body();
                suggestions = prepareQuery.getSuggestions();
                if (suggestions != null) {
                    //suggestions = suggestions.
                    mutableLiveData.setValue(suggestions);
                }
            }

            @Override
            public void onFailure(Call<PrepareQuery> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }*/
