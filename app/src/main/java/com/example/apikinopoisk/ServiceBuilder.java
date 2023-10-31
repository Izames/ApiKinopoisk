package com.example.apikinopoisk;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ServiceBuilder {
    private static String URL = "https://kinopoiskapiunofficial.tech/api/";
    private static Retrofit retrofit = null;
    static Retrofit buildRequest(){
        OkHttpClient client = new OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder().baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client).build();
        return retrofit;
    }
}

