package ru.polyakov.transferme.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.polyakov.transferme.util.Const;

public class RequestAutocomplit  {

    private static Retrofit retrofit;

    public static Retrofit getAutoComplit(){
        if(retrofit ==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Const.KIWI_TAXI_BASE_URL_AUTOCOMPLT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


        return retrofit;

    };
}
