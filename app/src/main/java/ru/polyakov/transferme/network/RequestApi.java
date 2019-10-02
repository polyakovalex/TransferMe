package ru.polyakov.transferme.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.polyakov.transferme.network.dto.PrepareQuery;
import ru.polyakov.transferme.network.dto.Suggestion;

public interface RequestApi {
    @GET("autocomplete?lang=ru&extra=1&limit=5&empty_price=1&request_source=new_front&placefrom=true=V")
    Call<PrepareQuery> listRepos(@Query("to") String keyboard,@Query("query") String v);
    //Call<PrepareQuery.List<Suggestion>>
}
