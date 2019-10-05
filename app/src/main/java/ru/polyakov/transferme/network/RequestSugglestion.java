package ru.polyakov.transferme.network;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DateFormat;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.polyakov.transferme.util.Const;

public class RequestSugglestion {

    private static Retrofit retrofit;

    public static Retrofit getSugglestion(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        /*Gson gson = new GsonBuilder()
                //.registerTypeAdapter(Id.class, new IdTypeAdapter())
                //.enableComplexMapKeySerialization()
                //.serializeNulls()
                //.setDateFormat(DateFormat.LONG)
                //.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                //.setPrettyPrinting()
                //.setVersion(1.0)
                .create();*/


        if(retrofit ==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Const.KIWI_TAXI_BASE_URL_AUTOCOMPLT)
                    .client(client)
                   // .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


        return retrofit;

    };
}
