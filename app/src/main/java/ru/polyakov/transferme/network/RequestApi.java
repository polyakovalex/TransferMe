package ru.polyakov.transferme.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.polyakov.transferme.network.dto.PrepareQuery;

public interface RequestApi {
    @GET("autocomplete?lang=ru&extra=1&limit=5&empty_price=1&request_source=new_front&placefrom=true&to=%D0%9C%D0%BE%D1%81%D0%BA%D0%B2%D0%B0%20%D0%A6%D0%90%D0%9E&query=V")
    Call<List<PrepareQuery>> listRepos();
}
