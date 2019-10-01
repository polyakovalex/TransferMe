package ru.polyakov.transferme.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.polyakov.transferme.util.Const;

public class RequestAutocomplit  {

    private static Retrofit retrofit;

    public static Retrofit getAutoComplit(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        if(retrofit ==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Const.KIWI_TAXI_BASE_URL_AUTOCOMPLT)
                    .client(client)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }


        return retrofit;

    };
}
