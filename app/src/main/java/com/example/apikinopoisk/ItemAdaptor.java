package com.example.apikinopoisk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemAdaptor extends RecyclerView.Adapter<ItemAdaptor.ViewHolder> {
    private Context context;
    private ArrayList<Film.Item> list;
    private ApiInterface apiInterface;

    public ItemAdaptor(Context context, Film list) {
        this.context = context;
        ArrayList<Film.Item> movies = list.getItems();
        this.list = movies;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdaptor.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Film.Item film = list.get(position);
        holder.name.setText(film.getNameRu());
        holder.date.setText(String.valueOf(film.getYear()) );
        holder.Rating.setText(String.valueOf(film.getRatingKinopoisk()));
        Picasso.with(context).load(film.getPosterUrl()).into(holder.iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InfoPage.class);

                apiInterface = ServiceBuilder.buildRequest().create(ApiInterface.class);
                Call<FilmIdClass> call = apiInterface.getCurrentFilm(list.get(position).getKinopoiskId(),
                        "3893e6f1-07a4-4e49-aca6-da672a5bd8e3");
                call.enqueue(new Callback<FilmIdClass>() {
                    @Override
                    public void onResponse(Call<FilmIdClass> call, Response<FilmIdClass> response) {
                        if(response.isSuccessful()){
                            FilmIdClass filmIdClass = response.body();
                            String VideoUrl;
                            Call<VideoClass> classCall = apiInterface.getVideo(list.get(position).getKinopoiskId(),
                                    "3893e6f1-07a4-4e49-aca6-da672a5bd8e3");
                            classCall.enqueue(new Callback<VideoClass>() {
                                @Override
                                public void onResponse(Call<VideoClass> call, Response<VideoClass> response) {
                                    if (response.isSuccessful()){
                                        VideoClass videoClass = response.body();
                                        intent.putExtra("name", filmIdClass.getNameRu());
                                        intent.putExtra("date", filmIdClass.getYear());
                                        intent.putExtra("description", filmIdClass.getDescription());
                                        intent.putExtra("poster", filmIdClass.getPosterUrl());
                                        intent.putExtra("rating", filmIdClass.getRatingKinopoisk());
                                        intent.putExtra("video", videoClass.getItems().get(0).getUrl());
                                        intent.putExtra("id", String.valueOf(filmIdClass.getKinopoiskId()) );
                                        context.startActivity(intent);
                                    }
                                }

                                @Override
                                public void onFailure(Call<VideoClass> call, Throwable t) {

                                }
                            });
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmIdClass> call, Throwable t) {

                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView Rating;
        TextView date;
        ImageView iv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            Rating = itemView.findViewById(R.id.rating);
            date = itemView.findViewById(R.id.date);
            iv = itemView.findViewById(R.id.cover);
        }
    }
}
