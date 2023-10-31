package com.example.apikinopoisk;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("v2.2/films/collections")
    Call<Film> getListPremierFilms(@Query("type") String type, @Query("page") int page, @Header("X-API-KEY") String apiKey);
    @GET("v2.2/films/{id}")
    Call<FilmIdClass> getCurrentFilm(@Path("id") int id, @Header("X-API-KEY") String apiKey);
    @GET("v2.2/films/{id}/videos")
    Call<VideoClass> getVideo(@Path("id") int id, @Header("X-API-KEY") String apiKey);
    @GET("v1/staff?filmId=305")
    Call<ArrayList<ActorsClass>> getActors(@Query("filmId") int id, @Header("X-API-KEY") String apiKey);
}
